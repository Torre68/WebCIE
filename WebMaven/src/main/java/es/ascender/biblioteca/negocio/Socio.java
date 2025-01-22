package es.ascender.biblioteca.negocio;

public class Socio {
	
	private String dni;
	private String nombre;
	private String apellidos;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Socio(String dni, String nombre, String apellidos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public Socio(String dni) {
		//CONSTRUCTOR con solo la clave primaria de la SQL
		super();
		this.dni = dni;
	}
	public Socio() {
		super();
	} 
	//CONSTRUCTOR VACIO
//	En Java, un constructor vacío (también conocido como constructor por defecto) es un 
//	constructor que no tiene parámetros. Hay varias razones por las cuales podrías querer 
//	definir un constructor vacío en una clase:
		
//  Inicialización por defecto: Si necesitas crear objetos de una clase sin proporcionar 
//	valores iniciales, un constructor vacío permite que se instancien esos objetos con 
//	valores predeterminados o simplemente inicializados a cero o null.
	
///   Facilitar la creación de objetos: En algunas situaciones, se requiere crear instancias
//    de una clase sin necesidad de pasar parámetros. Esto es especialmente útil en patrones 
//    de diseño como Singleton o en frameworks que manejan la creación de objetos automáticamente
//    (como algunos frameworks de inyección de dependencias).
////
//	Compatibilidad con frameworks: Muchos frameworks de Java, como Hibernate o Spring, 
//    requieren que las clases tengan un constructor vacío para poder instanciar objetos a 
//    través de reflexión. Sin un constructor vacío, estos frameworks podrían no funcionar 
//    correctamente.
//
//	Herencia: Si una clase hija no define su propio constructor y la clase padre tiene un 
//    constructor vacío, el compilador generará automáticamente un constructor vacío para la 
//    clase hija. Esto permite que las clases hijas sean instanciadas sin problemas.
//
//	Flexibilidad para futuras modificaciones: Al definir un constructor vacío, puedes agregar 
//    más lógica de inicialización en el futuro sin romper el código existente que crea 
//    instancias de esa clase.

	
	

}
