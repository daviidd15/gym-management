package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import GUI.VentanaProyecto;
import GUI.cliente.ReservasPanel;
import gimnasio.Gimnasio;
/**
* Controlador de la reserva del entrenamiento libre
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlReservaEntrenamientoLibre implements ActionListener {
	private ReservasPanel vista;
	private VentanaProyecto frame;
	
	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlReservaEntrenamientoLibre(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaActividades();
	}

	/**
	* Al pulsar el boton se muestra el panel del entrenamiento libre
	* @param e evento
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelEntrenamientoLibre();
	}
	
	/**
	* Muestra el panel del entrenamiento libre
	*/
	private void mostrarPanelEntrenamientoLibre() {
		this.frame.getVistaEntrenamientoLibre().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
}

