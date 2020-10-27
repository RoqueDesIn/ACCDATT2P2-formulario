package Main;

import Controladores.Controlador;

public class MainT2P2 {
	/**

	 * Esta clase define el módulo principal de la aplicación.

	 * @author Roque Flores Naranjo
	 * 
	 * @version 27/10/2020-1.0

	 * @see <a href = "https://www.linkedin.com/in/roque-flores-naranjo/" /> Mi LinkEdin :) </a>

	 */
	// estados
	
	//comportamientos
	public MainT2P2() {

	}

	/**
	 * inicia la aplicación, ejecuta el controlador
	 * @param args
	 */
	public static void main(String[] args) {
		Controlador.conectar();
	}

}
