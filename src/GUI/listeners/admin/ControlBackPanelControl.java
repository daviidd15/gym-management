package GUI.listeners.admin;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.PanelAdministradorMonitores;
import GUI.monitor.AccesoNominaPanel;
import gimnasio.Gimnasio;
/**
 * Controlador del back del panel de control
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackPanelControl implements ActionListener{
	private PanelAdministradorMonitores vista;
	private VentanaProyecto frame;
	/**
	 * Constructor del controlador
	 * @param frame del controlador
	 */
	public ControlBackPanelControl(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPanelControlMonitores();
	}
	/**
	 * Cuando se pulsa el boton se va al panel anterior
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelAnterior();
	}
	/**
	 * Muestra el panel anterior
	 */
	private void mostrarPanelAnterior() {
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
