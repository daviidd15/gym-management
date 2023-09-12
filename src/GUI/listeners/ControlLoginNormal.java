package GUI.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.LoginPanel;
import GUI.VentanaProyecto;
import gimnasio.Gimnasio;
import usuarios.*;

/**
 * Controlador que lleva al usuario a su vista correspondiente, dependiendo
 * de si es un cliente, un monitor o el administrador
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlLoginNormal implements ActionListener {
	private LoginPanel vista;
	VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlLoginNormal(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaLogin();
	}

	/**
	 * Cuando se pulse el boton de login se inicia sesion del usuario
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String nombreUsuario = vista.getNombreUsuario();
		char[] contrasenia = vista.getContrasenia();

		if (Gimnasio.getGimnasio().login(nombreUsuario, String.valueOf(contrasenia)) == false) {
			JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos. ", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (Gimnasio.getGimnasio().getUsuarioByUser(nombreUsuario).isAdministrador()) {
			mostrarAdministradorPrincipal();
		} else if (Gimnasio.getGimnasio().getUsuarioByUser(nombreUsuario).isMonitor()) {
			mostrarMonitorPrincipal();
		} else if (Gimnasio.getGimnasio().getUsuarioByUser(nombreUsuario).isCliente()) {
			String finPenalizacion;
			Cliente cliente = (Cliente) Gimnasio.getGimnasio().getUsuarioByUser(nombreUsuario);
			String numCancelaciones = String.valueOf(cliente.getNumCancelacion());
			if (cliente.getFechaFinCancelaciones() == null) {
				finPenalizacion = "00/00/0000";
			} else {
				finPenalizacion = cliente.getFechaFinCancelaciones().toString();
			}
			this.frame.getVistaActividades().setFinPenalizacion(finPenalizacion);
			this.frame.getVistaActividades().setNumCancelaciones(numCancelaciones);
			mostrarPanelActividades();
		}

	}

	/**
	 * Metodo que muestra la pantalla principal del cliente
	 */ 
	private void mostrarPanelActividades() {
		this.frame.getVistaActividades().setVisible(true);
		this.vista.setVisible(false);
		// this.frame.getVistaRegistro().update();
	}
	
	
	private void mostrarAdministradorPrincipal() {
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);
		// this.frame.getVistaRegistro().update();
	}

	public void mostrarMonitorPrincipal() {
		this.frame.getVistaPantallaPrincipalMonitor().setVisible(true);
		this.vista.setVisible(false);
		// this.frame.getVistaRegistro().update();
	}

}
