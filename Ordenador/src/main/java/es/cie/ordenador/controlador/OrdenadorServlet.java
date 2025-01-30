package es.cie.ordenador.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cie.ordenador.negocio.Ordenador;
import es.cie.ordenador.repositories.OrdenadorRepository;
import es.cie.ordenador.repositories.jdbc.OrdenadorRepositoryJDBC;


/**
 * Servlet implementation class OrdenadorServelt
 */
@WebServlet("/OrdenadorServlet")
public class OrdenadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	OrdenadorRepository repo = new OrdenadorRepositoryJDBC();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Ordenador> lista = repo.showAll();
		
		if (request.getParameter("comando") == null) {

			request.setAttribute("lista", lista);
			RequestDispatcher despachador = request.getRequestDispatcher("ordenadorbuscador.jsp");

			despachador.forward(request, response);
			
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
		}else {
			String comando = request.getParameter("comando");
			if (comando.equals("insertform")) {

				RequestDispatcher despachador = request.getRequestDispatcher("insertform.html");

				despachador.forward(request, response);
			} else if (comando.equals("salvarordenador")) {

				String marca = request.getParameter("marca");
			
				int precio = Integer.parseInt(request.getParameter("precio"));

				Ordenador o = new Ordenador(marca,precio);
				OrdenadorRepository repo = new OrdenadorRepositoryJDBC();
				repo.insert(o);

				lista=repo.showAll();
				
				
				request.setAttribute("lista", lista);
				RequestDispatcher despachador = request.getRequestDispatcher("ordenadorbuscador.jsp");
				despachador.forward(request, response);
				
				
			

		}

		}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
