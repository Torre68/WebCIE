package es.ascender.biblioteca.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.ascender.biblioteca.negocio.Socio;
import es.ascender.biblioteca.repositories.SocioRepository;

public class SocioRepositoryJDBC implements SocioRepository {

	static final String DB_URL = "jdbc:mysql://localhost:3306/biblioteca";
	static final String USER = "root";
	static final String PASS = "";

	@Override
	public List<Socio> buscarTodos() {
		Connection conexion = null; // La INTERFAZ connection con el que nos conectamos a la base de datos
// esta localizada en Libraries/WebAppLibraries/mysql-connector-j-8.4.0.jar. 
// En mysql-connector-j-8.4.0.jar. viene todo lo necesario para hacer las conexiones a la sql.
		Statement sentencia = null;
		ResultSet rs = null;
		List<Socio> lista = new ArrayList<Socio>();
		// List es la INTERFAZ de ARRAYLIST.
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Registra el driver para poder conectarse.
			// para preparar la sentencia sql a lanzar.
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			// El comando que ordena la conexion a traves de las variables de arriba.
			sentencia = conexion.createStatement();
			// una vez que ejecuto el comando el resultado se asigna a un ResultSet.
			rs = sentencia.executeQuery("select * from socios");

			while (rs.next()) {
				Socio s = new Socio(rs.getString("dni"), rs.getString("nombre"), rs.getNString("apellidos"));
				lista.add(s);

			}

		} catch (ClassNotFoundException | SQLException e) {
			// Seleccionamos ambos statements (Class.forName("com.mysql.jdbc.Driver"); y
			// Statement sentencia = conexion.createStatement(); y
			// surround with multiple try/catch.
			e.printStackTrace();
		}
//

		return lista;
	}

	@Override
	public void insertar(Socio socio) {
		// Aqui implementamos el metodo insertar socio de la interfaz.
		Connection conexion = null;
		Statement sentencia = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");// Surround with multicatch block
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			// Add exception to existing catch clause.
			sentencia = conexion.createStatement();
			String insertarSql = "insert into socios values('" + socio.getDni() + "','" + socio.getNombre() + "','"
					+ socio.getApellidos() + "')";
			sentencia.executeUpdate(insertarSql);// Seleccionamos desde que empiezan las 
			// comillas y Refactor>Extract Local Variable (Esto nos vale para luego usar un 
			// syso e imprimir por consola la frase de las comillas y poder comprobar que 
			// no tenga fallos).
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void borrar(Socio socio) {
		// Aqui implementamos el metodo borrar.
		
		Connection conexion = null;
		Statement sentencia = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			// Add exception to existing catch clause.
			sentencia = conexion.createStatement();
			String borrarSql = "delete from socios where dni='" + socio.getDni() +"'";
			//Aqui cambiamos el nombre de la variable y los parametros (Normalmente solo se
			//borra por clave Primary). CUIDADO con usar correctamente el comando adecuado
			//de SQL.
			sentencia.executeUpdate(borrarSql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Socio> buscarTodosOrdenados(String orden) {
		Connection conexion = null; 
				Statement sentencia = null;
				ResultSet rs = null;
				List<Socio> lista = new ArrayList<Socio>();
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					conexion = DriverManager.getConnection(DB_URL, USER, PASS);
					
					sentencia = conexion.createStatement();
					
					rs = sentencia.executeQuery("select * from socios order by "+orden);
					// Implementamos el metodo Ordenar

					while (rs.next()) {
						Socio s = new Socio(rs.getString("dni"), rs.getString("nombre"), rs.getNString("apellidos"));
						lista.add(s);

					}

				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
	}
				return lista;
		
	}

}
