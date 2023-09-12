package GUI.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import GUI.listeners.admin.ControlBackAdminEntrenaiento;
import GUI.listeners.admin.ControlBackCrearSesionActividades;
import GUI.listeners.admin.ControlCrearSesionActividad;
import GUI.listeners.admin.ControlCrearSesionEntrenamiento;
import gimnasio.Sala;
import gimnasio.SalaSimple;

/**
 * La clase AdministradorEntrenamientoLibre extiende de JPanel y es utilizada para mostrar
 * la vista de creacion de una sesion de un entrenamiento libre
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class AdministradorEntrenamientoLibre extends JPanel{
	private JComboBox<String> salaCombo;
	private JComboBox<String> horaFinCombo;
	private SpringLayout layout;
	private JButton back;
	private JButton crear;
	private final JComboBox<String> diaCombo;
	private final JComboBox<String> mesCombo;
	private final JComboBox<String> anioCombo;
	private final JComboBox<String> horaCombo;
	private final JComboBox<String> minutoCombo;
	private final JComboBox<String> minutoFinCombo ;
	
	/**
	 * Constructor de la clase AdministradorEntrenamientoLibre
	 * 
	 * inicializa los componentes de la vista
	 */
	public AdministradorEntrenamientoLibre() {
		
		layout = new SpringLayout();
		this.setLayout(layout);

		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		JLabel label = new JLabel("GIMNASIO LADFIT");
		JLabel nombrePanel = new JLabel("Creación Sesion de Entrenamiento Libre");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);
		
		String[] dias = {"dd","1", "2", "3", "4", "5", "6", "7",  "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19","20", "21", "22", "23", "24", "25", "25", "26", "27", "28", "29", "30"};
		String [] meses = {"mm", "1", "2", "3", "4", "5", "6", "7",  "8", "9", "10", "11", "12"};
		String[] anios = {"aaaa","2023", "2024", "2025"};
		JLabel dia = new JLabel("Día: ");
		diaCombo = new JComboBox(dias);
		diaCombo.setSelectedIndex(0);
		
		JLabel mes = new JLabel("Mes: ");
		mesCombo = new JComboBox(meses);
		mesCombo.setSelectedIndex(0);
		
		JLabel anio = new JLabel("Año: ");
		anioCombo = new JComboBox(anios);
		anioCombo.setSelectedIndex(0);
		
		String[] horas = {"HH","00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
		
		JLabel horaInicio = new JLabel("Hora de inicio: ");
		horaCombo = new JComboBox(horas);
		horaCombo.setSelectedIndex(0);
		
		String minutos[]= {"mm","00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
		minutoCombo = new JComboBox(minutos);
		minutoCombo.setSelectedIndex(0);
		
		JLabel horaFin = new JLabel("Hora de fin: ");
		horaFinCombo = new JComboBox(horas);
		horaFinCombo.setSelectedIndex(0);
		
		minutoFinCombo = new JComboBox(minutos);
		minutoFinCombo.setSelectedIndex(0);
		
		String ejSalas[]= {"Sin salas disponibles"};
		JLabel sala = new JLabel("Sala: ");
		salaCombo = new JComboBox(ejSalas);
		salaCombo.setSelectedIndex(0);
		
		
		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		crear = new JButton("Crear");
		crear.setPreferredSize(new Dimension(200, 20));
		crear.setBackground(Color.LIGHT_GRAY);
		
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, nombrePanel, 55, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombrePanel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, dia, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, dia, -150, SpringLayout.WEST, diaCombo);
		
		layout.putConstraint(SpringLayout.WEST, mes, 0, SpringLayout.WEST, dia);
		layout.putConstraint(SpringLayout.NORTH, mes, 35, SpringLayout.NORTH, dia);
		
		layout.putConstraint(SpringLayout.WEST, anio, 0, SpringLayout.WEST, mes);
		layout.putConstraint(SpringLayout.NORTH, anio, 35, SpringLayout.NORTH, mes);
		
		layout.putConstraint(SpringLayout.WEST, horaInicio, 0, SpringLayout.WEST, anio);
		layout.putConstraint(SpringLayout.NORTH, horaInicio, 35, SpringLayout.NORTH, anio);
		
		layout.putConstraint(SpringLayout.WEST, horaFin, 0, SpringLayout.WEST, horaInicio);
		layout.putConstraint(SpringLayout.NORTH, horaFin, 35, SpringLayout.NORTH, horaInicio);
		
		layout.putConstraint(SpringLayout.WEST, sala, 0, SpringLayout.WEST, horaFin);
		layout.putConstraint(SpringLayout.NORTH, sala, 35, SpringLayout.NORTH, horaFin);
	
		
		layout.putConstraint(SpringLayout.NORTH, diaCombo, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, diaCombo, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.WEST, mesCombo, 0, SpringLayout.WEST, diaCombo);
		layout.putConstraint(SpringLayout.NORTH, mesCombo, 35, SpringLayout.NORTH, diaCombo);
		
		layout.putConstraint(SpringLayout.WEST, anioCombo, 0, SpringLayout.WEST, mesCombo);
		layout.putConstraint(SpringLayout.NORTH, anioCombo, 35, SpringLayout.NORTH, mesCombo);
		
		layout.putConstraint(SpringLayout.WEST, horaCombo, 0, SpringLayout.WEST, anioCombo);
		layout.putConstraint(SpringLayout.NORTH, horaCombo, 35, SpringLayout.NORTH, anioCombo);
		
		layout.putConstraint(SpringLayout.WEST, minutoCombo, 100, SpringLayout.WEST, horaCombo);
		layout.putConstraint(SpringLayout.NORTH, minutoCombo, 0, SpringLayout.NORTH, horaCombo);
		
		layout.putConstraint(SpringLayout.WEST, horaFinCombo, 0, SpringLayout.WEST, horaCombo);
		layout.putConstraint(SpringLayout.NORTH, horaFinCombo, 35, SpringLayout.NORTH, horaCombo);
		
		layout.putConstraint(SpringLayout.WEST, minutoFinCombo, 100, SpringLayout.WEST, horaFinCombo);
		layout.putConstraint(SpringLayout.NORTH, minutoFinCombo, 0, SpringLayout.NORTH, horaFinCombo);
		
		layout.putConstraint(SpringLayout.WEST, salaCombo, 0, SpringLayout.WEST, horaFinCombo);
		layout.putConstraint(SpringLayout.NORTH, salaCombo, 35, SpringLayout.NORTH, horaFinCombo);
		
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
		
		layout.putConstraint(SpringLayout.WEST, crear, 80, SpringLayout.WEST, horaFin);
		layout.putConstraint(SpringLayout.NORTH, crear, 40, SpringLayout.NORTH, salaCombo);
		
		this.add(label);
		this.add(nombrePanel);
		this.add(dia);
		this.add(mes);
		this.add(anio);
		this.add(horaInicio);
		this.add(horaFin);
		this.add(sala);
		this.add(diaCombo);
		this.add(mesCombo);
		this.add(anioCombo);
		this.add(horaCombo);
		this.add(minutoCombo);
		this.add(horaFinCombo);
		this.add(minutoFinCombo);
		this.add(salaCombo);
		this.add(back);
		this.add(crear);
	}
	
	
	/**
	 * Setter que establece la lista de salas simples
	 * 
	 * @param salas lista de salas simples actualizada
	 */
	public void setSalas(List<SalaSimple> salas) {

		if(salas.size()==0){
			return;
		}
		this.remove(salaCombo);
		this.salaCombo.removeAllItems();
		
		for(Sala s: salas){
			salaCombo.addItem(s.getNombre());
		}
		
		layout.putConstraint(SpringLayout.WEST, salaCombo, 0, SpringLayout.WEST, this.horaFinCombo);
		layout.putConstraint(SpringLayout.NORTH, salaCombo, 35, SpringLayout.SOUTH, this.horaFinCombo);

		this.add(salaCombo);
	}
	
	/**
	 * Setter, establece un controlador para el boton de back
	 * 
	 * @param control controlador para el boton de back 
	 */
	public void setControlBackAdminEntrenaiento(ControlBackAdminEntrenaiento control) {
		this.back.addActionListener(control);
	}
	
	
	/**
	 * Setter, establece un controlador para el boton de crear
	 * 
	 * @param control controlador para el boton de crear
	 */
	public void setControlCrearSesionEntrenamiento(ControlCrearSesionEntrenamiento control){
		this.crear.addActionListener(control);
	}
	
	/**
	 * Getter 
	 * 
	 * @return String con la hora en la que empieza la sesion
	 */
	public String getHoraInicio(){
		return this.horaCombo.getSelectedItem().toString();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el minuto en el que empieza la sesion
	 */
	public String getMinutoInicio(){
		return this.minutoCombo.getSelectedItem().toString();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el dia en el que efectuara la sesion
	 */
	public String getDiaCombo(){
		return this.diaCombo.getSelectedItem().toString();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el mes en el que se efectuara la sesion
	 */
	public String getMesCombo(){
		return this.mesCombo.getSelectedItem().toString();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el año en el que se efectuara la sesion
	 */
	public String getAnioCombo(){
		return this.anioCombo.getSelectedItem().toString();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con la hora en la que finalizara la sesion
	 */
	public String getHoraFin(){
		return this.horaFinCombo.getSelectedItem().toString();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el minuto en el que finalizara la sesion
	 */
	public String getMinutoFin(){
		return this.minutoFinCombo.getSelectedItem().toString();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con la sala en la que se impartira la sesion
	 */
	public String getSala(){
		return this.salaCombo.getSelectedItem().toString();
	}
	
}
