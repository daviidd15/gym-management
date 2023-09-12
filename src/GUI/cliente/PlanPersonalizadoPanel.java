package GUI.cliente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import GUI.listeners.cliente.*;
import actividades.ActividadGrupal;
import actividades.PlanPersonalizado;
import gimnasio.Gimnasio;

@SuppressWarnings("serial")
/**
 * La clase PlanPersonalizadoPanel extiende de JPanel y es utilizada para mostrar
 * la vista de la reserva de planes personalizados
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class PlanPersonalizadoPanel extends JPanel{
	private JButton back;
	private final JComboBox<String> combo3;
	private JButton reservar;
	private JRadioButton si;
	private JRadioButton no;
	private SpringLayout layout;
	private JLabel etiqueta3;
	private JLabel nombrePanel;
	
	/**
	 * Constructor de la clase PlanPersonalizadoPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public PlanPersonalizadoPanel() {
		layout = new SpringLayout(); 
		this.setLayout(layout);
		
		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		
		JLabel label = new JLabel("GIMNASIO LADFIT");
		nombrePanel = new JLabel("Reserva plan personalizado");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);
	
		String[] planesPersonalizados = {"Seleccione un plan"};
		
		etiqueta3 = new JLabel("Plan personalizado: ");
		combo3 = new JComboBox<String>(planesPersonalizados);
		combo3.setSelectedIndex(0);
		
		JLabel etiqueta = new JLabel("En caso de que haya alguien apuntado, ¿Quiere apuntarse a la lista de espera?");
		
		si = new JRadioButton("SI");
		no = new JRadioButton("NO");

		ButtonGroup grupo = new ButtonGroup();
		
		grupo.add(si);
		grupo.add(no);
	
		
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
		
    	layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, etiqueta3, -50, SpringLayout.HORIZONTAL_CENTER, nombrePanel);
		layout.putConstraint(SpringLayout.NORTH, etiqueta3, 70, SpringLayout.NORTH, nombrePanel);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta, 0, SpringLayout.WEST, etiqueta3);
        layout.putConstraint(SpringLayout.NORTH, etiqueta, 55, SpringLayout.NORTH, etiqueta3);
        
		layout.putConstraint(SpringLayout.NORTH, si, 35, SpringLayout.SOUTH, etiqueta);
		layout.putConstraint(SpringLayout.WEST, si, 20, SpringLayout.WEST, etiqueta);
		
		layout.putConstraint(SpringLayout.NORTH, no, 35, SpringLayout.SOUTH, etiqueta);
		layout.putConstraint(SpringLayout.WEST, no, 45, SpringLayout.WEST, si);
		
		
		layout.putConstraint(SpringLayout.WEST, combo3, 70, SpringLayout.EAST, etiqueta3);
		layout.putConstraint(SpringLayout.NORTH, combo3, 70, SpringLayout.SOUTH, nombrePanel);
		
		layout.putConstraint(SpringLayout.WEST, reservar, 50, SpringLayout.WEST, si);
		layout.putConstraint(SpringLayout.NORTH, reservar, 35, SpringLayout.SOUTH, si);
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
        this.add(label);
        this.add(nombrePanel);
        
		this.add(etiqueta3);
		this.add(etiqueta);
		this.add(si);
		this.add(no);
		this.add(combo3);
		this.add(reservar);
		this.add(back);
	}
	
	/**
	 * Setter, establece un controlador para el boton de back
	 * 
	 * @param controladorBackPlanPersonalizado controlador para el boton de back en esta vista
	 */
	public void setControladorBack(ControlBackPlanPersonalizado controladorBackPlanPersonalizado) {
		back.addActionListener(controladorBackPlanPersonalizado);
	}
	
	/**
	 * Setter, establece un controlador para el boton de reservar
	 * 
	 * @param controladorBotonReservaPlanPersonalizado controlador para el boton de reservar en esta vista
	 */
	public void setControladorBoton(ControlBotonReservaPlanPersonalizado controladorBotonReservaPlanPersonalizado) {
		reservar.addActionListener(controladorBotonReservaPlanPersonalizado);
	}
	
	/**
	 * Getter
	 * 
	 * @return PlanPersonalizado obtenido de la seleccion del cliente en el combo box
	 */
	public PlanPersonalizado getPlanPersonalizado() {
		return Gimnasio.getGimnasio().getPlanPersonalizadoByName((String)combo3.getSelectedItem());
	}
	
	/**
	 * Getter
	 * 
	 * @return string Si, si el cliente ha elegido apuntarse a la lista de espera en caso de que
	 * el plan esté contratado o No, en caso contrario
	 */
	public String getListaEspera() {
		if (si.isSelected()) {
			return "Si";
		}else {
			return "No";
		}
	}
	
	/**
	 * Setter, establece la lista de planes personalizados actualizada
	 * 
	 * @param planes String con la lista de planes personalizados
	 */
	public void setPlanesList(String [] planes){
		this.remove(combo3);
		this.combo3.removeAllItems();
		this.combo3.addItem("Seleccione un plan");
		for(int i=0; i< planes.length; i++){
			combo3.addItem(planes[i]);
		}
		
		layout.putConstraint(SpringLayout.WEST, combo3, 70, SpringLayout.EAST, etiqueta3);
		layout.putConstraint(SpringLayout.NORTH, combo3, 70, SpringLayout.NORTH, nombrePanel);
		
		this.add(combo3);
	}
}
