package br.com.AMGiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.AMGiv.beans.Cliente;
/**
 * The Class ClienteDAO.
 */
public class ClienteDAO {
	/**
	 * Cadastrar cliente.
	 * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param c de Cliente da classe Cliente.java
	 * @param conexao de Connection (conexao com banco de dados)
	 * @return String com mensagem de sucesso
	 * @throws Sql Exception
	 * @throws Exception
	 */
	public String cadastrarCliente(Cliente c,Connection conexao) throws Exception {
		
		String sql = "INSERT INTO T_AM_GIV_CLIENTE (CD_CLIENTE,NR_CPF, NR_RG,DT_NASCIMENTO,NR_QUARTO_PREFERIDO,DS_EMAIL,DS_SENHA,NM_PESSOA)"
		+ " VALUES (SQ_AM_PESSOA.nextval,?,?,?,?,?,?,?)";
		try {

			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setFloat(2, c.getCpf());
			estrutura.setString(3, c.getRg());
			estrutura.setString(4, c.getDataNascimento());
			estrutura.setInt(5, c.getQuartoPreferido());
			estrutura.setString(6, c.getEmail());
			estrutura.setString(7, c.getSenha());
			estrutura.setString(8, c.getNome());
			estrutura.execute();
			estrutura.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "gravado com sucesso";
	}
	
	/**
	 * Gets pesquisar cliente.
	 * @author Rafael Paulo da Silva Queiros
	 * @version 1.0
	 * @since 1.0
	 * @param codCliente de cod cliente da classe Cliente.java
	 * @param conexao de Connection (conexão com banco de dados)
	 * @return Um objeto cliente
	 * @throws Exception 
	 * @throws Sql Exception 
	 */
	public Cliente getPesquisarCliente(int codCliente,Connection conexao) throws Exception {
		Cliente cliente = new Cliente();
		PreparedStatement estrutura = conexao.prepareStatement("select C.CD_CLIENTE,C.DS_EMAIL,C.DS_SENHA,C.DT_NASCIMENTO, C.NR_CPF,C.NR_QUARTO_PREFERIDO,C.NR_RG,P.NM_PESSOA "
				+ "  from T_AM_GIV_CLIENTE C INNER JOIN T_AM_GIV_PESSOA P"
				+ "  ON (C.CD_CLIENTE = P.CD_PESSOA)  WHERE CD_CLIENTE = ?");
		estrutura.setInt(1, codCliente);
		ResultSet resultadoDados = estrutura.executeQuery();
		if (resultadoDados.next()) {
			cliente.setCodCliente(resultadoDados.getInt("CD_CLIENTE"));
			cliente.setCpf(resultadoDados.getLong("NR_CPF"));
			cliente.setRg(resultadoDados.getString("NR_RG"));
			cliente.setDataNascimento(resultadoDados.getString("DT_NASCIMENTO"));
			cliente.setQuartoPreferido(resultadoDados.getInt("NR_QUARTO_PREFERIDO"));
			cliente.setEmail(resultadoDados.getString("DS_EMAIL"));
			cliente.setSenha(resultadoDados.getString("DS_SENHA"));
			cliente.setNome(resultadoDados.getString("NM_PESSOA"));
		}
		resultadoDados.close();
		estrutura.close();
		return cliente;
	}
	
	
	/**
	 * Deletar cliente.
	 * @author Rafael Paulo da Silva Queiros
	 * @version 1.0
	 * @since 1.0
	 * @param codCliente de cod cliente da classe Cliente.java
	 * @param conexao de Connection (conexão com banco de dados)
	 * @return um um inteiro com o resultado dos dados
	 * @throws Exception the exception
	 */
	public int deletarCliente(int codCliente, Connection conexao) throws Exception {
		PreparedStatement estrutura = conexao
				.prepareStatement("delete from T_AM_GIV_CLIENTE where CD_CLIENTE = ?");
		estrutura.setInt(1, codCliente);
		int resultadoDados = estrutura.executeUpdate();
		estrutura.close();
		return resultadoDados;
	}
	

}
