package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.cliente.EntrenamientoLibrePanel;
import GUI.cliente.NotificacionesPanel;

/**
* Controlador del volver de las notificaciones
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlBackNotificaciones  implements ActionListener{
	private NotificacionesPanel vista;
	private VentanaProyecto frame;
	
	/**
	* Constructor del panel de notificaciones
	* @param frame del controlador
	*/
	public ControlBackNotificaciones(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaNotificacionesCliente();
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
	* Muestra el panel anterior
	*/
	private void mostrarPanelAnterior() {
		this.frame.getVistaActividades().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
