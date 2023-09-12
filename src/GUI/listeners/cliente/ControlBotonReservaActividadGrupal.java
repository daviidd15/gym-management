package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;


import GUI.LoginPanel;
import GUI.VentanaProyecto;
import GUI.cliente.*;
import actividades.ActividadGrupal;
import actividades.ActividadMonitorizada;
import excepciones.ClientePenalizado;
import excepciones.NoCumpleRequisito;
import excepciones.NoExisteSesion;
import gimnasio.Gimnasio;
import gimnasio.SalaSimple;
import usuarios.*;
import actividades.*;

/**
* Controlador del boton de reservar una sesion
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlBotonReservaActividadGrupal implements ActionListener {
	private ActividadGrupalPanel vista;
	private VentanaProyecto frame;
	
	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlBotonReservaActividadGrupal(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaActividadGrupal();
	}

	/**
	* Al pulsar el boton se reserva la sesion
	* @param e evento
	*/
	@Override
	public void actionPerformed(ActionEvent e) {	
		Cliente cliente = (Cliente)Gimnasio.getGimnasio().getUsuarioActualOperando();
		
		ActividadGrupal actividadGrupal = vista.getTipoActividadGrupal();
		
		
		for (Sesion s: actividadGrupal.getSesiones()) {
			if (actividadGrupal.existeSesion(s.getSala(), s.getHoraInicio(), s.getFecha()) == true) {
				try {
					//actividadGrupal.getSesionBySalaHora(s.getSala(), s.getHoraInicio())
					if(cliente.reservarSesion(s)==true){
						JOptionPane.showMessageDialog(vista, "Se ha reservado correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
						
						break;
					}
					else {
						JOptionPane.showMessageDialog(vista, "Error al apuntarse", "Error", JOptionPane.ERROR_MESSAGE);
						mostrarPanelActividades();
					}
				} catch(ClientePenalizado e1) {
					JOptionPane.showMessageDialog(vista, e1.toString(), "Error", JOptionPane.ERROR_MESSAGE);
					mostrarPanelActividades();
				}catch(NoCumpleRequisito e2){
					JOptionPane.showMessageDialog(vista, e2.toString(), "Error", JOptionPane.ERROR_MESSAGE);
					mostrarPanelActividades();
				}catch(NoExisteSesion e3) {
					JOptionPane.showMessageDialog(vista, e3.toString(), "Error", JOptionPane.ERROR_MESSAGE);
					mostrarPanelActividades();
				}
			}
		}
		mostrarPanelActividades();
		
	}
	
	/**
	* Metodo que muetsra el panel principal del cliente
	*/
	private void mostrarPanelActividades() {
		this.frame.getVistaActividades().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
}
