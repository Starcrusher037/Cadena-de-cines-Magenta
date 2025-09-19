
package cadenacinesmagenta.persistencia;

import cadenacinesmagenta.logica.Pelicula;
import dao.CarteleraDAO;
import igu.Pantalla;


public class Controlador {

   
    private CarteleraDAO cDAO = new CarteleraDAO();
    private Pantalla pant;

    public Controlador(Pantalla pant) {
        this.pant = pant;
    }
    
    
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
                pant.mostrarTabla();
                break;
            case "Buscar":
                
                
            case "Cerrar programa":
                
                
            default:
        
                
        }
        
    }
    
    
}
