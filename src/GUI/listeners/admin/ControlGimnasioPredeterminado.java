package GUI.listeners.admin;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.*;
import gimnasio.Gimnasio;

/**
* Controlador del boton que lleva desde la vista principal del administrador
* a la vista que establecelos valores predeterminador del gimnasio
* 
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlGimnasioPredeterminado implements ActionListener{
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;
	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlGimnasioPredeterminado(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
		
	}

	/**
	* Al pulsar el boton se muestra el panel de los valores predeterminados a establecer
	* @param e evento
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarValoresPredeterminados();
	}
	
	/**
	*Método que muestra el panel de los valores predetermindos
	*/
	private void mostrarValoresPredeterminados() {
		this.frame.getVistaGimnasioPredeterminado().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}