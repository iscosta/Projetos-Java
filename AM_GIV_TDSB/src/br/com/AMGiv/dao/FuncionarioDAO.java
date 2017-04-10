package br.com.AMGiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.AMGiv.beans.Funcionario;
/**
 * Class FuncionarioDAO.
 */
public class FuncionarioDAO {
	/**
	 * Gets pesquisar funcionario.
	 * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param codFuncionario de cod funcionario da classe Funcionario.java
	 * @param conexao de  Connection (conexao com banco de dados)
	 * @return Um objeto funcionario 
	 * @trhows Sql Exception 
	 * @throws Exception
	 */
	public Funcionario getPesquisarFuncionario(int codFuncionario,Connection conexao) throws Exception {
		Funcionario funcionario = new Funcionario();
		PreparedStatement estrutura = conexao.prepareStatement(" SELECT F.CD_FUNCIONARIO,F.DS_CARGO,F.DT_ADMISSAO,P.NM_PESSOA "
																+ "  FROM T_AM_GIV_FUNCIONARIO F INNER JOIN T_AM_GIV_PESSOA P "
																+ " ON(F.CD_FUNCIONARIO = P.CD_PESSOA) WHERE CD_FUNCIONARIO = ?");
		estrutura.setInt(1, codFuncionario);
		ResultSet resultadoDados = estrutura.executeQuery();
		if (resultadoDados.next()) {
			funcionario.setCargo(resultadoDados.getInt("DS_CARGO")); 
			funcionario.setCodFuncionario(resultadoDados.getInt("CD_FUNCIONARIO"));
			funcionario.setDtAdmissao(resultadoDados.getString("DT_ADMISSAO"));
			funcionario.setNome(resultadoDados.getString("NM_PESSOA"));
		}
		resultadoDados.close();
		estrutura.close();
		return funcionario;
	}
	
}
