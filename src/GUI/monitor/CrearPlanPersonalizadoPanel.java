package GUI.monitor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.*;
import GUI.listeners.*;
import GUI.listeners.monitor.*;
import actividades.Objetivo;

/**
 * La clase CrearPlanPersonalizadoPanel extiende de JPanel y es utilizada para mostrar
 * la vista de crear un plan personalizado
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class CrearPlanPersonalizadoPanel extends JPanel{
	private JTextField nombreActividadCampo;
	private ButtonGroup grupo;
	private JRadioButton gananciaMasaMuscular;
	private JRadioButton perdidaGrasa;
	private JRadioButton rehabilitacion;
	private JTextField descripcionCampo;
	private JTextField sesionesRequeridasMinCampo;
	private JTextField sesionesRequeridasMaxCampo;
	private JTextField edadMinimaCampo;
	private JTextField edadMaximaCampo;
	private JTextField antiguedadMinCampo;
	private JTextField antiguedadMaxCampo;
	private JButton crear;
	private JButton back;
	
	/**
	 * Constructor de la clase CrearPlanPersonalizadoPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public CrearPlanPersonalizadoPanel(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		String monitor = "Pepe";
		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		
		JLabel label = new JLabel("GIMNASIO LADFIT");
		JLabel nombrePanel = new JLabel("Creación Plan Personalizado ");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);
		
		JLabel nombreActividad = new JLabel("Nombre: ");
		nombreActividadCampo = new JTextField(10);
		
		gananciaMasaMuscular = new JRadioButton("Ganancia de masa muscular");
		perdidaGrasa = new JRadioButton("Perdida de peso");
		rehabilitacion = new JRadioButton("Rehabilitación");		
		
		grupo = new ButtonGroup();
		grupo.add(gananciaMasaMuscular);
		grupo.add(perdidaGrasa);
		grupo.add(rehabilitacion);
		
		JLabel descripcion = new JLabel("Descripcion: ");
		descripcionCampo = new JTextField(40);
		
		JLabel sesionesRequeridasMin = new JLabel("Indica las sesiones requeridas mínimas: ");
		sesionesRequeridasMinCampo = new JTextField(10);
		
		JLabel sesionesRequeridasMax = new JLabel("Indica las sesiones requeridas máximas: ");
		sesionesRequeridasMaxCampo = new JTextField(10);
		
		JLabel edadMinima = new JLabel("Indica la edad minima: ");
		edadMinimaCampo = new JTextField(10);
		
		JLabel edadMaxima = new JLabel("Indica la edad maxima: ");
		edadMaximaCampo = new JTextField(10);
		
		JLabel antiguedadMin = new JLabel("Indica la antiguedad minima: ");
		antiguedadMinCampo = new JTextField(10);
		
		JLabel antiguedadMax = new JLabel("Indica la antiguedad maxima: ");
		antiguedadMaxCampo = new JTextField(10);
		
		
		crear = new JButton("Crear");
		crear.setPreferredSize(new Dimension(200, 40));
		crear.setBackground(Color.LIGHT_GRAY);
		
		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, nombrePanel, 35, SpringLayout.NORTH, label);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombrePanel, 0, SpringLayout.HORIZONTAL_CENTER, label);
		
		
		layout.putConstraint(SpringLayout.EAST, nombreActividad, -150, SpringLayout.WEST, nombreActividadCampo);
		layout.putConstraint(SpringLayout.NORTH, nombreActividad, 100, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, descripcion, 0, SpringLayout.WEST, nombreActividad);
		layout.putConstraint(SpringLayout.NORTH, descripcion, 35, SpringLayout.NORTH, nombreActividad);
		
		layout.putConstraint(SpringLayout.WEST, sesionesRequeridasMin, 0, SpringLayout.WEST, descripcion);
		layout.putConstraint(SpringLayout.NORTH, sesionesRequeridasMin, 35, SpringLayout.NORTH, descripcion);
		
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
		
		
		
		layout.putConstraint(SpringLayout.NORTH, nombreActividadCampo, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombreActividadCampo, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.WEST, descripcionCampo, 0, SpringLayout.WEST, nombreActividadCampo);
		layout.putConstraint(SpringLayout.NORTH, descripcionCampo, 35, SpringLayout.NORTH, nombreActividadCampo);
		
		layout.putConstraint(SpringLayout.EAST, sesionesRequeridasMinCampo, 0, SpringLayout.EAST, descripcionCampo);
		layout.putConstraint(SpringLayout.NORTH, sesionesRequeridasMinCampo, 35, SpringLayout.NORTH, descripcionCampo);
		
		layout.putConstraint(SpringLayout.EAST, sesionesRequeridasMaxCampo, 0, SpringLayout.EAST, sesionesRequeridasMinCampo);
		layout.putConstraint(SpringLayout.NORTH, sesionesRequeridasMaxCampo, 35, SpringLayout.NORTH, sesionesRequeridasMinCampo);
		
		layout.putConstraint(SpringLayout.EAST, edadMinimaCampo, 0, SpringLayout.EAST, sesionesRequeridasMaxCampo);
		layout.putConstraint(SpringLayout.NORTH, edadMinimaCampo, 35, SpringLayout.NORTH, sesionesRequeridasMaxCampo);
		
		layout.putConstraint(SpringLayout.EAST, edadMaximaCampo, 0, SpringLayout.EAST, edadMinimaCampo);
		layout.putConstraint(SpringLayout.NORTH, edadMaximaCampo, 35, SpringLayout.NORTH, edadMinimaCampo);
		
		layout.putConstraint(SpringLayout.EAST, antiguedadMinCampo, 0, SpringLayout.EAST, edadMaximaCampo);
		layout.putConstraint(SpringLayout.NORTH, antiguedadMinCampo, 35, SpringLayout.NORTH, edadMaximaCampo);
		
		layout.putConstraint(SpringLayout.EAST, antiguedadMaxCampo, 0, SpringLayout.EAST, antiguedadMinCampo);
		layout.putConstraint(SpringLayout.NORTH, antiguedadMaxCampo, 35, SpringLayout.NORTH, antiguedadMinCampo);
		
		layout.putConstraint(SpringLayout.WEST, gananciaMasaMuscular, 0, SpringLayout.WEST, antiguedadMax);
		layout.putConstraint(SpringLayout.NORTH, gananciaMasaMuscular, 55, SpringLayout.NORTH, antiguedadMax);
		
		layout.putConstraint(SpringLayout.WEST, perdidaGrasa, 0, SpringLayout.WEST, gananciaMasaMuscular);
		layout.putConstraint(SpringLayout.NORTH, perdidaGrasa, 55, SpringLayout.NORTH, gananciaMasaMuscular);
		
		layout.putConstraint(SpringLayout.WEST, rehabilitacion, 0, SpringLayout.WEST, perdidaGrasa);
		layout.putConstraint(SpringLayout.NORTH, rehabilitacion, 55, SpringLayout.NORTH, perdidaGrasa);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, crear, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, crear, 55, SpringLayout.NORTH, rehabilitacion);
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
		this.add(label);
		this.add(nombrePanel);
		this.add(nombreActividad);
		this.add(nombreActividadCampo);
		this.add(descripcion);
		this.add(descripcionCampo);
		
		this.add(gananciaMasaMuscular);
		this.add(perdidaGrasa);
		this.add(rehabilitacion);
		
		this.add(sesionesRequeridasMin);
		this.add(sesionesRequeridasMinCampo);
		this.add(sesionesRequeridasMax);
		this.add(sesionesRequeridasMaxCampo);
		this.add(edadMinima);
		this.add(edadMinimaCampo);
		this.add(edadMaxima);
		this.add(edadMaximaCampo);
		this.add(antiguedadMin);
		this.add(antiguedadMinCampo);
		this.add(antiguedadMax);
		this.add(antiguedadMaxCampo);
		

		this.add(back);
		this.add(crear);
	}
	
	/**
	 * Setter, establece un controlador para el boton de crear
	 * 
	 * @param controladorCrearPlanPersonalizado controlador para el boton de crear
	 */
	public void setControladorCrearPlanPersonalizado(ControlCrearPlanPersonalizadoBoton controladorCrearPlanPersonalizado) {
		crear.addActionListener(controladorCrearPlanPersonalizado);
	}
	
	/**
	 * Setter, establece un controlador para el boton de back
	 * 
	 * @param controladorBackCrearPlan controlador para el boton de crear
	 */
	public void setControladorBackCrearPlan(ControlBackCrearPlan controladorBackCrearPlan) {
		back.addActionListener(controladorBackCrearPlan);
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el nombre del plan personalizado
	 */
	public String getNombre(){
		return this.nombreActividadCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con la descripcion del plan personalizado
	 */
	public String getDescripcion() {
		return this.descripcionCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return Objetivo tipo de objetivo del plan personalizado
	 */
	public Objetivo getObjetivo(){
		if (gananciaMasaMuscular.isSelected()) {
			return Objetivo.GANANCIA_MASA_MUSCULAR;
		}
		else if (perdidaGrasa.isSelected()) {
			return Objetivo.PERDIDA_DE_PESO;
		}
		else if (rehabilitacion.isSelected()) {
			return Objetivo.REHABILITACION;
		}
		return null;
	}
	
	/**
	 * Getter
	 * 
	 * @return int con el requisito de sesiones minimas
	 */
	public int getSesionesRequeridasMin() {
		
		return Integer.parseInt(this.sesionesRequeridasMinCampo.getText());
	}
	
	/**
	 * Getter
	 * 
	 * @return int con el requisito de sesiones maximas
	 */
	public int getSesionesRequeridasMax() {
		return Integer.parseInt(this.sesionesRequeridasMaxCampo.getText()); 
	}
	
	/**
	 * Getter
	 * 
	 * @return int con el requisito de edad minima
	 */
	public int getEdadMinima() {
		return Integer.parseInt(this.edadMinimaCampo.getText()); 
	}
	
	/**
	 * Getter
	 * 
	 * @return int con el requisito de edad maxima
	 */
	public int getEdadMaxima() {
		return Integer.parseInt(this.edadMaximaCampo.getText());
	}
	
	/**
	 * Getter
	 * 
	 * @return int con el requisito de antigüedad minima
	 */
	public int getAntiguedadMinCampo() {
		return Integer.parseInt(this.antiguedadMinCampo.getText());
	}
	
	/**
	 * Getter
	 * 
	 * @return int con el requisito de antigüedad maxima
	 */
	public int getAntiguedadMaxCampo() {
		return Integer.parseInt(this.antiguedadMaxCampo.getText());
	}
}
