package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoExecute {
	/**

	 * Esta clase define el objeto execute() de la aplicación.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 27/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	
	// estados
	private Connection cn;
	
	// comportamientos
	/*
	 * Constructor con una conexión como parámetro
	 */
	public DaoExecute(Connection cn) {
		this.cn = cn;
	}
	
	/**
	 * realiza un execute() y devuelve un booleano
	 * si tiene éxito
	 * @return 
	 */
	public boolean executeRun (String sqlString) {
		boolean rst=false;
		// creamos el Resulset
		try {
			Statement stm  = cn.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.CONCUR_UPDATABLE);
			rst = stm.execute(sqlString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
	}
}
