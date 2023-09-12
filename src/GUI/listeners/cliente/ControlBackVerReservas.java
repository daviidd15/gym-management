package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.cliente.ReservasPanel;
import GUI.cliente.VerReservasPanel;
/**
* Controlador el back de las reservas
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlBackVerReservas implements ActionListener{
	private VerReservasPanel vista;
	private VentanaProyecto frame;

	public ControlBackVerReservas(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaVerReservas();
	}
	
	/**
	* Al pulsar el boton se muesttra el panel anterior
	* @param e evento
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelAnterior();
	}
	
	/**
	* Metodo que muestra el panel anterior
	*/
	private void mostrarPanelAnterior() {
		this.frame.getVistaActividades().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
