package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.cliente.EntrenamientoLibrePanel;
import GUI.monitor.PantallaPrincipalMonitorPanel;
import gimnasio.Gimnasio;
/**
* Metodo del volver del panel de entrenamiento libre
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlBackEntrenamientoLibre implements ActionListener{
	private EntrenamientoLibrePanel vista;
	private VentanaProyecto frame;

	/**
	* Constructor del controlador
	* @param frame del proyecto
	*/
	public ControlBackEntrenamientoLibre(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaEntrenamientoLibre();
	}

	/**
	* Al pulsar el boton de vuelve al panel anterior
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
