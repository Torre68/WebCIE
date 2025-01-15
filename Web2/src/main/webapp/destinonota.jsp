<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Hola, soy el Destino.
<img src="https://tenor.com/view/there-can-be-only-one-gif-17652867202966242006">
<%
String nota = request.getParameter("nota");
int notaBuena=Integer.parseInt(nota);
if (notaBuena>=5)
	out.println("Has aprobado.");
else out.println("Has suspendido.");
out.println(nota);
%>

</body>
</html>