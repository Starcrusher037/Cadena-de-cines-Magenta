
package cadenacinesmagenta;

import cadenacinesmagenta.persistencia.Controlador;
import igu.Pantalla;

public class Cadenacinesmagenta {

  
    public static void main(String[] args) {
    
        /*Un controlador necesita de una pantalla y viceversa por lo que se inicia una pantalla null para pasarsela a 
        al controlador y luego se le agrega mediante un set el controlador a la instancia de pantalla, así comparten 
        instancias.*/
        Pantalla monitor = new Pantalla(null);
        Controlador controlador = new Controlador(monitor);
        monitor.setControlador(controlador);
        
        //El objeto de tipo pantalla se hace visible y se centra no tomando puntos de referencia para la ubicacion.
         monitor.setVisible(true);
         monitor.setLocationRelativeTo(null); 
    }
}
