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

import GUI.listeners.admin.ControlBackVerBeneficios;

/**
 * La clase VerBeneficiosPanel extiende de JPanel y es utilizada para mostrar
 * la vista de los beneficios por mes del gimnasio
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class VerBeneficiosPanel extends JPanel{
	private JTable tabla;
	private JScrollPane scrollTabla;
	private JButton volver;
	
	/**
	 * Constructor de la clase VerBeneficiosPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public VerBeneficiosPanel() {
		 String[] titulos = { "Nombre actividad","Beneficio"};
		 Object[][] filas = {{}};
		  
		
		this.setLayout(new BorderLayout());

		JPanel volverPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 		
		volver = new JButton("Volver");
				
		volver.setBackground(Color.LIGHT_GRAY);
		
		volverPanel.add(volver);
		this.add(volverPanel, BorderLayout.NORTH);
		
	}
	
	/**
	 * Setter que establece la tabla con los valores
	 * 
	 * @param table tabla con los valores de los beneficios actualizados
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
	 * Setter, establece el controlador para el boton del back
	 * 
	 * @param controlador controlador para el boton del back
	 */
	public void setBackVerBeneficios(ControlBackVerBeneficios controlador) {
		volver.addActionListener(controlador);
	}
}
