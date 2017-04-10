package br.com.AMGiv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.AMGiv.beans.Hospedagem;
import br.com.AMGiv.bo.FuncionarioBO;
import br.com.AMGiv.bo.ReservaQuartoBO;

/**
 * Class HospedagemDAO.
 */
public class HospedagemDAO {
	/**
	 * Registrar hospedagem.
	 * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param h de Hospedagem da classe Hospedagem.java
	 * @param conexao de Connection(conexao com banco de dados)
	 * @return String com menssagem de sucesso
	 * @throws Sql Exception 
	 * @throws Exception	 
	 */
	public String registrarHospedagem(Hospedagem h,Connection conexao) throws Exception {		
		String sql = "INSERT INTO T_AM_GIV_HOSPEDAGEM (CD_CLIENTE,CD_FUNCIONARIO,CD_RESERVA,DT_ENTRADA,DT_SAIDA,NR_QUARTO,VC_PERC_DESCONTO,CD_HOSPEDAGEM)"
		+ " VALUES (?,?,?,TO_DATE(?,'dd/MM/yyyy hh24:mi:ss'),TO_DATE(?,'dd/MM/yyyy'),?,0,SQ_AM_GIV_HOSPEDAGEM.nextval)";
		try {
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, h.getReservaQuarto().getCliente().getCodCliente());
			System.out.println("1 cliente "+h.getReservaQuarto().getCliente().getCodCliente());
			estrutura.setInt(2, h.getFuncionario().getCodFuncionario());
			System.out.println("2 func "+h.getFuncionario().getCodFuncionario());
			estrutura.setInt(3, h.getReservaQuarto().getCodReserva());
			System.out.println(" 3 cod reser "+h.getReservaQuarto().getCodReserva());
			estrutura.setString(4, h.getDataHoraEntrada());
			System.out.println("4 dataEntrada "+h.getDataHoraEntrada());
			estrutura.setString(5, h.getReservaQuarto().getDataFinal());
			System.out.println("5 data saida "+h.getReservaQuarto().getDataFinal());
			estrutura.setInt(6, h.getReservaQuarto().getQuarto().getNumQuarto());
			System.out.println("6 Quarto: "+h.getReservaQuarto().getQuarto().getNumQuarto());
			estrutura.execute();
			estrutura.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "gravado com sucesso";
	}
	/**
	 * Gets de pesquisar hospedagem.
	 * @author Rafael Paulo da Silva Queiros
	 * @version 1.0
	 * @since 1.0
	 * @param codHospedagem de cod hospedagem da classe Hospedagem
	 * @param conexao de Connection(conexao com banco de dados)
	 * @return retorna um obejto do tipo hospedagem 
	 * @throws Exception 
	 * @throws Sql Exception 
	 */	
	public Hospedagem getPesquisarHospedagem(int codHospedagem,Connection conexao) throws Exception {
		Hospedagem hospedagem = new Hospedagem();
		PreparedStatement estrutura = conexao.prepareStatement("SELECT CD_HOSPEDAGEM, CD_CLIENTE,CD_FUNCIONARIO,CD_RESERVA,DT_ENTRADA,DT_SAIDA,NR_QUARTO, "
				+ " VC_PERC_DESCONTO FROM T_AM_GIV_HOSPEDAGEM WHERE CD_HOSPEDAGEM = ?");
		estrutura.setInt(1, codHospedagem);
		ResultSet resultadoDados = estrutura.executeQuery();
		if (resultadoDados.next()) {
			hospedagem.setCodHospedagem(resultadoDados.getInt("CD_HOSPEDAGEM"));
			hospedagem.setDataHoraEntrada(resultadoDados.getString("DT_ENTRADA"));
			hospedagem.setFuncionario((FuncionarioBO.ConsultarFuncionario(resultadoDados.getInt("CD_FUNCIONARIO"), conexao)));
			hospedagem.setReservaQuarto(ReservaQuartoBO.ConsultarReservaQuarto(resultadoDados.getInt("CD_RESERVA"), conexao));
		}
		resultadoDados.close();
		estrutura.close();
		return hospedagem;
	}

}
