package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.PanelAdministradorMonitores;
import GUI.admin.VerBeneficiosPanel;


/**
 * Controlador que lleva al administrador desde la vista de ver los beneficios del gimnasio 
 *  a la pantalla principal del administrador
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackVerBeneficios implements ActionListener{
	private VerBeneficiosPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlBackVerBeneficios(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaBeneficios();
	}
	
	/**
	 * Cuando se pulse el boton de back el administrador vuelve al panel principal
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelAnterior();
	}
	
	/**
	 * Método que muestra el panel principal del administrador
	 */
	private void mostrarPanelAnterior() {
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
}
