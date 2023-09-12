package GUI.listeners.monitor;

import java.time.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.monitor.*;
import gimnasio.*;

/**
 * Controlador que crea una sesion de un plan personalizado
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBotonCrearSesionPlan implements ActionListener{
	private CrearSesionPlanPersonalizadoPanel vista;
	private VentanaProyecto frame;
	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlBotonCrearSesionPlan(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaCrearSesionPlan();
		
	}

	/**
	* Al pulsar el boton de crear se crea la sesion del plan personalizado
	* 
	* @param e evento
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(Gimnasio.getGimnasio().getPlanPersonalizadoByName(this.frame.getVistaCrearSesionPlan().getPlan()).crearSesionPersonalizada(LocalDate.of(Integer.parseInt(this.frame.getVistaCrearSesionPlan().getAnioCombo()),  Month.of(Integer.parseInt(this.frame.getVistaCrearSesionPlan().getMesCombo())), Integer.parseInt(this.frame.getVistaCrearSesionPlan().getDiaCombo())), LocalTime.of((Integer.parseInt(this.frame.getVistaCrearSesionPlan().getHoraInicio())),(Integer.parseInt(this.frame.getVistaCrearSesionPlan().getMinutoInicio()))), LocalTime.of((Integer.parseInt(this.frame.getVistaCrearSesionPlan().getHoraFin())),(Integer.parseInt(this.frame.getVistaCrearSesionPlan().getMinutoFin()))), (SalaSimple)Gimnasio.getGimnasio().getSalaByName(this.frame.getVistaCrearSesionPlan().getSala()), Gimnasio.getGimnasio().getPlanPersonalizadoByName(this.frame.getVistaCrearSesionPlan().getPlan())))
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
		this.frame.getVistaPantallaPrincipalMonitor().setVisible(true);
		this.vista.setVisible(false);
	}

}
