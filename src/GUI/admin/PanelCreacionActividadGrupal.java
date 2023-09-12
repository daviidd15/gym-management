package GUI.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import GUI.listeners.admin.ControlBackCrearActividades;
import GUI.listeners.admin.ControlCrearActividad;
import gimnasio.Gimnasio;
import usuarios.Monitor;

/**
 * La clase PanelCreacionActividadGrupal extiende de JPanel y es utilizada para mostrar
 * la vista del panel de creacion de un tipo de actividad grupal
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class PanelCreacionActividadGrupal extends JPanel{
	
	private JComboBox monitorCombo;
	private SpringLayout layout;
	private JTextField precioCampo;
	private JButton back;
	private JButton crear;
	private JTextField sesionesRequeridasMinCampo;
	private JTextField nombreActividadCampo;
	private JTextField sesionesRequeridasMaxCampo;
	private JTextField edadMinimaCampo;
	private JTextField edadMaximaCampo;
	private JTextField antiguedadMinCampo;
	private JTextField antiguedadMaxCampo;
	

	/**
	 * Constructor de la clase PanelCreacionActividadGrupal
	 * 
	 * inicializa los componentes de la vista
	 */
	public PanelCreacionActividadGrupal() {
		
		String monitores[]= {"No hay monitores disponibles"};
		
		layout = new SpringLayout();
		this.setLayout(layout);

		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		JLabel label = new JLabel("GIMNASIO LADFIT");
		JLabel nombrePanel = new JLabel("Creación Tipo Actividad Grupal");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);
		
		
		
		
		JLabel nombreActividad = new JLabel("Nombre de la Actividad: ");
		nombreActividadCampo = new JTextField(10);
		
		JLabel precio = new JLabel("Precio: ");
		precioCampo = new JTextField(10);
		
		JLabel monitor = new JLabel("Monitor: ");
		monitorCombo = new JComboBox(monitores);
		monitorCombo.setSelectedIndex(0);
		
		JLabel sesionesRequeridasMin = new JLabel("Sesiones requeridas mínimas: ");
		sesionesRequeridasMinCampo = new JTextField(10);
		
		JLabel sesionesRequeridasMax = new JLabel("Sesiones requeridas máximas: ");
		sesionesRequeridasMaxCampo = new JTextField(10);
		
		JLabel edadMinima = new JLabel("Edad mínima: ");
		edadMinimaCampo = new JTextField(10);
		
		JLabel edadMaxima = new JLabel("Edad máxima: ");
		edadMaximaCampo = new JTextField(10);
		
		JLabel antiguedadMin = new JLabel("Antigüedad mínima: ");
		antiguedadMinCampo = new JTextField(10);
		
		JLabel antiguedadMax = new JLabel("Antigüedad máxima: ");
		antiguedadMaxCampo = new JTextField(10);
		
		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		crear = new JButton("Crear");
		crear.setBackground(Color.LIGHT_GRAY);
		crear.setPreferredSize(new Dimension(200, 20));
		
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, nombrePanel, 55, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombrePanel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, nombreActividad, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, nombreActividad, -150, SpringLayout.WEST, nombreActividadCampo);
		
		layout.putConstraint(SpringLayout.WEST, precio, 0, SpringLayout.WEST, nombreActividad);
		layout.putConstraint(SpringLayout.NORTH, precio, 35, SpringLayout.NORTH, nombreActividad);
		
		layout.putConstraint(SpringLayout.WEST, monitor, 0, SpringLayout.WEST, precio);
		layout.putConstraint(SpringLayout.NORTH, monitor, 35, SpringLayout.NORTH, precio);
		
		layout.putConstraint(SpringLayout.WEST, sesionesRequeridasMin, 0, SpringLayout.WEST, monitor);
		layout.putConstraint(SpringLayout.NORTH, sesionesRequeridasMin, 35, SpringLayout.NORTH, monitor);
		
		layout.putConstraint(SpringLayout.WEST, sesionesRequeridasMax, 0, SpringLayout.WEST, sesionesRequeridasMin);
		layout.putConstraint(SpringLayout.NORTH, sesionesRequeridasMax, 35, SpringLayout.NORTH, sesionesRequeridasMin);
		
		layout.putConstraint(SpringLayout.WEST, edadMinima, 0, SpringLayout.WEST, sesionesRequeridasMax);
		layout.putConstraint(SpringLayout.NORTH, edadMinima, 35, SpringLayout.NORTH, sesionesRequeridasMax);
		
		layout.putConstraint(SpringLayout.WEST, edadMaxima, 0, SpringLayout.WEST, edadMinima);
		layout.putConstraint(SpringLayout.NORTH, edadMaxima, 35, SpringLayout.NORTH, edadMinima);
		
		layout.putConstraint(SpringLayout.WEST, antiguedadMin, 0, SpringLayout.WEST, edadMaxima);
		layout.putConstraint(SpringLayout.NORTH, antiguedadMin, 35, SpringLayout.NORTH, edadMaxima);
		
		layout.putConstraint(SpringLayout.WEST, antiguedadMax, 0, SpringLayout.WEST, antiguedadMin);
		layout.putConstraint(SpringLayout.NORTH, antiguedadMax, 35, SpringLayout.NORTH, antiguedadMin);
		
		layout.putConstraint(SpringLayout.NORTH, nombreActividadCampo, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombreActividadCampo, 50, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.WEST, precioCampo, 0, SpringLayout.WEST, nombreActividadCampo);
		layout.putConstraint(SpringLayout.NORTH, precioCampo, 35, SpringLayout.NORTH, nombreActividadCampo);
		
		layout.putConstraint(SpringLayout.WEST, monitorCombo, 0, SpringLayout.WEST, precioCampo);
		layout.putConstraint(SpringLayout.NORTH, monitorCombo, 35, SpringLayout.NORTH, precioCampo);
		
		layout.putConstraint(SpringLayout.WEST, sesionesRequeridasMinCampo, 0, SpringLayout.WEST, monitorCombo);
		layout.putConstraint(SpringLayout.NORTH, sesionesRequeridasMinCampo, 35, SpringLayout.NORTH, monitorCombo);
		
		layout.putConstraint(SpringLayout.WEST, sesionesRequeridasMaxCampo, 0, SpringLayout.WEST, sesionesRequeridasMinCampo);
		layout.putConstraint(SpringLayout.NORTH, sesionesRequeridasMaxCampo, 35, SpringLayout.NORTH, sesionesRequeridasMinCampo);
		
		layout.putConstraint(SpringLayout.WEST, edadMinimaCampo, 0, SpringLayout.WEST, sesionesRequeridasMaxCampo);
		layout.putConstraint(SpringLayout.NORTH, edadMinimaCampo, 35, SpringLayout.NORTH, sesionesRequeridasMaxCampo);
		
		layout.putConstraint(SpringLayout.WEST, edadMaximaCampo, 0, SpringLayout.WEST, edadMinimaCampo);
		layout.putConstraint(SpringLayout.NORTH, edadMaximaCampo, 35, SpringLayout.NORTH, edadMinimaCampo);
		
		layout.putConstraint(SpringLayout.WEST, antiguedadMinCampo, 0, SpringLayout.WEST, edadMaximaCampo);
		layout.putConstraint(SpringLayout.NORTH, antiguedadMinCampo, 35, SpringLayout.NORTH, edadMaximaCampo);
		
		layout.putConstraint(SpringLayout.WEST, antiguedadMaxCampo, 0, SpringLayout.WEST, antiguedadMinCampo);
		layout.putConstraint(SpringLayout.NORTH, antiguedadMaxCampo, 35, SpringLayout.NORTH, antiguedadMinCampo);
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, crear, -80, SpringLayout.HORIZONTAL_CENTER, nombrePanel);
		layout.putConstraint(SpringLayout.NORTH, crear, 50, SpringLayout.NORTH, antiguedadMaxCampo);
		
		this.add(label);
		this.add(nombrePanel);
		this.add(nombreActividad);
		this.add(precio);
		this.add(monitor);
		this.add(sesionesRequeridasMin);
		this.add(sesionesRequeridasMax);
		this.add(edadMinima);
		this.add(edadMaxima);
		this.add(antiguedadMin);
		this.add(antiguedadMax);
		this.add(nombreActividadCampo);
		this.add(precioCampo);
		this.add(monitorCombo);
		this.add(sesionesRequeridasMinCampo);
		this.add(sesionesRequeridasMaxCampo);
		this.add(edadMinimaCampo);
		this.add(edadMaximaCampo);
		this.add(antiguedadMinCampo);
		this.add(antiguedadMaxCampo);
		this.add(back);
		this.add(crear);
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el nombre del tipo de actividad grupal
	 */
	public String getNombreActividad(){
		return this.nombreActividadCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el precio de la actividad grupal
	 */
	public String getPrecio(){
		return this.precioCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el requisito de sesiones minimas 
	 */
	public String getSesionesRequeridasMin(){
		return this.sesionesRequeridasMinCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el requisito de sesiones maximas
	 */
	public String getSesionesRequeridasMax(){
		return this.sesionesRequeridasMaxCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el requisito de edad minima
	 */
	public String getEdadMinima(){
		return this.edadMinimaCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el requisito de edad maxima
	 */
	public String getEdadMaxima(){
		return this.edadMaximaCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el requisito de antigüedad mínima
	 */
	public String getAntiguedadMin(){
		return this.antiguedadMinCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el requisito de antigüedad máxima
	 */
	public String getAntiguedadMax(){
		return this.antiguedadMaxCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el monitor que va a impatir la actividad
	 */
	public String getMonitor(){
		return this.monitorCombo.getSelectedItem().toString();	
	}
	
	/**
	 * Setter que establece la lista de monitores en un combo box
	 * 
	 * @param monitores lista de monitores actualizada
	 */
	public void setMonitores(List<Monitor> monitores) {

		if(monitores.size()==0){
			return;
		}
		this.remove(monitorCombo);
		this.monitorCombo.removeAllItems();
		
		for(Monitor m: monitores){
			monitorCombo.addItem(m.getName());
		}
		
		layout.putConstraint(SpringLayout.WEST, monitorCombo, 0, SpringLayout.WEST, this.precioCampo);
		layout.putConstraint(SpringLayout.NORTH, monitorCombo, 10, SpringLayout.SOUTH, this.precioCampo);

		this.add(monitorCombo);
	}
	
	/**
	 * Setter, establece un controlador para el boton back
	 * 
	 * @param control controlador para el boton back en esta vista
	 */
	public void setControlBackCrearActividades(ControlBackCrearActividades control) {
		this.back.addActionListener(control);
	}
	
	/**
	 * Setter, establece un controlador para el boton crear
	 * 
	 * @param control controlador para el boton crear
	 */
	public void setControlCrearActividad(ControlCrearActividad control){
		this.crear.addActionListener(control);
	}
	
	
}
