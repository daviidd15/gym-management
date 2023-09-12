package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.*;
import GUI.admin.AdministradorRegistroMonitorPanel;
import gimnasio.Gimnasio;

/**
 * Controlador que registra a un monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlMonitorRegistrado implements ActionListener {
	private AdministradorRegistroMonitorPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlMonitorRegistrado(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaRegistroMonitor();
	}
	
	/**
	 * Cuando se pulse el boton registrar, se llama al método de gimnasio que registra a un monitor
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(Gimnasio.getGimnasio().registraMonitor(vista.getUsuario(), vista.getContrasenia(), vista.getCorreo(), vista.getNombre(), vista.getDNI())!=null){
			if(Gimnasio.getGimnasio().login(vista.getUsuario(), vista.getContrasenia())){
				JOptionPane.showMessageDialog(vista, "Se ha registrado y logueado correctamente al monitor. ", "Registro Finalizado", JOptionPane.INFORMATION_MESSAGE);
				mostrarPanelMonitores();
			}
			}
		else
			JOptionPane.showMessageDialog(vista, "Error en el registro. ", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Método que muestra el panel principal del administrador
	 */
	private void mostrarPanelMonitores() {
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	



}
