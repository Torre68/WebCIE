package es.rubeninc.negocio;

public class Multimedia {
	
	private String ISRC;
	private String autor;
	private String titulo;
	private int ejemplares;
	private String formato;
	
	public Multimedia(String iSRC, String autor, String titulo, int ejemplares, String formato) {
		super();
		ISRC = iSRC;
		this.autor = autor;
		this.titulo = titulo;
		this.ejemplares = ejemplares;
		this.formato = formato;
		
		
	}

	public String getISRC() {
		return ISRC;
	}

	public void setISRC(String iSRC) {
		ISRC = iSRC;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Multimedia() {
		super();
	}

	public Multimedia(String iSRC) {
		super();
		ISRC = iSRC;
	}
	
	


}
