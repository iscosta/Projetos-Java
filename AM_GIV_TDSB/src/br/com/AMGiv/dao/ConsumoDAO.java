package br.com.AMGiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.AMGiv.beans.Consumo;
import br.com.AMGiv.bo.FuncionarioBO;
import br.com.AMGiv.bo.HospedagemBO;


/**
 *  Class ConsumoDAO.
 */
public class ConsumoDAO {
	/**
	 * Gets lista.
	 * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param codHospedagem de cod hospedagem da classe Hospedagem.java
	 * @param conexao de Connection (conexão com banco de dados)
	 * @return um lista de objetos de Consumo
	 * @throws Sql Exception
	 * @throws Exception
	 */
	public List<Consumo> getLista(int codHospedagem,Connection conexao) throws Exception{
		List<Consumo> lstConsumo = new ArrayList<Consumo>();
		PreparedStatement estrutura =conexao.prepareStatement("select  C.CD_CONSUMO, C.CD_HOSPEDAGEM, C.CD_TIPO_SERVICO, "
				+ "C.CD_FUNCIONARIO, C.DT_CONSUMO, C.QT_CONSUMO, P.DT_VALIDADE, (C.QT_CONSUMO*P.VL_PRECO), PS.DS_SERVICO"
				+ " from T_AM_GIV_CONSUMO C INNER JOIN T_AM_GIV_HIST_PRECO P "
				+ " ON(C.CD_TIPO_SERVICO = P.CD_TIPO_SERVICO) INNER JOIN T_AM_GIV_PRODUTO_SERVICO PS "
				+ " ON(PS.CD_TIPO_SERVICO = C.CD_TIPO_SERVICO) "
				+ "WHERE TO_CHAR(P.DT_VALIDADE, 'MM/YYYY') = '07/2015'and CD_HOSPEDAGEM = ?");
		estrutura.setInt(1, codHospedagem);
		ResultSet resultadoDados = estrutura.executeQuery();		
		while(resultadoDados.next()){
			Consumo consumo = new Consumo();
			consumo.setCodConsumo(resultadoDados.getInt("CD_CONSUMO"));
			consumo.setDataConsumo((resultadoDados.getString("DT_CONSUMO")));
			consumo.setFuncionario(FuncionarioBO.ConsultarFuncionario(resultadoDados.getInt("CD_FUNCIONARIO"), conexao));
			consumo.setHospedagem(HospedagemBO.consultarHospedagem(resultadoDados.getInt("CD_HOSPEDAGEM"), conexao));
			consumo.setQuantidade((resultadoDados.getInt("QT_CONSUMO")));
			consumo.setTipoServico((resultadoDados.getString("DS_SERVICO")));
			consumo.setTotalConsumo((resultadoDados.getDouble("(C.QT_CONSUMO*P.VL_PRECO)")));
			lstConsumo.add(consumo);
		}		
		resultadoDados.close();
		estrutura.close();
		return lstConsumo;
	}

}
