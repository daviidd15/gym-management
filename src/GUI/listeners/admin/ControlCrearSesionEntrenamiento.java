package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorEntrenamientoLibre;
import gimnasio.Gimnasio;
import gimnasio.SalaSimple;

/**
* Controlador del boton que crea la sesion entrenamiento libre
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlCrearSesionEntrenamiento implements ActionListener{
	private AdministradorEntrenamientoLibre vista;
	private VentanaProyecto frame;
	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlCrearSesionEntrenamiento(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminEntrenamiento();
		
	}

	/**
	* Al pulsar el boton de crear se crea la sesion de la actividad grupal
	* @param e evento
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Gimnasio.getGimnasio().crearSesionActividadLibre( LocalDate.of(Integer.parseInt(this.frame.getVistaAdminEntrenamiento().getAnioCombo()),  Month.of(Integer.parseInt(this.frame.getVistaAdminEntrenamiento().getMesCombo())), Integer.parseInt(this.frame.getVistaAdminEntrenamiento().getDiaCombo())), LocalTime.of((Integer.parseInt(this.frame.getVistaAdminEntrenamiento().getHoraInicio())),(Integer.parseInt(this.frame.getVistaAdminEntrenamiento().getMinutoInicio()))), LocalTime.of((Integer.parseInt(this.frame.getVistaAdminEntrenamiento().getHoraFin())),(Integer.parseInt(this.frame.getVistaAdminEntrenamiento().getMinutoFin()))),(SalaSimple)Gimnasio.getGimnasio().getSalaByName(this.frame.getVistaAdminEntrenamiento().getSala())))
		{		JOptionPane.showMessageDialog(vista, "Se ha creado correctamente", "Creacion correcta", JOptionPane.INFORMATION_MESSAGE);
				mostrarPanelAnterior();
		}else{
			JOptionPane.showMessageDialog(vista, "Error al crear la sesion de entrenamiento libre", "Error", JOptionPane.ERROR_MESSAGE);
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
