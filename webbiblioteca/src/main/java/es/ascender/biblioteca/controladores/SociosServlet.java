package es.ascender.biblioteca.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.ascender.biblioteca.negocio.Socio;
import es.ascender.biblioteca.repositories.SocioRepository;
import es.ascender.biblioteca.repositories.jdbc.SocioRepositoryJDBC;


@WebServlet("/SociosServlet")
public class SociosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SocioRepository repo = new SocioRepositoryJDBC();
	List<Socio> lista = null;
  
	//El metodo que se ejecuta cuando pido el servlet doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("orden") != null) {
			lista = repo.buscarTodosOrdenados(request.getParameter("orden"));
		} else {
			lista = repo.buscarTodos();
		}
		request.setAttribute("lista", lista);//PETICION DE LA LISTA DE DATOS
//		The line of code you've provided is typically found in a Java web application that uses the Java Servlet API, often in the context of a servlet or a JSP (JavaServer Pages) file. Here's a breakdown of what this line does:
//			
//			    request:
//			        This is an instance of HttpServletRequest, which represents the client's request to the server. It contains data about the request such as parameters, headers, and attributes.
//
//			    setAttribute:
//			        This method is used to store an attribute in the request scope. Attributes are key-value pairs that can be used to pass data between different components of a web application, such as servlets and JSPs.
//			        The data stored in the request attributes is only available during the lifecycle of the request. Once the response is sent back to the client, all request attributes are discarded.
//
//			    "lista":
//			        This is a String that serves as the key for the attribute. It identifies the attribute so that it can be retrieved later. In this case, the key is "lista".
//
//			    lista:
//			        This is the value being stored in the request attribute. It could be any object, but often it is a collection (like a List or ArrayList) or some other data structure. The name lista suggests that it might be a list of items, possibly relevant to the current request.

		RequestDispatcher despachador= request.getRequestDispatcher("listasociosjdbc.jsp");
		despachador.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
