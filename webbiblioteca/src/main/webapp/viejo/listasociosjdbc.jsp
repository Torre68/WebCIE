<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.ascender.biblioteca.negocio.Socio"%>

<%@ page import="es.ascender.biblioteca.repositories.SocioRepository"%>
<%@ page import="java.util.List"%>
<%@ page
	import="es.ascender.biblioteca.repositories.jdbc.SocioRepositoryJDBC"%>
<!--     CUIDADO AL IMPORTAR, HAY QUE SER CUIDADOSO CON EL SPELLING -->

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
	//  INTERFAZ                    IMPLEMENTACION
	SocioRepository repo = new SocioRepositoryJDBC();
	List<Socio> lista = null;
	if (request.getParameter("orden") != null) {

		out.println("Ordenado por " + request.getParameter("orden"));
		lista = repo.buscarTodosOrdenados(request.getParameter("orden"));
	} else {
		//out.println("Sin ordenar");
		lista = repo.buscarTodos();

	}

	//Mejor programar orientado a la interfaz que al objeto porque da mas flexibilidad al programa.

	// SocioRepository repo = new SocioRepositoryMemoria();

	//     Tipo de datos: SocioRepository es probablemente una interfaz o una clase abstracta que 
	//     define un contrato para operaciones relacionadas con "Socios" (por ejemplo, métodos 
	//		para buscar, agregar, eliminar, etc.).
	//     Instanciación: new SocioRepositoryMemoria() crea una nueva instancia de 
	//     SocioRepositoryMemoria, que es una clase concreta que implementa la interfaz 
	//     SocioRepository. Esto sugiere que SocioRepositoryMemoria podría estar diseñado 
	//     para manejar datos en memoria (por ejemplo, una lista o un array), en lugar de usar 
	//     una base de datos o almacenamiento persistente.
	//     Asignación: La instancia creada se asigna a la variable repo, que es de tipo 
	//     SocioRepository. Esto permite que repo se use para acceder a métodos definidos en 
	//     la interfaz SocioRepository, sin importar qué implementación concreta se esté 
	//      utilizando.

	// List<Socio> lista= repo.buscarTodos();
	//     Tipo de datos: List<Socio> es una lista que contendrá objetos de tipo Socio. Esto 
	//     sugiere que Socio es una clase que representa a un socio (por ejemplo, en un club, 
	//		una organización, etc.).
	//     Llamada a un método: repo.buscarTodos() es una llamada al método buscarTodos() 
	//     de la instancia repo. Este método está diseñado para buscar y devolver todos los 
	//     objetos de tipo Socio almacenados en la implementación de SocioRepositoryMemoria.
	//     Asignación: El resultado de la llamada a buscarTodos() se asigna a la variable lista. 
	//     Esto significa que lista ahora contiene todos los socios que fueron recuperados de la 
	//     memoria.

	// Todo lo que importamos desde src/main/java y sus subpackages es para que esto funcione.
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
			<td><a href="borrarsocioJDBC.jsp?dni=<%=s.getDni()%>" class="btn btn-danger">borrar</a></td>
			<!--  Añadimos la linea de arriba para incluir en el formulario la opcion borrar -->

		</tr>
		<%
		}
		%>


	</table>
	<!--  Ancla, enlace a otra pagina. -->
	<a href="formulariosocio.html" class="btn btn-primary"> Insertar </a>
</div>
</body>
</html>