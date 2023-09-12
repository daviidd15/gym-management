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
 * Controlador que muestra un mensaje de OK si se ha leido correctamente el backup
 * o un mensaje de error en caso contrario
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackup implements ActionListener {
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;

	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlBackup(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
	}

	/**
	 * Cuando se pulse el boton de leer el backup, se leera la ultima copia de seguridad del dia de hoy
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		File directory = new File("./copias/copia_" + LocalDate.now());
		File file = new File(directory, "copia_" + LocalDate.now() + ".txt");
		try {
			Gimnasio.getGimnasio().lecturaGimnasio(file);
		} catch (IOException ios) {
			JOptionPane.showMessageDialog(vista, "Error al leer la copia de seguridad", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
			JOptionPane.showMessageDialog(vista, "Se ha leido correctamente el backup", "Correcto",
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
