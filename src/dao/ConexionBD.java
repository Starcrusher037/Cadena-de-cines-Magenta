
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    private static final String url = "jdbc:mysql://localhost:3306/Cine_DB";
    private static final String usuario = "root";
    private static final String contrasenia = "Basesdatos2025";
    
    public static Connection conectarBD() throws SQLException{
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,usuario,contrasenia);
        } catch (ClassNotFoundException e) {
            System.out.println("\nError, no se encontro el driver de mysql");
        }catch (SQLException e){
            System.out.println("\nError en la coneccion a la base de datos");
        }
        return conn;
    }
    
       
}
