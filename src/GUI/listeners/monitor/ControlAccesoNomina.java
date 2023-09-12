package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.monitor.*;
import gimnasio.Gimnasio;

/**
 * Controlador que lleva al monitor a la vista para la descarga de la nomina
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlAccesoNomina implements ActionListener{
	private PantallaPrincipalMonitorPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlAccesoNomina(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPantallaPrincipalMonitor();
	}

	/**
	 * Cuando se pulse el boton de ver nomina, se dirige al panel de descargar la nomina
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelNomina();
	}
	
	/**
	 * Método que muestra la vista de acceso a la nomina del monitor
	 */
	private void mostrarPanelNomina() {
		this.frame.getVistaAccesoPanel().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
