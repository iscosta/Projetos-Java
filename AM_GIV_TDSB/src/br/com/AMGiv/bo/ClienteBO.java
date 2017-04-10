package br.com.AMGiv.bo;

import java.sql.Connection;

import br.com.AMGiv.beans.Cliente;
import br.com.AMGiv.dao.ClienteDAO;
/**
 * Class ClienteBO.
 */
public abstract class ClienteBO {
	
	/**
	 * Consultar cliente e verificar sua existencia dentro do banco de dados.
	 * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param codCliente de cod cliente da classe cliente
	 * @param conn de Connection (conexao com banco de dados)
	 * @return objeto cliente
	 * @throws Sql Exception
	 * @throws Exception
	 */
	
	public static Cliente ConsultarCliente(int codCliente,Connection conn) throws Exception {
		return new ClienteDAO().getPesquisarCliente(codCliente,conn);
	}

}
