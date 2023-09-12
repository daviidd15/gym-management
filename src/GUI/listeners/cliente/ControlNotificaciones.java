package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;

import GUI.VentanaProyecto;
import GUI.cliente.ReservasPanel;
import gimnasio.Gimnasio;
import gimnasio.Notificacion;
import gimnasio.Sala;
import usuarios.Monitor;

	/**
	 * Clase Constructor del controlador
	 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
	 */
public class ControlNotificaciones implements ActionListener {
	private ReservasPanel vista;
	private VentanaProyecto frame;

	public ControlNotificaciones(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaActividades();
	}

	/**
	 * Realiza la accion del controlador
	 * @param e del evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		List<Notificacion> notificaciones = Gimnasio.getGimnasio().getUsuarioActualOperando().getNotificaciones();
	
		String[] str = new String[notificaciones.size()];
		
		for (int i = 0; i < notificaciones.size(); i++) {
			str[i] = notificaciones.get(i).getContenido();
		}
		
		
		this.frame.getVistaNotificacionesCliente().setNotificaciones(str);

		mostrarPanelNotificaciones();
	}
	/**
	 * muestra el panel de notificaciones
	 */
	private void mostrarPanelNotificaciones() {
		this.frame.getVistaNotificacionesCliente().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
}
