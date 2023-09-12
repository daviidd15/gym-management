package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.monitor.CancelarClaseMonitorPanel;
import GUI.monitor.CrearPlanPersonalizadoPanel;

/**
 * Controlador que lleva al monitor desde la vista de cancelar de monitor
 * al panel principal de monitor 
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackCancelarClase implements ActionListener{
	private CancelarClaseMonitorPanel vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlBackCancelarClase(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaCancelarClase();
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
	}
}
