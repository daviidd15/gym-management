package GUI.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalTime;

import javax.swing.*;

import GUI.listeners.admin.*;
import gimnasio.Gimnasio;
import gimnasio.Sala;
import gimnasio.SalaCompuesta;

/**
 * La clase SalasPanel extiende de JPanel y es utilizada para mostrar
 * la vista de la creacion de salas
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class SalasPanel extends JPanel {
	private JButton back;
	private final JComboBox<String> salasCombo;
	private final JComboBox<String> salasCombo2;

	private JButton crear;
	private JTextField aforoCampo;
	private JTextField descripcionCampo;
	private JTextField nombreCampo;
	private JRadioButton climatizada;
	private SpringLayout layout;
	private final JComboBox<String> horaCombo;
	private final JComboBox<String> minutoCombo;
	private final JComboBox<String> horaFinCombo;
	private final JComboBox<String> minutoFinCombo;

	/**
	 * Constructor de la clase SalasPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public SalasPanel() {
		layout = new SpringLayout();
		this.setLayout(layout);

		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		JLabel label = new JLabel("GIMNASIO LADFIT");
		JLabel nombrePanel = new JLabel("Creación de salas");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);

		JLabel label1 = new JLabel("Tipo de sala a definir: ");

		String[] salas = { "Sala simple", "Sala compuesta" };
		salasCombo = new JComboBox<String>(salas);
		salasCombo.setSelectedIndex(0);

		JLabel label2 = new JLabel(
				"Si es una sala dentro de otra sala, seleccione la sala compuesta de la que deriva: ");

		String[] salasDefinidas = { "No tiene" };
		salasCombo2 = new JComboBox<String>(salasDefinidas);
		salasCombo2.setSelectedItem(0);

		JLabel nombre = new JLabel("Nombre: ");
		JLabel descripcion = new JLabel("Descripción: ");
		JLabel aforo = new JLabel("Aforo: ");

		nombreCampo = new JTextField(10);
		aforoCampo = new JTextField(10);
		descripcionCampo = new JTextField(10);

		climatizada = new JRadioButton("Sala climatizada");
		climatizada.setSelected(false);


		String[] horas = { "HH", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23" };

		JLabel horaInicio = new JLabel("Hora de inicio: ");
		horaCombo = new JComboBox(horas);
		horaCombo.setSelectedIndex(0);

		String minutos[] = { "mm", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47",
				"48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" };
		minutoCombo = new JComboBox(minutos);
		minutoCombo.setSelectedIndex(0);

		JLabel horaFin = new JLabel("Hora de fin: ");
		horaFinCombo = new JComboBox(horas);
		horaFinCombo.setSelectedIndex(0);

		minutoFinCombo = new JComboBox(minutos);
		minutoFinCombo.setSelectedIndex(0);

		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		crear = new JButton("Crear sala");
		crear.setBackground(Color.LIGHT_GRAY);
		
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);

		layout.putConstraint(SpringLayout.NORTH, nombrePanel, 55, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombrePanel, 0, SpringLayout.HORIZONTAL_CENTER, this);

		layout.putConstraint(SpringLayout.WEST, nombre, -500, SpringLayout.WEST, nombreCampo);
		layout.putConstraint(SpringLayout.NORTH, nombre, 200, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, descripcion, 0, SpringLayout.WEST, nombre);
		layout.putConstraint(SpringLayout.NORTH, descripcion, 35, SpringLayout.NORTH, nombre);

		layout.putConstraint(SpringLayout.WEST, label1, 0, SpringLayout.WEST, descripcion);
		layout.putConstraint(SpringLayout.NORTH, label1, 35, SpringLayout.NORTH, descripcion);

		layout.putConstraint(SpringLayout.WEST, label2, 0, SpringLayout.WEST, label1);
		layout.putConstraint(SpringLayout.NORTH, label2, 35, SpringLayout.NORTH, label1);

		layout.putConstraint(SpringLayout.WEST, climatizada, 0, SpringLayout.WEST, label2);
		layout.putConstraint(SpringLayout.NORTH, climatizada, 35, SpringLayout.NORTH, label2);

		layout.putConstraint(SpringLayout.WEST, horaInicio, 0, SpringLayout.WEST, climatizada);
		layout.putConstraint(SpringLayout.NORTH, horaInicio, 35, SpringLayout.NORTH, climatizada);

		layout.putConstraint(SpringLayout.WEST, horaFin, 0, SpringLayout.WEST, horaInicio);
		layout.putConstraint(SpringLayout.NORTH, horaFin, 35, SpringLayout.NORTH, horaInicio);

		layout.putConstraint(SpringLayout.WEST, aforo, 0, SpringLayout.WEST, horaFin);
		layout.putConstraint(SpringLayout.NORTH, aforo, 35, SpringLayout.NORTH, horaFin);

		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombreCampo, 200, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, nombreCampo, 200, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, descripcionCampo, 0, SpringLayout.WEST, nombreCampo);
		layout.putConstraint(SpringLayout.NORTH, descripcionCampo, 35, SpringLayout.NORTH, nombreCampo);

		layout.putConstraint(SpringLayout.WEST, salasCombo, 0, SpringLayout.WEST, descripcionCampo);
		layout.putConstraint(SpringLayout.NORTH, salasCombo, 35, SpringLayout.NORTH, descripcionCampo);

		layout.putConstraint(SpringLayout.WEST, salasCombo2, 0, SpringLayout.WEST, salasCombo);
		layout.putConstraint(SpringLayout.NORTH, salasCombo2, 65, SpringLayout.NORTH, salasCombo);

		layout.putConstraint(SpringLayout.WEST, horaCombo, 0, SpringLayout.WEST, salasCombo2);
		layout.putConstraint(SpringLayout.NORTH, horaCombo, 45, SpringLayout.NORTH, salasCombo2);

		layout.putConstraint(SpringLayout.WEST, minutoCombo, 50, SpringLayout.WEST, horaCombo);
		layout.putConstraint(SpringLayout.NORTH, minutoCombo, 45, SpringLayout.NORTH, salasCombo2);

		layout.putConstraint(SpringLayout.WEST, horaFinCombo, 0, SpringLayout.WEST, horaCombo);
		layout.putConstraint(SpringLayout.NORTH, horaFinCombo, 45, SpringLayout.NORTH, horaCombo);

		layout.putConstraint(SpringLayout.WEST, minutoFinCombo, 50, SpringLayout.WEST, horaFinCombo);
		layout.putConstraint(SpringLayout.NORTH, minutoFinCombo, 45, SpringLayout.NORTH, horaCombo);

		layout.putConstraint(SpringLayout.WEST, aforoCampo, 0, SpringLayout.WEST, horaFinCombo);
		layout.putConstraint(SpringLayout.NORTH, aforoCampo, 45, SpringLayout.NORTH, horaFinCombo);

		layout.putConstraint(SpringLayout.WEST, crear, 205, SpringLayout.WEST, aforo);
		layout.putConstraint(SpringLayout.NORTH, crear, 75, SpringLayout.NORTH, aforo);

		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
		
		
		
		this.add(label);
		this.add(nombrePanel);
		this.add(nombre);
		this.add(descripcion);
		this.add(label1);
		this.add(label2);
		this.add(climatizada);
		this.add(horaInicio);
		this.add(horaFin);
		this.add(aforo);
		this.add(nombreCampo);
		this.add(descripcionCampo);
		this.add(salasCombo);
		this.add(salasCombo2);
		this.add(horaCombo);
		this.add(minutoCombo);
		this.add(horaFinCombo);
		this.add(minutoFinCombo);
		this.add(aforoCampo);
		this.add(back);
		this.add(crear);
	}
	
	/**
	 * Setter, establece un controlador para el boton de back
	 * 
	 * @param controladorBackSalas controlador para el boton de back
	 */
	public void setControladorBackSalas(ControlBackSalas controladorBackSalas) {
		back.addActionListener(controladorBackSalas);
	}
	
	/**
	 * Setter, establece un controlador para el boton de crear
	 * 
	 * @param controladorCrearSalas controlador para el boton de crear
	 */
	public void setControladorCrear(ControlCrearSalas controladorCrearSalas) {
		crear.addActionListener(controladorCrearSalas);
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el nombre de la sala
	 */
	public String getNombre() {
		return nombreCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con la descripcion de la sala
	 */
	public String getDescripcion() {
		return descripcionCampo.getText();
	}

	/**
	 * Getter
	 * 
	 * @return String con el aforo de la sala
	 */
	public String getAforo() {
		return aforoCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return true si la sala esta climatizada o false en caso contrario
	 */
	public boolean getClimatizacion() {
		return climatizada.isSelected();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con la hora de inicio de climatizacion
	 */
	public String getHoraInicioClima() {
		return (String) horaCombo.getSelectedItem();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el minuto de inicio de climatizacion
	 */
	public String getMinutoInicioClima() {
		return (String) minutoCombo.getSelectedItem();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con la hora de fin de climatizacion
	 */
	public String getHoraFinClima() {
		return (String) horaFinCombo.getSelectedItem();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el minuto de fin de climatizacion
	 */
	public String getMinutoFinClima() {
		return (String) minutoFinCombo.getSelectedItem();
	}

	/**
	 * Getter
	 * 
	 * @return String con el tipo de sala 
	 */
	public String getTipoSala() {
		return (String) salasCombo.getSelectedItem();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con la sala padre en caso de que sea una sala compuesta
	 * o No tiene en caso de que no sea compuesta
	 */
	public String getSalaPadre() {
		return (String) salasCombo2.getSelectedItem();
	}
	
	/**
	 * Setter que establece la lista de salas compuestas
	 * 
	 * @param salas lista de salas compuestas actualizada
	 */
	public void setSalasCompuestas(String[] salas) {

		this.remove(salasCombo2);
		this.salasCombo2.removeAllItems();
		salasCombo2.addItem("No tiene");
		for (int i = 0; i < salas.length; i++) {
			salasCombo2.addItem(salas[i]);
		}
		layout.putConstraint(SpringLayout.WEST, salasCombo2, 0, SpringLayout.WEST, this.salasCombo);
		layout.putConstraint(SpringLayout.NORTH, salasCombo2, 25, SpringLayout.SOUTH, this.salasCombo);

		this.add(salasCombo2);
	}

}
