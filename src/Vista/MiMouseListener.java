package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Controladores.Controlador;
import DAO.DaoExecute;
import DAO.DaoExecuteQuery;

public class MiMouseListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton miboton = (JButton) e.getSource();
		
		switch  (miboton.getText()) {
			//carga primer registro
		//******************************
			case "<<":
				// al primer registro
				try {
					Controlador.getMiRst().first();
				} catch (SQLException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				};
				Controlador.cargaRegistro();
					break;
			
			// al registro anterior
					//*************************
			case "<":
				// al registro anterior
				try {
					// Ya estamos en el primer registro
					if (Controlador.getMiRst().previous()==false) {
						JOptionPane.showMessageDialog(Controlador.getMiGui().getFrame(), "Ya está en el primer registro.");
						Controlador.getMiRst().first();
					} else {
						// nos posicionamos en el registro anterior
						Controlador.cargaRegistro();
					}
				} catch (SQLException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				};
				break;
			
			//Borra el registro
				//******************
			case "Borrar":
				// Borrar registro
				int okSeguro = JOptionPane.showConfirmDialog(Controlador.getMiGui().getFrame(),"Se borrará el registro seleccionado. ¿Está seguro?");
				if (okSeguro==JOptionPane.YES_OPTION) {
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
				}
				
				break;
			
			// nuevo registro
				//****************
			case "Nuevo":
				// Añadir registro (solo limpiará los textos del formulario)		
				Controlador.getMiGui().getTFCAsignatura().setText("");;
				Controlador.getMiGui().getTFIdProfesor().setText("");;
				Controlador.getMiGui().getTFNombreAsignatura().setText("");;
				// deshabilita botones
				cambiaEstadoBT(false);
				break;
			
				// guardar registro
				//***************
			case "Guardar":
				boolean okComprobar=false;
				okComprobar=compruebaTexto();
				if (okComprobar) {
					guardar();
					cambiaEstadoBT(true);
				}
				break;
			
			// registro siguiente
			case ">":
				// al registro siguiente
				try {
					if (Controlador.getMiRst().next()==false) {
						JOptionPane.showMessageDialog(Controlador.getMiGui().getFrame(),"Ya está en el último registro");
						Controlador.getMiRst().last();
					} else {
						Controlador.cargaRegistro();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
				break;
					
			case ">>":
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
	
	/**
	 * habilita/deshabilita botones
	 * @param b
	 */
	private void cambiaEstadoBT(boolean b) {
		Controlador.getMiGui().getBTBorra().setEnabled(b);
		Controlador.getMiGui().getBTNuevo().setEnabled(b);
		Controlador.getMiGui().getBTPrimero().setEnabled(b);
		Controlador.getMiGui().getBTUltimo().setEnabled(b);
		Controlador.getMiGui().getBTSiguiente().setEnabled(b);
		Controlador.getMiGui().getBTAnterior().setEnabled(b);		
	}

	/**
	 * comprueba que el texto no sea nulo
	 * @return verdadero si es todo correcto, falso si ha habido error
	 */
	private boolean compruebaTexto() {
		boolean resultado=true;
		// comprueba Código asignatura
		if (Controlador.getMiGui().getTFCAsignatura().getText().length()==0) {
			JOptionPane.showMessageDialog(Controlador.getMiGui().getFrame(),"El código de asignatura no puede ser nulo");
			Controlador.getMiGui().getTFCAsignatura().requestFocus();
			resultado = false;
		};
		// comprueba idprofesor
		if ((Controlador.getMiGui().getTFIdProfesor().getText().length()==0) && resultado) {
			JOptionPane.showMessageDialog(Controlador.getMiGui().getFrame(),"El Id de profesosor de asignatura no puede ser nulo");
			Controlador.getMiGui().getTFIdProfesor().requestFocus();
			resultado = false;
		};
		// comprueba Nombre
		if ((Controlador.getMiGui().getTFNombreAsignatura().getText().length()==0) && resultado) {
			JOptionPane.showMessageDialog(Controlador.getMiGui().getFrame(),"El nombre de asignatura no puede ser nulo");
			Controlador.getMiGui().getTFNombreAsignatura().requestFocus();
			resultado = false;
		};
		return resultado;
	}

	/**
	 * Guarda un registro si ya existe e inserta si no existe
	 */
	private void guardar() {
		// variables
		String miSql;
		ResultSet okAsignatura;
		
		// comprobar que existe el registro
		//DaoExecute miExeQuery = Controlador.getExe();
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
	}


}
