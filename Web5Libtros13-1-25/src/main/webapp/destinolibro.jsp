<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resumen Libro</title>
</head>
<body>
<%
String ISBN = request.getParameter("ISBN");
String titulo = request.getParameter("titulo");
String autor = request.getParameter("autor");
String paginas = request.getParameter("paginas");
String genero = request.getParameter("genero");
String idioma = request.getParameter("idioma");

int disponibilidad = Integer.parseInt(request.getParameter("disponibilidad"));

out.println("<br>");
out.println("ISBN= "+ISBN);
out.println("<br>");
out.println("Titulo= "+titulo);
out.println("<br>");
out.println("Autor= "+autor);
out.println("<br>");
out.println("Paginas= "+paginas);
out.println("<br>");
out.println("Genero= "+genero);
out.println("<br>");
out.println("Idioma= "+idioma);
out.println("<br>");

if (disponibilidad==1){
	out.println("Estado = Disponible");
}else {out.println("Estado = No Disponible");
}



%>

</body>
</html>