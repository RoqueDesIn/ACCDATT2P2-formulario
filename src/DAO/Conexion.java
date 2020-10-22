package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	final String CONTROLADOR = "com.mysql.jdbc.Driver";
    final String URL = "jdbc:mysql://localhost:3306/prueba2?allowPublicKeyRetrieval=true&useSSL=false";
    final String USUARIO = "root";
    final String CLAVE = "AdminMysql1211$";
    
	/**
	 * CLASE para conectar con una BD MySQL
	 * @return retorna la clase Conexión
	 */
	public Connection conectar() {
        Connection conexion = null;
        
        try {
           Class.forName(CONTROLADOR);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        
        return conexion;
    }
	
}
