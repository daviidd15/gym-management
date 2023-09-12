package GUI.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import GUI.listeners.admin.*;

/**
 * La clase PanelAdministradorMonitores extiende de JPanel y es utilizada para mostrar
 * la vista de administracion de los monitores
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class PanelAdministradorMonitores extends JPanel{
	private JButton registro;
	private JButton cambiar;
	private JButton back;
	private JTextField suplementoCampo;
	
	/**
	 * Constructor de la clase PanelAdministradorMonitores
	 * 
	 * inicializa los componentes de la vista
	 */
	public PanelAdministradorMonitores(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);

		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		JLabel label = new JLabel("GIMNASIO LADFIT");
		JLabel nombrePanel = new JLabel("Administracion de Monitores");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);
		
		
		JLabel sueldo = new JLabel("Sueldo base: ");
		JTextField sueldoCampo = new JTextField(10);
		
		JLabel suplemento = new JLabel("Suplemento: ");
		JTextField suplementoCampo = new JTextField(10);
		
		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		cambiar = new JButton("Cambiar sueldo");
		cambiar.setBackground(Color.LIGHT_GRAY);
		
		registro = new JButton("Registrar un nuevo monitor");
		registro.setBackground(Color.LIGHT_GRAY);
		
		
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, nombrePanel, 35, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombrePanel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, sueldo, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, sueldo, -150, SpringLayout.WEST, sueldoCampo);
		
		layout.putConstraint(SpringLayout.WEST, suplemento, 0, SpringLayout.WEST, sueldo);
		layout.putConstraint(SpringLayout.NORTH, suplemento, 35, SpringLayout.NORTH, sueldo);
		
		layout.putConstraint(SpringLayout.NORTH, sueldoCampo, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, sueldoCampo, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.WEST, suplementoCampo, 0, SpringLayout.WEST, sueldoCampo);
		layout.putConstraint(SpringLayout.NORTH, suplementoCampo, 35, SpringLayout.NORTH, sueldoCampo);
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, cambiar, -70, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, cambiar, 100, SpringLayout.NORTH, sueldoCampo);
		
		layout.putConstraint(SpringLayout.EAST, registro, 0, SpringLayout.WEST, sueldo);
		layout.putConstraint(SpringLayout.NORTH, registro, 15, SpringLayout.NORTH, sueldo);
		
		this.add(label);
		this.add(nombrePanel);
		this.add(sueldo);
		this.add(suplemento);
		this.add(sueldoCampo);
		this.add(suplementoCampo);
		this.add(back);
		this.add(cambiar);
		this.add(registro);
	}
	
	/**
	 * Setter, establece un controlador para el boton de registro
	 * 
	 * @param controladorRegistroMonitor controlador para el boton de registro
	 */
	public void setControladorRegistroMonitor(ControlRegistroMonitor controladorRegistroMonitor) {
		registro.addActionListener(controladorRegistroMonitor);
	}
	
	/**
	 * Setter, establece un controlador para el boton de back
	 * 
	 * @param controladorBackPanelControl controlador para el boton de back
	 */
	public void setControladorBack(ControlBackPanelControl controladorBackPanelControl) {
		back.addActionListener(controladorBackPanelControl);
	}
}
