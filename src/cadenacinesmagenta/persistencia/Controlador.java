
package cadenacinesmagenta.persistencia;

import cadenacinesmagenta.logica.Pelicula;
import dao.CarteleraDAO;
import igu.Pantalla;
import javax.swing.JOptionPane;


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
                pant.mostrarTabla();
                break;
            case "Modificar":
                p.setId(Integer.parseInt(pant.consultarID()));
                cDAO.actualizarPelicula(p);
                pant.mostrarTabla();
                break;
            case "Eliminar":
                 boolean eliminado = cDAO.eliminarPelicula(Integer.parseInt(pant.consultarID()));
                if (!eliminado) JOptionPane.showMessageDialog(pant, "Ocurrio un error al eliminar la pelicula, verifique que exista el ID");
                else pant.mostrarTabla();
                break;
            case "Listar":
                pant.mostrarTabla();
                break;
            case "Buscar":
                
                
            case "Cerrar Programa":
                pant.mensajeDespedida();
                System.exit(0);
                break;
                
            default:
        
                
        }
        
    }
    
    
}
