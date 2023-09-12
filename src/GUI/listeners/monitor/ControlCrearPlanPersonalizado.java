package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


import GUI.VentanaProyecto;
import GUI.monitor.PantallaPrincipalMonitorPanel;
import gimnasio.Gimnasio;

/**
 * Controlador que muestra la vista de crear un plan personalizado por un monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlCrearPlanPersonalizado implements ActionListener{
	
	private PantallaPrincipalMonitorPanel vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlCrearPlanPersonalizado(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPantallaPrincipalMonitor();
	}

	/**
	 * Metodo que muestra la vista de crear un plan personalizado
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelCrearPlanPersonalizado();
	}
	
	/**
	 * Metodo que muestra la vista de crear un plan personalizado
	 */
	private void mostrarPanelCrearPlanPersonalizado() {
		this.frame.getVistaCrearPlanPersonalizado().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();S
	}
}
