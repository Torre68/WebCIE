<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.cie.repositories.*"%>
<%@ page import="es.cie.negocio.Libro"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LISTA LIBROS</title>
<link rel="stylesheet" href="estilo.css">
</head>

<%


LibroRepository repo = new LibroRepositoryMemoria();
String tipobusqueda = request.getParameter("tipobusqueda");
String textobusqueda = request.getParameter("textobusqueda");
List<Libro> lista = null;

if (tipobusqueda != null && textobusqueda != null) {

	if (tipobusqueda.equalsIgnoreCase("titulo")) {
		
		lista = repo.buscarPortitulo(textobusqueda);
	} else if (tipobusqueda.equalsIgnoreCase("autor")) {
	
		lista = repo.buscarAutor(textobusqueda);
	}

	else {
	}
} else {
	lista = repo.buscarTodos();
}
%>
<body>
	<form method="get">
		<select name="tipobusqueda">
			<option>Titulo</option>
			<option>Autor</option>

		</select> <input type="text" name="textobusqueda" /> <input type="submit"
			value="buscar " />
	</form>


	<h1>LISTA DE LIBROS</h1>
	<table border=1>
		<caption>LIBROS</caption>
		<tr>
			<th>ISBN</th>
			<th>Titulo</th>
			<th>Autor</th>
			<th>Paginas</th>
		</tr>

		<%
		for (Libro libro : lista) {
		%>

		<!-- fila o row tr (table row) -->
		<tr>
			<td><%=libro.getISBN()%></td>
			<td><%=libro.getTitulo()%></td>
			<td><%=libro.getAutor()%></td>
			<td><%=libro.getPaginas()%></td>

		</tr>





		<%
		}
		%>

	</table>

</body>
</html>