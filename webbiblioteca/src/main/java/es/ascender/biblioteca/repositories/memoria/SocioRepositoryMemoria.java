package es.ascender.biblioteca.repositories.memoria;

import java.util.ArrayList;
import java.util.List;

import es.ascender.biblioteca.negocio.Socio;
import es.ascender.biblioteca.repositories.SocioRepository;
//IMPLEMENTACION
public class SocioRepositoryMemoria implements SocioRepository{

	@Override
	public List<Socio> buscarTodos() {
		//Esto lo estamos haciendo como paso previo para comprobar que la lista funciona.
		List<Socio> lista = new ArrayList<Socio> ();
		lista.add(new Socio ("1","maria","sanchez"));
		lista.add(new Socio ("2","juan","perez"));
		return lista;
	}
	
	
	

}
