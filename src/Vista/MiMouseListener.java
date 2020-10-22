package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;

import Controladores.Controlador;
import DAO.RstDelete;

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
					cargaRegistro();
					break;
					
			case "Anterior":
				// al registro anterior
				try {
					Controlador.getMiRst().previous();
				} catch (SQLException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				};
				cargaRegistro();
				break;
				
			case "Borrar":
				// Borrar registro
				try {
					// Borramos el registro
					RstDelete miRstDel = Controlador.getRstDel();
					String miSql = "delete from asignatura where "+Controlador.getMiRst().getInt(1);
					miRstDel.deleteRun(miSql);
					// borramos del rst
					Controlador.getMiRst().deleteRow();
					cargaRegistro();
					;
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				break;
				
			case "Nuevo":
				// Añadir registro (solo limpiará los textos del formulario)		
				Controlador.getMiGui().
				
			case "Guardar":
				// modificar registro
			
				//Aquí habría que modificar el registro de la tabla
				
		
				cargaRegistro();
				break;
				
			case "Siguiente":
				// al registro siguiente
				try {
					Controlador.getMiRst().next();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
					cargaRegistro();
					break;
					
			case "Último":
				// al último registro
				try {
						Controlador.getMiRst().last();
					} catch (SQLException e1) {
						e1.printStackTrace();
					};
					cargaRegistro();
					break;
					
			default:
				System.out.println("eing?");
		};
	}

		
	private void cargaRegistro() {
		try {
			GUI.getTFCAsignatura().setText(Integer.toString(Controlador.getMiRst().getInt(1)));
			GUI.getTFIdProfesor().setText(Controlador.getMiRst().getString(2));
			GUI.getTFNombreAsignatura().setText(Controlador.getMiRst().getString(3));				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	}
}
