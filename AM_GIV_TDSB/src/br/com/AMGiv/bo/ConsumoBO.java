package br.com.AMGiv.bo;

import java.sql.Connection;
import java.util.List;

import br.com.AMGiv.beans.Consumo;
import br.com.AMGiv.dao.ConsumoDAO;
/**
 * Class ConsumoBO.
 */
public abstract class ConsumoBO {
	
		/**
	 * Uma lista de Consumos.
	 * @author Givs
	 * @version 1.0
	 * @since 1.0
	 * @param codHospedagem de cod hospedagem da classe Hospedagem.java
	 * @param conn de Connection (conexao com banco de dados)
	 * @return Uma lista de objetos do tipo consumo
	 * @throws Sql Exception
	 * @throws Exception
	 */
	
	public static List<Consumo> listarConsumo(int codHospedagem,Connection conn) throws Exception{
		return new ConsumoDAO().getLista(codHospedagem, conn);
	}
	
}
