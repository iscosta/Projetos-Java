package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EMFactorySingleton;

public class ConsoleView {

	public static void main(String[] args) {
		//Instanciar o ClienteDAO
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		List<Cliente> clientes = clienteDao.listar();
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("CEP:" + cliente.getEndereco().getCep());
		}
		
		System.out.println("************BUSCA POR NOME:");
		//Teste da busca por nome
		clientes = clienteDao.buscarPorNome("Leandro");
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("CPF: " + cliente.getCpf());
		}
		
		//Buscar Pacote por Transporte
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		
		Transporte transporte = transporteDao.findById(1);
		List<Pacote> pacotes = pacoteDao.buscarPorTransporte(transporte);
		System.out.println("BUSCA DE PACOTES POR TRANSPORTE");
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		//Buscar clientes por estado
		clientes = clienteDao.buscarPorEstado("SP");
		System.out.println("BUSCA DE CLIENTE POR ESTADO");
		for (Cliente cliente : clientes){
			System.out.println(cliente.getNome());
		}
		
		//Buscar clientes por dias de reserva
		clientes = clienteDao.buscarPorDiasReserva(10);
		System.out.println("BUSCAR POR DIAS DE RESERVA");
		for (Cliente cliente : clientes){
			System.out.println(cliente.getNome());
		}
		
		//Buscar nome e cpf dos clientes
		List<Object[]> lista = clienteDao.buscarNomeCPF("a");
		for (Object[] objects : lista) {
			System.out.println("NOME: " + objects[0]);
			System.out.println("CPF: " + objects[1]);
		}
		
		//Contar a quantidade de clientes cadastrados
		long qtd = clienteDao.contarTotal();
		System.out.println("TOTAL DE CLIENTES: " + qtd);
		
		//Listar os pacotes pela data de saída
		System.out.println("BUSCAR PACOTE POR DATA SAÍDA");
		Calendar inicio =
			new GregorianCalendar(2013, Calendar.JANUARY, 1);
		Calendar fim = Calendar.getInstance(); //Data Atual
		pacotes = pacoteDao.getPacotes(inicio , fim );
		for (Pacote p : pacotes){
			System.out.println(p.getDescricao());
			System.out.println(p.getDataSaida().getTime());
		}
		
		//Buscar o cliente pelo nome e cidade
		System.out.println("BUSCAR CLIENTE PELO NOME E CIDADE");
		clientes = clienteDao.getClientePorNome("Lean", "a");
		for (Cliente c : clientes){
			System.out.println(c.getNome() + " - " + 
						c.getEndereco().getCidade().getNome());
		}
		
		//Buscar clientes por estado
		List<String> estados = new ArrayList<String>();
		estados.add("SP");
		estados.add("PR");
		estados.add("BA");
		
		System.out.println("BUSCAR CLIENTE POR ESTADOS");
		clientes = clienteDao.getClientePorEstado(estados);
		for (Cliente c : clientes){
			System.out.println(c.getNome() + " - " + 
				c.getEndereco().getCidade().getUf());
		}
		
		System.out.println("BUSCAR TRANSPORTE POR EMPRESA");
		List<Transporte> transportes = transporteDao.buscarPorEmpresa("o");
		for (Transporte t : transportes) {
			System.out.println(t.getEmpresa());
		}
		
		System.exit(0);
	}

}



