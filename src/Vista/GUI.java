package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.FlowLayout;
import java.awt.event.MouseListener;

public class GUI {
	/**

	 * Esta clase define el objeto window principal de la GUI.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 27/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	
	// estados
	private  JFrame frame;
	private  JTextField TFCAsignatura;
	private  JTextField TFIdProfesor;
	private  JTextField TFNombreAsignatura;
	private MouseListener miMouseListener;
	private JButton BTNuevo;
	private JButton BTPrimero;
	private JButton BTultimo;
	private JButton BTSiguiente;
	private JButton BTAnterior;
	private JButton BTBorra;
	private JLabel LBRegistros;

	/**
	 * inicializa la GUI.
	 */
	public GUI() {
		initialize();
	}

	/**
	 *Inicializa contenidos del frame.
	 */
	private void initialize() {
		// frame principal
		frame = new JFrame();
		frame.setBounds(100, 100, 489, 245);
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
			panelidProfesor.setMaximumSize(new Dimension(500,50));
			frame.getContentPane().add(panelidProfesor);
			
			JLabel LANombreAsig = new JLabel("Nombre");
			panelidProfesor.add(LANombreAsig);
			
			TFNombreAsignatura = new JTextField();
			panelidProfesor.add(TFNombreAsignatura);
			TFNombreAsignatura.setColumns(40);
		
		// Panel para la botonera
		JPanel panelBotoneras = new JPanel();
		panelBotoneras.setMaximumSize(new Dimension(1000, 60));
		frame.getContentPane().add(panelBotoneras);;;
		panelBotoneras.setLayout(new BoxLayout(panelBotoneras, BoxLayout.Y_AXIS));
		
		JPanel panelBotonera = new JPanel();
		panelBotoneras.add(panelBotonera);
		
		BTBorra = new JButton("Borrar");
		panelBotonera.add(BTBorra);
		
		JButton BTGuardar = new JButton("Guardar");
		panelBotonera.add(BTGuardar);
		
		BTNuevo = new JButton("Nuevo");
		panelBotonera.add(BTNuevo);
		BTNuevo.addActionListener(new MiMouseListener());
		BTGuardar.addActionListener(new MiMouseListener());
		BTBorra.addActionListener(new MiMouseListener());
		
		// panel registros
		JPanel panelRegistros = new JPanel();
		panelBotoneras.add(panelRegistros);
		
		panelRegistros.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		BTPrimero = new JButton("<<");
		BTPrimero.setToolTipText("Primer registro.");
		BTPrimero.setForeground(Color.RED);
		BTPrimero.setFont(new Font("Tahoma", Font.BOLD, 8));
		panelRegistros.add(BTPrimero);
		
		BTAnterior = new JButton("<");
		BTAnterior.setToolTipText("Registro anterior.");
		BTAnterior.setForeground(Color.RED);
		BTAnterior.setFont(new Font("Tahoma", Font.BOLD, 8));
		panelRegistros.add(BTAnterior);
		
		LBRegistros = new JLabel(" No se han encontrado registros.                     ");
		LBRegistros.setBackground(Color.WHITE);
		Border bordeRegistros = BorderFactory.createLineBorder(Color.BLUE,1);
		LBRegistros.setBorder(bordeRegistros);

		panelRegistros.add(LBRegistros);
		

		
		
		BTSiguiente = new JButton(">");
		BTSiguiente.setToolTipText("Registro siguiente.");
		BTSiguiente.setForeground(Color.RED);
		BTSiguiente.setFont(new Font("Tahoma", Font.BOLD, 8));
		panelRegistros.add(BTSiguiente);
		
		BTultimo = new JButton(">>");
		BTultimo.setToolTipText("\u00DAltimo registro.");
		BTultimo.setForeground(Color.RED);
		BTultimo.setFont(new Font("Tahoma", Font.BOLD, 8));
		panelRegistros.add(BTultimo);
		BTultimo.addActionListener(new MiMouseListener());
		BTSiguiente.addActionListener(new MiMouseListener());
		BTAnterior.addActionListener(new MiMouseListener());
		BTPrimero.addActionListener(new MiMouseListener());;;;;;
		
	}
	
	// GETTERS AND SETTERS
	/**
	 * get Label controls de registros
	 * @return
	 */
	public  JLabel getLBRegistros() {
		return LBRegistros;
	}
	/**
	 * get texto Botón Borra
	 * @return
	 */
	public  JButton getBTBorra() {
		return BTBorra;
	}
	
	/**
	 * get texto Botón Nuevo
	 * @return
	 */
	public  JButton getBTNuevo() {
		return BTNuevo;
	}
	
	/**
	 * get texto Botón primero
	 * @return
	 */
	public  JButton getBTPrimero() {
		return BTPrimero;
	}
	
	
	/**
	 * get texto Botón último
	 * @return
	 */
	public  JButton getBTUltimo() {
		return BTultimo;
	}
	
	/**
	 * get texto Botón siguiente
	 * @return
	 */
	public  JButton getBTSiguiente() {
		return BTSiguiente;
	}
	
	/**
	 * get texto Botón anterior
	 * @return
	 */
	public  JButton getBTAnterior() {
		return BTAnterior;
	}

	/**
	 * get texto Código asignatura
	 * @return
	 */
	public  JTextField getTFCAsignatura() {
		return TFCAsignatura;
	}

	/**
	 * get texto Id Profesor
	 * @return
	 */
	public  JTextField getTFIdProfesor() {
		return TFIdProfesor;
	}
	
	/**
	 * get texto Nombre Asignatura
	 * @return
	 */
	public  JTextField getTFNombreAsignatura() {
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
	public  JFrame getFrame() {
		return frame;
	}


}
