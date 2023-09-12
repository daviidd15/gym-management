package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.monitor.AccesoHorarioMonitorPanel;
import GUI.monitor.PantallaPrincipalMonitorPanel;
import gimnasio.Gimnasio;

/**
 * Controlador que lleva al monitor desde la vista del horario del monitor
 * al panel principal de monitor 
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackAccesoHorario implements ActionListener{
	private AccesoHorarioMonitorPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlBackAccesoHorario(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAccesoHorarioMonitor();
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
	 * Metodo que muestra el panel principal del monitor
	 */
	private void mostrarPanelAnterior() {
		this.frame.getVistaPantallaPrincipalMonitor().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
