package es.ascender.biblioteca.repositories;
//INTERFAZ
import java.util.List;

import es.ascender.biblioteca.negocio.Socio;

public interface SocioRepository {
	
	List<Socio> buscarTodos(); //Para mostrar toda la SQL
	void insertar (Socio socio); //Para insertar datos (en este caso Socio) en la SQL
    void borrar (Socio socio); //Para borrar datos de la SQL
    List<Socio> buscarTodosOrdenados (String orden); // Para ordenar los resultados por el campo elegido.
}
