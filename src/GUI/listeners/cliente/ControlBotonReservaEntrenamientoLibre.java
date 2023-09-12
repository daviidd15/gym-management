package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.cliente.ActividadGrupalPanel;
import GUI.cliente.EntrenamientoLibrePanel;
import actividades.ActividadGrupal;
import actividades.Sesion;
import excepciones.ClientePenalizado;
import excepciones.NoCumpleRequisito;
import excepciones.NoExisteSesion;
import gimnasio.Gimnasio;
import usuarios.Cliente;

	/**
	 * Clase del controlador del boton para reservar un entrenamiento libre
	 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
	 */
public class ControlBotonReservaEntrenamientoLibre  implements ActionListener {
	private EntrenamientoLibrePanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * @param frame del controlador
	 */
	public ControlBotonReservaEntrenamientoLibre(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaEntrenamientoLibre();
	}

	/**
	 * La accion del controlador, Reserva el entrenamiento libre
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {	
		Cliente cliente = (Cliente)Gimnasio.getGimnasio().getUsuarioActualOperando();
		
		LocalTime hora = LocalTime.of(vista.getComboHora(), vista.getComboMinutos());
		  
		
		for (Sesion s: Gimnasio.getGimnasio().getSesiones()) {
			if (s.getActividadMonitorizada() == null && s.getHoraInicio().equals(hora)) {
				try {
					if (cliente.reservarSesion(s) == true) {
						JOptionPane.showMessageDialog(vista, "Ha sido apuntado correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
						mostrarPanelActividades();
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
	}
	
	/**
	* Mostrar panel anterior
	*/
	private void mostrarPanelActividades() {
		this.frame.getVistaActividades().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
}
