package br.com.AMGiv.bo;

import java.sql.Connection;

import br.com.AMGiv.beans.Funcionario;
import br.com.AMGiv.dao.FuncionarioDAO;

/**
 * Class FuncionarioBO.
 */

public abstract class FuncionarioBO {
	
	/**
	 * Consultar funcionario.
	 * @author * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param codFuncionario de cod funcionario da classe Funcionario.java
	 * @param conn de Connection (conexao com banco de dados)
	 * @return objeto do tipo funcionario 
	 * @throws Sql Exception
	 * @throws Exception
	 */
	
	public static Funcionario ConsultarFuncionario(int codFuncionario,Connection conn) throws Exception {
		return new FuncionarioDAO().getPesquisarFuncionario(codFuncionario,conn);
	}
	
}
