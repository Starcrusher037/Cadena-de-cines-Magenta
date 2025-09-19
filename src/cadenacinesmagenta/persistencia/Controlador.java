
package cadenacinesmagenta.persistencia;

import cadenacinesmagenta.logica.Pelicula;
import dao.CarteleraDAO;


public class Controlador {
   
    CarteleraDAO cDAO = new CarteleraDAO();
    
    //EJECUTAR LA ELECCION DE LA BARRA TAREAS
    public void ejecutorBarraTareas(String tarea,Pelicula p){
    
        switch (tarea){
            case "Crear":
                cDAO.agregarPelicula(p);
                break;
            case "Modificar":
                cDAO.actualizarPelicula(p);
                break;
            case "Eliminar":
                
                
            case "Listar":
                cDAO.listarPeliculas();
                
            case "Buscar":
                
                
            case "Cerrar programa":
                
                
            default:
        
                
        }
        
    }
    
    
}
