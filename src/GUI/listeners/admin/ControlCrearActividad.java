package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.admin.*;
import gimnasio.Gimnasio;

/**
 * Controlador que crea una actividad grupal
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlCrearActividad implements ActionListener{
	private PanelCreacionActividadGrupal vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlCrearActividad(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaCrearActividadGrupal();
		
	}

	/**
	 * Cuando se pulse el boton de crear, se llama al metodo de gimnasio que crea un tipo de actividad grupal
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(Gimnasio.getGimnasio().crearTipoActividadGrupal(this.frame.getVistaCrearActividadGrupal().getNombreActividad(), Integer.parseInt(this.frame.getVistaCrearActividadGrupal().getPrecio()), Gimnasio.getGimnasio().getMonitorByName(this.frame.getVistaCrearActividadGrupal().getMonitor()) , Integer.parseInt(this.frame.getVistaCrearActividadGrupal().getEdadMinima()),  Integer.parseInt(this.frame.getVistaCrearActividadGrupal().getEdadMaxima()),  Integer.parseInt(this.frame.getVistaCrearActividadGrupal().getSesionesRequeridasMin()),  Integer.parseInt(this.frame.getVistaCrearActividadGrupal().getSesionesRequeridasMax() ),Integer.parseInt(this.frame.getVistaCrearActividadGrupal().getAntiguedadMin()), Integer.parseInt(this.frame.getVistaCrearActividadGrupal().getAntiguedadMax()))){
			JOptionPane.showMessageDialog(vista, "Se ha creado correctamente", "Creacion correcta", JOptionPane.INFORMATION_MESSAGE);
			mostrarPanelAnterior();
		}else{
			JOptionPane.showMessageDialog(vista, "Error al crear el tipo de actividad grupal", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método que muestra el panel principal del administrador
	 */
	private void mostrarPanelAnterior() {
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);
		// this.frame.getVistaRegistro().update();
	}

}
