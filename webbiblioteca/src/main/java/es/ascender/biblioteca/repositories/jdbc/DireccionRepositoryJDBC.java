package es.ascender.biblioteca.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.ascender.biblioteca.negocio.Direccion;

import es.ascender.biblioteca.repositories.DireccionRepository;


public class DireccionRepositoryJDBC implements DireccionRepository {

	static final String DB_URL = "jdbc:mysql://localhost:3306/biblioteca";
	static final String USER = "root";
	static final String PASS = "";

	@Override
	public List<Direccion> buscarTodos() {
		Connection conexion = null; 
		Statement sentencia = null;
		ResultSet rs = null;
		List<Direccion> lista = new ArrayList<Direccion>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			
			sentencia = conexion.createStatement();
			
			rs = sentencia.executeQuery("select * from direccion");

			while (rs.next()) {
				Direccion d = new Direccion(rs.getString("dni"), rs.getString("calle"), rs.getInt("numero"), rs.getInt("CP"));
				lista.add(d);

			}

		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
//

		return lista;
	}

	@Override
	public void insertar(Direccion direccion) {
		
		Connection conexion = null;
		Statement sentencia = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			
			sentencia = conexion.createStatement();
			String insertarSql = "insert into direccion values('" + direccion.getDni() + "','" + direccion.getCalle() + "','" + direccion.getNumero() + "','" + direccion.getCP() + "')";
			sentencia.executeUpdate(insertarSql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void borrar(Direccion direccion) {
		
		Connection conexion = null;
		Statement sentencia = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(DB_URL, USER, PASS);
			
			sentencia = conexion.createStatement();
			String borrarSql = "delete from direccion where calle= '" + direccion.getCalle() + "' and numero='" + direccion.getNumero() + "'";
			System.out.println(borrarSql);
			sentencia.executeUpdate(borrarSql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Direccion> buscarTodosOrdenados(String orden) {
		Connection conexion = null; 
				Statement sentencia = null;
				ResultSet rs = null;
				List<Direccion> lista = new ArrayList<Direccion>();
				
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
					conexion = DriverManager.getConnection(DB_URL, USER, PASS);
					
					sentencia = conexion.createStatement();
					
					rs = sentencia.executeQuery("select * from direccion order by "+orden);
					
					while (rs.next()) {
						Direccion d = new Direccion(rs.getString("dni"), rs.getString("calle"), rs.getInt("numero"), rs.getInt("CP"));
						lista.add(d);

					}

				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
	}
				return lista;
		
	}

}
