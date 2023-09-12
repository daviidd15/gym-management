package GUI.monitor;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.*;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import GUI.listeners.monitor.*;
import GUI.listeners.ControlRegistro;

/**
 * La clase CancelarClaseMonitorPanel extiende de JPanel y es utilizada para mostrar
 * la vista de que un monitor pueda cancelar una de sus actividades
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class CancelarClaseMonitorPanel extends JPanel {
	private JTextField nombreActividadCampo;
	private JTable tabla;
	private JScrollPane scrollTabla;
	private JButton volver;
	private JButton cancelar;
	
	/**
	 * Constructor de la clase CancelarClaseMonitorPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public CancelarClaseMonitorPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel volverPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cancelarPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
		
		 volver = new JButton("Volver");
		cancelar= new JButton("Cancelar");
		volver.setBackground(Color.LIGHT_GRAY);
		cancelar.setBackground(Color.LIGHT_GRAY);
		
		volverPanel.add(volver);
		cancelarPanel.add(cancelar);
		this.add(volverPanel, BorderLayout.NORTH);
		this.add(cancelarPanel, BorderLayout.SOUTH);
		
	}
	
	/**
	 * Setter, establece un controlador para el boton de cancelar
	 * 
	 * @param controladorCancelarClaseBoton controlador para el boton de cancelar
	 */
	public void setControlCancelarClaseBoton(ControlCancelarClaseBoton controladorCancelarClaseBoton){
		cancelar.addActionListener(controladorCancelarClaseBoton);
	}
	
	/**
	 * Setter, establece un controlador para el boton de volver
	 * 
	 * @param controladorBackCancelarClase controlador para el back
	 */
	public void setControladorBackCancelarClase(ControlBackCancelarClase controladorBackCancelarClase) {
		volver.addActionListener(controladorBackCancelarClase);
	}
	
	/**
	 * Getter
	 * 
	 * @return JTable con las actividades del monitor
	 */
	public JTable getTablaCancelarClase(){
		return this.tabla;
	}
	
	/**
	 * Setter que establece las actividades del monitor 
	 * 
	 * @param table tabla con las actividades del monitor actualizadas
	 */
	public void setTable(JTable table){
		JTable tablaNueva = table;
		
		if(this.tabla!=null) {
			this.remove(scrollTabla);
		}
		
		tablaNueva.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaNueva.setPreferredScrollableViewportSize(new Dimension(1000, 1000));
		JScrollPane scrollTabla2 = new JScrollPane(tablaNueva);
		
		this.add(scrollTabla2);
		
		tablaNueva.setAutoCreateRowSorter(true);
		this.tabla = tablaNueva;
		this.scrollTabla = scrollTabla2;
	}
	

}