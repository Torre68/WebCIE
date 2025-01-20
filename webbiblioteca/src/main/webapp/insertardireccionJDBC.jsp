<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--     Hay que importar todo lo que vayamos a utilizar. -->
    <%@ page import= "es.ascender.biblioteca.negocio.Direccion" %>
    <%@ page import= "es.ascender.biblioteca.repositories.DireccionRepository" %>
    <%@ page import= "es.ascender.biblioteca.repositories.jdbc.DireccionRepositoryJDBC" %>


<%

String dni= request.getParameter("dni");
String calle= request.getParameter("calle");
int numero = Integer.parseInt(request.getParameter("numero"));
int CP = Integer.parseInt(request.getParameter("CP"));
 
Direccion d = new Direccion (dni,calle,numero,CP); 
DireccionRepository repo= new DireccionRepositoryJDBC(); 
repo.insertar(d);

response.sendRedirect("listadireccionjdbc.jsp");






%>
