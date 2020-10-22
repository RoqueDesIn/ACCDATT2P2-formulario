package Controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.Conexion;
import DAO.DaoExecute;
import DAO.DaoExecuteQuery;
import Vista.GUI;

public abstract class Controlador {
	private static Connection cn;
	private static ResultSet miRst;
	private static DaoExecute miExe;
	private static GUI miGui;
	private static DaoExecuteQuery miRstSelect;
	
	public Controlador() {

	}
	public static void conectar () {
		//creamos la conexión
		Conexion miConexion = new Conexion();
		cn= miConexion.conectar();
		
		// creamos nuestro resultset para la select
		refreshRst();
		
		// creamos nuestro DaoDelete
		miExe= new DaoExecute(cn);
		
		// llamamos a la GUI
		miGui = new GUI();
		miGui.getFrame().setVisible(true);
		
		// cargamos el formulario con el primer registro
		try {
			miRst.first();
			cargaRegistro();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}

	}
	/**
	 * Carga un registro del formulario desde el resultset
	 */
	public static void cargaRegistro() {
		try {
			miGui.getTFCAsignatura().setText(Integer.toString(miRst.getInt(1)));
			miGui.getTFIdProfesor().setText(Integer.toString(miRst.getInt(3)));
			miGui.getTFNombreAsignatura().setText(miRst.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	}
	
	/*
	 * refresca el resulset
	 */
	public static void refreshRst() {
		setMiRstSelect(new DaoExecuteQuery(cn));
		String miSql= "select * from asignatura";
		miRst = getMiRstSelect().executeQuerytRun(miSql);		
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
	public static DaoExecute getExe() {
		return miExe;
	}
	
	/**
	 * get resultSet
	 * @return
	 */
	public static ResultSet getMiRst() {
		return miRst;
	}

	/**
	 * get miGui
	 * @return
	 */
	public static GUI getMiGui() {
		return miGui;
	}

	/**
	 * get miGui
	 * @return
	 */
	public static DaoExecuteQuery getmiRstSelect() {
		return getMiRstSelect();
	}
	public static DaoExecuteQuery getMiRstSelect() {
		return miRstSelect;
	}
	public static void setMiRstSelect(DaoExecuteQuery miRstSelect) {
		Controlador.miRstSelect = miRstSelect;
	}
}
