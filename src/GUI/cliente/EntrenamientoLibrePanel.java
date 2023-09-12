package GUI.cliente;

import java.awt.*;
import java.time.LocalTime;

import javax.swing.*;



import GUI.listeners.cliente.*;

/**
 * La clase EntrenamientoLibrePanel extiende de JPanel y es utilizada para mostrar
 * la vista de la reserva de entrenamientos libres
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class EntrenamientoLibrePanel extends JPanel{
	private JButton back;
	private JButton reservar;
	private final JComboBox<String> comboDias;
	private final JComboBox<String> comboHora;
	private final JComboBox<String>mesCombo;
	private final JComboBox<String>minutoCombo;
	private JLabel nombrePanel;
	
	/**
	 * Constructor de la clase EntrenamientoLibrePanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public EntrenamientoLibrePanel() {
		SpringLayout layout = new SpringLayout(); 
		this.setLayout(layout);
		
		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		
		JLabel label = new JLabel("GIMNASIO LADFIT");
		nombrePanel = new JLabel("Reserva entrenamiento libre");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);

		String[] dias = {"dd", "1", "2", "3", "4", "5", "6", "7",  "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19","20", "21", "22", "23", "24", "25", "25", "26", "27", "28", "29", "30"};
		comboDias = new JComboBox<String>(dias);
		comboDias.setSelectedIndex(0);
		
		String[] horas = {"hh", "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
		
		
		comboHora = new JComboBox<String>(horas);
		comboHora.setSelectedIndex(0);
		
		String [] meses = {"mm", "1", "2", "3", "4", "5", "6", "7",  "8", "9", "10", "11", "12"};
	
		mesCombo = new JComboBox<String>(meses);
		mesCombo.setSelectedIndex(0);
        
		String minutos[]= {"mm","00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
		minutoCombo = new JComboBox<String>(minutos);
		minutoCombo.setSelectedIndex(0);
		
		reservar = new JButton("Reservar");
		reservar.setPreferredSize(new Dimension(250, 30));
		reservar.setBackground(Color.LIGHT_GRAY);
		
		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, nombrePanel, 35, SpringLayout.NORTH, label);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombrePanel, 0, SpringLayout.HORIZONTAL_CENTER, label);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, comboDias, -100, SpringLayout.HORIZONTAL_CENTER, nombrePanel); 
		layout.putConstraint(SpringLayout.NORTH, comboDias, 70, SpringLayout.NORTH, nombrePanel);
		
		layout.putConstraint(SpringLayout.WEST, mesCombo, 55, SpringLayout.WEST, comboDias); 
		layout.putConstraint(SpringLayout.NORTH, mesCombo, 70, SpringLayout.NORTH, nombrePanel);
		
		layout.putConstraint(SpringLayout.WEST, comboHora, 55, SpringLayout.WEST, mesCombo); 
		layout.putConstraint(SpringLayout.NORTH, comboHora, 70, SpringLayout.NORTH, nombrePanel);

		layout.putConstraint(SpringLayout.WEST, minutoCombo, 55, SpringLayout.WEST, comboHora); 
		layout.putConstraint(SpringLayout.NORTH, minutoCombo, 70, SpringLayout.NORTH, nombrePanel);
		

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, reservar, 0, SpringLayout.HORIZONTAL_CENTER, this); 
		layout.putConstraint(SpringLayout.NORTH, reservar, 130, SpringLayout.NORTH, nombrePanel);
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
        
        this.add(label);
        this.add(nombrePanel);
        
        this.add(comboDias);
		this.add(mesCombo);
		
		this.add(comboHora);
		this.add(minutoCombo);
		
		this.add(reservar);
		this.add(back);
	}
	
	/**
	 * Setter, establece un controlador para el boton de back
	 * 
	 * @param controladorBackEntrenamientoLibre controlador para el botón de back en esta vista 
	 */
	public void setControladorBack(ControlBackEntrenamientoLibre controladorBackEntrenamientoLibre) {
		back.addActionListener(controladorBackEntrenamientoLibre);
	}
	
	/**
	 * Setter, establece un controlador para el boton de reservar
	 * 
	 * @param controlador controlador para el boton de reservar en esta vista
	 */
	public void setControladorReserva(ControlBotonReservaEntrenamientoLibre controlador) {
		reservar.addActionListener(controlador);
	}
	
	/**
	 * Getter
	 * 
	 * @return int con la hora obtenida del combo box
	 */
	public int getComboHora() {
		return Integer.parseInt((String)comboHora.getSelectedItem());
	}
	
	/**
	 * Getter
	 * 
	 * @return int con los minutos obtenidos del combo box
	 */
	public int getComboMinutos() {
		return Integer.parseInt((String)minutoCombo.getSelectedItem());
	}
	

}
