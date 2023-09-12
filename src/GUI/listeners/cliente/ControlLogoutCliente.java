package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import GUI.VentanaProyecto;
import GUI.cliente.ReservasPanel;
import gimnasio.Gimnasio;
import GUI.LoginPanel;

/**
 * Clase del controlador para el logout del cliente
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 */
public class ControlLogoutCliente implements ActionListener{
	private ReservasPanel vista;
	private VentanaProyecto frame;
	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlLogoutCliente(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaActividades();
	}
	
	/**
	 * Realiza la acciones del controlador
	 * @param e evento
	 */
	public void actionPerformed(ActionEvent e) {
			if(Gimnasio.getGimnasio().getUsuarioActualOperando().logout())
			mostrarPanelLogin();
		}
	
	/**
	* Muestra el panel del login
	*/
	private void mostrarPanelLogin() {
		this.frame.getVistaLogin().setVisible(true);
		this.vista.setVisible(false);		
		
	}
	
	
	
}