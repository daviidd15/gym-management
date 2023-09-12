package GUI.listeners.cliente;

import GUI.VentanaProyecto;
import GUI.cliente.*;
import actividades.ActividadMonitorizada;
import gimnasio.Gimnasio;
import usuarios.*;
import actividades.*;
import java.time.*;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

	/**
	 * Clase del Constructor del controlador
	 * @author Alvaro Casasus, David Palomares, Laura de la Cruz 
	 */
public class ControlCancelarVerReservas implements ActionListener{
	private ReservasPanel vista;
	private VentanaProyecto frame;
	public ControlCancelarVerReservas(VentanaProyecto frame){
		this.frame = frame;
		this.vista = this.frame.getVistaActividades();
	}
	
	/**
	 * Realiza la accion del Constructor
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JTable table = this.frame.getVistaVerReservas().getTablaCancelarReserva();
		
		int filaSeleccionada = table.getSelectedRow();
		
		Cliente c = (Cliente) Gimnasio.getGimnasio().getUsuarioActualOperando();
		
		
		if(c.cancelarReserva(c.getReservaByName(table.getValueAt(filaSeleccionada, 0).toString(), LocalDate.parse(table.getValueAt(filaSeleccionada, 1).toString()), LocalTime.parse(table.getValueAt(filaSeleccionada, 2).toString())))==true){
			JOptionPane.showMessageDialog(vista, "Se ha cancelado correctamente", "Cancelacion correcta", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(vista, "Ha habido un error en la cancelacion", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		}
		
		
		
	

}