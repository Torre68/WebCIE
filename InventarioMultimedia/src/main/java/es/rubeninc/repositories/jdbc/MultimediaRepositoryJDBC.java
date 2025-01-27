package es.rubeninc.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import es.rubeninc.negocio.Multimedia;
import es.rubeninc.repositories.MultimediaRepository;

public class MultimediaRepositoryJDBC implements MultimediaRepository {

	String cadenaconexion = "jdbc:mysql://localhost:3306/Casa";

	List<Multimedia> lista = new ArrayList<Multimedia>();

	@Override
	public List<Multimedia> inventarioCompleto() {
		try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "81117192146");
				Statement sentencia = conexion.createStatement();) {
			ResultSet rs = sentencia.executeQuery("select * from multimedia");

			while (rs.next()) {
				Multimedia m = new Multimedia(rs.getString("ISRC"), rs.getString("autor"), rs.getString("titulo"),
						rs.getInt("ejemplares"), rs.getString("formato"));
				lista.add(m);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;

	}

	@Override
	public void insertarMultimedia(Multimedia multimedia) {
		try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "81117192146");
				Statement sentencia = conexion.createStatement();) {

			String insertarSQL = "insert into multimedia values ('" + multimedia.getISRC() + "','"
					+ multimedia.getAutor() + "','" + multimedia.getTitulo() + "','" + multimedia.getEjemplares()
					+ "','" + multimedia.getFormato() + "')";
			sentencia.executeUpdate(insertarSQL);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void borrarMultimedia(Multimedia multimedia) {
		
		try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "81117192146");
				Statement sentencia = conexion.createStatement();) {
			

			sentencia.executeUpdate("delete from multimedia where ISRC='"+multimedia.getISRC()+ "'");
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Multimedia> buscarAutor(String autor) {
		List<Multimedia> lista = new ArrayList<Multimedia>();
		try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "81117192146");
				Statement sentencia = conexion.createStatement();) {
			ResultSet rs = sentencia.executeQuery("select * from multimedia where autor='"+autor+ "'");
			while (rs.next()) {
				Multimedia m = new Multimedia(rs.getString("autor"));
				lista.add(m);

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<Multimedia> buscarTitulo(String titulo) {
		List<Multimedia> lista = new ArrayList<Multimedia>();
		try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "81117192146");
				Statement sentencia = conexion.createStatement();) {
			ResultSet rs = sentencia.executeQuery("select * from multimedia where titulo='"+titulo+ "'");
			while (rs.next()) {
				Multimedia m = new Multimedia(rs.getString("titulo"));
				lista.add(m);

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

	@Override
	public List<Multimedia> porOrden(String orden) {
		try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "81117192146");
				Statement sentencia = conexion.createStatement();) {
			ResultSet rs = sentencia.executeQuery("select * from multimedia order by"+orden);

			while (rs.next()) {
				Multimedia m = new Multimedia(rs.getString("ISRC"), rs.getString("autor"), rs.getString("titulo"),
						rs.getInt("ejemplares"), rs.getString("formato"));
				lista.add(m);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;
	}

}
