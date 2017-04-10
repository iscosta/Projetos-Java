package br.com.AMGiv.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.AMGiv.beans.Hospedagem;
import br.com.AMGiv.beans.ReservaQuarto;
import br.com.AMGiv.bo.HospedagemBO;
import br.com.AMGiv.bo.ReservaQuartoBO;
import br.com.AMGiv.conexao.ConexaoFactory;
import br.com.AMGiv.excecoes.Excecoes;

/**
 * Servlet implementation class CheckIn
 */
@WebServlet("/CheckIn")
public class CheckIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codNull = "Código não informado";
		String page = null;
		if(request.getParameter("codReserva") == null || request.getParameter("codReserva")==""){
			page = "checkin.jsp";
			getServletContext().setAttribute("status", codNull);			
		}else{				
			try {
				Connection con;
				
				con = ConexaoFactory.controlarInstancia().getConnection("------","---------");				
				
				try{
					
					int cdReserva = Integer.parseInt(request.getParameter("codReserva"));
					
					ReservaQuarto reserva = new ReservaQuarto();
										
					reserva = ReservaQuartoBO.ConsultarReservaQuarto(cdReserva, con);
					getServletContext().setAttribute("reserva",reserva);
					
					String dataAtual = request.getParameter("dataAtual");
					String horaAtual = request.getParameter("horaAtual");
					
					System.out.println("Data hora ini "+dataAtual+" "+horaAtual);
					
					Hospedagem h = new Hospedagem();
					h.setDataHoraEntrada(dataAtual+" "+horaAtual);
					h.setFuncionario(reserva.getFuncionario());
					h.setReservaQuarto(reserva);
					
					if(verificarDatas(h.getReservaQuarto().getDataInicio()) == true){
						h.getReservaQuarto().setStatus(3);
						ReservaQuartoBO.AlterarStatusReserva(h.getReservaQuarto().getStatus(),h.getReservaQuarto().getCodReserva(), con);
						String saida = "Data de Check-In excedida!";
						getServletContext().setAttribute("status",saida);
						page = "consultar.jsp";
					}else{
						HospedagemBO.cadastrarHospedagem(h, con);
						page = "index.jsp";
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
			
			}catch(SQLException se){
				se.printStackTrace();				
			} catch (Exception e1) {				
				e1.printStackTrace();
			}
		
		
		}//fim else
	}
	
	public static boolean verificarDatas(String dt) throws Exception{
		Calendar calendar = Calendar.getInstance();
		Calendar cal= Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");								 
		cal.setTime(dateFormat.parse(dt));
		
		return cal.getTime().before(calendar.getTime());
	}
	
	
}
