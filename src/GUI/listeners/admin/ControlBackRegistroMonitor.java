package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorRegistroMonitorPanel;
import GUI.monitor.AccesoNominaPanel;
import gimnasio.Gimnasio;

/**
 * Controlador que lleva al administrador desde la vista de registro de un monitor 
 *  a la vista de control de monitores
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackRegistroMonitor implements ActionListener{
	private AdministradorRegistroMonitorPanel vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlBackRegistroMonitor(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaRegistroMonitor();
	}

	/**
	 * Cuando se pulse el boton de back el administrador vuelve al panel de control de monitores
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelAnterior();
	}
	
	/**
	 * Método que muestra el panel de control de monitores
	 */
	private void mostrarPanelAnterior() {
		this.frame.getVistaPanelControlMonitores().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
}
