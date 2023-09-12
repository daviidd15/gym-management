package GUI.cliente;

import java.awt.*;
import javax.swing.*;

import GUI.listeners.ControlLoginNormal;
import GUI.listeners.ControlLoginRegistroPanel;
import GUI.listeners.cliente.*;
import gimnasio.Gimnasio;

/**
 * La clase ReservasPanel extiende de JPanel y es utilizada para mostrar
 * la pantalla principal del usuario cliente
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ReservasPanel extends JPanel{
	private JButton grupalButton;
	private JButton planPersonalizadoButton;
	private JButton libreButton;
	private JButton notificaciones;
	private JButton logout;
	private JButton verReservas;
	private JLabel numCancelaciones;
	private JLabel finPenalizacion;
	private SpringLayout layout;
	
	/**
	 * Constructor de la clase ReservasPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public ReservasPanel() {
		layout = new SpringLayout(); 
		this.setLayout(layout);
		
		Font font = new Font("Courier New", Font.BOLD, 15);

		grupalButton = new JButton("Actividad Grupal");
        planPersonalizadoButton = new JButton("Plan Personalizado");
        libreButton = new JButton("Entrenamiento Libre");
        notificaciones = new JButton("Notificaciones");
        verReservas = new JButton("Ver reservas");
        
        numCancelaciones = new JLabel("No tiene cancelaciones");
        finPenalizacion = new JLabel("No está penalizado");
      
        logout = new JButton("Logout");
        
        grupalButton.setPreferredSize(new Dimension(210, 50));
        grupalButton.setBackground(Color.gray);
        grupalButton.setForeground(Color.white);
        grupalButton.setFont(font);
        
        planPersonalizadoButton.setPreferredSize(new Dimension(210, 50));
        planPersonalizadoButton.setBackground(Color.gray);
        planPersonalizadoButton.setForeground(Color.white);
        planPersonalizadoButton.setFont(font);
        
        libreButton.setPreferredSize(new Dimension(210, 50));
        libreButton.setBackground(Color.gray);
        libreButton.setForeground(Color.white);
        libreButton.setFont(font);
        
        notificaciones.setPreferredSize(new Dimension(210, 50));
        notificaciones.setBackground(Color.gray);
        notificaciones.setForeground(Color.white);
        notificaciones.setFont(font);
        
        verReservas.setBackground(Color.LIGHT_GRAY);
        verReservas.setFont(font);
        
		logout.setPreferredSize(new Dimension(100, 20));
		logout.setForeground(Color.red);
		logout.setBackground(Color.LIGHT_GRAY);
		logout.setFont(font);
 
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, grupalButton, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, grupalButton, 250, SpringLayout.NORTH, this);
        
    	layout.putConstraint(SpringLayout.WEST, planPersonalizadoButton, 0, SpringLayout.WEST, grupalButton);
		layout.putConstraint(SpringLayout.NORTH, planPersonalizadoButton, 100, SpringLayout.NORTH, grupalButton);
        
        
        layout.putConstraint(SpringLayout.WEST, libreButton, 0, SpringLayout.WEST, planPersonalizadoButton);
        layout.putConstraint(SpringLayout.NORTH, libreButton, 100, SpringLayout.NORTH, planPersonalizadoButton);
        
        layout.putConstraint(SpringLayout.WEST, notificaciones, 0, SpringLayout.WEST, libreButton);
        layout.putConstraint(SpringLayout.NORTH, notificaciones, 100, SpringLayout.NORTH, libreButton);
        
        layout.putConstraint(SpringLayout.EAST, verReservas, -50, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, verReservas, 10, SpringLayout.NORTH, this);
        
        
        layout.putConstraint(SpringLayout.EAST, numCancelaciones, -50, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, numCancelaciones, 10, SpringLayout.NORTH, verReservas);
        
        
        layout.putConstraint(SpringLayout.EAST, finPenalizacion, -50, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, finPenalizacion, 10, SpringLayout.NORTH, numCancelaciones);
        
  
        layout.putConstraint(SpringLayout.WEST, logout, 15, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, logout, 15, SpringLayout.NORTH, this);
        
        this.add(numCancelaciones);
        this.add(finPenalizacion);
        this.add(grupalButton);
        this.add(planPersonalizadoButton);
        this.add(libreButton);
        this.add(notificaciones);
        this.add(verReservas);
        this.add(logout);
	}
	
	/**
	 * Setter, establece el controlador para el boton de actividad grupal
	 * 
	 * @param controladorReservaGrupal controlador para el boton de actividad grupal
	 */
	public void setControladorGrupal(ControlReservaGrupal controladorReservaGrupal) {
		grupalButton.addActionListener(controladorReservaGrupal);
	}
	
	/**
	 * Setter, establece el controlador para el boton de plan personalizado
	 * 
	 * @param controladorPlanPersonalizado controlador para el boton de plan personalizado
	 */
	public void setControladorPlanPersonalizado(ControlReservaPlanPersonalizado controladorPlanPersonalizado) {
		planPersonalizadoButton.addActionListener(controladorPlanPersonalizado);
	}
	
	/**
	 * Setter, establece el controlador para el boton de entrenamiento libre
	 * 
	 * @param controladorEntrenamientoLibre controlador para el boton de entrenamiento libre
	 */
	public void setControladorEntrenamientoLibre(ControlReservaEntrenamientoLibre controladorEntrenamientoLibre) {
		libreButton.addActionListener(controladorEntrenamientoLibre);
	}
	
	/**
	 * Setter, establece el controlador para el boton de logout
	 * 
	 * @param controladorLogoutCliente controlador para el boton de logout
	 */
	public void setControladorLogoutCliente(ControlLogoutCliente controladorLogoutCliente){
		logout.addActionListener(controladorLogoutCliente);
	}
	
	/**
	 * Setter, establece el controlador para el boton de notificaciones 
	 * 
	 * @param controladorNotificaciones controlador para el boton de notificaciones
	 */
	public void setControladorNotificaciones(ControlNotificaciones controladorNotificaciones) {
		notificaciones.addActionListener(controladorNotificaciones);
	}
	
	/**
	 * Setter, establece el controlador para el boton de ver reservas
	 * 
	 * @param controladorVerReservas controlador para el boton de ver reservas
	 */
	public void setControladorVerReservas(ControlVerReservas controladorVerReservas) {
		verReservas.addActionListener(controladorVerReservas);
	}
	
	/**
	 * Setter, establece el numero de cancelaciones seguidas del cliente
	 * 
	 * @param numero String con el numero de cancelaciones seguidas del cliente
	 */
	public void setNumCancelaciones(String numero) {
		this.remove(numCancelaciones);
		JLabel numCancelaciones2 = new JLabel(numero);
		this.numCancelaciones = numCancelaciones2;
		
		layout.putConstraint(SpringLayout.WEST, numCancelaciones2, 0, SpringLayout.WEST, verReservas);
        layout.putConstraint(SpringLayout.NORTH, numCancelaciones2, 20, SpringLayout.SOUTH, verReservas);
        
		this.add(numCancelaciones2);
	}
	
	/**
	 * Setter, establece la fecha de fin de penalizacion del cliente
	 * 
	 * @param fecha String con la fecha de fin de penalizacion del cliente
	 */
	public void setFinPenalizacion(String fecha) {
		this.remove(finPenalizacion);
		JLabel finPenalizacion2=  new JLabel(fecha);
		this.finPenalizacion = finPenalizacion2;
		
		layout.putConstraint(SpringLayout.WEST, finPenalizacion2, 0, SpringLayout.WEST, verReservas);
        layout.putConstraint(SpringLayout.NORTH, finPenalizacion2, 20, SpringLayout.SOUTH, numCancelaciones);
        
		this.add(finPenalizacion2);
	}
	
}
