package Controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.Conexion;
import DAO.RstDelete;
import DAO.RstSelect;
import Vista.GUI;

public abstract class Controlador {
	private static Connection cn;
	private static ResultSet miRst;
	private static RstDelete rstDel;
	
	public Controlador() {

	}
	public static void conectar () {
		//creamos la conexión
		Conexion miConexion = new Conexion();
		cn= miConexion.conectar();
		
		// creamos nuestro resultset para la select
		RstSelect miRstSelect=new RstSelect(cn);
		String miSql= "select * from asignatura";
		miRst = miRstSelect.selectRun(miSql);
		
		// creamos nuestro DaoDelete
		rstDel= new RstDelete(cn);
		
		// llamamos a la GUI
		GUI miGui = new GUI();
		GUI.getFrame().setVisible(true);
		
		// cargamos el formulario con el primer registro
		try {
			miRst.last();
			GUI.getTFCAsignatura().setText(Integer.toString(miRst.getInt(1)));
			GUI.getTFIdProfesor().setText(miRst.getString(2));
			GUI.getTFNombreAsignatura().setText(miRst.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}

	}
	
	/**
	 * get conexion
	 * @return
	 */
	public Connection getCn() {
		return cn;
	}
	
	/**
	 * get rstDel
	 * @return 
	 * @return
	 */
	public static RstDelete getRstDel() {
		return rstDel;
	}
	
	/**
	 * get resultSet
	 * @return
	 */
	public static ResultSet getMiRst() {
		return miRst;
	}

	
}
