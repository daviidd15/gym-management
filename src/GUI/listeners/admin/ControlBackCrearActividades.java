package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.GimnasioValoresPredeterminados;
import GUI.admin.PanelCreacionActividadGrupal;
/**
 * Control del back del panel de crear actividades
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackCrearActividades implements ActionListener{
	private PanelCreacionActividadGrupal vista;
	private VentanaProyecto frame;
	/**
	 * Constructor del controlador
	 * @param frame del controlador
	 */
	public ControlBackCrearActividades(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaCrearActividadGrupal();
	}
	
	/**
	 * Al pulsar el boton te lleva al anterior panel
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelAnterior();
	}
	
	/**
	 * Se muestra el anterior panel
	 */
	private void mostrarPanelAnterior() {
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
