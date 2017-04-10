<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import = "java.util.*"%> 
<%@page import = "java.text.SimpleDateFormat"%> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="StyleSheets/styleCheckout.css">
    <title>Hotel Boa Viagem | Check-Out</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
	<script type="text/javascript" href="jquery/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script type="text/javascript" src="jquery/behavior.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <script type="text/javascript" src="jquery/jquery-1.11.2.min.js"></script>
    <link rel="stylesheet" href="jquery/jquery-ui-1.11.4.custom/jquery-ui.css" />
	<script>
		$(function() {
		    $("#tabs").tabs({
		        event: "click"
		    })
		});
	</script>
</head>
<body>
    <div class="wrapper">
    	<header>
	        <h1>Hotel Boa Viagem</h1>
	        <h2>CHECK-OUT</h2>
        </header>
        <main>
        <form action="CheckOut" method="get">
       
		       <div class="form">
		           <label for="codHospedagem">Hospedagem</label>
		           <input type="text" name="codHospedagem" value="${hospedagem.codHospedagem}" id="hospedagem" onkeypress="return SomenteNumero(event)" maxlength="6" readonly />
		           
				<label for="nomeHospede">Hóspede</label>
		           <input type="text" name="nomeHospede" maxlength="30" value="${hospedagem.reservaQuarto.cliente.nome}" readonly />
				
		           <label>CPF</label>
		           <input type="text" name="cpf" value="${hospedagem.reservaQuarto.cliente.cpf}" OnKeyPress="formatar('###.###.###-##', this)" maxlength="14" readonly />
						
				<label>Data Saída</label>
		           <input type="date" name="dataSaida" />
		           
				<label>Horário de Saída</label>
				
		           <input type="time" name="horaSaida" />
		       </div>
		       <div class="valores">
		           <label>Total Consumo</label>
		           <input type="text" name="totalConsumo" maxlength="12" onkeypress="MascaraMoeda(this)" value="${totalConsumo}" readonly />
		           <label>Total da Estádia</label>
		           <input type="text" name="totalEstadia" maxlength="12" onkeypress="MascaraMoeda(this)" value="${hospedagem.reservaQuarto.totalReservaQuarto}" readonly />
		           <label>Total á Pagar</label>
		           <input type="text" name="totalGeral" maxlength="12" onkeypress="MascaraMoeda(this)"  value="${totalGeral}" readonly />
		       </div>
		       <div class="tabela">
		           <table class="rwd-table">
		               <tr>
		                   <th>Código</th>
		                   <th>Tipo de Serviço</th>
		                   <th>Quantidade</th>
		                   <th>Valor</th>
		               </tr>
		               <tr>
					<c:forEach var="consumo" items="${listaConsumo}">
						<tr>
							<td>${consumo.codConsumo}</td>
							<td>${consumo.tipoServico}</td>
							<td>${consumo.quantidade}</td>
							<td>${consumo.totalConsumo}</td>
						</tr>
					</c:forEach>
		               </tr>
		
		
		           </table>
		       </div>		
			
		     	<div id="tabs">
			       <ul>
			           <li><a href="#tabs-1">Cartão</a>
			           </li>
			           <li><a href="#tabs-2">Dinheiro</a>
			           </li>
			           <li><a href="#tabs-3">Cheque</a>
			           </li>
			       </ul>
			       <div id="tabs-1">
			           <p><input type="radio" name="tip_pag" value="CARTÃO DÉBITO" />Débito</p>
			           <p><input type="radio" name="tip_pag" value="CARTÃO DE CRÉDITO PARCELADO" />Crédito</p>
			       </div>
			       <div id="tabs-2">
						<p><input type="radio" name="tip_pag" value="DINHEIRO - A VISTA"> Dinheiro</p>
					</div>
			       	<div id="tabs-3">
					<p><input type="radio" name="tip_pag" value="CHEQUE - A VISTA" > Cheque à vista</p> 
					<p><input type="radio" name="tip_pag" value="CHEQUE PARCELADO"> Cheque parcelado</p>
			       	</div>
		    	</div>
		        
		        <div id="btnConfirma">
		            <button value="Confirmar Pagamento">Confirmar Pagamento</button>
		            <button value="imprimir" onClick="window.print()">Imprimir</button>
		        </div>
		   	<!-- /.wrapper -->
    	</form>
    	</main>
    	</div>
</body>

</html>