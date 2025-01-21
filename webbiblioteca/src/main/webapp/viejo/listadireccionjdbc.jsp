<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.ascender.biblioteca.negocio.Direccion"%>

<%@ page import="es.ascender.biblioteca.repositories.DireccionRepository"%>
<%@ page import="java.util.List"%>
<%@ page
	import="es.ascender.biblioteca.repositories.jdbc.DireccionRepositoryJDBC"%>
<!--     CUIDADO AL IMPORTAR, HAY QUE SER CUIDADOSO CON EL SPELLING -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//  INTERFAZ                    IMPLEMENTACION
	DireccionRepository repo = new DireccionRepositoryJDBC();
	List<Direccion> lista = null;
	if (request.getParameter("orden") != null) {

		out.println("Ordenado por " + request.getParameter("orden"));
		lista = repo.buscarTodosOrdenados(request.getParameter("orden"));
	} else {
		out.println("Sin ordenar");
		lista = repo.buscarTodos();

	}

	%>


	<table>
		<thead>
			<tr>
				<th><a href="?orden=dni">Dni</a></th>
				<th><a href="?orden=calle">Calle</a></th>
				<th><a href="?orden=numero">Numero</a></th>
				<th><a href="?orden=CP">CP</a></th>
				<th>Borrar</th>

			</tr>
		</thead>

		<%
		for (Direccion d : lista) {
		%>
		<!-- esto es una fila  -->
		<tr>
			<!-- una columna o celda -->

			<td><%=d.getDni()%></td>
			<td><%=d.getCalle()%></td>
			<td><%=d.getNumero()%></td>
			<td><%=d.getCP()%></td>
			<td><a href="borrardireccionJDBC.jsp?calle=<%=d.getCalle()%>&numero=<%=d.getNumero()%>">borrar</a></td>
			<!--  Añadimos la linea de arriba para incluir en el formulario la opcion borrar -->

		</tr>
		<%
		}
		%>


	</table>
	<!--  Ancla, enlace a otra pagina. -->
	<a href="formulariodireccion.html"> Insertar </a>

</body>
</html>