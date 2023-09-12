package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorPrincipalPanel;
import GUI.admin.PanelAdministradorMonitores;
import GUI.admin.PlanesPorMonitorPanel;
import GUI.monitor.AccesoNominaPanel;
import gimnasio.Gimnasio;

/**
 * Controlador del back de planes por monitor
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackPlanesPorMonitor  implements ActionListener{

	private PlanesPorMonitorPanel vista;
	private Gimnasio modelo;
	private VentanaProyecto frame;
	/**
	 * Constructor del copntrolador
	 * @param frame del controlador
	 */
	public ControlBackPlanesPorMonitor(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPlanesPorMonitor();
	}
	
	/**
	 * Al pulsar el boton se va al panel anterior
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelAnterior();
	}
	
	/**
	 * Se muestra el panel anterior
	 */
	private void mostrarPanelAnterior() {
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}

