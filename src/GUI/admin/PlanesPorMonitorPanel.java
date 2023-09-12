package GUI.admin;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GUI.listeners.admin.*;

/**
 * La clase PlanesPorMonitorPanel extiende de JPanel y es utilizada para mostrar
 * la vista de los planes personalizados que ha ofertado cada monitor y si han sido contratados
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class PlanesPorMonitorPanel extends JPanel {
	
	private JTable tabla;
	private JScrollPane scrollTabla;
	private JButton volver;
	
	/**
	 * Constructor de la clase PlanesPorMonitorPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public PlanesPorMonitorPanel() {
		
		
		 String[] titulos = { "Nombre", "Monitor", "Contratado", "Descripcion", "Objetivo" };
		  Object[][] filas = {{}};
		  
		
		this.setLayout(new BorderLayout());

		JPanel volverPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		
		 volver = new JButton("Volver");
		 volver.setPreferredSize(new Dimension(100, 20));
		 volver.setBackground(Color.LIGHT_GRAY);
		 
		volverPanel.add(volver);
		this.add(volverPanel, BorderLayout.NORTH);

		
	}
	
	/**
	 * Setter que establece la tabla con los valores 
	 * 
	 * @param table tabla con los valores actualizados
	 */
	public void setNewTable(JTable table) {
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
	
	/**
	 * Setter, establece el controlador para el boton de back
	 * 
	 * @param contBackPlanesPorMonitor controlador para el boton de back
	 */
	public void setControladorBack(ControlBackPlanesPorMonitor contBackPlanesPorMonitor) {
		volver.addActionListener(contBackPlanesPorMonitor);
		
	}

}
