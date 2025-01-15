<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="es.cie.repositories.*" %>
    <%@ page import="es.cie.negocio.Libro" %>
    <%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LISTA LIBROS</title>
<link rel="stylesheet" href="estilo.css">
</head>

<%


LibroRepository repo=new LibroRepositoryMemoria();
String titulo= request.getParameter("titulo");
String autor = request.getParameter("autor");
List<Libro> lista= null;

if (titulo!= null) {
		lista=repo.buscarPortitulo(titulo);
}else if (autor!=null){
	lista=repo.buscarAutor(autor);
}

else {lista = repo.buscarTodos ();}
%>
<body>
<form method="get">
Titulo: <input type="text" name="titulo"/>
<input type="submit" value="buscar titulo"/>
</form>
<form method="get">
Autor: <input type="text" name="autor"/>
<input type="submit" value="buscar autor"/>
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

for (Libro libro:lista){%>

<!-- fila o row tr (table row) -->
<tr>
<td><%=libro.getISBN() %></td>
<td><%=libro.getTitulo() %></td>
<td><%=libro.getAutor() %></td>
<td><%=libro.getPaginas() %></td>

</tr>





<% } %>

</table>

</body>
</html>