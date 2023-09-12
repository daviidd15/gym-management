package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.SalasPanel;
import GUI.cliente.EntrenamientoLibrePanel;

/**
 * Controlador que lleva al administrador desde la vista de crear salas a 
 *  a la pantalla principal del administrador
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackSalas implements ActionListener{
	private SalasPanel vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlBackSalas(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaSalas();
	}

	/**
	 * Cuando se pulse el boton de back el administrador vuelve al panel principal
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
