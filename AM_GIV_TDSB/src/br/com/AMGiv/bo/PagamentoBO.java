package br.com.AMGiv.bo;

import java.sql.Connection;

import br.com.AMGiv.beans.Pagamento;
import br.com.AMGiv.dao.PagamentoDAO;
import br.com.AMGiv.excecoes.Excecoes;

/**
 * Class PagamentoBO.
 */
public abstract class PagamentoBO {
	
	/**
	 * Registrar pagamento.
	 * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param pagamento de pagamento da Classe Pagamento.java
	 * @param conn de Connection (conexão com banco de dados)
	 * @throws Sql Exception
	 * @throws Exception
	 */
	 
	public static void registrarPagamento(Pagamento pagamento, Connection conn) throws Exception{
		if(pagamento.getTipoFormaPag().equals(null) || pagamento.getTipoFormaPag().equals("") || pagamento.getTipoFormaPag().equals(" ")){
			throw new Excecoes("Forma de pagamento não informada!");
		}
		
		if(pagamento.getValorTotal() <=0){
			throw new Excecoes("Valor total da hospedagem não informada!");
		}
		
		if(pagamento.getHospedagem() == null){
			throw new Excecoes("Hospedagem não informada");
		}
		
		if(pagamento.getDataHoraSaida().equals("") || pagamento.getDataHoraSaida().equals(" ")){
			throw new Excecoes("Data e horada da saida não informada");
		}
		new PagamentoDAO().registrarPagamento(pagamento, conn);
	}
	
	
	/**
	 * Buscar pagamento.
	 * @author Rafael Paulo da Silva Queiros
	 * @version 1.0
	 * @since 1.0
	 * @param codHospedagem de cod hospedagem da classe Hospedagem.java
	 * @param conn de Connection (conexão com banco de dados)
	 * @return objeto pagamento
	 * @throws Exception
	 * @throws Sql Exception
	 */
	public static Pagamento buscarPagamento(int codHospedagem, Connection conn) throws Exception{
		return new PagamentoDAO().getPesquisarPagamento(codHospedagem, conn);
	}

}
