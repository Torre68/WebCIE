package es.cie.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cie.negocio.Libro;

public class LibroRepositoryJDBC implements LibroRepository {

	static final String DB_URL = "jdbc:mysql://localhost:3306/cie1";
	static final String USER = "root";
	static final String PASS = "";
	
	
	@Override
	public List<Libro> buscarTodos() {
		
		
		
		ResultSet rs=null;
		Connection conexion=null;
		ArrayList<Libro> lista= new ArrayList<Libro>();
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			//conecto a la base de datos
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			//preparo la sentencia
			Statement sentencia = conexion.createStatement();
			//ejecuto
			rs = sentencia.executeQuery("select * from Libros");
			while (rs.next()) {
				
				Libro p= new Libro(rs.getString("isbn"),
						rs.getString("titulo"),rs.getString("autor"), rs.getInt("paginas"));
				
				lista.add(p);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if (conexion!=null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return lista;
	}
		


	@Override
	public List<Libro> buscarPortitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> buscarAutor(String autor) {
		// TODO Auto-generated method stub
		return null;
	}

}