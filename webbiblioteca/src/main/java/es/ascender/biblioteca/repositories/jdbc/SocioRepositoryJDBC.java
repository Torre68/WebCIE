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
	
	static final String DB_URL="jdbc:mysql://localhost:3306/biblioteca";
	static final String USER="root";
	static final String PASS="";

	@Override
	public List<Socio> buscarTodos() {
		Connection conexion = null; // La INTERFAZ connection con el que nos conectamos a la base de datos
// esta localizada en Libraries/WebAppLibraries/mysql-connector-j-8.4.0.jar. 
// En mysql-connector-j-8.4.0.jar. viene todo lo necesario para hacer las conexiones a la sql.
		Statement sentencia=null;
		ResultSet rs= null;
		List<Socio> lista= new ArrayList<Socio>();
		//List es la INTERFAZ de ARRAYLIST.
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Registra el driver para poder conectarse.
			//para preparar la sentencia sql a lanzar.
			conexion = DriverManager.getConnection(DB_URL,USER,PASS);
			//El comando que ordena la conexion a traves de las variables de arriba.
			sentencia = conexion.createStatement();
			//una vez que ejecuto el comando el resultado se asigna a un ResultSet.
			rs=sentencia.executeQuery("select * from socios");
			
			while (rs.next()) {
				Socio s= new Socio(rs.getString("dni"),rs.getString("nombre"),
						rs.getNString("apellidos"));
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

}
