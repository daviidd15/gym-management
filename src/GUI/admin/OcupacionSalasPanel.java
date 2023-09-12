 package GUI.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import GUI.listeners.admin.ControlBackOcupacion;
import GUI.listeners.cliente.ControlBackVerReservas;

/**
 * La clase OcupacionSalasPanel extiende de JPanel y es utilizada para mostrar
 * la vista de la ocupacion de las salas del gimnasio
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class OcupacionSalasPanel extends JPanel{
	private JTable tabla;
	private JScrollPane scrollTabla;
	private JButton volver;
	
	/**
	 * Constructor de la clase OcupacionSalasPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public OcupacionSalasPanel() {
		 String[] titulos = { "Nombre sala","Ocupación"};
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
	 * Setter que establece los valores para la tabla
	 * 
	 * @param table tabla en la que estan contenidos los nuevos valores
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
	 * Setter, establece un controlador para el boton de volver
	 * 
	 * @param controlador controlador para el boton de volver
	 */
	public void setControladorBack(ControlBackOcupacion controlador) {
		volver.addActionListener(controlador);
	}
}
