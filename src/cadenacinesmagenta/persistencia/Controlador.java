
package cadenacinesmagenta.persistencia;

import dao.CarteleraDAO;
import cadenacinesmagenta.modelo.Pelicula;
import igu.Pantalla;
import javax.swing.JOptionPane;


public class Controlador {

    private CarteleraDAO cartelera = new CarteleraDAO();
    private Pantalla pant;

    public Controlador(Pantalla pant) {
        this.pant = pant;
    }
    
    
    //EJECUTAR LA ELECCION DE LA BARRA TAREAS DE LA IGU
    public void ejecutorBarraTareas(String tarea,Pelicula p){
    
        switch (tarea){
            case "Crear":
                cartelera.agregarPelicula(p);
                pant.mostrarTabla(cartelera.listarPeliculas());
                break;
            case "Modificar":
                p.setId(Integer.parseInt(pant.consultarID()));
                cartelera.actualizarPelicula(p);
                pant.mostrarTabla(cartelera.listarPeliculas());
                break;
            case "Eliminar":
                 boolean eliminado = cartelera.eliminarPelicula(Integer.parseInt(pant.consultarID()));
                if (!eliminado) JOptionPane.showMessageDialog(pant, "Ocurrio un error al eliminar la pelicula, verifique que exista el ID");
                else pant.mostrarTabla(cartelera.listarPeliculas());
                break;
            case "Listar":
                pant.mostrarTabla(cartelera.listarPeliculas());
                break;
            case "Buscar":
                pant.mostrarPelicula();
                break;
                
            case "Cerrar Programa":
                pant.mensajeDespedida();
                System.exit(0);
                break;
                
            default:
                
                
        }  
    }
    
    
}
