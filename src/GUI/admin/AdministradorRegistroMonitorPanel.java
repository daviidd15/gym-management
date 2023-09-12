package GUI.admin;

import javax.swing.*;

import GUI.listeners.*;
import GUI.listeners.admin.*;

import java.awt.*;

/**
 * La clase AdministradorRegistroMonitorPanel extiende de JPanel y es utilizada para mostrar
 * la vista de registrar un monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class AdministradorRegistroMonitorPanel extends JPanel {
	private JButton registra;
	private JButton back;
	private JTextField nombreCampo;
	private JTextField correoCampo;
	private JTextField usuarioCampo;
	private JPasswordField contraseniaCampo;
	private JTextField dniCampo;
	private JLabel nombrePanel;
	
	/**
	 * Constructor de la clase AdministradorRegistroMonitorPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public AdministradorRegistroMonitorPanel() {
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);

		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		JLabel label = new JLabel("GIMNASIO LADFIT");
		JLabel nombrePanel = new JLabel("Registro de un monitor");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);
		
		JLabel nombre = new JLabel("Nombre: ");
		nombreCampo = new JTextField(10);
		
		JLabel correo = new JLabel("Correo Electronico: ");
		correoCampo = new JTextField(10);
		
		JLabel usuario = new JLabel("Usuario: ");
		usuarioCampo = new JTextField(10);
		
		JLabel contrasenia = new JLabel("Contraseña: ");
		contraseniaCampo = new JPasswordField(10);
		
		JLabel DNI = new JLabel("Dni: ");
		dniCampo = new JTextField(10);
		
		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		registra = new JButton("Registra al monitor");
		registra.setBackground(Color.LIGHT_GRAY);
		
		
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, nombrePanel, 35, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombrePanel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		
		layout.putConstraint(SpringLayout.NORTH, nombre, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, nombre, -150, SpringLayout.WEST, nombreCampo);
		
		layout.putConstraint(SpringLayout.WEST, correo, 0, SpringLayout.WEST, nombre);
		layout.putConstraint(SpringLayout.NORTH, correo, 35, SpringLayout.NORTH, nombre);
		
		layout.putConstraint(SpringLayout.WEST, usuario, 0, SpringLayout.WEST, correo);
		layout.putConstraint(SpringLayout.NORTH, usuario, 35, SpringLayout.NORTH, correo);
		
		layout.putConstraint(SpringLayout.WEST, contrasenia, 0, SpringLayout.WEST, usuario);
		layout.putConstraint(SpringLayout.NORTH, contrasenia, 35, SpringLayout.NORTH, usuario);
		
		layout.putConstraint(SpringLayout.WEST, DNI, 0, SpringLayout.WEST, contrasenia);
		layout.putConstraint(SpringLayout.NORTH, DNI, 35, SpringLayout.NORTH, contrasenia);
		
		layout.putConstraint(SpringLayout.NORTH, nombreCampo, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombreCampo, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.WEST, correoCampo, 0, SpringLayout.WEST, nombreCampo);
		layout.putConstraint(SpringLayout.NORTH, correoCampo, 35, SpringLayout.NORTH, nombreCampo);
		
		layout.putConstraint(SpringLayout.WEST, usuarioCampo, 0, SpringLayout.WEST, correoCampo);
		layout.putConstraint(SpringLayout.NORTH, usuarioCampo, 35, SpringLayout.NORTH, correoCampo);
		
		layout.putConstraint(SpringLayout.WEST, contraseniaCampo, 0, SpringLayout.WEST, usuarioCampo);
		layout.putConstraint(SpringLayout.NORTH, contraseniaCampo, 35, SpringLayout.NORTH, usuarioCampo);
		
		layout.putConstraint(SpringLayout.WEST, dniCampo, 0, SpringLayout.WEST, contraseniaCampo);
		layout.putConstraint(SpringLayout.NORTH, dniCampo, 35, SpringLayout.NORTH, contraseniaCampo);
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
		
		layout.putConstraint(SpringLayout.WEST, registra, 100, SpringLayout.WEST, DNI);
		layout.putConstraint(SpringLayout.NORTH, registra, 35, SpringLayout.NORTH, DNI);
		
		this.add(label);
		this.add(nombrePanel);
		
		this.add(nombre);
		this.add(correo);
		this.add(usuario);
		this.add(contrasenia);
		this.add(DNI);
		this.add(nombreCampo);
		this.add(correoCampo);
		this.add(usuarioCampo);
		this.add(contraseniaCampo);
		this.add(dniCampo);
		this.add(back);
		this.add(registra);
		}
	
	/**
	 * Setter, establece un controlador para el boton que registra al monitor
	 * 
	 * @param controladorMonitorRegistrado controlador para el boton que registra al monitor
	 */
	public void setControladorMonitorRegistrado(ControlMonitorRegistrado controladorMonitorRegistrado) {
		registra.addActionListener(controladorMonitorRegistrado);
	}
	
	/**
	 * Setter, establece un controlador para el boton de back
	 * 
	 * @param controladorBackRegistroMonitor controlador para el boton de back de esta vista
	 */
	public void setControladorBackRegistroMonitor(ControlBackRegistroMonitor controladorBackRegistroMonitor) {
		back.addActionListener(controladorBackRegistroMonitor);
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el nombre del usuario del monitor
	 */
	public String getUsuario(){
		return this.usuarioCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el correo del monitor 
	 */
	public String getCorreo(){
		return this.correoCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el DNI del monitor
	 */
	public String getDNI(){
		return this.dniCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con la contraseña del monitor
	 */
	public String getContrasenia(){
		return String.valueOf(this.contraseniaCampo.getPassword());
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el nombre del monitor
	 */
	public String getNombre(){
		return this.nombreCampo.getText();
	}
}
