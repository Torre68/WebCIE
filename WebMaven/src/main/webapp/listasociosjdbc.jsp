<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.ascender.biblioteca.negocio.Socio"%>
<%@ page import="java.util.List"%>

<!-- JSP FUNCIONANDO CON SERVLET -->
<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lista Socios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    <h1 style="text-align: center;">LISTA DE SOCIOS</h1>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	List<Socio> lista= (List<Socio>) request.getAttribute("lista");

	
	%>

<div class="container">
	<table class="table table-striped table-hover">
		<thead>
			<tr class="table-primary">
				<th><a href="?orden=dni">Dni</a></th>
				<th><a href="?orden=nombre">Nombre</a></th>
				<th><a href="?orden=apellidos">Apellidos</a></th>
				<th>Borrar</th>

			</tr>
		</thead>

		<%
		for (Socio s : lista) {
		%>
		<!-- esto es una fila  -->
		<tr>
			<!-- una columna o celda -->

			<td><%=s.getDni()%></td>
			<td><%=s.getNombre()%></td>
			<td><%=s.getApellidos()%></td>
			<td><a href="?comando=borrarsocio&dni=<%=s.getDni()%>" class="btn btn-danger">borrar</a></td>
			<!--  Añadimos la linea de arriba para incluir en el formulario la opcion borrar -->

		</tr>
		<%
		}
		%>


	</table>
	<!--  Ancla, enlace a otra pagina. -->
	<a href="?comando=formulariosocio" class="btn btn-primary"> Insertar </a>
<!-- 	Aqui quitamos el link directo al formulario y se lo damos al servlet para que haga 
de intermediario -->
</div>
</body>
</html>