package br.com.AMGiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.AMGiv.beans.Pagamento;
import br.com.AMGiv.bo.ConsumoBO;
import br.com.AMGiv.bo.HospedagemBO;

/**
 *	Class PagamentoDAO.
 */
public class PagamentoDAO {
	/**
	 * Registrar pagamento.
	 * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param p de Pagamento da classe Pagamento.java
	 * @param conexao the Connection (conexão com banco de dados)
	 * @return retorna uma mensagem de sucesso 
	 * @throws Sql Exception
	 * @throws Exception	 
	 */	
	public String registrarPagamento(Pagamento p,Connection conexao) throws Exception {		
		String sql = "INSERT INTO T_AM_GIV_PAGAMENTO ( cd_hospedagem, cd_tipo_formapag, dt_pagamento, vl_pagamento) "
				+ "VALUES(?, (SELECT cd_tipo_formapag FROM T_AM_GIV_TIPO_FORMAPAG WHERE ds_formapag = ?), TO_DATE(?,'DD/mm/yyyy'), ?)";
		try {
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, p.getHospedagem().getCodHospedagem());
			estrutura.setString(2, p.getTipoFormaPag().toUpperCase());
			estrutura.setString(3, p.getDataHoraSaida());
			estrutura.setDouble(4, p.getValorTotal());
			estrutura.execute();
			estrutura.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "gravado com sucesso";
	}
	/**
	 * Gets pesquisar pagamento.
	 * @author Rafael Paulo da Silva Queiros
	 * @version 1.0
	 * @since 1.0
	 * @param codHospedagem de cod hospedagem da classe Hospedagem.java
	 * @param conexao de Connection (conexao com banco de dados )
	 * @return retorna objeto do tipo Pagamento 
	 * @throws Exception 
	 * @thrws Sql Exception
	 */
	public Pagamento getPesquisarPagamento(int codHospedagem,Connection conexao) throws Exception {
		Pagamento pagamento = new Pagamento();
		PreparedStatement estrutura = conexao.prepareStatement("select CD_HOSPEDAGEM, F.DS_FORMAPAG , DT_PAGAMENTO, VL_PAGAMENTO from T_AM_GIV_PAGAMENTO P "
				+ " INNER JOIN T_AM_GIV_TIPO_FORMAPAG F ON(F.CD_TIPO_FORMAPAG = P.CD_TIPO_FORMAPAG) WHERE CD_HOSPEDAGEM = ?");
		estrutura.setInt(1, codHospedagem);
		ResultSet resultadoDados = estrutura.executeQuery();
		if (resultadoDados.next()) {
			pagamento.setConsumo(ConsumoBO.listarConsumo(resultadoDados.getInt("CD_HOSPEDAGEM"), conexao));
			pagamento.setDataHoraSaida(resultadoDados.getString("DT_PAGAMENTO"));
			pagamento.setHospedagem(HospedagemBO.consultarHospedagem(resultadoDados.getInt("CD_HOSPEDAGEM"), conexao));
			pagamento.setTipoFormaPag(resultadoDados.getString("DS_FORMAPAG"));
			pagamento.setValorTotal(resultadoDados.getDouble("VL_PAGAMENTO"));
		}
		resultadoDados.close();
		estrutura.close();
		return pagamento;
	}

}
