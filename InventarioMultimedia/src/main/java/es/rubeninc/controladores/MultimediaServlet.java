package es.rubeninc.controladores;

import es.rubeninc.negocio.Multimedia;
import es.rubeninc.repositories.MultimediaRepository;
import es.rubeninc.repositories.jdbc.MultimediaRepositoryJDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/multimedia")
public class MultimediaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MultimediaRepository multimediaRepository = new MultimediaRepositoryJDBC();
    List<Multimedia> lista = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("buscar".equals(action)) {
            String tipoBusqueda = request.getParameter("tipobusqueda");
            String textoBusqueda = request.getParameter("textobusqueda");
            List<Multimedia> lista;
            
            switch (tipoBusqueda) {
                
                case "autor":
                    lista = multimediaRepository.buscarAutor(textoBusqueda);
                    break;
                case "titulo":
                    lista = multimediaRepository.buscarTitulo(textoBusqueda);
                    break;
                default:
                    lista = multimediaRepository.inventarioCompleto();
            }
            
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("buscadormultimedia.jsp").forward(request, response);
        } else {
            List<Multimedia> lista = multimediaRepository.inventarioCompleto();
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("buscadormultimedia.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isrc = request.getParameter("ISRC");
        String autor = request.getParameter("autor");
        String titulo = request.getParameter("titulo");
        int ejemplares = Integer.parseInt(request.getParameter("ejemplares"));
        String formato = request.getParameter("formato");

        Multimedia multimedia = new Multimedia(isrc, autor, titulo, ejemplares, formato);
        multimediaRepository.insertarMultimedia(multimedia);

        response.sendRedirect("buscadormultimedia.jsp");
    }
}