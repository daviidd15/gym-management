package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.OcupacionSalasPanel;
import GUI.admin.PanelAdministradorMonitores;
import gimnasio.Gimnasio;
/**
 * Controlador del back de la ocupacion
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBackOcupacion implements ActionListener{
	private OcupacionSalasPanel vista;
	private VentanaProyecto frame;
	/**
	 * Constructor del controlador
	 * @param frame del controlador
	 */
	public ControlBackOcupacion(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaOcupacionSalas();
	}
	
	/**
	 * Cuando se pulsa el boton te lleva al panel anterior
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelAnterior();
	}
	/**
	 * Método que te meustra el panel anterior
	 */
	private void mostrarPanelAnterior() {
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}

