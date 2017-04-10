package br.com.AMGiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.AMGiv.beans.Quarto;

/**
 * The Class QuartoDAO.
 */
public class QuartoDAO {
	/**
	 * Gets pesquisar quarto.
	 * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param numQuarto de num quarto da classe Quarto.java
	 * @param conexao de Connection (conexao com banco de dados )
	 * @return um objeto do tipo quarto 
	 * @throws Sql Exception 
	 * @throws Exception	 
	 */
	public Quarto getPesquisarQuarto(int numQuarto,Connection conexao) throws Exception {
		Quarto quarto = new Quarto();
		PreparedStatement estrutura = conexao.prepareStatement("select * from T_AM_GIV_QUARTO where NR_QUARTO = ?");
		estrutura.setInt(1, numQuarto);
		ResultSet resultadoDados = estrutura.executeQuery();
		if (resultadoDados.next()) {
			quarto.setCapacidade(resultadoDados.getInt("NR_CAPACIDADE"));
			quarto.setNumAndar(resultadoDados.getInt("NR_ANDAR"));
			quarto.setNumQuarto(resultadoDados.getInt("NR_QUARTO"));			
			quarto.setTipoQuarto(resultadoDados.getString("CD_TIPO_QUARTO"));
		}
		resultadoDados.close();
		estrutura.close();
		return quarto;
	}


}
