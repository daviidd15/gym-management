package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorEntrenamientoLibre;
import GUI.admin.PanelCreacionSesionActividadGrupal;

/**
 * Controlador del back del panel de creacion de sesiones de entrenaiento libre
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackAdminEntrenaiento implements ActionListener{
	private AdministradorEntrenamientoLibre vista;
	private VentanaProyecto frame;
	/**
	 * Constructor del controlador
	 * @param frame del controlador
	 */
	public ControlBackAdminEntrenaiento(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminEntrenamiento();
	}
	
	/**
	 * Al pulsar el boton se muestra el panel anterior
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