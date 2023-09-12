package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.cliente.EntrenamientoLibrePanel;
import GUI.monitor.ConsultarNotificacionesPanel;

/**
 * Controlador que lleva al monitor desde la vista consultar notificaciones del monitor
 * al panel principal de monitor 
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackConsultarNotificaciones implements ActionListener{
	private ConsultarNotificacionesPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlBackConsultarNotificaciones(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaConsultarNotificaciones();
	}

	/**
	 * Cuando se pulse el boton de back, vuelve al panel principal del monitor
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelAnterior();
	}
	
	/**
	 * Metodo que muestra la pantalla principal del monitor 
	 */
	private void mostrarPanelAnterior() {
		this.frame.getVistaPantallaPrincipalMonitor().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
