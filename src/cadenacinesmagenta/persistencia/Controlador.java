
package cadenacinesmagenta.persistencia;

import dao.CarteleraDAO;
import cadenacinesmagenta.modelo.Pelicula;
import igu.Pantalla;
import java.util.ArrayList;
import java.util.List;
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
                boolean eliminado = false;
                try{
                    eliminado = cartelera.eliminarPelicula(Integer.parseInt(pant.consultarID()));
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(pant, "Ha ocurrido un error al ingresar el id");
                }
                if (!eliminado) JOptionPane.showMessageDialog(pant, "Ocurrio un error al eliminar la pelicula, verifique que exista el ID");
                else pant.mostrarTabla(cartelera.listarPeliculas());
                break;
            case "Listar":
                try{
                    pant.mostrarTabla(cartelera.listarPeliculas(listaDatosFiltrado()));
                }catch(NullPointerException e){
                    JOptionPane.showMessageDialog(pant,"Se cancelo la operacion" );
                }
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
    
    
    public List<String> listaDatosFiltrado(){
        List<String> datosFiltros = new ArrayList<>(); 
                switch(pant.seleccionFiltrado()){   
                    case "Listar todo":
                        break;
                    case "Filtrar por genero":
                        datosFiltros.add(pant.seleccionGenero());
                        break;
                    case "filtrar por rango anio":
                        String minimo = pant.seleccionRangoAnios("inicio");
                        String maximo = pant.seleccionRangoAnios("fin");
                        if (minimo == null || maximo == null) return null;
                        datosFiltros.add(minimo);
                        datosFiltros.add(maximo);
                        break;
                }
        return datosFiltros;
    }
    
    
}
