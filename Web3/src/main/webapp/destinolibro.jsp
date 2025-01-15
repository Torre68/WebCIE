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
<title>DESTINO LIBRO</title>
</head>
<img src = "https://i.giphy.com/media/v1.Y2lkPTc5MGI3NjExMml2djAyeHNtYW4zZ2pkNXQ5ZHl0OWszaHNhNmNrc28zbXpqOG9mNCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/EshBrE0Y0Uz8QuAVfA/giphy-downsized-large.gif"/>
<body>
<%
String titulo = request.getParameter ("titulo");
titulo = titulo != null ? titulo.toUpperCase() : null;
String autor = request.getParameter ("autor");
autor = autor != null ? autor.toUpperCase() : null;


//     Evaluación de la condición:
//         titulo != null: Aquí se está verificando si la variable titulo no es null. Esto significa que estás comprobando si hay un valor asignado a titulo.

//     Operador Ternario:
//         El operador ternario tiene la forma condición ? valorSiVerdadero : valorSiFalso. En este caso, la condición es titulo != null.
//         Si la condición es verdadera (es decir, titulo no es null), se ejecuta la expresión que está antes de los dos puntos (:), que en este caso es titulo.toUpperCase().
//         Si la condición es falsa (es decir, titulo es null), se ejecuta la expresión que está después de los dos puntos, que en este caso es null.

//     Lógica de Ejecución:
//         Si titulo tiene un valor (no es null), se llamará al método toUpperCase() sobre titulo, que convertirá el texto de titulo a mayúsculas.
//         Si titulo es null, entonces se asignará null a sí mismo.

//     Asignación:
//         Finalmente, el resultado de la evaluación del operador ternario se asigna de nuevo a la variable titulo.

String isbn = request.getParameter("ISBN");

String lenguaje= request.getParameter("lenguaje");
lenguaje = lenguaje != null ? lenguaje.toUpperCase() : null;
int nivel = Integer.parseInt (request.getParameter("numpag"));
String nuevoT = request.getParameter("disponible");
boolean nuevo = Boolean.parseBoolean(nuevoT);

String nivelTexto =""; 

if (nivel==1){
nivelTexto ="Hasta 100 pág.";
}else if (nivel ==2){
nivelTexto ="Hasta 300 pág.";
}else {
	nivelTexto ="Más de 300 pág.";}


%>



<p>
El TÍTULO es: <%= titulo %>

</p>
<p>
El AUTOR es: <%= autor %>

</p>
<p>
El ISBN del libro es: <%= isbn %>

</p>
<p>
El LENGUAJE seleccionado es: <%= lenguaje %>

</p>
<p>


El número apróximado de páginas es: <%= nivelTexto %>
</p>
<p>


El libro está: <% if (nuevo) {out.println("DISPONIBLE");} else {out.println ("NO DISPONIBLE");}%>
</p>
<p>


<p>Los generos a los que pertenece el libro son: <% 
String [] generoL = request.getParameterValues ("genero");
out.println("<ul>");
for (int i=0; i<generoL.length;i++){
	out.println("<li>"+generoL[i]+"</li>");
}out.println("</ul>"); 
%> 
</p>

</body>
</html>