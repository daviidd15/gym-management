package GUI.listeners.admin;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.*;
import gimnasio.Gimnasio;
/**
 * Controlador que lleva a la creacion de actividades
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlActividades implements ActionListener{
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;
	/**
	 * Constructor del controlador
	 * @param frame frame del controlador
	 */
	public ControlActividades(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
		
	}

	/**
	 * Cuando se pulse el boton se actuliza la lista de los monitores del panel y se va a las actividades
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.getVistaCrearActividadGrupal().setMonitores(Gimnasio.getGimnasio().getMonitores());
		mostrarPanelCreacionActividades();
	}
	/**
	 * Método que muestra el panel de las actividades
	 */
	private void mostrarPanelCreacionActividades() {
		this.frame.getVistaCrearActividadGrupal().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}