package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	/**

	 * Esta clase define el objeto conxi�n de la aplicaci�n.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 27/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	
	// estados
	final String CONTROLADOR = "com.mysql.jdbc.Driver";
    final String URL = "jdbc:mysql://localhost:3306/prueba2?allowPublicKeyRetrieval=true&useSSL=false";
    final String USUARIO = "root";
    final String CLAVE = "AdminMysql1211$";
    
	/**
	 * CLASE para conectar con una BD MySQL
	 * @return retorna la clase Conexi�n
	 */
	public Connection conectar() {
        Connection conexion = null;
        
        try {
           Class.forName(CONTROLADOR);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexi�n OK");

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error en la conexi�n");
            e.printStackTrace();
        }
        
        return conexion;
    }
	
}
