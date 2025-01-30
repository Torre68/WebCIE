package es.cie.ordenador.repositories.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cie.ordenador.negocio.Ordenador;
import es.cie.ordenador.repositories.OrdenadorRepository;

public class OrdenadorRepositoryJDBC implements OrdenadorRepository{
	
	

		String cadenaconexion = "jdbc:mysql://localhost:3306/biblioteca";


	
		

		@Override
		public List<Ordenador> showAll() {
			List<Ordenador> lista = new ArrayList<Ordenador>();
			try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "");
					Statement sentencia = conexion.createStatement();) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				ResultSet rs = sentencia.executeQuery("select * from ordenador");

				while (rs.next()) {
					Ordenador o = new Ordenador(rs.getString("marca"), rs.getInt("precio"));
					lista.add(o);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return lista;

		}

		@Override
		public void insert(Ordenador ordenador) {
			try (Connection conexion = DriverManager.getConnection(cadenaconexion, "root", "");
					Statement sentencia = conexion.createStatement();) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String insertarSQL = "insert into ordenador values ('" + ordenador.getMarca()
						+ "','" + ordenador.getPrecio() + "')";
				sentencia.executeUpdate(insertarSQL);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
		

		

	}


