package es.cie.repositories;
import java.util.List;

import es.cie.negocio.Libro;

import java.util.ArrayList;

public class LibroRepositoryMemoria implements LibroRepository {
	
	private static List<Libro> lista = new ArrayList<Libro> ();
	
	static { 
		
		lista.add(new Libro ("01","java","pepe",200));
		lista.add(new Libro ("02","javaio","enrique",260));
		lista.add(new Libro ("03","javascript","manolo",300));
		lista.add(new Libro ("04","javaOOP","eva",208));
		lista.add(new Libro ("05","python","ana",190));
		lista.add(new Libro ("06","java","sole",270));
		lista.add(new Libro ("07","c+","pablo",350));
		lista.add(new Libro ("08","css","susana",100));
		
		
	}
	
	@Override
	public List <Libro> buscarTodos (){
		return lista;
	}
	
	@Override
	public List <Libro> buscarPortitulo (String titulo) {
		
		List <Libro> listaNueva = new ArrayList <Libro> ();
		for (Libro l:lista) {
			String tituloLibro=l.getTitulo();
			if(tituloLibro.toLowerCase().contains(titulo.toLowerCase())) {
				listaNueva.add(l);
			}
			
		}
		return listaNueva;
	}
	@Override
	public List <Libro> buscarAutor (String autor) {
		
		List <Libro> listaNueva = new ArrayList <Libro> ();
		for (Libro l:lista) {
			String autorLibro=l.getAutor();
			if(autorLibro.toLowerCase().contains(autor.toLowerCase())) {
				listaNueva.add(l);
			}
			
		}
		return listaNueva;
	}
	

}
