package GUI.cliente;

import java.awt.*;

import javax.swing.*;
import java.util.*;
import java.util.List;

import GUI.listeners.cliente.*;
import actividades.ActividadGrupal;
import gimnasio.Gimnasio;

/**
 * La clase ActividadGrupalPanel extiende de JPanel y es utilizada para mostrar
 * la vista de la reserva de actividades grupales
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ActividadGrupalPanel extends JPanel{
	private JButton reservar;
	private JButton back;
	private JComboBox<String> combo3;
	private final JComboBox<String> comboDias;
	private final JComboBox<String> comboHora;
	private final JComboBox<String>mesCombo;
	private final JComboBox<String>minutoCombo;
	private SpringLayout layout;
	private String etiqueta3;
	private JLabel nombrePanel;
	private JButton recargarActividades;
	private JLabel explicacion;
	
	/**
	 * Constructor de la clase ActividadGrupalPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public ActividadGrupalPanel(){
		layout = new SpringLayout(); 
		this.setLayout(layout);
	
		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		
		//Font font3 = new Font("Courier New", Font.BOLD, 13);
		
		JLabel label = new JLabel("GIMNASIO LADFIT");
		nombrePanel = new JLabel("Reserva actividad grupal");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);
		
		explicacion = new JLabel("Pulse recargar para ver las actividades que hay disponibles a esa hora");
		String[] actividadesgrupales = {"No hay actividades disponibles para esa fecha"};
		
		combo3 = new JComboBox<String>(actividadesgrupales);
		combo3.setSelectedIndex(0);
		
		
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
		
		recargarActividades = new JButton("Recargar actividades");
		recargarActividades.setPreferredSize(new Dimension(250, 30));
		recargarActividades.setBackground(Color.LIGHT_GRAY);
		
		reservar = new JButton("Reservar");
		reservar.setPreferredSize(new Dimension(250, 30));
		reservar.setBackground(Color.LIGHT_GRAY);
		
		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		//back.setFont(font3);
		
		
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
		
		layout.putConstraint(SpringLayout.WEST, explicacion, 0, SpringLayout.WEST, comboDias); 
		layout.putConstraint(SpringLayout.NORTH, explicacion, 50, SpringLayout.NORTH, comboDias);
		
		layout.putConstraint(SpringLayout.WEST, recargarActividades, 0, SpringLayout.WEST, explicacion); 
		layout.putConstraint(SpringLayout.NORTH, recargarActividades, 50, SpringLayout.NORTH, explicacion);
		
		layout.putConstraint(SpringLayout.WEST, combo3, 0, SpringLayout.WEST, recargarActividades); 
		layout.putConstraint(SpringLayout.NORTH, combo3, 50, SpringLayout.NORTH, recargarActividades);
		
		
		layout.putConstraint(SpringLayout.WEST, reservar, 0, SpringLayout.WEST, combo3); 
		layout.putConstraint(SpringLayout.NORTH, reservar, 50, SpringLayout.NORTH, combo3);
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
        
        this.add(label);
        this.add(nombrePanel);
        
		this.add(comboDias);
		this.add(mesCombo);
		
		this.add(comboHora);
		this.add(minutoCombo);
		
		this.add(explicacion);
		this.add(recargarActividades);
		this.add(combo3);
		
		
		
		this.add(reservar);
		this.add(back);
	}

	/**
	 * Setter, establece un controlador para el boton de reservar
	 * 
	 * @param contBotonReservaGrupal Controlador para el botón de reserva 
	 */
	public void setControladorBotonReserva(ControlBotonReservaActividadGrupal contBotonReservaGrupal) {
		reservar.addActionListener(contBotonReservaGrupal);
	}
	
	/**
	 * Setter, establece un controlador para el boton de back
	 * 
	 * @param controladorBackActividad controlador para el botón de back
	 */
	public void serControladorBackActividadGrupal(ControlBackActividadGrupal controladorBackActividad) {
		back.addActionListener(controladorBackActividad);
	}
	
	/**
	 * Setter, establece un controlador para el botón de recargar actividades
	 * 
	 * @param control controlador para el boton de recargar actividades
	 */
	public void setControlRecargaActividad(ControlRecargaActividades control) {
		recargarActividades.addActionListener(control);
	}
	
	/**
	 * Getter
	 * 
	 * @return ActividadGrupal con el tipo de actividad grupal que haya seleccionado el cliente
	 * en el combo box
	 */
	public ActividadGrupal getTipoActividadGrupal() {
		return Gimnasio.getGimnasio().getActividadGrupalByName((String)combo3.getSelectedItem());
	}
	
	/**
	 * Getter
	 * 
	 * @return string con la hora que ha seleccionado el cliente en el combo box
	 */
	public String getHora() {
		return (String)comboHora.getSelectedItem();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el minuto que ha seleccionado el cliente en el combo box
	 */
	public String getMinuto() {
		return (String)minutoCombo.getSelectedItem();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el dia que ha seleccionado el cliente en el combo box 
	 */
	public String getDia() {
		return (String)comboDias.getSelectedItem();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el mes que ha seleccionado el cliente en el combo box
	 */
	public String getMes() {
		return (String)mesCombo.getSelectedItem();
	}
	
	/**
	 * Setter, establece la lista de actividades grupales para el combo box
	 * 
	 * @param actividades lista de actividades que se establecen en el combo box 
	 */
	public void setActividadesList(List<ActividadGrupal>actividades){
		if(actividades.isEmpty()==true){
			return;
		}
		this.remove(this.combo3);
		String[] nombres = new String[actividades.size()+1];
		nombres[0] = "Seleccione una actividad";
		for(int i=1; i<= actividades.size(); i++){
			nombres[1] = actividades.get(i-1).getNombre();
		}
		
		JComboBox<String> combo4 = new JComboBox<String>(nombres);
		combo4.setSelectedIndex(0);
		this.remove(reservar);
		this.combo3 = combo4;
		layout.putConstraint(SpringLayout.WEST, this.combo3, 0, SpringLayout.WEST, recargarActividades); 
		layout.putConstraint(SpringLayout.NORTH, this.combo3, 50, SpringLayout.NORTH, recargarActividades);
		layout.putConstraint(SpringLayout.WEST, reservar, 0, SpringLayout.WEST, combo3); 
		layout.putConstraint(SpringLayout.NORTH, reservar, 50, SpringLayout.NORTH, combo3);
		
		this.add(this.combo3);
		this.add(reservar);
		this.revalidate();
		this.repaint();
		
	}
}
