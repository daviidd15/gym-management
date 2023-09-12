package GUI.listeners.monitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;

import GUI.*;
import GUI.monitor.*;
import gimnasio.Gimnasio;
import usuarios.Monitor;

/**
 * Controlador que lleva al monitor a la vista del horario del monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlAccesoHorario implements ActionListener{
	private PantallaPrincipalMonitorPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlAccesoHorario(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPantallaPrincipalMonitor();
	}

	/**
	 * Cuando se pulse el boton de horario, se actualizan los valores del horario del monitor
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Monitor m = ((Monitor)Gimnasio.getGimnasio().getUsuarioActualOperando());
		String[] titulos = {"Dia de la semana", "Nombre", "Hora de inicio", "Hora de fin"};
		JTable table = new JTable(m.getHorarioSemana(), titulos);
		
		this.frame.getVistaAccesoHorarioMonitor().setTable(table);
		mostrarPanelHorario();
	}
	
	/**
	 * Método que muestra el horario del monitor
	 */
	private void mostrarPanelHorario() {
		this.frame.getVistaAccesoHorarioMonitor().setVisible(true);
		this.vista.setVisible(false);		
	}

}

