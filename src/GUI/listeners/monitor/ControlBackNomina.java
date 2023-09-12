package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorPrincipalPanel;
import GUI.monitor.AccesoNominaPanel;
import gimnasio.Gimnasio;

/**
 * Controlador que lleva al monitor desde el panel de descargarse la nomina
 * al panel de la pantalla principal
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackNomina implements ActionListener {
	private AccesoNominaPanel vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlBackNomina(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAccesoPanel();
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
