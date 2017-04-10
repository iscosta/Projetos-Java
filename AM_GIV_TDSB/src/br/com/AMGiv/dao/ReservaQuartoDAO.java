package br.com.AMGiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.AMGiv.beans.ReservaQuarto;
import br.com.AMGiv.bo.ClienteBO;
import br.com.AMGiv.bo.FuncionarioBO;
import br.com.AMGiv.bo.QuartoBO;

/**
 * The Class ReservaQuartoDAO.
 */

public class ReservaQuartoDAO {
	

		/**
		 * Gets pesquisar reserva quarto.
		 * @author Givs
		 * @version 1.0
		 * @since 1.0
		 * @param codReserva de  cod reserva da classe ReservaQuarto.java
		 * @param conexao Connection (conexao com banco de dados)
		 * @return objeto reservaQuarto
		 * @trows Sql Exception 
		 * @throws Exception		 
		 */		
		public ReservaQuarto getPesquisarReservaQuarto(int codReserva,Connection conexao) throws Exception {
			ReservaQuarto reservaQuarto = new ReservaQuarto();
			PreparedStatement estrutura = conexao.prepareStatement("select R.CD_CLIENTE,R.CD_FUNCIONARIO,R.CD_RESERVA,TO_CHAR(DT_FINAL_RESERVA,'DD/MM/YYYY'), "
					+ " TO_CHAR(DT_INICIO_RESERVA,'DD/MM/YYYY'), TO_CHAR(DT_SOLICITACAO,'DD/MM/YYYY'), R.QT_ADULTO,R.QT_CRIANCA,R.ST_RESERVA,RQ.DS_OBSERVACAO, "
					+ " RQ.NR_QUARTO,RQ.QT_PESSOA_QUARTO,((RQ.QT_PESSOA_QUARTO*HV.VL_PRECO_QUARTO)* "
					+ " (TO_DATE(DT_FINAL_RESERVA,'DD/MM/YYYY')-TO_DATE(DT_INICIO_RESERVA,'DD/MM/YYYY'))) TOTALRESERVA	"
							+ " from T_AM_GIV_RESERVA R INNER JOIN T_AM_GIV_RESERVA_QUARTO RQ ON (RQ.CD_RESERVA = R.CD_RESERVA) "
							+ " INNER JOIN T_AM_GIV_QUARTO Q  ON (Q.NR_QUARTO = RQ.NR_QUARTO) INNER JOIN T_AM_GIV_HIST_VALOR HV "
							+ " ON (HV.CD_TIPO_QUARTO = Q.CD_TIPO_QUARTO) WHERE TO_CHAR(DT_SOLICITACAO,'MM/YYYY') = TO_CHAR(HV.DT_VALIDADE,'MM/YYYY')  "
							+ " AND R.CD_RESERVA = ?");
			estrutura.setInt(1, codReserva);
			ResultSet resultadoDados = estrutura.executeQuery();
			if (resultadoDados.next()) {
				reservaQuarto.setCapaciPessoaQuarto(resultadoDados.getInt("QT_PESSOA_QUARTO")); 
				reservaQuarto.setCliente(ClienteBO.ConsultarCliente(resultadoDados.getInt("CD_CLIENTE"), conexao));
				reservaQuarto.setCodReserva(resultadoDados.getInt("CD_RESERVA"));
				reservaQuarto.setDataFinal(resultadoDados.getString("TO_CHAR(DT_FINAL_RESERVA,'DD/MM/YYYY')"));
				reservaQuarto.setDataInicio(resultadoDados.getString("TO_CHAR(DT_INICIO_RESERVA,'DD/MM/YYYY')"));
				reservaQuarto.setDataSolicitacao(resultadoDados.getString("TO_CHAR(DT_SOLICITACAO,'DD/MM/YYYY')"));
				reservaQuarto.setFuncionario(FuncionarioBO.ConsultarFuncionario(resultadoDados.getInt("CD_FUNCIONARIO"),conexao));
				reservaQuarto.setObservacao(resultadoDados.getString("DS_OBSERVACAO"));
				reservaQuarto.setQntAdultos(resultadoDados.getInt("QT_ADULTO"));
				reservaQuarto.setQntCriancas(resultadoDados.getInt("QT_CRIANCA"));
				reservaQuarto.setQuarto(QuartoBO.ConsultarQuarto(resultadoDados.getInt("NR_QUARTO"), conexao));
				reservaQuarto.setStatus(resultadoDados.getInt("ST_RESERVA"));
				reservaQuarto.setTotalReservaQuarto(resultadoDados.getDouble("TOTALRESERVA"));
			}
			resultadoDados.close();
			estrutura.close();
			return reservaQuarto;
		}
		
	/**
	 * Atualizar status reserva.
	 * @author Rafael Paulo da Silva Queiros
	 * @version 1.0
	 * @since 1.0
	 * @param status de status da classe ReservaQuarto.java
	 * @param codReserva de cod reserva da classe ReservaQuarto.java
	 * @param conexao de Connection (conexao com banco de dados)
	 * @return um inteiro para atualizar o status da reserva
	 * @throws Exception
	 * @trhows Sql Exception 
	 */	
	public int atualizarStatusReserva(int status,int codReserva, Connection conexao) throws Exception{		
		PreparedStatement estrutura = conexao.prepareStatement("UPDATE T_AM_GIV_RESERVA SET ST_RESERVA = ? where CD_RESERVA = ?");
		estrutura.setInt(1, status);
		estrutura.setInt(2, codReserva);
		int i = estrutura.executeUpdate();
		estrutura.close();
		return i;
	}
   
	
    
    
    
    
    
    
    
}
