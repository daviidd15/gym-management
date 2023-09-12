package GUI.listeners.admin;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.GimnasioValoresPredeterminados;
import GUI.admin.PanelCreacionActividadGrupal;
import GUI.admin.PanelCreacionSesionActividadGrupal;
/**
 * Controlador del back del panel de creacion de sesiones de actividades grupales
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackCrearSesionActividades implements ActionListener{
	private PanelCreacionSesionActividadGrupal vista;
	private VentanaProyecto frame;
	/**
	 * Constructor del controlador
	 * @param frame del controlador
	 */
	public ControlBackCrearSesionActividades(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaCrearActividadGrupalSesion();
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
