
package cadenacinesmagenta;

import cadenacinesmagenta.persistencia.Controlador;
import igu.Pantalla;

public class Cadenacinesmagenta {

  
    public static void main(String[] args) {
   
        Pantalla monitor = new Pantalla(null);
        Controlador controlador = new Controlador(monitor);
        monitor.setControlador(controlador);
        
       
         monitor.setVisible(true);
         monitor.setLocationRelativeTo(null);
         
         
         
         
         
    }
}
