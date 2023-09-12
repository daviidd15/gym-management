package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import GUI.LoginPanel;
import GUI.VentanaProyecto;
import GUI.cliente.ReservasPanel;
import actividades.ActividadGrupal;
import gimnasio.Gimnasio;
import tarifas.Tarifa;
/**
* Controlador que te lleva al penlpanel de reserva
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlReservaGrupal implements ActionListener {
	private ReservasPanel vista;
	private VentanaProyecto frame;
	
	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlReservaGrupal(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaActividades();
	}

	/**
	* Al pulsar el boton se muestra el panel de las reservas
	* @param e evento
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		mostrarPanelActividadGrupal();
	}
	
	private void mostrarPanelActividadGrupal() {
		this.frame.getVistaActividadGrupal().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
}
