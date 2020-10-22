package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoExecuteQuery {
	private Connection cn;
	
	/*
	 * Constructor con una conexión 
	 */
	public DaoExecuteQuery(Connection cn) {
		this.cn = cn;
	}
	
	/**
	 * realiza una select y devuelve un resulset
	 * @return
	 */
	public ResultSet executeQuerytRun (String miSql) {
		ResultSet rst=null;
		// creamos el Resulset
		try {
			Statement stm  = cn.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.CONCUR_UPDATABLE);
			rst = stm.executeQuery(miSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rst;
	}
	

}
