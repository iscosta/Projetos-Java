package br.com.AMGiv.bo;

import java.sql.Connection;

import br.com.AMGiv.beans.Quarto;
import br.com.AMGiv.dao.QuartoDAO;

/**
 * Class QuartoBO.
 */

public abstract class QuartoBO {

	/**
	 * Consultar quarto.
	 * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param numQuarto de num quarto da classe Quarto.java
	 * @param con de Connection(conexão com banco de dados)
	 * @return objeto do tipo quarto
	 * @throws Sql Exception
	 * @throws Exception
	 */

	public static Quarto ConsultarQuarto(int numQuarto,Connection conn) throws Exception {
		return new QuartoDAO().getPesquisarQuarto(numQuarto,conn);
	}
	
}
