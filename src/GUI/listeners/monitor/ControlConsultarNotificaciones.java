package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import GUI.VentanaProyecto;
import gimnasio.Gimnasio;
import gimnasio.Notificacion;
import gimnasio.Sala;
import usuarios.Monitor;
import GUI.monitor.ConsultarNotificacionesPanel;
import GUI.monitor.PantallaPrincipalMonitorPanel;

/**
 * Controlador que muestra la vista de las notificaciones de un monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlConsultarNotificaciones implements ActionListener{
	private PantallaPrincipalMonitorPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlConsultarNotificaciones(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPantallaPrincipalMonitor();
	}

	/**
	 * Metodo que actualiza la lista de notificaciones del monitor y muestra la pantalla de estas
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		List<Notificacion> notificaciones = Gimnasio.getGimnasio().getUsuarioActualOperando().getNotificaciones();
	
		String[] str = new String[notificaciones.size()];
		
		for (int i = 0; i < notificaciones.size(); i++) {
			str[i] = notificaciones.get(i).getContenido();
		}
		
		
		this.frame.getVistaConsultarNotificaciones().setConsultarNotificacionesPanel(str);

		mostrarPanelNotificaciones();
	}
	
	/**
	 * Metodo que muestra el panel de notificaciones del cliente
	 */
	private void mostrarPanelNotificaciones() {
		this.frame.getVistaConsultarNotificaciones().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
}
