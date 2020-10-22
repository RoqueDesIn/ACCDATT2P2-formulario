package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;

public class GUI {

	private static JFrame frame;
	private static JTextField TFCAsignatura;
	private static JTextField TFIdProfesor;
	private static JTextField TFNombreAsignatura;
	private MouseListener miMouseListener;
	


	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frame principal
		frame = new JFrame();
		frame.setBounds(100, 100, 578, 221);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		// panel para el título
		JPanel panelTítulo = new JPanel();
		panelTítulo.setMaximumSize(new Dimension(500,30));
		frame.getContentPane().add(panelTítulo);
				
		JLabel lblNewLabel = new JLabel("Mantenimiento de asignaturas");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTítulo.add(lblNewLabel);
		
		//panel principal
		JPanel panelPrincipal = new JPanel();
		frame.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
			
			//panel para el código de asignatura
			JPanel panelCasignatura = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCasignatura.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelCasignatura.setMaximumSize(new Dimension(500,30));
			frame.getContentPane().add(panelCasignatura);
	
			JLabel LACAsignatura = new JLabel("C\u00F3digo de asignatura");
			panelCasignatura.add(LACAsignatura);
			
			TFCAsignatura = new JTextField();
			panelCasignatura.add(TFCAsignatura);
			TFCAsignatura.setColumns(10);
			
			//panel para el nombre
			JPanel panelNombre = new JPanel();
			FlowLayout flowLayout_1 = (FlowLayout) panelNombre.getLayout();
			flowLayout_1.setAlignment(FlowLayout.LEFT);
			panelNombre.setMaximumSize(new Dimension(500,30));
			frame.getContentPane().add(panelNombre);
			
			JLabel LAIdProfesor = new JLabel("Identificador de profesor");
			panelNombre.add(LAIdProfesor);
			
			TFIdProfesor = new JTextField();
			panelNombre.add(TFIdProfesor);
			TFIdProfesor.setColumns(10);
			
			// panel para el id profesor
			//panel para el nombre
			JPanel panelidProfesor = new JPanel();
			FlowLayout flowLayout_2 = (FlowLayout) panelidProfesor.getLayout();
			flowLayout_2.setAlignment(FlowLayout.LEFT);
			panelidProfesor.setMaximumSize(new Dimension(500,30));
			frame.getContentPane().add(panelidProfesor);
			
			JLabel LANombreAsig = new JLabel("Nombre");
			panelidProfesor.add(LANombreAsig);
			
			TFNombreAsignatura = new JTextField();
			panelidProfesor.add(TFNombreAsignatura);
			TFNombreAsignatura.setColumns(40);
		
		// Panel para la botonera
		JPanel panelBotonera = new JPanel();
		panelBotonera.setMaximumSize(new Dimension(1000, 60));
		frame.getContentPane().add(panelBotonera);
		panelBotonera.setLayout(new BoxLayout(panelBotonera, BoxLayout.X_AXIS));
		
		panelBotonera.add(Box.createRigidArea(new Dimension(10, 0)));
		JButton BTPrimero = new JButton("Primero");
		BTPrimero.addActionListener(new MiMouseListener());;
		panelBotonera.add(BTPrimero);
		
		JButton BTAnterior = new JButton("Anterior");
		BTAnterior.addActionListener(new MiMouseListener());;
		panelBotonera.add(BTAnterior);
		
		JButton BTBorra = new JButton("Borrar");
		BTBorra.addActionListener(new MiMouseListener());;
		panelBotonera.add(BTBorra);
		
		JButton BTNuevo = new JButton("Nuevo");
		BTNuevo.addActionListener(new MiMouseListener());;
		panelBotonera.add(BTNuevo);
		
		JButton BTGuardar = new JButton("Guardar");
		BTNuevo.addActionListener(new MiMouseListener());;
		panelBotonera.add(BTGuardar);
		
		JButton BTSiguiente = new JButton("Siguiente");
		BTSiguiente.addActionListener(new MiMouseListener());;
		panelBotonera.add(BTSiguiente);
		
		JButton BTultimo = new JButton("\u00DAltimo");
		BTultimo.addActionListener(new MiMouseListener());;
		panelBotonera.add(BTultimo);

		
	}

	/**
	 * get texto Código asignatura
	 * @return
	 */
	public static JTextField getTFCAsignatura() {
		return TFCAsignatura;
	}

	/**
	 * get texto Id Profesor
	 * @return
	 */
	public static JTextField getTFIdProfesor() {
		return TFIdProfesor;
	}
	
	/**
	 * get texto Nombre Asignatura
	 * @return
	 */
	public static JTextField getTFNombreAsignatura() {
		return TFNombreAsignatura;
	}

	/**
	 * get Listener
	 * @return
	 */
	public MouseListener getMiMouseListener() {
		return miMouseListener;
	}

	/**
	 * get Frame
	 * @return
	 */
	public static JFrame getFrame() {
		return frame;
	}


}
