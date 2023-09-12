package GUI.listeners.admin;

import java.time.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.admin.*;
import gimnasio.*;

/**
* Controlador del boton que crea la sesion actividad grupal
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlCrearSesionActividad implements ActionListener{
	private PanelCreacionSesionActividadGrupal vista;
	private VentanaProyecto frame;
	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlCrearSesionActividad(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaCrearActividadGrupalSesion();
		
	}

	/**
	* Al pulsar el boton de crear se crea la sesion de la actividad grupal
	* @param e evento
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Gimnasio.getGimnasio().getActividadGrupalByName(this.frame.getVistaCrearActividadGrupalSesion().getActividad()).crearSesionActividadGrupal(LocalDate.of(Integer.parseInt(this.frame.getVistaCrearActividadGrupalSesion().getAnioCombo()),  Month.of(Integer.parseInt(this.frame.getVistaCrearActividadGrupalSesion().getMesCombo())), Integer.parseInt(this.frame.getVistaCrearActividadGrupalSesion().getDiaCombo())), LocalTime.of((Integer.parseInt(this.frame.getVistaCrearActividadGrupalSesion().getHoraInicio())),(Integer.parseInt(this.frame.getVistaCrearActividadGrupalSesion().getMinutoInicio()))), LocalTime.of((Integer.parseInt(this.frame.getVistaCrearActividadGrupalSesion().getHoraFin())),(Integer.parseInt(this.frame.getVistaCrearActividadGrupalSesion().getMinutoFin()))),(SalaSimple)Gimnasio.getGimnasio().getSalaByName(this.frame.getVistaCrearActividadGrupalSesion().getSala())))
		{		JOptionPane.showMessageDialog(vista, "Se ha creado correctamente", "Creacion correcta", JOptionPane.INFORMATION_MESSAGE);
				mostrarPanelAnterior();
		}else{
			JOptionPane.showMessageDialog(vista, "Error al crear la sesion de la actividad grupal", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	/**
	* Metodo que muestra el panel principal
	*/
	public void mostrarPanelAnterior(){
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);
	}
	
	

}