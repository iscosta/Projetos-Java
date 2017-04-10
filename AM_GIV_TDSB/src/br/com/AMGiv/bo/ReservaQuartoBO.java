package br.com.AMGiv.bo;

import java.sql.Connection;

import br.com.AMGiv.beans.ReservaQuarto;
import br.com.AMGiv.dao.ReservaQuartoDAO;

/**
 * Class ReservaQuartoBO.
 */

public abstract class ReservaQuartoBO {
	
	/**
	 * Consultar reserva quarto.
	 * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param codReserva de cod reserva da classe ReservaQuarto.java
	 * @param conn de Connection (conexão com banco de dados)
	 * @return objeto reserva quarto
	 * @throws Sql Exception
	 * @throws Exception
	 */
	
	public static ReservaQuarto ConsultarReservaQuarto(int codReserva,Connection conn) throws Exception {
		return new ReservaQuartoDAO().getPesquisarReservaQuarto(codReserva,conn);
	}
	
	/**
	 * Alterar status reserva.
	 * @author Rafael Paulo da Silva Queiros
	 * @version 1.0
	 * @since 1.0
	 * @param status de status da classe ReservaQuarto.java
	 * @param codReserva de cod reserva da classe ReservaQuarto.java
	 * @param conn de  Connection (conexão com banco de dados) 
	 * @return retorna um inteiro alterando e atualizando o status da reserva
	 * @throws Exception 
	 * @throws Sql Exception
	 */
	public static int AlterarStatusReserva(int status,int codReserva,Connection conn) throws Exception {
		return new ReservaQuartoDAO().atualizarStatusReserva(status,codReserva,conn);
	}
	
}
