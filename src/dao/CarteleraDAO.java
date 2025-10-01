
package dao;

import cadenacinesmagenta.modelo.Pelicula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarteleraDAO {
  
    
    // Recibe un objeto pelicula y lo carga a la base de datos
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
        }catch (SQLException e) {
            System.out.println(" Error al agregar: " + e.getMessage());
        }
    }

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
    
    // Conecta con base de datos, genera y devuelve una lista .
    public List<Pelicula> listarPeliculas(List<String> listaArgumentos) {
        if (listaArgumentos == null) return null;   
        List<Pelicula> lista = new ArrayList<>();
        String sql;
        try (Connection conn = ConexionBD.conectarBD()){
            PreparedStatement ps ;
                
            if (listaArgumentos.isEmpty()){
                sql = "SELECT * FROM Cartelera";
                ps = conn.prepareStatement(sql);
            }else if (listaArgumentos.size()==1) {
                sql = "SELECT * FROM Cartelera WHERE genero = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,listaArgumentos.get(0));
            }
            else {
                sql = "SELECT *FROM Cartelera WHERE anio >= ? AND anio <= ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(listaArgumentos.get(0)));
                ps.setInt(2, Integer.parseInt(listaArgumentos.get(1)));
            }
            
           try(ResultSet rs = ps.executeQuery()){
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
           }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    
    // Recibe una pelicula y actualiza los datos de la pelicula correspondiente al ID en la base de datos
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
    

    // Mediante el ID borra la pelicula de la base de datos correspondiente y devuelve un boolean que se ocupa en la igu
    public boolean eliminarPelicula(int id) {
        String sql = "DELETE FROM Cartelera WHERE id=?";
        try (Connection conn = ConexionBD.conectarBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            if( ps.executeUpdate() > 0) {
                System.out.println(" Pelicula eliminada con ID: " + id);
                return true;
            }
            else return false;
        } catch (SQLException e) {
            System.out.println(" Error al eliminar: " + e.getMessage());
            return false;
        }
    }
    
    public Pelicula buscarPelicula(String pelicula){
        for (Pelicula p : listarPeliculas()){
            if (p.getTitulo().toUpperCase().equalsIgnoreCase(pelicula)) return p;
        }
        return null ;
    }
}
