package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorPrincipalPanel;
import gimnasio.Gimnasio;
import usuarios.*;
import actividades.*;

/**
 * Controlador que lleva al administrador desde la vista principal del admin
 * a la vista de control de monitores
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlPanelControlMonitor implements ActionListener{
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlPanelControlMonitor(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
	}

	/**
	 * Cuando se pulse el boton de monitores, se dirige a la vista de panel de control de estos
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelControlMonitores();

	}
	
	/**
	 * Método que muestra el panel de control de los monitores
	 */
	private void mostrarPanelControlMonitores() {
		this.frame.getVistaPanelControlMonitores().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
