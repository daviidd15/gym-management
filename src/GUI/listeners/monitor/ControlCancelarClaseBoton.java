package GUI.listeners.monitor;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.monitor.PantallaPrincipalMonitorPanel;
import GUI.monitor.CancelarClaseMonitorPanel;
import gimnasio.Gimnasio;
import usuarios.Monitor;


/**
 * Controlador que cancela una clase de un monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlCancelarClaseBoton implements ActionListener{
	
	private CancelarClaseMonitorPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlCancelarClaseBoton(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaCancelarClase();
	}
	
	/**
	 * Metodo que cancela una sesion de un monitor
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JTable table = this.frame.getVistaCancelarClase().getTablaCancelarClase();
		int filaSeleccionada = table.getSelectedRow();
		
		
		
		if(((Monitor)Gimnasio.getGimnasio().getUsuarioActualOperando()).cancelarClaseMonitor(table.getValueAt(filaSeleccionada, 1).toString(),LocalTime.parse(table.getValueAt(filaSeleccionada, 2).toString()), LocalDate.now().with(DayOfWeek.valueOf(table.getValueAt(filaSeleccionada, 0).toString())))==true){
			JOptionPane.showMessageDialog(vista, "Se ha cancelado correctamente", "Cancelacion correcta", JOptionPane.INFORMATION_MESSAGE);
			mostrarPanelPrincipalMonitor();
		}
		else{
			JOptionPane.showMessageDialog(vista, "Ha habido un error en la cancelacion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Metodo que muestra la pantalla principal de un monitor
	 */
	private void mostrarPanelPrincipalMonitor() {
		this.frame.getVistaPantallaPrincipalMonitor().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
}
