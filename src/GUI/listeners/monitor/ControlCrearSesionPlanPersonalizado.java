package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


import GUI.VentanaProyecto;
import GUI.monitor.PantallaPrincipalMonitorPanel;
import gimnasio.Gimnasio;
import usuarios.Monitor;
/**
* Controlador que te lleva a la creacion de sesiones personalizadas
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*
*/
public class ControlCrearSesionPlanPersonalizado implements ActionListener{
	private PantallaPrincipalMonitorPanel vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlCrearSesionPlanPersonalizado(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPantallaPrincipalMonitor();
	}

	/**
	 * Metodo que muestra la vista de crear un plan personalizado
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.getVistaCrearSesionPlan().setSalas(Gimnasio.getGimnasio().getSalasSimples());
		this.frame.getVistaCrearSesionPlan().setPlanes(Gimnasio.getGimnasio().getPlanesByMonitor(((Monitor)Gimnasio.getGimnasio().getUsuarioActualOperando())));
		mostrarPanelCrearSesionPlanPersonalizado();
	}
	
	/**
	 * Metodo que muestra la vista de crear un plan personalizado
	 */
	private void mostrarPanelCrearSesionPlanPersonalizado() {
		this.frame.getVistaCrearSesionPlan().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();S
	}
}
