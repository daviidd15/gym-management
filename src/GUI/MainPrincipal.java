package GUI;

import java.awt.EventQueue;

import GUI.listeners.*;
import gimnasio.Gimnasio;

/**
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class MainPrincipal {
	
	/**
	 * 
	 * @param args argumentos del main 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {						
					VentanaProyecto frame = new VentanaProyecto();
					Controlador controlador = new Controlador(frame);
					frame.setControlador(controlador);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
