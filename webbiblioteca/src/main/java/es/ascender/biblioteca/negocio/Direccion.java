package es.ascender.biblioteca.negocio;

public class Direccion {
	
	private String dni;
	private String calle;
	private int numero;
	private int CP;
	
	public Direccion(String dni, String calle, int numero, int cP) {
		super();
		this.dni = dni;
		this.calle = calle;
		this.numero = numero;
		CP = cP;
	}
	public Direccion(String calle, int numero) {
		super();
		this.calle = calle;
		this.numero = numero;
	}
	public Direccion() {
		super();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCP() {
		return CP;
	}
	public void setCP(int cP) {
		CP = cP;
	}
	
	
	
}