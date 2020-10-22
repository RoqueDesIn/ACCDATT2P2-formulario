package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

import Controladores.Controlador;
import DAO.DaoExecute;
import DAO.DaoExecuteQuery;

public class MiMouseListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton miboton = (JButton) e.getSource();
		switch  (miboton.getText()) {
			//carga primer registro
			case "Primero":
				// al primer registro
				try {
					Controlador.getMiRst().first();
				} catch (SQLException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				};
				Controlador.cargaRegistro();
					break;
					
			case "Anterior":
				// al registro anterior
				try {
					Controlador.getMiRst().previous();
				} catch (SQLException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				};
				Controlador.cargaRegistro();
				break;
				
			case "Borrar":
				// Borrar registro
				try {
					// Borramos el registro
					DaoExecute miRstDel = Controlador.getExe();
					String miSql = "delete from asignatura where codAsignatura = '"+Controlador.getMiRst().getInt(1)+"'";
					miRstDel.executeRun(miSql);
					// borramos del rst
					Controlador.getMiRst().deleteRow();
					Controlador.getMiRst().first();
					Controlador.cargaRegistro();
					;
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				break;
				
			case "Nuevo":
				// Añadir registro (solo limpiará los textos del formulario)		
				Controlador.getMiGui().getTFCAsignatura().setText("");;
				Controlador.getMiGui().getTFIdProfesor().setText("");;
				Controlador.getMiGui().getTFNombreAsignatura().setText("");;
				break;
				
			case "Guardar":
				// variables
				String miSql;
				ResultSet okAsignatura;
				
				// comprobar que existe el registro
				DaoExecute miExeQuery = Controlador.getExe();
				miSql="select * from asignatura where codAsignatura = "+Controlador.getMiGui().getTFCAsignatura().getText();
				okAsignatura = Controlador.getMiRstSelect().executeQuerytRun(miSql);
				
			try {
				if (okAsignatura.first()) {
					// existe el registro > guardamos registro en BD
					miSql = "update asignatura set codAsignatura="+Integer.parseInt(Controlador.getMiGui().getTFCAsignatura().getText())
							+ ", Nombre = '" + Controlador.getMiGui().getTFNombreAsignatura().getText()
							+ "',  IdProfesor = "+ Integer.parseInt(Controlador.getMiGui().getTFIdProfesor().getText())+
							" where codAsignatura = " + Integer.parseInt(Controlador.getMiGui().getTFCAsignatura().getText())+";";
					Controlador.getExe().executeRun(miSql);
					// refrescamos el resultset
					Controlador.refreshRst();
					try {
						Controlador.getMiRst().first();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// cargamos el registro
					Controlador.cargaRegistro();
				}else {
					// no existe el registro > insertamos
					miSql = "insert into asignatura (codAsignatura,Nombre,IdProfesor) values ("
							+ Integer.parseInt(Controlador.getMiGui().getTFCAsignatura().getText()) + ", '"
							+ Controlador.getMiGui().getTFNombreAsignatura().getText() + "', "
							+ Integer.parseInt(Controlador.getMiGui().getTFIdProfesor().getText())+" );";
					Controlador.getExe().executeRun(miSql);
					// refrescamos el resultset
					Controlador.refreshRst();
					try {
						Controlador.getMiRst().first();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// cargamos el registro
					Controlador.cargaRegistro();
				}
			} catch (NumberFormatException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
					
			case "Siguiente":
				// al registro siguiente
				try {
					Controlador.getMiRst().next();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
				Controlador.cargaRegistro();
					break;
					
			case "Último":
				// al último registro
				try {
						Controlador.getMiRst().last();
					} catch (SQLException e1) {
						e1.printStackTrace();
					};
					Controlador.cargaRegistro();
					break;
					
			default:
				System.out.println("eing?");
		};
	}


}
