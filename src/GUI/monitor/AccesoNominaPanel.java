package GUI.monitor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import GUI.listeners.monitor.*;
import GUI.listeners.ControlRegistro;

/**
 * La clase AccesoNominaPanel extiende de JPanel y es utilizada para mostrar
 * la vista con el boton para que se pueda descargar un pdf con la nomina
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class AccesoNominaPanel extends JPanel{
	private JButton descarga;
	private JButton back;
	private JLabel nombrePanel;
	
	/**
	 * Constructor de la clase AccesoNominaPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public AccesoNominaPanel(){
		SpringLayout layout = new SpringLayout(); 
		this.setLayout(layout);
		

		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		
		JLabel label = new JLabel("GIMNASIO LADFIT");
		nombrePanel = new JLabel("Descarga nómina monitor");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);
		
		label.setFont(font);
		
		descarga = new JButton("Descargar la nómina");
		descarga.setPreferredSize(new Dimension(200, 40));
		
		descarga.setBackground(Color.GRAY);
		descarga.setForeground(Color.WHITE);
		
		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, nombrePanel, 35, SpringLayout.NORTH, label);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombrePanel, 0, SpringLayout.HORIZONTAL_CENTER, label);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, descarga, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, descarga, -50, SpringLayout.VERTICAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);
		
        this.add(label);
        this.add(nombrePanel);
		this.add(descarga);
		this.add(back);
	}
	
	/**
	 * Setter, establece el controlador para el boton de descarga
	 * 
	 * @param controladorDescargaNomina controlador para el boton de descarga
	 */
	public void setControladorRegistro(ControlDescargaNomina controladorDescargaNomina) {
		descarga.addActionListener(controladorDescargaNomina);
	}
	
	/**
	 * Setter, establece el controlador para el boton de back
	 * 
	 * @param controladorBack controlador para el boton de back
	 */
	public void setControladorBack(ControlBackNomina controladorBack) {
		back.addActionListener(controladorBack);
	}
	
}