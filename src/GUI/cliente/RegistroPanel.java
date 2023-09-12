package GUI.cliente;

import java.awt.*;
import java.util.List;
import gimnasio.*;
import tarifas.*;
import java.time.LocalDate;

import javax.swing.*;

import GUI.listeners.ControlRegistro;
import GUI.listeners.cliente.*;

@SuppressWarnings("serial")
/**
 * La clase RegistroPanel extiende de JPanel y es utilizada para mostrar
 * el registro de un cliente
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class RegistroPanel extends JPanel{
	private JLabel etiqueta;
	private JTextField campo;
	private JLabel etiqueta2;
	private JTextField campo2;
	private JLabel etiqueta3;
	private JTextField campo3;
	private JLabel etiqueta4;
	private JTextField campo4;
	private JLabel etiqueta5;
	private JPasswordField campo5;
	private JLabel etiqueta6;
	private JTextField campo6;
	private JLabel etiqueta7;
	private JTextField campo7;
	private JLabel etiqueta8;
	private JTextField campo8;
	private JLabel tarifa;
	private final JComboBox<String> tarifaCombo;
	private SpringLayout layout;
	private JButton back;
	private JButton registrarse;
	
	/**
	 * Constructor de la clase RegistroPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public RegistroPanel() {
		layout = new SpringLayout(); 
		this.setLayout(layout);
		
		String[] tarifas = {"Tarifa Pago por uso"};
		
		this.tarifa = new JLabel("Tarifa: ");
		tarifaCombo = new JComboBox<String>(tarifas);
		tarifaCombo.setSelectedIndex(0);
	
		
		
		etiqueta = new JLabel("Nombre: ");
		campo = new JTextField(10);
		
		etiqueta2 = new JLabel("Numero de telefono: ");
		campo2 = new JTextField(10);
		
		etiqueta3 = new JLabel("Fecha de nacimiento(dd/mm/aaaa): ");
		campo3 = new JTextField(10);
		
		etiqueta4 = new JLabel("Usuario: ");
		campo4 = new JTextField(10);
		
		etiqueta5 = new JLabel("Contraseña: ");
		campo5 = new JPasswordField(10);
		
		etiqueta6 = new JLabel("Nombre del titular: ");
		campo6 = new JTextField(10);
		
		etiqueta7 = new JLabel("Numero de la tarjeta: ");
		campo7 = new JTextField(10);
		
		etiqueta8 = new JLabel("Pin: ");
		campo8 = new JTextField(10);
		
		
		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		registrarse = new JButton("      Registrarse      "); 
		registrarse.setBackground(Color.LIGHT_GRAY);
	
		
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, etiqueta, -150, SpringLayout.WEST, campo);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta2, 0, SpringLayout.WEST, etiqueta);
		layout.putConstraint(SpringLayout.NORTH, etiqueta2, 35, SpringLayout.NORTH, etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta3, 0, SpringLayout.WEST, etiqueta2);
		layout.putConstraint(SpringLayout.NORTH, etiqueta3, 35, SpringLayout.NORTH, etiqueta2);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta4, 0, SpringLayout.WEST, etiqueta3);
		layout.putConstraint(SpringLayout.NORTH, etiqueta4, 35, SpringLayout.NORTH, etiqueta3);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta5, 0, SpringLayout.WEST, etiqueta4);
		layout.putConstraint(SpringLayout.NORTH, etiqueta5, 35, SpringLayout.NORTH, etiqueta4);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta6, 0, SpringLayout.WEST, etiqueta5);
		layout.putConstraint(SpringLayout.NORTH, etiqueta6, 35, SpringLayout.NORTH, etiqueta5);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta7, 0, SpringLayout.WEST, etiqueta6);
		layout.putConstraint(SpringLayout.NORTH, etiqueta7, 35, SpringLayout.NORTH, etiqueta6);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta8, 0, SpringLayout.WEST, etiqueta7);
		layout.putConstraint(SpringLayout.NORTH, etiqueta8, 35, SpringLayout.NORTH, etiqueta7);
		
		
		layout.putConstraint(SpringLayout.NORTH, campo, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, campo, 50, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.WEST, campo2, 0, SpringLayout.WEST, campo);
		layout.putConstraint(SpringLayout.NORTH, campo2, 35, SpringLayout.NORTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, campo3, 0, SpringLayout.WEST, campo2);
		layout.putConstraint(SpringLayout.NORTH, campo3, 35, SpringLayout.NORTH, campo2);
		
		layout.putConstraint(SpringLayout.WEST, campo4, 0, SpringLayout.WEST, campo3);
		layout.putConstraint(SpringLayout.NORTH, campo4, 35, SpringLayout.NORTH, campo3);
		
		
		layout.putConstraint(SpringLayout.WEST, campo5, 0, SpringLayout.WEST, campo4);
		layout.putConstraint(SpringLayout.NORTH, campo5, 35, SpringLayout.NORTH, campo4);
		
		layout.putConstraint(SpringLayout.WEST, campo6, 0, SpringLayout.WEST, campo5);
		layout.putConstraint(SpringLayout.NORTH, campo6, 35, SpringLayout.NORTH, campo5);
		
		layout.putConstraint(SpringLayout.WEST, campo7, 0, SpringLayout.WEST, campo6);
		layout.putConstraint(SpringLayout.NORTH, campo7, 35, SpringLayout.NORTH, campo6);
		
		layout.putConstraint(SpringLayout.WEST, campo8, 0, SpringLayout.WEST, campo7);
		layout.putConstraint(SpringLayout.NORTH, campo8, 35, SpringLayout.NORTH, campo7);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.tarifa, 0, SpringLayout.HORIZONTAL_CENTER, etiqueta8);
		layout.putConstraint(SpringLayout.NORTH, this.tarifa, 25, SpringLayout.SOUTH, etiqueta8);
		
		layout.putConstraint(SpringLayout.WEST, tarifaCombo, 0, SpringLayout.WEST, this.tarifa);
		layout.putConstraint(SpringLayout.NORTH, tarifaCombo, 25, SpringLayout.SOUTH, this.tarifa);
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, registrarse, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, registrarse, 50, SpringLayout.SOUTH, this.tarifa);
		
		this.add(etiqueta); 
		this.add(campo);
		
		this.add(etiqueta2); 
		this.add(campo2);
		
		this.add(etiqueta3);
		this.add(campo3);
		
		this.add(etiqueta4);
		this.add(campo4);
		
		this.add(etiqueta5);
		this.add(campo5);
		
		this.add(etiqueta6);
		this.add(campo6);
		
		this.add(etiqueta7);
		this.add(campo7);
		
		this.add(etiqueta8);
		this.add(campo8);
		
		this.add(this.tarifa);
		this.add(tarifaCombo);
		
		this.add(back);
		this.add(registrarse);
	}
	
	/**
	 * Setter, establece un controlador para el boton registrarse
	 * 
	 * @param controladorRegistro controlador para el boton registrarse
	 */
	public void setControladorRegistro(ControlRegistro controladorRegistro) {
		registrarse.addActionListener(controladorRegistro);
	}
	
	/**
	 * Setter, establece un controlador para el boton back
	 * 
	 * @param controladorBack controlador para el boton de back en esta vista
	 */
	public void setControladorBack(ControlBackRegistro controladorBack) {
		back.addActionListener(controladorBack);
	}
	
	/**
	 * Setter, establece la lista de tarifas para el combo box
	 * 
	 * @param tarifas String con la lista de tarifas
	 */
	public void setTarifasList(String [] tarifas){
		this.remove(tarifaCombo);
		this.tarifaCombo.removeAllItems();
		tarifaCombo.addItem("Tarifa Pago por uso");
		for(int i=0; i< tarifas.length; i++){
			tarifaCombo.addItem(tarifas[i]);
		}
		layout.putConstraint(SpringLayout.WEST, tarifaCombo, 0, SpringLayout.WEST, campo8);
		layout.putConstraint(SpringLayout.NORTH, tarifaCombo, 35, SpringLayout.NORTH,campo8);
		this.add(tarifaCombo);
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el nombre de usuario
	 */
	public String getUsuario() {
		return campo4.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el nombre del cliente
	 */
	public String getNombre() {
		return campo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el telefono del cliente
	 */
	public String getTelefono() {
		return campo2.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return LocalDate con la fecha de nacimiento del cliente
	 */
	public LocalDate getFechaNacimiento() {
		String dia = campo3.getText().substring(0,2);
		String mes = campo3.getText().substring(3, 5);
		String anio = campo3.getText().substring(6, 10);
		System.out.println(dia +" "+ mes + " "+ anio);
		return LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
	}
	
	/**
	 * Getter
	 * 
	 * @return String con la tarifa que ha seleccionado el cliente en el combo box
	 */
	public String getTarifa(){
		return (String)tarifaCombo.getSelectedItem();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con la contraseña del cliente
	 */
	public String getContrasenia() {
		return String.valueOf(campo5.getPassword());
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el nombre del titular de la tarjeta
	 */
	public String nombreTitular() {
		return campo6.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el numero de la tarjeta 
	 */
	public String getNumeroTarjeta() {
		return campo7.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el pin de la tarjeta
	 */
	public String getPin() {
		return campo8.getText();
	}
	
}
