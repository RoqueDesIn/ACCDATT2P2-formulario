package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RstDelete {
	// estados
	private Connection cn;
	
	// comportamientos
	/*
	 * Constructor con una conexión como parámetro
	 */
	public RstDelete(Connection cn) {
		this.cn = cn;
	}
	
	/**
	 * realiza un delete y devuelve un booleano
	 * @return
	 */
	public boolean deleteRun (String sqlString) {
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
