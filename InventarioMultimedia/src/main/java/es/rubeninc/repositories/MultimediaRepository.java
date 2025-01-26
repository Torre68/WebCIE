package es.rubeninc.repositories;

import java.util.List;

import es.rubeninc.negocio.Multimedia;

public interface MultimediaRepository {

	
	List<Multimedia> inventarioCompleto();
	void insertarMultimedia(Multimedia multimedia);
	void borrarMultimedia(Multimedia multimedia);
	List<Multimedia> buscarAutor(Multimedia multimedia);
	List<Multimedia> buscarTitulo(Multimedia multimedia);
	List<Multimedia> porOrden(String orden);
}
