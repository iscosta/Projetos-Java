package br.com.AMGiv.bo;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.AMGiv.beans.Hospedagem;
import br.com.AMGiv.dao.HospedagemDAO;
import br.com.AMGiv.excecoes.Excecoes;


/**
 *  Class HospedagemBO.
 */

public abstract class HospedagemBO {
		/** dao. */
	static HospedagemDAO dao = new HospedagemDAO();
	/**
	 * Cadastrar hospedagem.
	 *
	 * @author Givs
	 * @version 1.0
	 * @param h de Hospedagem da classe Hospedagem.java
	 * @param conn de Connection (parametro de conexão com o banco de dados)
	 * @throws Sql Exception 
	 * @since 1.0
	 * @throws Exception
	 */
	public static void cadastrarHospedagem(Hospedagem h, Connection conn) throws Exception{
		
		if(h.getReservaQuarto().getStatus() != 1){			
			throw new Excecoes("Reserva Cancelada");
		}
		Calendar calendar = Calendar.getInstance();
		Calendar cal= Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Data inicio: "+h.getReservaQuarto().getDataInicio() );
		String data = h.getReservaQuarto().getDataInicio();						 
		cal.setTime(dateFormat.parse(data)); 		
		
		if(cal.getTime().before(calendar.getTime())){
			h.getReservaQuarto().setStatus(3);
			ReservaQuartoBO.AlterarStatusReserva(h.getReservaQuarto().getStatus(),h.getReservaQuarto().getCodReserva(), conn);
			throw new Excecoes("Data de Check-In excedida!");
		}
		new HospedagemDAO().registrarHospedagem(h, conn);
	}
	/**
	 * Consultar hospedagem.
	 * @author Rafael Paulo da Silva Queiros
	 * @version 1.0
	 * @since 1.0
	 * @param codHospedagem de cod hospedagem da classe Hospedagem
	 * @param conn de Connection (parametro de conexão com o banco de dados)
	 * @return objeto do tipo hospedagem
	 * @throws Exception 
	 * @throws sql Exception
	 */
	public static Hospedagem consultarHospedagem(int codHospedagem,Connection conn) throws Exception{
		return new HospedagemDAO().getPesquisarHospedagem(codHospedagem, conn);
	}
	
	
	
}
