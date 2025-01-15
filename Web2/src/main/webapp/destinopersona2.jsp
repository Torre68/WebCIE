<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Calendar" %>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>
    <%@ page import="java.text.DateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String nombre = request.getParameter("nombre");
String apellidos = request.getParameter("apellidos");
String fechaTexto = request.getParameter("Fecha de Nacimiento");

// Convertimos texto de cadena en una fecha Date con un formateador.
DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
Date fecha = df.parse(fechaTexto);

// Creamos una instancia de Calendar y la configuramos con la fecha parseada
Calendar calen = Calendar.getInstance();
calen.setTime(fecha);

// Ahora podemos obtener el mes correctamente
int mes = calen.get(Calendar.MONTH) + 1; // Sumamos 1 para que enero sea 1, febrero sea 2, etc.

out.println(nombre);
out.println(apellidos);
out.println(fechaTexto); // Imprimimos la fecha.
%>
</body>
</html>