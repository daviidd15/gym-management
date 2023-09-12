package GUI;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GUI.listeners.ControlLoginNormal;
import GUI.listeners.ControlLoginRegistroPanel;

@SuppressWarnings("serial")
/**
 * La clase LoginPanel extiende de JPanel y es utilizada para mostrar
 * la vista del login
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class LoginPanel extends JPanel{
	private JTextField campo;
	private JPasswordField campo2;
	private JButton button;
	private JButton button2;
	
	/**
	 * Constructor de la clase LoginPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public LoginPanel() {
		SpringLayout layout = new SpringLayout(); 
		this.setLayout(layout);
		
		Font font = new Font("Arial", Font.BOLD, 30);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		
		JLabel label = new JLabel("GIMNASIO LADFIT");
		label.setForeground(Color.blue);
		label.setFont(font);
		
		JLabel nombre = new JLabel("Nombre de usuario: ");
		campo = new JTextField(20);
		campo.setPreferredSize(new Dimension(200, 20));
		
		JLabel contrasenia = new JLabel("Contraseña: ");
		/*JLabel ic = new JLabel("");
		this.setBackground(getBackground());
		ImageIcon i = new ImageIcon("./icono.jpg");
		ic.setIcon(i);
		*/
		campo2 = new JPasswordField(20);
		campo2.setPreferredSize(new Dimension(200, 20));
		button = new JButton("Registrarse");
		button.setBackground(Color.LIGHT_GRAY);
	
		
		
		button2 = new JButton("LOGIN");
		button2.setPreferredSize(new Dimension(230, 40));
		button2.setFont(font2);
        
		button2.setBackground(Color.gray);
		button2.setForeground(Color.white);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, -40, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, label, -40, SpringLayout.VERTICAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, nombre, 15, SpringLayout.SOUTH, label);
		layout.putConstraint(SpringLayout.EAST, nombre, -20, SpringLayout.WEST, campo);
		
		layout.putConstraint(SpringLayout.NORTH, contrasenia, 5, SpringLayout.SOUTH, nombre);
		layout.putConstraint(SpringLayout.WEST, contrasenia, 0, SpringLayout.WEST, nombre);
		
		
		
		layout.putConstraint(SpringLayout.EAST, campo, 20, SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, campo, 15, SpringLayout.SOUTH, label);
		
		layout.putConstraint(SpringLayout.WEST, campo2, 0, SpringLayout.WEST, campo);
		layout.putConstraint(SpringLayout.NORTH, campo2, 5, SpringLayout.SOUTH, campo);
		
		
		layout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, contrasenia);
		layout.putConstraint(SpringLayout.NORTH, button, 13, SpringLayout.SOUTH, contrasenia);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button2, 0, SpringLayout.HORIZONTAL_CENTER, label);
		//layout.putConstraint(SpringLayout.WEST, button2, 0, SpringLayout.WEST, button);
		layout.putConstraint(SpringLayout.NORTH, button2, 13, SpringLayout.SOUTH, button);
		
		
		this.add(label);
		this.add(nombre);		
		this.add(campo);
		this.add(contrasenia);
		this.add(campo2);
		this.add(button);
		this.add(button2);
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el nombre de usuario que inicia sesion
	 */
	 public String getNombreUsuario () {
		 return campo.getText();
	}
	 
	/**
	 * Getter
	 * 
	 * @return char[] con la contraseña del usuario que inicia sesion
	 */
	public char[] getContrasenia() {
		return campo2.getPassword();
	}

	/**
	 * Setter, establece un controlador para el boton de registrarse
	 * 
	 * @param controladorRegistroLogin controlador para el boton de registro
	 */
	public void setControladorRegistro(ControlLoginRegistroPanel controladorRegistroLogin) {
		button.addActionListener(controladorRegistroLogin);
	}
	
	/**
	 * Setter, establece un controlador para el boton de login
	 * 
	 * @param controladorLoginNormal controlador para el boton de login
	 */
	public void setControladorActividades(ControlLoginNormal controladorLoginNormal) {
		button2.addActionListener(controladorLoginNormal);
	}
	 
}
