package GUI.monitor;

import java.awt.*;

import javax.swing.*;

import GUI.listeners.monitor.*;

/**
 * La clase AccesoHorarioMonitorPanel extiende de JPanel y es utilizada para mostrar
 * la vista del horario del monitor por semana
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class AccesoHorarioMonitorPanel extends JPanel {
	private JButton volver;
	private JTable tabla;
	private JScrollPane scrollTabla;
	
	/**
	 * Constructor de la clase AccesoHorarioMonitorPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public AccesoHorarioMonitorPanel() {
		this.setLayout(new BorderLayout());

		JPanel volverPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		
		 volver = new JButton("Volver");
		 volver.setBackground(Color.LIGHT_GRAY);
		 
		volverPanel.add(volver);
		this.add(volverPanel, BorderLayout.NORTH);
	}
	
	/**
	 * Setter, establece el controlador para el boton de volver
	 * 
	 * @param controladorAccesoHorario controlador para el boton de volver
	 */
	public void setControladorBack(ControlBackAccesoHorario controladorAccesoHorario) {
		volver.addActionListener(controladorAccesoHorario);
	}
	
	/**
	 * Setter, establece la tabla con el horario del monitor actualizado
	 * 
	 * @param table tabla con el horario del monitor
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
