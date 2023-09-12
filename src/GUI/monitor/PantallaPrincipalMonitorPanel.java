package GUI.monitor;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GUI.listeners.*;
import GUI.listeners.monitor.*;

/**
 * La clase PantallaPrincipalMonitorPanel extiende de JPanel y es utilizada para mostrar
 * la vista de la pantalla principal del monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class PantallaPrincipalMonitorPanel extends JPanel{
	private JButton accesoNomina;
	private JButton accesoHorario;
	private JButton crearPlanPersonalizado;
	private JButton cancelarClase;
	private JButton consultarNotificaciones;
	private JButton crearSesionPlanPersonalizado;
	private JButton logout;
	
	/**
	 * Constructor de la clase PantallaPrincipalMonitorPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public PantallaPrincipalMonitorPanel(){
		SpringLayout layout = new SpringLayout(); 
		this.setLayout(layout);
		
		Font font = new Font("Courier New", Font.BOLD, 13);
		
		accesoNomina = new JButton("Acceso nomina"); 
		accesoHorario = new JButton("Acceso horario"); 
		crearPlanPersonalizado = new JButton("Crear plan personalizado"); 
		cancelarClase = new JButton("Cancelar clase");
		consultarNotificaciones = new JButton("Consultar notificaciones");
		crearSesionPlanPersonalizado = new JButton("Crear sesion plan personalizado");
		logout = new JButton("Logout");
		
		
		 
		accesoNomina.setPreferredSize(new Dimension(230, 50));
		accesoNomina.setBackground(Color.gray);
		accesoNomina.setForeground(Color.white);
		accesoNomina.setFont(font);
		
		accesoHorario.setPreferredSize(new Dimension(230, 50));
		accesoHorario.setBackground(Color.gray);
		accesoHorario.setForeground(Color.white);
		accesoHorario.setFont(font);
		
		crearPlanPersonalizado.setPreferredSize(new Dimension(230, 50));
		crearPlanPersonalizado.setBackground(Color.gray);
		crearPlanPersonalizado.setForeground(Color.white);
		crearPlanPersonalizado.setFont(font);
		
		crearSesionPlanPersonalizado.setPreferredSize(new Dimension(230, 50));
		crearSesionPlanPersonalizado.setBackground(Color.gray);
		crearSesionPlanPersonalizado.setForeground(Color.white);
		crearSesionPlanPersonalizado.setFont(font);
		
		cancelarClase.setPreferredSize(new Dimension(230, 50));
		cancelarClase.setBackground(Color.gray);
		cancelarClase.setForeground(Color.white);
		cancelarClase.setFont(font);
		
		consultarNotificaciones.setPreferredSize(new Dimension(230, 50));
		consultarNotificaciones.setBackground(Color.gray);
		consultarNotificaciones.setForeground(Color.white);
		consultarNotificaciones.setFont(font);
		
		logout.setPreferredSize(new Dimension(100, 20));
		logout.setForeground(Color.red);
		logout.setBackground(Color.LIGHT_GRAY);
		logout.setFont(font);

		
		layout.putConstraint(SpringLayout.NORTH, accesoNomina, 160, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, accesoNomina, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.WEST, accesoHorario, 0, SpringLayout.WEST, accesoNomina);
		layout.putConstraint(SpringLayout.NORTH, accesoHorario, 75, SpringLayout.NORTH, accesoNomina);
		
		layout.putConstraint(SpringLayout.WEST, crearPlanPersonalizado, 0, SpringLayout.WEST, accesoHorario);
		layout.putConstraint(SpringLayout.NORTH, crearPlanPersonalizado, 75, SpringLayout.NORTH, accesoHorario);
		
		layout.putConstraint(SpringLayout.WEST, crearSesionPlanPersonalizado, 0, SpringLayout.WEST, crearPlanPersonalizado);
		layout.putConstraint(SpringLayout.NORTH, crearSesionPlanPersonalizado, 75, SpringLayout.NORTH, crearPlanPersonalizado);
		
		layout.putConstraint(SpringLayout.WEST, cancelarClase, 0, SpringLayout.WEST, crearSesionPlanPersonalizado);
		layout.putConstraint(SpringLayout.NORTH, cancelarClase, 75, SpringLayout.NORTH, crearSesionPlanPersonalizado);
		
		
		layout.putConstraint(SpringLayout.WEST, consultarNotificaciones, 0, SpringLayout.WEST, cancelarClase);
		layout.putConstraint(SpringLayout.NORTH, consultarNotificaciones, 75, SpringLayout.NORTH, cancelarClase);
		
		layout.putConstraint(SpringLayout.WEST, logout, 25, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, logout, 25, SpringLayout.NORTH, this);
		
		this.add(accesoNomina);
		this.add(accesoHorario);
		this.add(crearPlanPersonalizado);
		this.add(crearSesionPlanPersonalizado);
		this.add(cancelarClase);
		this.add(consultarNotificaciones);
		this.add(logout);		
	}
	
	
	/**
	 * Setter, establece un controlador para el boton de acceso a la nomina
	 * 
	 * @param controladorAccesoNomina controlador para el boton de acceso a la nomina
	 */
	public void setControladorAccesoNomina(ControlAccesoNomina controladorAccesoNomina) {
		accesoNomina.addActionListener(controladorAccesoNomina);
	}
	
	/**
	 * Setter, establece un controlador para el boton de acceso al horario
	 * 
	 * @param controladorAccesoHorario controlador para el boton de acceso al horario
	 */
	public void setControladorAccesoHorario(ControlAccesoHorario controladorAccesoHorario){
		accesoHorario.addActionListener(controladorAccesoHorario);
	}
	
	/**
	 * Setter, establece un controlador para el boton de crear un plan personalizado
	 * 
	 * @param controladorCrearPlanPersonalizado controlador para el boton de crear un plan personalizado
	 */
	public void setControladorPlanPersonalizado(ControlCrearPlanPersonalizado controladorCrearPlanPersonalizado){
		crearPlanPersonalizado.addActionListener(controladorCrearPlanPersonalizado);
	}
	
	/**
	 * Setter, establece un controlador para el boton de crear un plan personalizado
	 * 
	 * @param controladorCrearSesionPlanPersonalizado controlador para el boton de crear un plan personalizado
	 */
	public void setControladorCrearSesionPlanPersonalizado(ControlCrearSesionPlanPersonalizado controladorCrearSesionPlanPersonalizado){
		crearSesionPlanPersonalizado.addActionListener(controladorCrearSesionPlanPersonalizado);
	}
	
	/**
	 * Setter, establece un controlador para el boton de cancelar la clase
	 * 
	 * @param controladorCancelarClase controlador para el boton de cancelar clase
	 */
	public void setControladorCancelarClase(ControlCancelarClase controladorCancelarClase){
		cancelarClase.addActionListener(controladorCancelarClase);
	}
	
	/**
	 * Setter, establece un controlador para el boton de logout
	 * 
	 * @param controladorMonitor controlador para el logout
	 */
	public void setControladorLogout(ControlLogoutMonitor controladorMonitor){
		logout.addActionListener(controladorMonitor);
	}
	
	/**
	 * Setter, establece un controlador para el boton de consultar notificaciones
	 * 
	 * @param controladorConsultarNotificaciones controlador para el boton de consultar notificaciones
	 */
	public void setConsultarNotificaciones(ControlConsultarNotificaciones controladorConsultarNotificaciones) {
		consultarNotificaciones.addActionListener(controladorConsultarNotificaciones);
	}
	

}
