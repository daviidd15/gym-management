package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorPrincipalPanel;
import gimnasio.Gimnasio;
import java.io.*;
import java.time.*;

/**
 * Controlador que realiza un backup
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackupGuardar implements ActionListener {
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlBackupGuardar(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
	}
	
	/**
	 * Cuando se pulse el boton de guardar backup, se realizara una copia de seguridad
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Gimnasio.getGimnasio().escrituraGimnasio();

		} catch (IOException exc) {
			JOptionPane.showMessageDialog(vista, "Error en la salida de escrituraGimnasio", "Error",
					JOptionPane.ERROR_MESSAGE);
					return;
		} 
			JOptionPane.showMessageDialog(vista, "Se ha guardaro correctamente el backup", "Correcto",
					JOptionPane.INFORMATION_MESSAGE);
			mostrarTrasBackup();
		
	}

	/**
	 * Método que muestra el panel principal del administrador
	 */
	private void mostrarTrasBackup() {
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);
		// this.frame.getVistaRegistro().update();
	}
}