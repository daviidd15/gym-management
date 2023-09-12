package GUI.listeners.cliente;

import GUI.VentanaProyecto;
import GUI.cliente.*;
import actividades.ActividadMonitorizada;
import gimnasio.Gimnasio;
import usuarios.*;
import actividades.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
/**
* Contrloador que te permite ver las reservas
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlVerReservas implements ActionListener {
	private ReservasPanel vista;
	private VentanaProyecto frame;

/**
*	Constructor del controlador ver reservas
*	@param frame el frame de control reservas
*/
	public ControlVerReservas(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaActividades();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTable tabla;
		String[] titulos = { "Nombre actividad", "Día", "Hora" };
		int n = 0;
		
		int i = 0;

		Cliente c = (Cliente) Gimnasio.getGimnasio().getUsuarioActualOperando();
		n = c.getReservas().size();
		
		Object[][] filas = new String[n][3];
		
		for (Reserva r : c.getReservas()) {
			if (r.getSesion().getActividadMonitorizada() == null) {
				filas[i][0] = "Entrenamiento libre";
				filas[i][1] = r.getSesion().getFecha().toString();
				filas[i][2] = r.getSesion().getHoraInicio().toString();
				i++;
			} else {
				filas[i][0] = r.getSesion().getActividadMonitorizada().getNombre();
				filas[i][1] = r.getSesion().getFecha().toString();
				filas[i][2] = r.getSesion().getHoraInicio().toString();
				i++;
			}
		}

		tabla = new JTable(filas, titulos);
		this.frame.getVistaVerReservas().setNewTable(tabla);

		mostrarReservas();

	}
	/**
	* Muestra el panel de las reservas
	*/
	private void mostrarReservas() {
		this.frame.getVistaVerReservas().setVisible(true);
		this.vista.setVisible(false);
		// this.frame.getVistaRegistro().update();
	}
}
