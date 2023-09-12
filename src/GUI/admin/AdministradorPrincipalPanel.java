package GUI.admin;

import javax.swing.*;
import java.awt.*;
import GUI.listeners.admin.*;

import gimnasio.Gimnasio;
import usuarios.*;

/**
 * La clase AdministradorPrincipalPanel extiende de JPanel y es utilizada para mostrar
 * la pantalla principal del administrador
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class AdministradorPrincipalPanel extends JPanel {
	private JButton logout;
	private JButton salas;
	private JButton planesPersonalizado;
	private JButton ocupacion;
	private JButton actividades;
	private JButton actividadesSesion;
	private JButton monitores;
	private JButton tarifas;
	private JButton backupLeer;
	private JButton backupGuardar;
	private JButton valoresGimnasio;
	private JButton verBeneficios;
	private JButton entrenamientoLibre;

	/**
	 * Constructor de la clase AdministradorPrincipalPanel
	 * 
	 * inicializa los componentes de la vista
	 */
	public AdministradorPrincipalPanel() {
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);

		Font font = new Font("Courier New", Font.BOLD, 13);
		
		valoresGimnasio = new JButton("Valores predeterminados");
		salas = new JButton("Salas");
		planesPersonalizado = new JButton("Planes personalizados");
		ocupacion = new JButton("Ocupacion");
		actividades = new JButton("Crear actividad grupal");
		actividadesSesion = new JButton("Crear sesion de actividad grupal");
		monitores = new JButton("Monitores");
		tarifas = new JButton("Tarifas");
		logout = new JButton("Logout");
		backupLeer = new JButton("Leer el último backup");
		backupGuardar = new JButton("Hacer un backup");
		verBeneficios = new JButton("Ver beneficios");
		entrenamientoLibre = new JButton("Entrenamiento Libre");

		valoresGimnasio.setPreferredSize(new Dimension(220, 40));
		valoresGimnasio.setBackground(Color.gray);
		valoresGimnasio.setForeground(Color.white);
		valoresGimnasio.setFont(font);

		salas.setPreferredSize(new Dimension(220, 40));
		salas.setBackground(Color.gray);
		salas.setForeground(Color.white);
		salas.setFont(font);
		

		planesPersonalizado.setPreferredSize(new Dimension(220, 40));
		planesPersonalizado.setBackground(Color.gray);
		planesPersonalizado.setForeground(Color.white);
		planesPersonalizado.setFont(font);

		ocupacion.setPreferredSize(new Dimension(220, 40));
		ocupacion.setBackground(Color.gray);
		ocupacion.setForeground(Color.white);
		ocupacion.setFont(font);

		actividades.setPreferredSize(new Dimension(220, 40));
		actividades.setBackground(Color.gray);
		actividades.setForeground(Color.white);
		actividades.setFont(font);

		actividadesSesion.setPreferredSize(new Dimension(220, 40));
		actividadesSesion.setBackground(Color.gray);
		actividadesSesion.setForeground(Color.white);
		actividadesSesion.setFont(font);

		monitores.setPreferredSize(new Dimension(220, 40));
		monitores.setBackground(Color.gray);
		monitores.setForeground(Color.white);
		monitores.setFont(font);

		tarifas.setPreferredSize(new Dimension(220, 40));
		tarifas.setBackground(Color.gray);
		tarifas.setForeground(Color.white);
		tarifas.setFont(font);

		backupLeer.setPreferredSize(new Dimension(220, 40));
		backupLeer.setBackground(Color.gray);
		backupLeer.setForeground(Color.white);
		backupLeer.setFont(font);

		backupGuardar.setPreferredSize(new Dimension(220, 40));
		backupGuardar.setBackground(Color.gray);
		backupGuardar.setForeground(Color.white);
		backupGuardar.setFont(font);

		verBeneficios.setPreferredSize(new Dimension(220, 40));
		verBeneficios.setBackground(Color.gray);
		verBeneficios.setForeground(Color.white);
		verBeneficios.setFont(font);
		
		entrenamientoLibre.setPreferredSize(new Dimension(220, 40));
		entrenamientoLibre.setBackground(Color.gray);
		entrenamientoLibre.setForeground(Color.white);
		entrenamientoLibre.setFont(font);

		logout.setPreferredSize(new Dimension(100, 20));
		logout.setForeground(Color.red);
		logout.setBackground(Color.LIGHT_GRAY);
		logout.setFont(font);

		layout.putConstraint(SpringLayout.NORTH, valoresGimnasio, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, valoresGimnasio, 0, SpringLayout.HORIZONTAL_CENTER, this);

		layout.putConstraint(SpringLayout.WEST, salas, 0, SpringLayout.WEST, valoresGimnasio);
		layout.putConstraint(SpringLayout.NORTH, salas, 55, SpringLayout.NORTH, valoresGimnasio);

		layout.putConstraint(SpringLayout.WEST, planesPersonalizado, 0, SpringLayout.WEST, salas);
		layout.putConstraint(SpringLayout.NORTH, planesPersonalizado, 55, SpringLayout.NORTH, salas);

		layout.putConstraint(SpringLayout.WEST, ocupacion, 0, SpringLayout.WEST, planesPersonalizado);
		layout.putConstraint(SpringLayout.NORTH, ocupacion, 55, SpringLayout.NORTH, planesPersonalizado);

		layout.putConstraint(SpringLayout.WEST, actividades, 0, SpringLayout.WEST, ocupacion);
		layout.putConstraint(SpringLayout.NORTH, actividades, 55, SpringLayout.NORTH, ocupacion);

		layout.putConstraint(SpringLayout.WEST, actividadesSesion, 0, SpringLayout.WEST, actividades);
		layout.putConstraint(SpringLayout.NORTH, actividadesSesion, 55, SpringLayout.NORTH, actividades);

		layout.putConstraint(SpringLayout.WEST, monitores, 0, SpringLayout.WEST, actividadesSesion);
		layout.putConstraint(SpringLayout.NORTH, monitores, 55, SpringLayout.NORTH, actividadesSesion);

		layout.putConstraint(SpringLayout.WEST, tarifas, 0, SpringLayout.WEST, monitores);
		layout.putConstraint(SpringLayout.NORTH, tarifas, 55, SpringLayout.NORTH, monitores);

		layout.putConstraint(SpringLayout.WEST, backupLeer, 0, SpringLayout.WEST, tarifas);
		layout.putConstraint(SpringLayout.NORTH, backupLeer, 55, SpringLayout.NORTH, tarifas);

		layout.putConstraint(SpringLayout.WEST, backupGuardar, 0, SpringLayout.WEST, backupLeer);
		layout.putConstraint(SpringLayout.NORTH, backupGuardar, 55, SpringLayout.NORTH, backupLeer);

		layout.putConstraint(SpringLayout.WEST, verBeneficios, 0, SpringLayout.WEST, backupGuardar);
		layout.putConstraint(SpringLayout.NORTH, verBeneficios, 55, SpringLayout.NORTH, backupGuardar);
		
		layout.putConstraint(SpringLayout.WEST, entrenamientoLibre, 0, SpringLayout.WEST, verBeneficios);
		layout.putConstraint(SpringLayout.NORTH, entrenamientoLibre, 55, SpringLayout.NORTH, verBeneficios);

		layout.putConstraint(SpringLayout.WEST, logout, 25, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, logout, 25, SpringLayout.NORTH, this);

		this.add(valoresGimnasio);
		this.add(salas);
		this.add(planesPersonalizado);
		this.add(ocupacion);
		this.add(actividades);
		this.add(actividadesSesion);
		this.add(monitores);
		this.add(tarifas);
		this.add(backupLeer);
		this.add(backupGuardar);
		this.add(verBeneficios);
		this.add(entrenamientoLibre);
		this.add(logout);
		
	}
	
	/**
	 * Getter
	 * 
	 * @return Usuario con el nombre de admin
	 */
	public Usuario getUsuario() {
		return Gimnasio.getGimnasio().getUsuarioByUser("admin");
	}

	/**
	 * Setter, establece el controlador para el boton de logout
	 * 
	 * @param controladorLogout controlador para el boton de logout
	 */
	public void setControladorLogoutAdmin(ControlLogoutAdmin controladorLogout) {
		logout.addActionListener(controladorLogout);
	}
	
	/**
	 * Setter, establece el controlador para el boton de leer el backup
	 * 
	 * @param controladorBackup controlador para el boton de leer el backup
	 */
	public void setControladorBackup(ControlBackup controladorBackup) {
		backupLeer.addActionListener(controladorBackup);
	}
	
	/**
	 * Setter, establece el controlador para el boton de monitores
	 * 
	 * @param controladorPanelControl controlador para el boton de monitores
	 */
	public void setControladorPanelControl(ControlPanelControlMonitor controladorPanelControl) {
		monitores.addActionListener(controladorPanelControl);
	}
	
	/**
	 * Setter, establece el controlador para el boton de guardar el backup
	 * 
	 * @param controladorBackupGuardar
	 */
	public void setControladorBackupGuardar(ControlBackupGuardar controladorBackupGuardar) {
		backupGuardar.addActionListener(controladorBackupGuardar);
	}
	
	/**
	 * Setter, establece el controlador para el boton de plan personalizado por monitor
	 * 
	 * @param controladorPlanesPorMonitor controlador para el boton de plan personalizado por monitor
	 */
	public void setControladorPlanesPorMonitor(ControlPlanesPorMonitor controladorPlanesPorMonitor) {
		planesPersonalizado.addActionListener(controladorPlanesPorMonitor);
	}
	
	/**
	 * Setter, establece el controlador para el boton de actualizar el precio de las tarifas
	 * 
	 * @param controladorCambiarPrecioTarifa controlador para actualizar el precio de las tarifas
	 */
	public void setControladorPrecioTarifa(ControlCambiarPrecioTarifa controladorCambiarPrecioTarifa) {
		tarifas.addActionListener(controladorCambiarPrecioTarifa);
	}
	
	/**
	 * Setter, establece el controlador para el boton de crear salas 
	 * 
	 * @param controladorSalasAdmin controlador para el boton de crear salas
	 */
	public void setControladorSalas(ControlSalasAdmin controladorSalasAdmin) {
		salas.addActionListener(controladorSalasAdmin);
	}
	
	/**
	 * Setter, establece el controlador para el boton de crear actividades
	 * 
	 * @param controlador controlador para el boton de crear actividades
	 */
	public void setControladorActividades(ControlActividades controlador) {
		actividades.addActionListener(controlador);
	}
	
	/**
	 * Setter, establece el controlador para el boton de crear una sesion de una actividad 
	 * 
	 * @param controlador controlador para el boton de crear una sesion de una actividad
	 */
	public void setControladorActividadesSesion(ControlActividadesSesion controlador) {
		actividadesSesion.addActionListener(controlador);
	}
	
	/**
	 * Setter, establece el controlador para el boton de establecer los valores predeterminados del gimnasio
	 * 
	 * @param controlador controlador para el boton de establecer los valores predeterminados del gimnasio
	 */
	public void setControladorGimnasioPredeterminado(ControlGimnasioPredeterminado controlador) {
		valoresGimnasio.addActionListener(controlador);
	}
	
	/**
	 * Setter, establece el controlador para ver la ocupacion de las salas
	 * 
	 * @param controlador controlador para ver la ocupacion de las salas
	 */
	public void setControladorOcupacionSalas(ControlOcupacionSalas controlador) {
		ocupacion.addActionListener(controlador);
	}
	
	/**
	 * Setter, establece el controlador para el boton de ver los beneficios del gimnasio
	 * 
	 * @param controlador controlador para ver los beneficios del gimnasio
	 */
	public void setControladorVerBeneficios(ControlVerBeneficios controlador) {
		verBeneficios.addActionListener(controlador);
	}
	
	/**
	 * Setter del controlador para el boton del entrenamiento libre
	 * @param controlador controlador del entrenamiento libre
	 */
	public void setControlAdminEntrenamiento(ControlAdminEntrenamiento controlador) {
		entrenamientoLibre.addActionListener(controlador);
	}
}
