package br.com.AMGiv.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.AMGiv.beans.Pagamento;
import br.com.AMGiv.bo.ConsumoBO;
import br.com.AMGiv.bo.HospedagemBO;
import br.com.AMGiv.bo.PagamentoBO;
import br.com.AMGiv.conexao.ConexaoFactory;
import br.com.AMGiv.excecoes.Excecoes;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		String saida = null;
		String cod = request.getParameter("codHospedagem");
		try {
			
			if(cod.equals(null) || cod.equals("") || cod.equals(" ")){
				saida = "Código não informado";
				page = "consultarcheckout.jsp";
				getServletContext().setAttribute("saida", saida);	
			}else{
				
				Connection con;
				
				con = ConexaoFactory.controlarInstancia().getConnection("------","-------");				
				
				try{
					
					int cdHospedagem = Integer.parseInt(request.getParameter("codHospedagem"));
					
					Pagamento pagamento = new Pagamento();					
					pagamento.setConsumo(ConsumoBO.listarConsumo(cdHospedagem, con));
					String data = request.getParameter("dataSaida")+" "+request.getParameter("horaSaida");					
					pagamento.setDataHoraSaida(formatarData(data));					
					pagamento.setHospedagem(HospedagemBO.consultarHospedagem(cdHospedagem, con));
					System.out.println("tipo: "+request.getParameter("tip_pag"));
					pagamento.setTipoFormaPag(request.getParameter("tip_pag"));
					pagamento.setValorTotal(Double.parseDouble(request.getParameter("totalGeral").replaceAll(",", ".")));
					
					if(verificarExistencia(pagamento.getHospedagem().getCodHospedagem(),con)){
						PagamentoBO.registrarPagamento(pagamento, con); 
						page = "consultarcheckout.jsp";
					}else{
						String status = "Pagamento já efetuado!";
						getServletContext().setAttribute("saida", status);	
						page = "consultarcheckout.jsp";
					}
					
					 
								
				} catch (Exception e1) {				
					e1.printStackTrace();
				
				}finally{
					try{
						con.close();
					}catch(SQLException e){
						throw new Excecoes("Falha: "+e);
					}catch(Exception e){
						throw new Excecoes("Falha: "+e);
					}
					response.sendRedirect(page);	
				}
				
				
			}
		}catch(SQLException se){
			se.printStackTrace();				
		} catch (Exception e1) {				
			e1.printStackTrace();
		}
			
			
		
		
	}
	
	public static boolean verificarExistencia(int cod, Connection con) throws Exception{
		Pagamento pagamento = new Pagamento();
		pagamento = PagamentoBO.buscarPagamento(cod, con);	
		System.out.println(pagamento.getValorTotal());
		if(pagamento.getValorTotal() ==  null){
			return true;
		}else{
			return false;
		}		
	}
	
	public static String formatarData(String data) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = sdf.parse(data);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		String strdate = null;

		SimpleDateFormat sdff = new SimpleDateFormat("dd/MM/yyyy");

		strdate = sdff.format(cal.getTime());
		
		System.out.println("Data "+strdate);
		return strdate;
	}
}
