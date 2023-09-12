package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.monitor.AccesoNominaPanel;
import gimnasio.Gimnasio;
import usuarios.Monitor;

/**
* Controlador del descarga de la nomina
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlDescargaNomina implements ActionListener {
	private AccesoNominaPanel vista;
	private VentanaProyecto frame;
	
	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlDescargaNomina(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAccesoPanel();
	}
	
	/**
	* Al pulsar el boton se descarga la nomina
	* @param e evento 
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Monitor m = (Monitor) Gimnasio.getGimnasio().getUsuarioActualOperando();
		m.accesoNomina();

		JOptionPane.showMessageDialog(vista, "Se ha descargado correctamente", "Correcto",
					JOptionPane.INFORMATION_MESSAGE);
		mostrarPanelPrincipal();
	}
	
	/**
	* Muestra el panel principal del monitor
	*/
	public void mostrarPanelPrincipal() {
		this.frame.getVistaPantallaPrincipalMonitor().setVisible(true);
		this.vista.setVisible(false);
	}

}