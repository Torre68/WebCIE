<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import= "es.ascender.biblioteca.negocio.Direccion" %>
    <%@ page import= "es.ascender.biblioteca.repositories.DireccionRepository" %>
    <%@ page import= "es.ascender.biblioteca.repositories.jdbc.DireccionRepositoryJDBC" %>


<%

String calle= request.getParameter("calle");
int numero = Integer.parseInt(request.getParameter("numero"));
//Hay que usar el .parseInt 

Direccion d = new Direccion (calle, numero); 
DireccionRepository repo= new DireccionRepositoryJDBC();
repo.borrar(d);

response.sendRedirect("listadireccionjdbc.jsp");






%>
