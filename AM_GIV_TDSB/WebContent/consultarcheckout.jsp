<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="StyleSheets/styleConsultCheckout.css">
	<title>Consultar Hospedagem | Hotel Boa Viagem</title>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" ></script>
	<script type="text/javascript" src="jquery/behavior.js"></script>
</head>
<body>
    <div class="wrapper">
    
    <form action="ConsultarCheckOut" method="get">
    	<header>
	        <h1>Hotel Boa Viagem</h1>
	        <h2>CHECK-OUT</h2>
        </header>
        <main>
	        <div>
	            <h2>Código da Hospedagem</h2>
	            <input type="text" name="codHospedagem" size="5" class="input_cod" onkeypress='return SomenteNumero(event)' maxlength="6" />
	        </div>
				<input type="image" id="botao" src="images/button_search.png" style=" padding-left:10px; padding-top:3px;display: block;" value="Consultar Hospedagem"/>
			
			<span id="saida">${saida}</span>
		</main>
	</form>
	
    </div>
    <!-- /.wrapper -->

</body>

</html>