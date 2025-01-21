package es.ascender.biblioteca.repositories;
//INTERFAZ
import java.util.List;

import es.ascender.biblioteca.negocio.Direccion;


public interface DireccionRepository {
	
	List<Direccion> buscarTodos(); 
	void insertar (Direccion direccion); 
    void borrar (Direccion direccion); 
    List<Direccion> buscarTodosOrdenados (String orden); 
}
