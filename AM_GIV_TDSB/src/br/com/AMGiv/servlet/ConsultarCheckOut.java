package br.com.AMGiv.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.AMGiv.beans.Consumo;
import br.com.AMGiv.beans.Hospedagem;
import br.com.AMGiv.beans.Pagamento;
import br.com.AMGiv.bo.ConsumoBO;
import br.com.AMGiv.bo.HospedagemBO;
import br.com.AMGiv.bo.PagamentoBO;
import br.com.AMGiv.conexao.ConexaoFactory;
import br.com.AMGiv.excecoes.Excecoes;

/**
 * Servlet implementation class ConsultarCheckOut
 */
@WebServlet("/ConsultarCheckOut")
public class ConsultarCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static Connection con;
	static DecimalFormat formatado = new DecimalFormat("#,##0.00");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		String saida = null;
		String cod = request.getParameter("codHospedagem");
		String status = null;
		try {	
		
			if(cod == null || cod.equals("") || cod.equals(" ")){
				saida = "Código não informado";
				page = "consultarcheckout.jsp";
				getServletContext().setAttribute("saida", saida);
			}else{
				
					
					con = ConexaoFactory.controlarInstancia().getConnection("------","--------");				
					
					try{
						
						int cdHospedagem = Integer.parseInt(request.getParameter("codHospedagem"));
						 List<Consumo> lstConsumo = new ArrayList<Consumo>();
						 lstConsumo = ConsumoBO.listarConsumo(cdHospedagem, con);
						 
						 getServletContext().setAttribute("listaConsumo", lstConsumo);
						 page = "checkout.jsp";
						 
						 Hospedagem h = new Hospedagem(); 
						 h = HospedagemBO.consultarHospedagem(cdHospedagem, con);
						 getServletContext().setAttribute("hospedagem", h);
						 
						
						 getServletContext().setAttribute("totalConsumo", formatado.format(calcTotalConsumo(lstConsumo)));
						 getServletContext().setAttribute("totalGeral", formatado.format(calcTotalConsumo(lstConsumo)+h.getReservaQuarto().getTotalReservaQuarto()));
						 					 
						 
						 if(verificarExistencia(cdHospedagem,con)){
							status = "Pagamento já efetuado para esta hospedagem!";
							 getServletContext().setAttribute("saida", status);
							 page = "consultarcheckout.jsp";
						 }
						 
						 
					}catch(Exception e){				
						throw new Excecoes("Falha: "+e);
					}finally{
						try{
							con.close();
						}catch(Exception e){
							throw new Excecoes("Falha: "+e);
						}
						response.sendRedirect(page);	
					}				
							
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
	}
	
	//total de consumo
	static double calcTotalConsumo(List<Consumo> lstConsumo){
		double totalConsumo=0;		
		for(Consumo c: lstConsumo){
			totalConsumo += c.getTotalConsumo();
		}		
		return totalConsumo;
	}
	
	public static boolean verificarExistencia(int cod, Connection con) throws Exception{
		Pagamento pagamento = new Pagamento();
		pagamento = PagamentoBO.buscarPagamento(cod, con);		
		if(pagamento.getValorTotal() > 0){
			return true;			
		}else{
			return false;
		}		
	}
	

}
