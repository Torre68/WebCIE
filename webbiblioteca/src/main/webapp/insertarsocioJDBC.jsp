<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--     Hay que importar todo lo que vayamos a utilizar. -->
    <%@ page import= "es.ascender.biblioteca.negocio.Socio" %>
    <%@ page import= "es.ascender.biblioteca.repositories.SocioRepository" %>
    <%@ page import= "es.ascender.biblioteca.repositories.jdbc.SocioRepositoryJDBC" %>


<%

String dni= request.getParameter("dni");
String nombre= request.getParameter("nombre");
String apellidos= request.getParameter("apellidos");
//Con todo esto recibimos la informacion del formulariosocio.html 
Socio s = new Socio (dni,nombre, apellidos); //Crea el objeto
SocioRepository repo= new SocioRepositoryJDBC(); //Paso el objeto a la entidad repo
repo.insertar(s);//Inserta el nuevo objeto Socio s en repo.

response.sendRedirect("listasociosjdbc.jsp");
//Esto al acabar el insertado nos devuelve a la pagina de origen.





%>
