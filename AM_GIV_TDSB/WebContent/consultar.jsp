<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hotel Boa Viagem | Check-In </title>
    <link rel="stylesheet" type="text/css" href="StyleSheets/styleCheckin.css">	
     <script type="text/javascript" src="jquery/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="jquery/behavior.js"></script>
	<body>
    <div class="wrapper">
    	<header>
	        <h1>Hotel Boa Viagem</h1>
	        <h2>CHECK-IN</h2>
		</header>
		<main>
		<form action="Consultar" method="get" class="formulario">
	        <div>
	            <h2>Código da Reserva </h2>
	            <input type="text" id="codReserva" name="codReserva" value="${reserva.codReserva}" size="5" class="input_cod" onkeypress='return SomenteNumero(event)' maxlength="6" >
	        			        <input type="image" src="images/button_search.png" style=" padding-left:10px; padding-top:3px;">
	        </div>
	        		</form>
	        <div cla	ss="wpcf7">
	        <div id="placeStatus">
				<span name="status" id="status">${status}</span>	
			</div>
		
			<div id="infoPessoais">			
				<p>Informações Pessoais</p>
	            <span class="wpcf7-form-control-wrap Name">
	            	<input type="text" id="hospede" value="${reserva.cliente.nome}" readonly size="40" class="nameinput wpcf7-form-control wpcf7-text wpcf7-validates-as-required" aria-required="true" aria-invalid="false" placeholder="Hóspede">
				</span>
	            <span class="wpcf7-form-control-wrap Name">
	            	<input name="cpf" type="text" id="cpf" value="${reserva.cliente.cpf}" readonly size="40" class="nameinput wpcf7-form-control wpcf7-text wpcf7-validates-as-required" aria-required="true" aria-invalid="false" placeholder="CPF">
	         	</span>
	            <span class="wpcf7-form-control-wrap Email">
	            	<input type="email" name="email" value="${reserva.cliente.email}" readonly size="40" class="nameinput wpcf7-form-control wpcf7-text wpcf7-validates-as-required" aria-required="true" aria-invalid="false" placeholder="Email">
	          	</span>
	            <span class="wpcf7-form-control-wrap Name">
	            	<input type="text" name="observacao" value="${reserva.observacao}" readonly size="40" class="nameinput wpcf7-form-control wpcf7-text wpcf7-validates-as-required" aria-required="true" aria-invalid="false" placeholder="Observação">
	          	</span>	
					
			</div>
			
	        </div>
	        
	        <div id="hospedagem">
	            <p>  Reserva  </p>
		            <label for="dataSolicitacao"> Data da Solicitação da Reserva: </label>
		            <input type="text" name="dataSolicitacao" class="reserva" value="${reserva.dataSolicitacao}" readonly/>
	            <br>
				
	            <label for="dataEntrada">  Data Entrada:   </label>
	            <input type="text" name="dataEntrada" class="reserva" value="${reserva.dataInicio}" readonly/>
	                       
	            <label for="dataSaida"> Data Saída:  </label>
	            <input type="text" name="dataSaida" class="reserva" value="${reserva.dataFinal}" readonly/>
	            
	            <br>
	
	            <label for="qtdAdultos"> Quantidade de Adultos: </label>
	            <input type="number" name="qtdAdultos" value="${reserva.qntAdultos}" max="5" min="0" class="reserva2"  readonly/>
							
	            <label for="qtdCrianca"> Quantidade de Crianças: </label>
	            <input type="number" name="qtCriancas" max="5" min="0" class="reserva2" value="${reserva.qntCriancas}" readonly>
	            
	            <br>
	
	            <label for="capaciPessoaQuarto"> Capacidade de Pessoas por Quartos:</label>
	            <input type="number" name="capaciPessoaQuarto" max="5" min="0" class="reserva2" value="${reserva.capaciPessoaQuarto}" readonly/>
	            
	            <br>
	            
	            <label for="quarto"> Quarto: </label>
	            <input type="number" name="quarto" max="100" min="0" class="reserva2" id="quarto" value="${reserva.quarto.numQuarto}" readonly/>
	
	            <label for="andar"> Andar:</label>
	            <input type="number" name="andar" max="10" min="0" class="reserva2" id="andar"value="${reserva.quarto.numAndar}" readonly/>
	
	            <label for="tipoQuarto"> Tipo Quarto:</label>
	            <input type="number" name="tipoQuarto" max="4" min="1" class="reserva2" id="tipoQuarto"value="${reserva.quarto.tipoQuarto}" readonly/>
	            
	            <br>
	            
	            <label for="dataCheckin"> Data Check-in:</label>
	            <input type="text" class="reserva" value="${dataAtual}" name="dataAtual" id="dataCheckin" readonly/>
	            
	            <label for="horaCheckin"> Horário:  </label>
	            <input type="text" class="reserva" value="${horaAtual}" name="horaAtual" id="horaCheckin" readonly/>
	            
	        	</div>	        	
				
				<div style="visibility:hidden;">
		           <button>Confirmar Reserva</button>
		       	</div>

       </main>
        
    </div>
    <!-- /.wrapper -->

</body>
</html>		