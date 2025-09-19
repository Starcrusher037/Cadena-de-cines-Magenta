
package dao;

import cadenacinesmagenta.logica.Pelicula;


public class TestCRUD {
    
    
   
    public static void main(String[] args) {
        CarteleraDAO dao = new CarteleraDAO();
/*
        // INSERTAR
        Pelicula nueva = new Pelicula("\nInception", "Christopher Nolan", 2010, 148, "Ciencia Ficcion");
        dao.agregarPelicula(nueva);

        // LISTAR
        System.out.println("\n Lista de peliculas:");
        for (Pelicula p : dao.listarPeliculas()) {
            System.out.println(p);
        }

        // ACTUALIZAR (ejemplo: cambiar duración)
        Pelicula actualizar = new Pelicula(1, "\nInception", "Christopher Nolan", 2010, 150, "Ciencia Ficcion");
        dao.actualizarPelicula(actualizar);
*/
        // ELIMINAR (ejemplo: borrar película con ID 1)
        dao.eliminarPelicula(13);
    
}

}
