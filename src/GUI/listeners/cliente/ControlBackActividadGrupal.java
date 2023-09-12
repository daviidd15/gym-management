package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.cliente.ActividadGrupalPanel;
import GUI.cliente.EntrenamientoLibrePanel;


	/**
	 * Clase del control del back en actividad grupal
	 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
	 */
public class ControlBackActividadGrupal  implements ActionListener{
	private ActividadGrupalPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * @param frame del controlador
	 */
	public ControlBackActividadGrupal(VentanaProyecto frame) {
		this.frame = frame;	
		this.vista = this.frame.getVistaActividadGrupal();
	}

	/**
	 * Metodo que se muestra el panel anterior
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
