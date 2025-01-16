<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="es.ascender.biblioteca.negocio.Socio" %>
    
    <%@ page import="es.ascender.biblioteca.repositories.SocioRepository" %>
    <%@ page import="java.util.List" %>
    <%@ page import= "es.ascender.biblioteca.repositories.jdbc.SocioRepositoryJDBC" %>
<!--     CUIDADO AL IMPORTAR, HAY QUE SER CUIDADOSO CON EL SPELLING -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//  INTERFAZ                    IMPLEMENTACION
SocioRepository repo = new SocioRepositoryJDBC();
List<Socio> lista= repo.buscarTodos();

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


<table>

<% for (Socio s:lista ){ %>
<!-- esto es una fila  -->
<tr> 
<!-- una columna o celda -->

<td><%= s.getDni() %></td>
<td><%= s.getNombre() %></td>
<td><%= s.getApellidos() %></td>


</tr>
<%} %>


</table>
</body>
</html>