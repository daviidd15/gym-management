package GUI.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import GUI.listeners.admin.ControlBackPrecioTarifas;
import GUI.listeners.admin.ControlBotonCambiarPrecioTarifas;
import gimnasio.Gimnasio;
import tarifas.Tarifa;

/**
 * La clase CambiarPrecioTarifa extiende de JPanel y es utilizada para mostrar
 * la vista del cambio de precio de una tarifa
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class CambiarPrecioTarifa extends JPanel{
	private JLabel nombreTarifa;
	private JLabel costeTarifa;
	private JTextField importe;
	private JButton boton;
	private JButton back;
	private final JComboBox<String> combo;
	private JLabel nombrePanel;
	
	/**
	 * Constructor de la clase CambiarPrecioTarifa
	 * 
	 * inicializa los componentes de la vista
	 */
	public CambiarPrecioTarifa() {
		SpringLayout layout = new SpringLayout(); 
		this.setLayout(layout);
		
		String[] tarifas = {"Tarifa de pago por uso", "Tarifa plana anual", "Tarifa plana trimestral"};
		combo = new JComboBox<String>(tarifas);
		combo.setSelectedIndex(1);
		
		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		
		JLabel label = new JLabel("GIMNASIO LADFIT");
		nombrePanel = new JLabel("Reserva actividad grupal");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);
		
		nombreTarifa = new JLabel("Nombre de la tarifa: ");
		
		costeTarifa = new JLabel("Coste de la tarifa: ");
		
		importe = new JTextField(20);
		importe.setPreferredSize(new Dimension(200, 20));
		
		boton = new JButton("Actualizar tarifa");
		boton.setPreferredSize(new Dimension(200, 40));
		boton.setBackground(Color.LIGHT_GRAY);
		
		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, nombrePanel, 35, SpringLayout.NORTH, label);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombrePanel, 0, SpringLayout.HORIZONTAL_CENTER, label);
		
		
		layout.putConstraint(SpringLayout.NORTH, nombreTarifa, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, nombreTarifa, -50, SpringLayout.WEST, combo);
		
		layout.putConstraint(SpringLayout.WEST, costeTarifa, 0, SpringLayout.WEST, nombreTarifa);
		layout.putConstraint(SpringLayout.NORTH, costeTarifa, 35, SpringLayout.NORTH, nombreTarifa);

		layout.putConstraint(SpringLayout.NORTH, combo, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, combo, 75, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.WEST, importe, 0, SpringLayout.WEST, combo);
		layout.putConstraint(SpringLayout.NORTH, importe, 35, SpringLayout.NORTH, combo);
		
		layout.putConstraint(SpringLayout.WEST, boton, 50, SpringLayout.WEST, costeTarifa);
		layout.putConstraint(SpringLayout.NORTH, boton, 35, SpringLayout.NORTH, costeTarifa);
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
		this.add(label);
		this.add(nombrePanel);
		this.add(nombreTarifa);
		this.add(combo);
		this.add(costeTarifa);
		this.add(importe);
		this.add(boton);
		this.add(back);
	}
	
	/**
	 * Setter, establece un controlador para el boton de back
	 * 
	 * @param controladorBackPrecioTarifas controlador para el boton de back de esta vista
	 */
	public void setControladorBack(ControlBackPrecioTarifas controladorBackPrecioTarifas) {
		back.addActionListener(controladorBackPrecioTarifas);
	}
	
	/**
	 * Setter, establece un controlador para el boton de actualizar la tarifa
	 * 
	 * @param controlador controlador para el boton de actualizar la tarifa
	 */
	public void setControladorBoton(ControlBotonCambiarPrecioTarifas controlador) {
		boton.addActionListener(controlador);
	}
	
	/**
	 * Getter
	 * 
	 * @return Tarifa tarifa seleccionada en el combo box
	 */
	public Tarifa getTarifa() {
		String tarifa = (String)combo.getSelectedItem();
		
		for (Tarifa t: Gimnasio.getGimnasio().getTarifas()) {
			if (t.getNombre().equals(tarifa)) {
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Getter
	 * 
	 * @return double con el coste actualizado de la tarifa
	 */
	public double getCosteTarifa() {
	    return Double.parseDouble(importe.getText());
	}

	
}
