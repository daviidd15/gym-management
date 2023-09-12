package GUI.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import GUI.listeners.cliente.ControlBackVerReservas;
import GUI.listeners.cliente.ControlCancelarVerReservas;
import actividades.ActividadMonitorizada;
import actividades.PlanPersonalizado;
import gimnasio.Gimnasio;
import usuarios.Monitor;
import usuarios.Usuario;

/**
 * La clase VerReservasPanel extiende de JPanel y es utilizada para mostrar
 * la pantalla de reservas del cliente
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class VerReservasPanel extends JPanel {
	private JTable tabla;
	private JScrollPane scrollTabla;
	private JButton volver;
	private JButton cancelar;
	
	/**
	 * Constructor de la clase VerReservasPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public VerReservasPanel() {
		 String[] titulos = { "Nombre actividad","Día", "Hora"};
		 Object[][] filas = {{}};
		  
		
		this.setLayout(new BorderLayout());

		JPanel volverPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JPanel cancelarPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		volver = new JButton("Volver");
		cancelar = new JButton("Cancelar");
		volver.setBackground(Color.LIGHT_GRAY);
		cancelar.setBackground(Color.LIGHT_GRAY);
		
		volverPanel.add(volver);
		cancelarPanel.add(cancelar);
		this.add(volverPanel, BorderLayout.NORTH);
		this.add(cancelarPanel,BorderLayout.SOUTH);
	}
	
	/**
	 * Setter, establece la tabla con las reservas del cliente actualizadas
	 * 
	 * @param table tabla con las reservas del cliente
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
	 * Setter, establece el controlador para el boton back
	 * 
	 * @param controladorBackVerReservas controlador para el boton back
	 */
	public void setControladorBack(ControlBackVerReservas controladorBackVerReservas) {
		volver.addActionListener(controladorBackVerReservas);
	}
	
	/**
	 * Setter, establece el controlador para el boton de cancelar
	 * 
	 * @param controladorCancelarVerReservas controlador para el boton cancelar
	 */
	public void setControladorCancelar(ControlCancelarVerReservas controladorCancelarVerReservas){
		cancelar.addActionListener(controladorCancelarVerReservas);
	}
	
	/**
	 * Getter
	 * 
	 * @return JTable con la tabla de las reservas
	 */
	public JTable getTablaCancelarReserva(){
		return this.tabla;
	}
	
}