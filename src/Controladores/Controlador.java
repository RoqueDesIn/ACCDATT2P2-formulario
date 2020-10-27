package Controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.Conexion;
import DAO.DaoExecute;
import DAO.DaoExecuteQuery;
import Vista.GUI;
/**

 * Esta clase define el objeto controlador de la aplicación.

 * @author Roque Flores Naranjo
 * 
 * @version 27/10/2020-1.0

 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

 */

public abstract class Controlador {
	//estados
	private static Connection cn;
	private static ResultSet miRst;
	private static DaoExecute miExe;
	private static GUI miGui;
	private static DaoExecuteQuery miRstSelect;
	
	//comportamientos
	/**
	 * Constructor vacio
	 */
	public Controlador() {

	}
	
	/**
	 * Módulo principal, Conecta con la BD, 
	 * extrae el Resulset, crea el DAO y la GUI
	 */
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
	 * Carga un registro del formulario desde el resultset en los textos de la GUI
	 */
	public static void cargaRegistro() {
		try {
			miGui.getTFCAsignatura().setText(Integer.toString(miRst.getInt(1)));
			miGui.getTFIdProfesor().setText(Integer.toString(miRst.getInt(3)));
			miGui.getTFNombreAsignatura().setText(miRst.getString(2));
			// refresca el label de control de registros
			updateLBReg();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	}
	
	/**
	 * Modifica label de control de registros
	 */
	private static void updateLBReg() {
		String miStr=null;
		try {
			// guarda registro actual
			int regAct=miRst.getRow();
			// refresca el label
			miStr = " Registro " + String.valueOf(miRst.getRow()) +  " de " 
					+ cuentaReg() +".                                   ";
			//recupera el registro en curso
			miRst.absolute(regAct);
			miGui.getLBRegistros().setText(miStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	}
	
	/**
	 * Ddevuelve un int con el número de registros en un resulset
	 * @return
	 */
	private static int cuentaReg() {
		int resultado=1;
		
		try {
			miRst.first();
			while (miRst.next()) {
				resultado++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
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
	 * get miRstSelect
	 * @return
	 */
	public static DaoExecuteQuery getMiRstSelect() {
		return miRstSelect;
	}
	
	// setters
	/**
	 * get setMiRstSelect
	 * @return
	 */
	public static void setMiRstSelect(DaoExecuteQuery miRstSelect) {
		Controlador.miRstSelect = miRstSelect;
	}
}
