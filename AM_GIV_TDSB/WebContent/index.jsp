<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="StyleSheets/style.css">
	<title>Hotel Boa Viagem</title>
	<script type="text/javascript" src="jquery/behavior.js"></script>
</head>
<body>
	<div class="body">
		<div class="camada">
			<video autoplay loop class="video"> <source
				src="images/hotel.mp4"
				type='video/mp4; codecs="avc1.42E01E, mp4a.40.2"' /> <source
				src="images/hotel.webm" type="video/webm" /> <source
				src="images/hotel.ogv" type="video/ogg" /> </video>
		</div>
		<div class="all">
			<header>
				<div class="header">
					<div>
						Hotel<span>Boa Viagem</span>
					</div>
				</div>
			</header>
			<main>
				<br>
				<div class="login">
					<input type="button" value="Check-in"onClick="link('consultar.jsp')" /> 
					<br> 
					<input type="button" value="Check-out" onClick="link('consultarcheckout.jsp')" />
				</div>
			</main>
		</div>
	</div>
</body>
</html>