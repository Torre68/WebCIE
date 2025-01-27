package es.rubeninc.repositories;

import java.util.List;

import es.rubeninc.negocio.Multimedia;

public interface MultimediaRepository {

	
	List<Multimedia> inventarioCompleto();
	void insertarMultimedia(Multimedia multimedia);
	void borrarMultimedia(Multimedia multimedia);
	List<Multimedia> buscarAutor(String autor); //Ojo no confundir los parametros que le damos al metodo.
	List<Multimedia> buscarTitulo(String titulo);
	List<Multimedia> porOrden(String orden);
}
