package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.cliente.ActividadGrupalPanel;
import GUI.cliente.RegistroPanel;
/**
* Controlador del volver del registro del cliente
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlBackRegistro implements ActionListener{
	private RegistroPanel vista;
	private VentanaProyecto frame;

	public ControlBackRegistro(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaRegistro();
	}

	/**
	* Al pulsar el boton muiestra el panel anterior
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
		this.frame.getVistaLogin().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
