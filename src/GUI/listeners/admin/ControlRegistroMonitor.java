package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.*;
import GUI.admin.PanelAdministradorMonitores;
import gimnasio.Gimnasio;

/**
 * Controlador que lleva al administrador desde la vista de control de monitores
 *  a la vista de registro de un monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlRegistroMonitor implements ActionListener{
	private PanelAdministradorMonitores vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlRegistroMonitor(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPanelControlMonitores();
	}

	
	/**
	 * Cuando se pulse el boton registrar un monitor
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		mostrarPanelRegistroMonitor();
	}
	
	/**
	 * Método para mostrar la vista de registro de un monitor
	 */
	private void mostrarPanelRegistroMonitor() {
		this.frame.getVistaRegistroMonitor().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
