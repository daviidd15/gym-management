package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import GUI.VentanaProyecto;
import GUI.monitor.PantallaPrincipalMonitorPanel;
import gimnasio.Gimnasio;

/**
 * Controlador que realiza el logout del monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlLogoutMonitor implements ActionListener{
	private PantallaPrincipalMonitorPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlLogoutMonitor(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPantallaPrincipalMonitor();
	}
	
	/**
	 * Metodo que realiza el logout del monitor en el gimnasio
	 * 
	 * @param e evento
	 */
	public void actionPerformed(ActionEvent e) {
			if(Gimnasio.getGimnasio().getUsuarioActualOperando().logout())
				mostrarPanelLogin();
			else
				JOptionPane.showMessageDialog(vista, "Error al hacer Logout", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	
	/**
	 * Metodo que muestra el panel del login
	 */
	private void mostrarPanelLogin() {
		this.frame.getVistaLogin().setVisible(true);
		this.vista.setVisible(false);		
		
	}
	
	
	
}