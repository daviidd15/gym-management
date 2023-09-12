package GUI.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import GUI.listeners.admin.*;
import gimnasio.Gimnasio;

/**
 * La clase GimnasioValoresPredeterminados extiende de JPanel y es utilizada para mostrar
 * la vista que establece los valores predeterminados del gimnasio
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class GimnasioValoresPredeterminados extends JPanel {
	private JButton cambiar;
	private JButton back;
	private JTextField sueldoCampo;
	private JTextField suplementoCampo;
	private JTextField diasPenalizacionCampo;
	private JTextField reservasCanceladasCampo;
	private JTextField porcentajeDevolucionCampo;
	private JTextField porcentajeDescuentoCampo;
	private JTextField precioSesionLibreCampo;
	private JTextField precioSesionPersonalizadoCampo;
	private JTextField precioTarifaPlanaCampo;
	
	/**
	 * Constructor de la clase GimnasioValoresPredeterminados
	 * 
	 * inicializa los componentes de la vista
	 */

	public GimnasioValoresPredeterminados() {
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);

		Font font = new Font("Arial", Font.BOLD, 20);
		Font font2 = new Font("Arial", Font.BOLD, 15);
		JLabel label = new JLabel("GIMNASIO LADFIT");
		JLabel nombrePanel = new JLabel("Valores predeterminados del gimnasio");
		label.setForeground(Color.blue);
		label.setFont(font);
		nombrePanel.setFont(font2);

		JLabel sueldo = new JLabel("Sueldo base: ");
		sueldoCampo = new JTextField(10);

		JLabel suplemento = new JLabel("Suplemento: ");
		suplementoCampo = new JTextField(10);

		JLabel diasPenalizacion = new JLabel("Dias de penalizacion");
		diasPenalizacionCampo = new JTextField(10);

		JLabel reservasCanceladas = new JLabel("Límite de reservas canceladas");
		reservasCanceladasCampo = new JTextField(10);

		JLabel porcentajeDevolucion = new JLabel("Porcentaje de devolucion");
		porcentajeDevolucionCampo = new JTextField(10);

		JLabel porcentajeDescuento = new JLabel("Porcentaje de descuento");
		porcentajeDescuentoCampo = new JTextField(10);

		JLabel precioSesionLibre = new JLabel("Precio de la sesion libre");
		precioSesionLibreCampo = new JTextField(10);

		JLabel precioSesionPersonalizado = new JLabel("Precio de la sesion personalizada");
		precioSesionPersonalizadoCampo = new JTextField(10);

		JLabel precioTarifaPlana = new JLabel("Precio de la tarifa plana");
		precioTarifaPlanaCampo = new JTextField(10);

		back = new JButton("Volver");
		back.setPreferredSize(new Dimension(100, 20));
		back.setBackground(Color.LIGHT_GRAY);
		
		cambiar = new JButton("Cambiar valores");
		cambiar.setBackground(Color.LIGHT_GRAY);

		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);

		layout.putConstraint(SpringLayout.NORTH, nombrePanel, 55, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nombrePanel, 0, SpringLayout.HORIZONTAL_CENTER, this);

		layout.putConstraint(SpringLayout.NORTH, sueldo, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, sueldo, -150, SpringLayout.WEST, sueldoCampo);

		layout.putConstraint(SpringLayout.WEST, suplemento, 0, SpringLayout.WEST, sueldo);
		layout.putConstraint(SpringLayout.NORTH, suplemento, 35, SpringLayout.NORTH, sueldo);

		layout.putConstraint(SpringLayout.WEST, diasPenalizacion, 0, SpringLayout.WEST, suplemento);
		layout.putConstraint(SpringLayout.NORTH, diasPenalizacion, 35, SpringLayout.NORTH, suplemento);

		layout.putConstraint(SpringLayout.WEST, reservasCanceladas, 0, SpringLayout.WEST, diasPenalizacion);
		layout.putConstraint(SpringLayout.NORTH, reservasCanceladas, 35, SpringLayout.NORTH, diasPenalizacion);

		layout.putConstraint(SpringLayout.WEST, porcentajeDevolucion, 0, SpringLayout.WEST, reservasCanceladas);
		layout.putConstraint(SpringLayout.NORTH, porcentajeDevolucion, 35, SpringLayout.NORTH, reservasCanceladas);

		layout.putConstraint(SpringLayout.WEST, porcentajeDescuento, 0, SpringLayout.WEST, porcentajeDevolucion);
		layout.putConstraint(SpringLayout.NORTH, porcentajeDescuento, 35, SpringLayout.NORTH, porcentajeDevolucion);

		layout.putConstraint(SpringLayout.WEST, precioSesionLibre, 0, SpringLayout.WEST, porcentajeDescuento);
		layout.putConstraint(SpringLayout.NORTH, precioSesionLibre, 35, SpringLayout.NORTH, porcentajeDescuento);

		layout.putConstraint(SpringLayout.WEST, precioSesionPersonalizado, 0, SpringLayout.WEST, precioSesionLibre);
		layout.putConstraint(SpringLayout.NORTH, precioSesionPersonalizado, 35, SpringLayout.NORTH, precioSesionLibre);

		layout.putConstraint(SpringLayout.WEST, precioTarifaPlana, 0, SpringLayout.WEST, precioSesionPersonalizado);
		layout.putConstraint(SpringLayout.NORTH, precioTarifaPlana, 35, SpringLayout.NORTH, precioSesionPersonalizado);

		layout.putConstraint(SpringLayout.NORTH, sueldoCampo, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, sueldoCampo, 0, SpringLayout.HORIZONTAL_CENTER, this);

		layout.putConstraint(SpringLayout.WEST, suplementoCampo, 0, SpringLayout.WEST, sueldoCampo);
		layout.putConstraint(SpringLayout.NORTH, suplementoCampo, 35, SpringLayout.NORTH, sueldoCampo);

		layout.putConstraint(SpringLayout.WEST, diasPenalizacionCampo, 0, SpringLayout.WEST, suplementoCampo);
		layout.putConstraint(SpringLayout.NORTH, diasPenalizacionCampo, 35, SpringLayout.NORTH, suplementoCampo);

		layout.putConstraint(SpringLayout.WEST, reservasCanceladasCampo, 0, SpringLayout.WEST, diasPenalizacionCampo);
		layout.putConstraint(SpringLayout.NORTH, reservasCanceladasCampo, 35, SpringLayout.NORTH,
				diasPenalizacionCampo);

		layout.putConstraint(SpringLayout.WEST, porcentajeDevolucionCampo, 0, SpringLayout.WEST,
				reservasCanceladasCampo);
		layout.putConstraint(SpringLayout.NORTH, porcentajeDevolucionCampo, 35, SpringLayout.NORTH,
				reservasCanceladasCampo);

		layout.putConstraint(SpringLayout.WEST, porcentajeDescuentoCampo, 0, SpringLayout.WEST,
				porcentajeDevolucionCampo);
		layout.putConstraint(SpringLayout.NORTH, porcentajeDescuentoCampo, 35, SpringLayout.NORTH,
				porcentajeDevolucionCampo);

		layout.putConstraint(SpringLayout.WEST, precioSesionLibreCampo, 0, SpringLayout.WEST, porcentajeDescuentoCampo);
		layout.putConstraint(SpringLayout.NORTH, precioSesionLibreCampo, 35, SpringLayout.NORTH,
				porcentajeDescuentoCampo);

		layout.putConstraint(SpringLayout.WEST, precioSesionPersonalizadoCampo, 0, SpringLayout.WEST,
				precioSesionLibreCampo);
		layout.putConstraint(SpringLayout.NORTH, precioSesionPersonalizadoCampo, 35, SpringLayout.NORTH,
				precioSesionLibreCampo);

		layout.putConstraint(SpringLayout.WEST, precioTarifaPlanaCampo, 0, SpringLayout.WEST,
				precioSesionPersonalizadoCampo);
		layout.putConstraint(SpringLayout.NORTH, precioTarifaPlanaCampo, 35, SpringLayout.NORTH,
				precioSesionPersonalizadoCampo);

		layout.putConstraint(SpringLayout.WEST, back, 25, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, cambiar, 185, SpringLayout.WEST, sueldoCampo);
		layout.putConstraint(SpringLayout.NORTH, cambiar, 150, SpringLayout.NORTH, sueldoCampo);

		this.add(label);
		this.add(nombrePanel);
		this.add(sueldo);
		this.add(suplemento);
		this.add(diasPenalizacion);
		this.add(reservasCanceladas);
		this.add(porcentajeDevolucion);
		this.add(porcentajeDescuento);
		this.add(precioSesionLibre);
		this.add(precioSesionPersonalizado);
		this.add(precioTarifaPlana);

		this.add(sueldoCampo);
		this.add(suplementoCampo);
		this.add(diasPenalizacionCampo);
		this.add(reservasCanceladasCampo);
		this.add(porcentajeDevolucionCampo);
		this.add(porcentajeDescuentoCampo);
		this.add(precioSesionLibreCampo);
		this.add(precioSesionPersonalizadoCampo);
		this.add(precioTarifaPlanaCampo);

		this.add(back);
		this.add(cambiar);

	}
	
	/**
	 * Getter
	 * 
	 * @return String con el sueldo del monitor
	 */
	public String getSueldo() {
		return this.sueldoCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el suplemento por hora del sueldo del monitor
	 */
	public String getSuplemento() {
		return this.suplementoCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con los dias de penalizado del cliente en caso de que 
	 * supere las cancelaciones seguidas establecidas por el administrador
	 */
	public String getDiasPenalizacion() {
		return this.diasPenalizacionCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el maximo de cancelaciones seguidas del cliente permitidas por el administrador
	 */
	public String getReservasCanceladas() {
		return this.reservasCanceladasCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el porcentaje de devolucion en caso de que el cliente cancele una reserva
	 */
	public String getPorcentajeDevolucion() {
		return this.porcentajeDevolucionCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el porcentaje de devolucion
	 */
	public String getPorcentajeDescuento() {
		return this.porcentajeDescuentoCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el precio del entrenamiento libre
	 */
	public String getPrecioSesionLibre() {
		return this.precioSesionLibreCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el precio de la sesion del plan personalizado
	 */
	public String getPrecioSesionPersonalizado() {
		return this.precioSesionPersonalizadoCampo.getText();
	}
	
	/**
	 * Getter
	 * 
	 * @return String con el precio de la tarifa plana
	 */
	public String getPrecioTarifaPlana() {
		return this.precioTarifaPlanaCampo.getText();
	}
	
	/**
	 * Setter, establece un controlador para el boton de cambiar los valores predeterminados
	 * 
	 * @param control controlador para el boton de cambiar los valores predeterminados
	 */
	public void setControlGuardarValores(ControlGuardarValores control) {
		this.cambiar.addActionListener(control);
	}
	
	/**
	 * Setter, establece un controlador para el boton de back
	 * 
	 * @param control controlador para el boton de back de esta vista
	 */
	public void setControlBackValores(ControlBackValores control) {
		this.back.addActionListener(control);
	}
}
