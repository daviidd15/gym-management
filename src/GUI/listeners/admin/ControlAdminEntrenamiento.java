package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorPrincipalPanel;
import gimnasio.Gimnasio;
/**
 * Controlador que te lleva al panel del entrenamiento libre
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlAdminEntrenamiento implements ActionListener{
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;
	/**
	 * Constructor del controlador
	 * @param frame del controlador
	 */
	public ControlAdminEntrenamiento(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
		
	}

	/**
	 * Método que actuaiza el panel de creacion de sesion de un entrenamiento libre cuando se pulsa el boton que te lleva a ese panel
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.getVistaAdminEntrenamiento().setSalas(Gimnasio.getGimnasio().getSalasSimples()); 
		mostrarPanelCreacionLibreSesion();
	}
	/**
	 * Método que te muestra el panel de la creacion de una sesion de un entrenamiento libre
	 */
	private void mostrarPanelCreacionLibreSesion() {
		this.frame.getVistaAdminEntrenamiento().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
}
