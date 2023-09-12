package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.monitor.CrearPlanPersonalizadoPanel;
import GUI.monitor.PantallaPrincipalMonitorPanel;
import actividades.Objetivo;
import gimnasio.Gimnasio;
import usuarios.Monitor;

/**
 * Controlador que crea un plan personalizado por un monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlCrearPlanPersonalizadoBoton implements ActionListener{
	private CrearPlanPersonalizadoPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlCrearPlanPersonalizadoBoton(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaCrearPlanPersonalizado();
	}

	/**
	 * Metodo que crea un tipo de plan personalizado cuando el monitor pulsa el boton de crear
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (Gimnasio.getGimnasio().crearTipoPlanPersonalizado(vista.getNombre(), vista.getDescripcion(), vista.getObjetivo(), 
																(Monitor)Gimnasio.getGimnasio().getUsuarioActualOperando(), vista.getSesionesRequeridasMin(), vista.getSesionesRequeridasMax(), vista.getEdadMinima(), vista.getEdadMaxima(), vista.getAntiguedadMinCampo(), vista.getAntiguedadMaxCampo()) == false){
			JOptionPane.showMessageDialog(vista, "Error al crear el plan personalizado", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			JOptionPane.showMessageDialog(vista, "Se ha creado correctamente el plan personalizado", "Correcto",
					JOptionPane.INFORMATION_MESSAGE);
			mostrarPanelPrincipal();
		}
		
	}
	
	/**
	 * Metodo que muestra el panel principal del monitor
	 */
	private void mostrarPanelPrincipal() {
		this.frame.getVistaPantallaPrincipalMonitor().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();S
	}
}
