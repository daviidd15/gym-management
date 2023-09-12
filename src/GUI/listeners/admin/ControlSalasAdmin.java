package GUI.listeners.admin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorPrincipalPanel;
import GUI.monitor.PantallaPrincipalMonitorPanel;
import gimnasio.Gimnasio;
import gimnasio.Sala;
import usuarios.Monitor;

/**
 * Controlador que lleva al administrador desde la vista principal del administrador
 *  a la pantalla principal del administrador
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlSalasAdmin implements ActionListener {
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlSalasAdmin(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
	}
	
	/**
	 * Cuando se pulse el boton de crear salas se actualiza la lsita de salas compuestas
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		List<Sala> s = Gimnasio.getGimnasio().getSalasComp();
		String[] str = new String[s.size()];
		for (int i = 0; i < s.size(); i++) {
			str[i] = s.get(i).getNombre();
		}
		this.frame.getVistaSalas().setSalasCompuestas(str);
		mostrarPanelSalas();
	}

	/**
	 * Método que muestra el panel de creacion de salas
	 */
	private void mostrarPanelSalas() {
		this.frame.getVistaSalas().setVisible(true);
		this.vista.setVisible(false);
	}

}
