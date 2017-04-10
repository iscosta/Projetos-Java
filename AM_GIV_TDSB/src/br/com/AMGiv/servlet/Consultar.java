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

import br.com.AMGiv.beans.ReservaQuarto;
import br.com.AMGiv.bo.ReservaQuartoBO;
import br.com.AMGiv.conexao.ConexaoFactory;
import br.com.AMGiv.excecoes.Excecoes;

/**
 * Servlet implementation class Consultar
 */
@WebServlet("/Consultar")
public class Consultar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=null;
		String codNull = "Código não informado";
		String codReserva = request.getParameter("codReserva");
		if( codReserva.equals(null) || codReserva.equals("") || codReserva.equals(" ")){
			page = "consultar.jsp";
			getServletContext().setAttribute("status", codNull);			
		}else{				
			try {
				Connection con;
				
				con = ConexaoFactory.controlarInstancia().getConnection("-------","--------");				
				
				try{
					
					int cdReserva = Integer.parseInt(request.getParameter("codReserva"));
					
					ReservaQuarto reserva = new ReservaQuarto();
										
					reserva = ReservaQuartoBO.ConsultarReservaQuarto(cdReserva, con);
					getServletContext().setAttribute("reserva",reserva);
					
					if(reserva.getCodReserva() != 0){
						
						getServletContext().setAttribute("status", getStatusReserva(reserva.getStatus()));
						if(reserva.getStatus() != 1){
							page = "consultar.jsp";
							codNull= getStatusReserva(reserva.getStatus());
							getServletContext().setAttribute("status", codNull);							
						}else{
							getServletContext().setAttribute("dataAtual", getDataAtual());
							getServletContext().setAttribute("horaAtual", getHoraAtual());
							page = "checkin.jsp";
						}
						
					}else{
						codNull = "Reserva não encontrada";
						getServletContext().setAttribute("status", codNull);
						page = "consultar.jsp";
					}
				}catch(SQLException e){
					throw new Excecoes("Falha: "+e);						
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
			}catch(SQLException se){
				se.printStackTrace();				
			} catch (Exception e1) {				
				e1.printStackTrace();
			}
		
		
		}//fim else
	}
	public static String getDataAtual(){
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataAtual = (dateFormat.format(cal.getTime()));
		
		return dataAtual;
	}
	
	public static String getHoraAtual(){
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
		String horaAtual = (dateFormate.format(cal.getTime()));
		
		return horaAtual;
	}
	
	public static String getStatusReserva(int status){
		String st=null;
		if(status == 1){
			st = "Reserva Aberta";
		}else if(status == 2){
			st = "Reserva Fechada";
		}else if(status == 3){
			st = "Reserva Cancelada";
		}else{
			st = "Status desconhecido!";
		}
		return st;
	}

}
