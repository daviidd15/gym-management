package GUI.listeners.monitor;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.monitor.PantallaPrincipalMonitorPanel;
import GUI.monitor.CancelarClaseMonitorPanel;
import gimnasio.Gimnasio;
import usuarios.Monitor;

/**
 * Controlador que lleva al monitor a la vista de cancelar clase
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlCancelarClase implements ActionListener{
	private PantallaPrincipalMonitorPanel vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlCancelarClase(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPantallaPrincipalMonitor();
	}

	/**
	 * Cuando se pulse el boton de cancelar clase, se actualizan los valores de este panel
	 * y se dirige a este
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Monitor m = ((Monitor)Gimnasio.getGimnasio().getUsuarioActualOperando());
		String[] titulos = {"Dia de la semana", "Nombre", "Hora de inicio", "Hora de fin"};
		JTable table = new JTable(m.getHorarioSemana(), titulos);
		this.frame.getVistaCancelarClase().setTable(table);
		mostrarCancelar();
	}
	
	
	/**
	 * Metodo que muestra la vista de cancelar clase
	 */
	private void mostrarCancelar() {
		this.frame.getVistaCancelarClase().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
		
	}
}
