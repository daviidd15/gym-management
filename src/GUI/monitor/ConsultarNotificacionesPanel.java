package GUI.monitor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import GUI.listeners.monitor.ControlBackConsultarNotificaciones;


/**
 * La clase ConsultarNotificacionesPanel extiende de JPanel y es utilizada para mostrar
 * la vista de las notificaciones del monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ConsultarNotificacionesPanel extends JPanel {
	private JButton back;
	private SpringLayout layout;
	private DefaultListModel<String> notificaciones; 
	private JList<String> listaNotificaciones;
	private JLabel nombrePanel;
	
	/**
	 * Constructor de la clase ConsultarNotificacionesPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public ConsultarNotificacionesPanel() {
	
		layout = new SpringLayout(); 
		this.setLayout(layout);
		
		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		
		JLabel label = new JLabel("GIMNASIO LADFIT");
		nombrePanel = new JLabel("Notificaciones");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);
		
		notificaciones = new DefaultListModel<String>();
		listaNotificaciones = new JList<String>(notificaciones);
		
		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(80, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, nombrePanel, 35, SpringLayout.NORTH, label);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombrePanel, 0, SpringLayout.HORIZONTAL_CENTER, label);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, listaNotificaciones, 0, SpringLayout.HORIZONTAL_CENTER, this.nombrePanel);
		layout.putConstraint(SpringLayout.NORTH, listaNotificaciones, 25, SpringLayout.SOUTH, this.nombrePanel);
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
		this.add(back);
		this.add(label);
		this.add(nombrePanel);
		this.add(listaNotificaciones);
	}
	
	/**
	 * Setter, establece un controlador para el boton de back
	 * 
	 * @param controladorBackConsultarNotificaciones controlador para el boton de back en esta vista
	 */
	public void setConsultarBackNotificaciones(ControlBackConsultarNotificaciones controladorBackConsultarNotificaciones) {
		back.addActionListener(controladorBackConsultarNotificaciones);
	}
	
	/**
	 * Setter que establece las notificaciones actualizadas
	 * 
	 * @param not String con el array de notificaciones del monitor
	 */
	public void setConsultarNotificacionesPanel(String[] not) {
		
		this.remove(listaNotificaciones);
		this.listaNotificaciones.removeAll();
		
		for (int i = 0; i < not.length; i++) {
			notificaciones.addElement(not[i]);
		}
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, listaNotificaciones, 0, SpringLayout.HORIZONTAL_CENTER, this.nombrePanel);
		layout.putConstraint(SpringLayout.NORTH, listaNotificaciones, 25, SpringLayout.SOUTH, this.nombrePanel);

		this.add(listaNotificaciones);
	}
}
