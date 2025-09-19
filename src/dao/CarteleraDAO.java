
package dao;

import cadenacinesmagenta.logica.Pelicula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CarteleraDAO {
    
     // CREATE - insertar película
    public void agregarPelicula(Pelicula p) {
        String sql = "INSERT INTO Cartelera (titulo, director, anio, duracion, genero) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectarBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setInt(3, p.getAnio());
            ps.setInt(4, p.getDuracion());
            ps.setString(5, p.getGenero());

            ps.executeUpdate();
            System.out.println(" Pelicula agregada: " + p.getTitulo());
        } catch (SQLException e) {
            System.out.println(" Error al agregar: " + e.getMessage());
        }
    }

    // READ - listar todas las películas
    public List<Pelicula> listarPeliculas() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cartelera";
        try (Connection conn = ConexionBD.conectarBD();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pelicula p = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("anio"),
                        rs.getInt("duracion"),
                        rs.getString("genero")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    
    //ESTE METODO ESTÁ PENSADO PARA TRABAJARLO EN CONSOLA
    public void mostrarPeliculas(List<Pelicula> peliculas){
        for (Pelicula p : peliculas){
            System.out.println(p);
        }
    }
    
    // UPDATE - actualizar película
    public void actualizarPelicula(Pelicula p) {
        String sql = "UPDATE Cartelera SET titulo=?, director=?, anio=?, duracion=?, genero=? WHERE id=?";
        try (Connection conn = ConexionBD.conectarBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setInt(3, p.getAnio());
            ps.setInt(4, p.getDuracion());
            ps.setString(5, p.getGenero());
            ps.setInt(6, p.getId());

            ps.executeUpdate();
            System.out.println(" Película actualizada: " + p.getTitulo());
        } catch (SQLException e) {
            System.out.println(" Error al actualizar: " + e.getMessage());
        }
    }

    // DELETE - eliminar película
    public void eliminarPelicula(int id) {
        String sql = "DELETE FROM Cartelera WHERE id=?";
        try (Connection conn = ConexionBD.conectarBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println(" Pelicula eliminada con ID: " + id);
        } catch (SQLException e) {
            System.out.println(" Error al eliminar: " + e.getMessage());
        }
    }
    
    
}
