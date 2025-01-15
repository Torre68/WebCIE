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
<title>DESTINO PERSONAS</title>
</head>

<body>
<%
String nombre = request.getParameter ("nombre");
String apellidos = request.getParameter ("apellidos");
String fechaTexto= request.getParameter ("Fecha de Nacimiento");
String lenguaje= request.getParameter("lenguaje");
//String nivel = request.getParameter ("nivel");
int nivel = Integer.parseInt (request.getParameter("nivel"));
String nuevoT = request.getParameter("nuevo");
boolean nuevo = Boolean.parseBoolean(nuevoT);
//Convertimos el int en un String

//Convertimos texto de cadena en una fecha Date con un formateador.
Calendar calen = Calendar.getInstance();
DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
Date fecha = df.parse(fechaTexto);
calen.setTime(fecha);
out.println(nombre);
out.println(apellidos);
out.println(calen.getTime());
//Creamos esta variable porque en java todo empieza en 0 (asi que enero seria 0, en vez de 1)
int mes = calen.get(Calendar.MONTH) + 1;
out.println("El día es "+calen.get(Calendar.DAY_OF_MONTH));
out.println("del mes "+mes);
out.println("del año "+calen.get(Calendar.YEAR));
DateFormat df1 = new SimpleDateFormat ("E dd/MM/yyyy ");
String nivelTexto =""; 

if (nivel==1){
nivelTexto ="Principiante";
}else if (nivel ==2){
nivelTexto ="Intermedio";
}else {
	nivelTexto ="Experto";}

String [] dispositivos = request.getParameterValues ("dispositivos");
out.println("<ul>");
for (int i=0; i<dispositivos.length;i++){
	out.println("<li>"+dispositivos[i]+"</li>");
}out.println("</ul>");
	


%>
<p>
La fecha es: <%= (df1.format(fecha)) %>

</p>
<p>
El lenguaje seleccionado es: <%= lenguaje %>

</p>
<p>


El nivel seleccionado es: <%= nivelTexto %>
</p>
<p>


Es un alumno: <% if (nuevo) {out.println("nuevo");} else {out.println ("antiguo");}%>
</p>
<p>


<%-- El/los dispositivo/s seleccionado/s es: <%= dispositivos %> --%>
</p>

</body>
</html>