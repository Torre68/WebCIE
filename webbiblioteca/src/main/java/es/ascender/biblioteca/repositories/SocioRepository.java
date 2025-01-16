package es.ascender.biblioteca.repositories;
//INTERFAZ
import java.util.List;

import es.ascender.biblioteca.negocio.Socio;

public interface SocioRepository {
	
	List<Socio> buscarTodos();

}
