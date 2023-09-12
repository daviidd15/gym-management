package GUI.listeners.monitor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTable;

import GUI.VentanaProyecto;
import GUI.monitor.CrearPlanPersonalizadoPanel;
import GUI.monitor.PantallaPrincipalMonitorPanel;
import gimnasio.Gimnasio;
import usuarios.Monitor;

/**
 * Controlador que lleva al monitor desde crear un plan personalizado
 * a la vista principal del monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackCrearPlan implements ActionListener{
	
	private CrearPlanPersonalizadoPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlBackCrearPlan(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaCrearPlanPersonalizado();
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
	}
}
