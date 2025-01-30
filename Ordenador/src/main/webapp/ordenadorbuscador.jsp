<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

ç
<%@ page import="es.cie.ordenador.negocio.Ordenador"%>
<%@ page import="java.util.List"%>

<% List<Ordenador>  lista= (List<Ordenador>)request.getAttribute("lista"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Buscador</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<div class="container">




		<h1>Lista De Ordenadores</h1>
			<caption>ORDENADORES</caption>
		<table class="table table-striped table-hover">
			<tr>
				<th>marca</th>
				<th>precio</th>
				
			</tr>

			<%
		//for each
		for (Ordenador  ordenador: lista) {
		%>

			<!-- fila o row tr (table row) -->
			<tr>
				

				<td><%=ordenador.getMarca()%></td>
				<td><%=ordenador.getPrecio()%></td>


			</tr>

			<% } %>
		</table>
		

		<p>
			<a href="?comando=insertform">Insertar Nuevo Ordenador</a>
		</p>
	</div>
</body>
</html>