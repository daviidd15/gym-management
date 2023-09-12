package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.*;
import gimnasio.Gimnasio;


/**
 * Controlador que lleva al administrador desde la vista principal 
 *  a la vista de cambiar el precio de una tarifa
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlCambiarPrecioTarifa implements ActionListener{
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlCambiarPrecioTarifa(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
	}

	/**
	 * Cuando se pulse el boton de cambiar precio de tarifas, se muestra dicho panel
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelCambioTarifas();
	}
	
	/**
	 * Método que muestra el panel de cambio de precio de tarifas
	 */
	private void mostrarPanelCambioTarifas() {
		this.frame.getVistaCambiarPrecioTarifa().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
