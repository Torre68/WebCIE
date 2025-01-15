package es.cie.repositories;

import java.util.List;

import es.cie.negocio.Libro;

public interface LibroRepository {

	List<Libro> buscarTodos();

	List<Libro> buscarPortitulo(String titulo);

	List<Libro> buscarAutor(String autor);

}