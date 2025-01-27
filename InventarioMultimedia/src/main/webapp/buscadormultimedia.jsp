<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Esta línea es una directiva JSP que establece que el lenguaje utilizado -->
<!-- es Java y configura el tipo de contenido y la codificación de caracteres -->
<!-- para la página (UTF-8). -->

<%@ page import="java.util.List"%>
<%@ page import="es.rubeninc.negocio.Multimedia"%>
<!-- Los importes necesarios -->
<%
List<Multimedia> lista = (List<Multimedia>) request.getAttribute("lista");
%>
<!-- Este bloque de código Java obtiene un atributo de la solicitud HTTP -->
<!-- llamado "lista", que se espera que sea una lista de objetos Multimedia. -->
<!-- El resultado se almacena en la variable lista. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Buscador</title>

<!-- Se define el tipo de documento como HTML5 y se -->
<!-- comienza la estructura HTML. Se establece la codificación de caracteres -->
<!-- y se configura la vista para dispositivos móviles (viewport). También se -->
<!-- da un título a la página ("Buscador"). -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<!-- Se incluye la hoja de estilo de Bootstrap desde un CDN (Content Delivery -->
<!-- Network), que proporciona estilos CSS predefinidos para mejorar la -->
<!-- apariencia de la página. -->
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<!-- 	Se abre el cuerpo de la página. También se incluye el script JavaScript -->
	<!-- 	de Bootstrap, que permite el uso de componentes interactivos. -->
	<div class="container">

		<!-- Se crea un contenedor Bootstrap que aplica márgenes y un ancho máximo a su contenido. -->



		<form method="get">
			<select name="tipobusqueda">
				<option>isrc</option>
				<option>autor</option>
				<option>titulo</option>
			</select> <input type="text" name="textobusqueda" /> <input type="submit"
				class="btn btn-warning" value="Buscar" />
		</form>
		<!-- 		Se crea un formulario que se enviará mediante el método GET. Contiene -->
		<!-- 		un menú desplegable (select) para elegir el tipo de búsqueda (ISRC, -->
		<!-- 		autor o título), un campo de texto para ingresar el término de -->
		<!-- 		búsqueda y un botón de envío con un estilo Bootstrap. -->

		<h1>Lista De Multimedia</h1>

		<!-- 		Se añade un encabezado (h1) que indica que la sección es para la lista de multimedia. -->

		<table class="table table-striped table-hover">
			<caption>MULTIMEDIA</caption>
			<tr>
				<th>isrc</th>
				<th>autor</th>
				<th>titulo</th>
				<th>ejemplares</th>
				<th>formato</th>
			</tr>
			<!-- 			Se inicia una tabla con estilos de Bootstrap para que sea "striped" -->
			<!-- 			(rayada) y "hover" (con efecto al pasar el mouse). Se define un -->
			<!-- 			encabezado para la tabla con los nombres de las columnas. -->
			<%
			//for each
			for (Multimedia multimedia : lista) {
			%>
			<!-- Se inicia un bucle for que itera sobre cada objeto Multimedia en la lista. -->
			<!-- fila o row tr (table row) -->
			<tr>
				<td><%=multimedia.getISRC()%></td>
				<td><%=multimedia.getTitulo()%></td>
				<td><%=multimedia.getAutor()%></td>
				<td><%=multimedia.getFormato()%></td>

			</tr>
			<!-- 				Para cada objeto Multimedia, -->
			<!-- 				se crea una fila (tr) en la tabla y se añaden celdas (td) que -->
			<!-- 				contienen valores obtenidos mediante métodos (getISRC(), -->
			<!-- 				getTitulo(), getAutor(), getFormato()) de cada objeto Multimedia. -->


			<%
			}
			%>

			<!-- 			Se cierra el bucle for -->

		</table>
	</div>
</body>
</html>

<!-- Se cierra la tabla, el contenedor y el cuerpo del HTML. Finalmente, se -->
<!-- cierra la estructura HTML. -->
