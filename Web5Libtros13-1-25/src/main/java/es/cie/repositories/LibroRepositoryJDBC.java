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

    // Lista para almacenar los libros
    private List<Libro> listaLibros;

    public LibroRepositoryJDBC() {
        // Cargar todos los libros al instanciar el repositorio
        listaLibros = buscarTodos();
    }

    @Override
    public List<Libro> buscarTodos() {
        ResultSet rs = null;
        Connection conexion = null;
        ArrayList<Libro> lista = new ArrayList<Libro>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Conecto a la base de datos
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            // Preparo la sentencia
            Statement sentencia = conexion.createStatement();
            // Ejecuto
            rs = sentencia.executeQuery("select * from Libros");
            while (rs.next()) {
                Libro p = new Libro(rs.getString("isbn"),
                        rs.getString("titulo"), rs.getString("autor"), rs.getInt("paginas"));

                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return lista;
    }

    public List<Libro> buscarPortitulo(String titulo) {
        ArrayList<Libro> listaNueva = new ArrayList<Libro>();
        for (Libro l : listaLibros) {
            String tituloLibro = l.getTitulo();
            if (tituloLibro.toLowerCase().contains(titulo.toLowerCase())) {
                listaNueva.add(l);
            }
        }
        return listaNueva;
    }

    public List<Libro> buscarAutor(String autor) {
        ArrayList<Libro> listaNueva = new ArrayList<Libro>();
        for (Libro l : listaLibros) {
            String autorLibro = l.getAutor();
            if (autorLibro.toLowerCase().contains(autor.toLowerCase())) {
                listaNueva.add(l);
            }
        }
        return listaNueva;
    }
}
