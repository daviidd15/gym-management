package GUI;

import java.awt.CardLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gimnasio.Gimnasio;
import GUI.cliente.*;
import GUI.listeners.*;
import GUI.listeners.admin.*;
import GUI.listeners.cliente.*;
import GUI.listeners.monitor.*;

import GUI.monitor.*;
import GUI.admin.*;

@SuppressWarnings("serial")
/**
 * Ventana del proyecto con todas las vistas
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class VentanaProyecto extends JFrame{
	private LoginPanel vistaLogin;
	private RegistroPanel vistaRegistro;
	
	//cliente
	private ReservasPanel vistaActividades;
	private ActividadGrupalPanel vistaActividadGrupal;
	private PlanPersonalizadoPanel vistaPlanPersonalizado;
	private EntrenamientoLibrePanel vistaEntrenamientoLibre;
	private NotificacionesPanel vistaNotificacionesCliente;
	private VerReservasPanel vistaVerReservas;

	//monitor
	private PantallaPrincipalMonitorPanel vistaPrincipalMonitor;
	private AccesoNominaPanel vistaAccesoNomina;
	private AccesoHorarioMonitorPanel vistaAccesoHorarioMonitor;
	private CrearPlanPersonalizadoPanel vistaCrearPlanPersonalizado;
	private CancelarClaseMonitorPanel vistaCancelarClase;
	private ConsultarNotificacionesPanel vistaConsultarNotificacionesPanel;
	private CrearSesionPlanPersonalizadoPanel vistaCrearSesionPlanPersonalizado;
	
	//admin
	private AdministradorRegistroMonitorPanel vistaRegistroMonitor;
	private PlanesPorMonitorPanel vistaPlanesPorMonitor;
	private AdministradorPrincipalPanel vistaAdminPrincipal;
	private PanelAdministradorMonitores vistaPanelControlMonitores;
	private CambiarPrecioTarifa vistaCambiarPrecioTarifa;
	private SalasPanel vistaSalas;
	private PanelCreacionActividadGrupal vistaCreacionActividad;
	private PanelCreacionSesionActividadGrupal vistaCreacionActividadSesion;
	private GimnasioValoresPredeterminados vistaGimnasioPredeterminado;
	private OcupacionSalasPanel vistaOcupacionSalas;
	private VerBeneficiosPanel vistaVerBeneficios;
	private AdministradorEntrenamientoLibre vistaAdminEntrenamiento;
	
	
	//CONTROLADORES
	private ControlLoginRegistroPanel contRegistroLoginRegistro;
	private ControlLoginNormal contLoginNormal;
	
	//Cliente
	private ControlReservaGrupal contReservaGrupal;
	private ControlReservaPlanPersonalizado contPlanPersonalizado;
	private ControlReservaEntrenamientoLibre contEntrenamientoLibre;
	private ControlRegistro contRegistro;
	private ControlBotonReservaActividadGrupal contBotonReservaGrupal;
	private ControlBackEntrenamientoLibre contBackEntrenamientoLibre;
	private ControlBackPlanPersonalizado contBackPlanPersonalizado;
	private ControlNotificaciones contNotificacionesCliente;
	private ControlVerReservas contVerReservas;
	private ControlBackVerReservas contBackVerReservas;
	private ControlCancelarVerReservas contCancelarVerReservas;
	private ControlBackNotificaciones contBackNotificaciones;
	private ControlBackActividadGrupal contBackActividadGrupal;
	private ControlBotonReservaPlanPersonalizado contBotonReservaPlanPersonalizado;
	private ControlBotonReservaEntrenamientoLibre contBotonReservaEntrenamientoLibre;
	private ControlBackRegistro contBackRegistro;
	private ControlRecargaActividades contRecarga; 
	
	//logout
	private ControlLogoutAdmin contLogoutAdmin;
	private ControlLogoutCliente contLogoutCliente;
	private ControlLogoutMonitor contLogoutMonitor;
	
	//monitor
	private ControlAccesoNomina contAccesoNomina;
	private ControlDescargaNomina contDescargaNomina;
	private ControlAccesoHorario contAccesoHorario;
	private ControlCrearPlanPersonalizado contCrearPlanPersonalizado;
	private ControlCancelarClase contCancelarClase;
	private ControlCrearPlanPersonalizadoBoton contCrearPlanPersonalizadoBoton;
	private ControlBackNomina contBackNomina;
	private ControlBackAccesoHorario contBackAccesoHorario;
	private ControlBackCrearPlan contBackCrearPlan;
	private ControlBackCancelarClase contBackCancelarClase;
	private ControlCancelarClaseBoton contCancelarClaseBoton;
	private ControlConsultarNotificaciones contConsultarNotificaciones;
	private ControlBackConsultarNotificaciones contBackConsultarNotificaciones;
	private ControlBackSesionPlanPersonalizado contBackSesionPlan;
	private ControlBotonCrearSesionPlan contBotonCrearSesionPlan;
	private ControlCrearSesionPlanPersonalizado contCrearSesionPlan;
	
	//admin
	private ControlBackup contBackup;
	private ControlBackupGuardar contBackupGuardar;
	private ControlRegistroMonitor contRegistroMonitor;
	private ControlPanelControlMonitor contPanelControlMonitores;
	private ControlMonitorRegistrado contMonitorRegistrado;
	private ControlPlanesPorMonitor contPlanesPorMonitor;
	private ControlCambiarPrecioTarifa contCambiarPrecioTarifa;
	private ControlBackRegistroMonitor contBackRegistroMonitor;
	private ControlBackPanelControl contBackPanelControl;
	private ControlBackPrecioTarifas contBackPrecioTarifas;
	private ControlBackPlanesPorMonitor contBackPlanesPorMonitor;
	private ControlSalasAdmin contSalas;
	private ControlBackSalas contBackSalas;
	private ControlCrearSalas contCrearSalas;
	private ControlActividades contCrearActividades;
	private ControlActividadesSesion contCrearSesionActividades;
	private ControlGimnasioPredeterminado contGimnasioPredeterminado;
	private ControlGuardarValores contGuardarValores;
	private ControlBackValores contBackValores;
	private ControlBackCrearSesionActividades contBackCrearSesionActividades;
	private ControlBackCrearActividades contBackCrearActividades;
	private ControlCrearActividad contCrearActividad;
	private ControlCrearSesionActividad contCrearSesionActividad;
	private ControlOcupacionSalas contOcupacionSalas;
	private ControlBackOcupacion contBackOcupacion;
	private ControlVerBeneficios contVerBeneficios;
	private ControlBackVerBeneficios contBackVerBeneficios;
	private ControlAdminEntrenamiento contAdminEntrenamiento;
	private ControlBackAdminEntrenaiento contBackAdminEntrenamiento;
	private ControlCrearSesionEntrenamiento contCrearEntrenamiento;
	
	private JPanel contentPane;
	
	/**
	 * Constructor de VentanaProyecto donde se crean todas las vistas del proyecto
	 */
	public VentanaProyecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());

		this.vistaLogin = new LoginPanel();
		contentPane.add(vistaLogin, "vistaLogin");

		this.vistaRegistro = new RegistroPanel(); 
		contentPane.add(vistaRegistro, "vistaRegistro");
		
		this.vistaActividades = new ReservasPanel();
		contentPane.add(vistaActividades, "vistaActividades");
		
		this.vistaActividadGrupal = new ActividadGrupalPanel();
		contentPane.add(vistaActividadGrupal, "vistaActividadGrupal");
		
		this.vistaPlanPersonalizado = new PlanPersonalizadoPanel();
		contentPane.add(vistaPlanPersonalizado, "vistaPlanPersonalizado");
		
		this.vistaEntrenamientoLibre = new EntrenamientoLibrePanel();
		contentPane.add(vistaEntrenamientoLibre, "vistaEntrenamientoLibre");
		
		this.vistaNotificacionesCliente = new NotificacionesPanel();
		contentPane.add(vistaNotificacionesCliente, "vistaNotificacionesCliente");
		
		this.vistaVerReservas = new VerReservasPanel();
		contentPane.add(vistaVerReservas, "vistaReservasCliente");
		
		
		this.vistaAdminPrincipal = new AdministradorPrincipalPanel();
		contentPane.add(vistaAdminPrincipal, "vistaAdminPrincipal");
		
		this.vistaPrincipalMonitor = new PantallaPrincipalMonitorPanel();
		contentPane.add(vistaPrincipalMonitor, "vistaMonitorPrincipal");
		
		
		this.vistaAccesoNomina = new AccesoNominaPanel();
		contentPane.add(vistaAccesoNomina, "vistaAccesoNomina");
		
		
		this.vistaPanelControlMonitores = new PanelAdministradorMonitores();
		contentPane.add(vistaPanelControlMonitores, "vistaPanelControlMonitores");
		
		this.vistaAccesoHorarioMonitor = new AccesoHorarioMonitorPanel();
		contentPane.add(vistaAccesoHorarioMonitor, "vistaAccesoHorario");
		
		
		this.vistaCrearPlanPersonalizado = new CrearPlanPersonalizadoPanel();
		contentPane.add(vistaCrearPlanPersonalizado, "vistaCrearPlanPersonalizado");
		
		this.vistaSalas = new SalasPanel();
		contentPane.add(vistaSalas, "vistaSalas");
		
		this.vistaCancelarClase = new CancelarClaseMonitorPanel();
		contentPane.add(vistaCancelarClase, "vistaCancelarClase");
		
		this.vistaRegistroMonitor = new AdministradorRegistroMonitorPanel();
		contentPane.add(vistaRegistroMonitor, "vistaRegistroMonitor");
		
		this.vistaPlanesPorMonitor = new PlanesPorMonitorPanel();
		contentPane.add(vistaPlanesPorMonitor, "vistaPlanesPorMonitor");
		
		this.vistaCambiarPrecioTarifa = new CambiarPrecioTarifa();
		contentPane.add(vistaCambiarPrecioTarifa, "vistaCambiarPrecioTarifa");
		
		this.vistaCreacionActividad = new PanelCreacionActividadGrupal();
		contentPane.add(vistaCreacionActividad, "vistaCreacionActividad");
		
		this.vistaCreacionActividadSesion = new PanelCreacionSesionActividadGrupal();
		contentPane.add(vistaCreacionActividadSesion, "vistaCreacionActividadSesion");
		
		this.vistaGimnasioPredeterminado = new GimnasioValoresPredeterminados();
		contentPane.add(vistaGimnasioPredeterminado, "vistaGimnasioPredeterminado");
		
		this.vistaOcupacionSalas = new OcupacionSalasPanel();
		contentPane.add(vistaOcupacionSalas, "vistaOcupacionSalas");
		
		this.vistaVerBeneficios = new VerBeneficiosPanel();
		contentPane.add(vistaVerBeneficios, "vistaVerBeneficios");
		
		this.vistaConsultarNotificacionesPanel = new ConsultarNotificacionesPanel();
		contentPane.add(vistaConsultarNotificacionesPanel, "vistaConsultarNotificacionesPanel");
		
		this.vistaAdminEntrenamiento = new AdministradorEntrenamientoLibre();
		contentPane.add(vistaAdminEntrenamiento, "vistaAdminEntrenamiento");
		
		this.vistaCrearSesionPlanPersonalizado = new CrearSesionPlanPersonalizadoPanel();
		contentPane.add(vistaCrearSesionPlanPersonalizado, "vistaCrearSesionPlanPersonalizado");
	}
	
	/**
	 * Setter donde se establecen los controladores de cada vista
	 * 
	 * @param controlador clase Contralador que contiene todos los controladores
	 */
	public void setControlador(Controlador controlador) {
		this.contRegistroLoginRegistro = controlador.getControlLoginRegistro();
		vistaLogin.setControladorRegistro(contRegistroLoginRegistro);
		
		this.contLoginNormal = controlador.getControlLoginNormal();
		vistaLogin.setControladorActividades(contLoginNormal);
		
		this.contConsultarNotificaciones = controlador.getControlConsultarNotificaciones();
		vistaPrincipalMonitor.setConsultarNotificaciones(contConsultarNotificaciones);
		
		this.contBackConsultarNotificaciones = controlador.getControlBackConsultarNotificaciones();
		vistaConsultarNotificacionesPanel.setConsultarBackNotificaciones(contBackConsultarNotificaciones);
		
		this.contReservaGrupal = controlador.getControlReservaGrupal();
		vistaActividades.setControladorGrupal(contReservaGrupal);
		
		this.contPlanPersonalizado = controlador.getControlReservaPlanPersonalizado();
		vistaActividades.setControladorPlanPersonalizado(contPlanPersonalizado);
		
		this.contEntrenamientoLibre = controlador.getControlReservaEntrenamientoLibre();
		vistaActividades.setControladorEntrenamientoLibre(contEntrenamientoLibre);
		
		this.contVerReservas = controlador.getControlVerReservas();
		vistaActividades.setControladorVerReservas(contVerReservas);
		
		this.contCancelarVerReservas = controlador.getControlCancelarVerReservas();
		vistaVerReservas.setControladorCancelar(contCancelarVerReservas);
		
		this.contBackEntrenamientoLibre = controlador.getControlBackEntrenamientoLibre();
		vistaEntrenamientoLibre.setControladorBack(contBackEntrenamientoLibre);
		
		this.contBotonReservaEntrenamientoLibre = controlador.getControlBotonReservaEntrenamientoLibre();
		vistaEntrenamientoLibre.setControladorReserva(contBotonReservaEntrenamientoLibre);
		
		this.contBackPlanPersonalizado = controlador.getControlBackPlanPersonalizado();
		vistaPlanPersonalizado.setControladorBack(contBackPlanPersonalizado);
		
		this.contBotonReservaPlanPersonalizado = controlador.getControlBotonReservaPlanPersonalizado();
		vistaPlanPersonalizado.setControladorBoton(contBotonReservaPlanPersonalizado);
		
		this.contBackNotificaciones = controlador.getControlBackNotificaciones();
		vistaNotificacionesCliente.setControladorBack(contBackNotificaciones);
		
		this.contRegistro = controlador.getControlRegistro();
		vistaRegistro.setControladorRegistro(contRegistro);
		
		this.contBackRegistro = controlador.getControlBackRegistro();
		vistaRegistro.setControladorBack(contBackRegistro);
		
		this.contBotonReservaGrupal = controlador.getControlBotonReservaGrupal();
		vistaActividadGrupal.setControladorBotonReserva(contBotonReservaGrupal);
		
		this.contBackActividadGrupal = controlador.getControlBackActividadGrupal();
		vistaActividadGrupal.serControladorBackActividadGrupal(contBackActividadGrupal);
	
		this.contNotificacionesCliente = controlador.getControlNotificacionesCliente();
		vistaActividades.setControladorNotificaciones(contNotificacionesCliente);
		
		this.contCancelarClaseBoton = controlador.getControlCancelarClaseBoton();
		vistaCancelarClase.setControlCancelarClaseBoton(contCancelarClaseBoton);
		
		
		this.contAccesoNomina = controlador.getControlAccesoNomina();
		vistaPrincipalMonitor.setControladorAccesoNomina(contAccesoNomina);
		
		this.contAccesoHorario = controlador.getControlAccesoHorario();
		vistaPrincipalMonitor.setControladorAccesoHorario(contAccesoHorario);
		
		this.contLogoutAdmin = controlador.getControlLogoutAdmin();
		vistaAdminPrincipal.setControladorLogoutAdmin(contLogoutAdmin);
		
		this.contLogoutCliente = controlador.getControlLogoutCliente();
		vistaActividades.setControladorLogoutCliente(contLogoutCliente);
		
		this.contBackVerReservas = controlador.getControlBackVerReservas();
		vistaVerReservas.setControladorBack(contBackVerReservas);
		
		this.contLogoutMonitor = controlador.getControlLogoutMonitor();
		vistaPrincipalMonitor.setControladorLogout(contLogoutMonitor);
		
		this.contCrearPlanPersonalizado= controlador.getControlCrearPlanPersonalizado();
		vistaPrincipalMonitor.setControladorPlanPersonalizado(contCrearPlanPersonalizado);
		
		this.contCrearPlanPersonalizadoBoton = controlador.getControladorCrearPlanPersonalizadoBoton();
		vistaCrearPlanPersonalizado.setControladorCrearPlanPersonalizado(contCrearPlanPersonalizadoBoton);
		
		
		this.contDescargaNomina = controlador.getControladorDescargaNomina();
		vistaAccesoNomina.setControladorRegistro(contDescargaNomina);
		
		this.contBackNomina = controlador.getControlBackNomina();
		vistaAccesoNomina.setControladorBack(contBackNomina);
		
		this.contBackCrearPlan = controlador.getControladorBackPlan();
		vistaCrearPlanPersonalizado.setControladorBackCrearPlan(contBackCrearPlan);
		
		this.contBackSalas = controlador.getControlBackSalas();
		vistaSalas.setControladorBackSalas(contBackSalas);
		
		this.contCrearSalas = controlador.getControlSalasCreadas();
		vistaSalas.setControladorCrear(contCrearSalas);
		
		this.contBackup = controlador.getControlBackup();
		vistaAdminPrincipal.setControladorBackup(contBackup);
		
		this.contBackupGuardar = controlador.getControlBackupGuardar();
		vistaAdminPrincipal.setControladorBackupGuardar(contBackupGuardar);
		
		this.contPanelControlMonitores = controlador.getControlPanelControl();
		vistaAdminPrincipal.setControladorPanelControl(contPanelControlMonitores);
		
		this.contPlanesPorMonitor = controlador.getControlPlanesPorMonitor();
		vistaAdminPrincipal.setControladorPlanesPorMonitor(contPlanesPorMonitor);
		
		this.contCambiarPrecioTarifa = controlador.getControladorCambiarPrecioTarifa();
		vistaAdminPrincipal.setControladorPrecioTarifa(contCambiarPrecioTarifa);
		
		this.contSalas = controlador.getControlSalas();
		vistaAdminPrincipal.setControladorSalas(contSalas);
		
		this.contCancelarClase = controlador.getControlCancelarClase();
		vistaPrincipalMonitor.setControladorCancelarClase(contCancelarClase);
		
		this.contBackCancelarClase = controlador.getControlBackCancelarClase();
		vistaCancelarClase.setControladorBackCancelarClase(contBackCancelarClase);
		
		this.contRegistroMonitor = controlador.getControlRegistroMonitor();
		vistaPanelControlMonitores.setControladorRegistroMonitor(contRegistroMonitor);
		
		this.contBackPanelControl = controlador.getControlBackPanelControl();
		vistaPanelControlMonitores.setControladorBack(contBackPanelControl);
		
		this.contMonitorRegistrado = controlador.getControlMonitorRegistrado();
		vistaRegistroMonitor.setControladorMonitorRegistrado(contMonitorRegistrado);
		
		this.contBackRegistroMonitor = controlador.getControlBackRegistroMonitor();
		vistaRegistroMonitor.setControladorBackRegistroMonitor(contBackRegistroMonitor);
		
		this.contBackAccesoHorario = controlador.getControladorBackAccesoHorario();
		vistaAccesoHorarioMonitor.setControladorBack(contBackAccesoHorario);
		
		this.contBackPrecioTarifas = controlador.getControlBackPrecioTarifas();
		vistaCambiarPrecioTarifa.setControladorBack(contBackPrecioTarifas);
		
		this.contBackPlanesPorMonitor = controlador.getControladorPlanesPorMonitor();
		vistaPlanesPorMonitor.setControladorBack(contBackPlanesPorMonitor);
		
		this.contCrearActividades = controlador.getControlCrearActividades();
		vistaAdminPrincipal.setControladorActividades(contCrearActividades);
		
		this.contCrearSesionActividades = controlador.getControlCrearActividadesSesion();
		vistaAdminPrincipal.setControladorActividadesSesion(contCrearSesionActividades);
		
		this.contGimnasioPredeterminado = controlador.getControlGimnasioPredeterminado();
		vistaAdminPrincipal.setControladorGimnasioPredeterminado(contGimnasioPredeterminado);
		
		this.contGuardarValores = controlador.getControlGuardarValores();
		vistaGimnasioPredeterminado.setControlGuardarValores(contGuardarValores);
		
		this.contBackValores = controlador.getControlBackValores();
		vistaGimnasioPredeterminado.setControlBackValores(contBackValores);
		
		this.contBackCrearSesionActividades = controlador.getControlBackCrearSesionActividades();
		vistaCreacionActividadSesion.setControlBackCrearSesionActividades(contBackCrearSesionActividades);
		
		this.contBackCrearActividades = controlador.getControlBackCrearActividades();
		vistaCreacionActividad.setControlBackCrearActividades(contBackCrearActividades);
		
		this.contCrearActividad = controlador.getControlCrearActividad();
		vistaCreacionActividad.setControlCrearActividad(contCrearActividad);
		
		this.contCrearSesionActividad = controlador.getControlCrearSesionActividad();
		vistaCreacionActividadSesion.setControlCrearSesionActividad(contCrearSesionActividad);
		
		this.contOcupacionSalas = controlador.getControlOcupacionSalas();
		vistaAdminPrincipal.setControladorOcupacionSalas(contOcupacionSalas);
		
		this.contBackOcupacion = controlador.getControlBackOcupacion();
		vistaOcupacionSalas.setControladorBack(contBackOcupacion);
		
		this.contVerBeneficios = controlador.getControlVerBeneficios();
		vistaAdminPrincipal.setControladorVerBeneficios(contVerBeneficios);
		
		this.contBackVerBeneficios = controlador.getControlBackVerBeneficios();
		vistaVerBeneficios.setBackVerBeneficios(contBackVerBeneficios);
		
		this.contRecarga = controlador.getControlRecarga();
		vistaActividadGrupal.setControlRecargaActividad(contRecarga);
		
		this.contAdminEntrenamiento = controlador.getControlAdminENtrenamiento();
		vistaAdminPrincipal.setControlAdminEntrenamiento(contAdminEntrenamiento);
		
		this.contBackAdminEntrenamiento = controlador.getControlBackAdminEntrenamiento();
		vistaAdminEntrenamiento.setControlBackAdminEntrenaiento(contBackAdminEntrenamiento);
		
		this.contCrearEntrenamiento = controlador.getControlCrearEntrenamiento();
		vistaAdminEntrenamiento.setControlCrearSesionEntrenamiento(contCrearEntrenamiento);
		
		this.contBackSesionPlan = controlador.getControlBackSesionPersonalizada();
		vistaCrearSesionPlanPersonalizado.setControlBackCrearSesionActividades(contBackSesionPlan);
		
		this.contCrearSesionPlan = controlador.getControlSesionPlan();
		vistaPrincipalMonitor.setControladorCrearSesionPlanPersonalizado(contCrearSesionPlan);
		
		this.contBotonCrearSesionPlan = controlador.getControlCrearSesionPlan();
		vistaCrearSesionPlanPersonalizado.setControlCrearSesionPlan(contBotonCrearSesionPlan);
	}

	/**
	 * Getter
	 * 
	 * @return LoginPanel se obtiene la vista del panel del login
	 */
	public LoginPanel getVistaLogin() {
		return this.vistaLogin;
	}
	
	/**
	 * Getter
	 * 
	 * @return ConsultarNotificacionesPanel se obtiene la vista del panel de las notificaciones del monitor
	 */
	public ConsultarNotificacionesPanel getVistaConsultarNotificaciones(){
		return this.vistaConsultarNotificacionesPanel;
	}
	
	/**
	 * Getter
	 * 
	 * @return RegistroPanel se obtiene la vista del registro del cliente
	 */
	public RegistroPanel getVistaRegistro() {
		return this.vistaRegistro;
	}
	
	/**
	 * Getter
	 * 
	 * @return ReservasPanel se obtiene la vista principal del cliente
	 */
	public ReservasPanel getVistaActividades() {
		return this.vistaActividades;
	}
	
	/**
	 * Getter
	 * 
	 * @return ActividadGrupalPanel se obtiene la vista de reservas de actividad grupal
	 */
	public ActividadGrupalPanel getVistaActividadGrupal() {
		return this.vistaActividadGrupal;
	}
	
	/**
	 * Getter
	 * 
	 * @return VerReservasPanel se obtiene la vista de las reservas que ha hecho un cliente
	 */
	public VerReservasPanel getVistaVerReservas() {
		return this.vistaVerReservas;
	}
	
	/**
	 * Getter
	 * 
	 * @return PlanPersonalizadoPanel se obtiene la vista para la reserva de un plan personalizado
	 */
	public PlanPersonalizadoPanel getVistaPlanPersonalizado() {
		return this.vistaPlanPersonalizado;
	}
	
	/**
	 * Getter
	 * 
	 * @return EntrenamientoLibrePanel se obtiene la vista para la reserva de un entrenamiento libre
	 */
	public EntrenamientoLibrePanel getVistaEntrenamientoLibre() {
		return this.vistaEntrenamientoLibre;
	}
	
	/**
	 * Getter
	 * 
	 * @return NotificacionesPanel se obtiene la vista de las notificacionesd de un cliente
	 */
	public NotificacionesPanel getVistaNotificacionesCliente() {
		return this.vistaNotificacionesCliente;
	}
	
	/**
	 * Getter
	 * 
	 * @return AdministradorPrincipalPanel se obtiene la vista del panel principal del administrador
	 */
	public AdministradorPrincipalPanel getVistaAdminPrincipal() {
		return this.vistaAdminPrincipal;
	}
	
	/**
	 * Getter
	 * 
	 * @return PantallaPrincipalMonitorPanel se obtiene la vista de la pantalla principal del monitor
	 */
	public PantallaPrincipalMonitorPanel getVistaPantallaPrincipalMonitor() {
		return this.vistaPrincipalMonitor;
	}
	
	/**
	 * Getter
	 *
	 * @return AccesoNominaPanel se obtiene la vista del acceso a la nomina del monitor
	 */
	public AccesoNominaPanel getVistaAccesoPanel(){
		return this.vistaAccesoNomina;
	}
	
	/**
	 * Getter
	 * 
	 * @return AccesoHorarioMonitorPanel se obtiene la vista del horario del monitor
	 */
	public AccesoHorarioMonitorPanel getVistaAccesoHorarioMonitor(){
		return this.vistaAccesoHorarioMonitor;
	}
	
	/**
	 * Getter
	 * 
	 * @return CrearPlanPersonalizadoPanel se obtiene la vista de crear un plan personalizado por un monitor
	 */
	public CrearPlanPersonalizadoPanel getVistaCrearPlanPersonalizado(){
		return this.vistaCrearPlanPersonalizado;
	}
	
	/**
	 * Getter
	 * 
	 * @return CancelarClaseMonitorPanel se obtiene la vista de cancelar una clase por un monitor
	 */
	public CancelarClaseMonitorPanel getVistaCancelarClase(){
		return this.vistaCancelarClase;
	}
	
	/**
	 * Getter
	 * 
	 * @return SalasPanel se obtiene la vista de la creacion de salas por el administrador
	 */
	public SalasPanel getVistaSalas() {
		return this.vistaSalas;
	}
	
	/**
	 * Getter
	 * 
	 * @return PanelAdministradorMonitores se obtiene la vista del panel de control de monitores por el administrador
	 */
	public PanelAdministradorMonitores getVistaPanelControlMonitores() {
		return this.vistaPanelControlMonitores;
	}
	
	/**
	 * Getter
	 * 
	 * @return AdministradorRegistroMonitorPanel se obtiene la vista de registro de un monitor por el administrador
	 */
	public AdministradorRegistroMonitorPanel getVistaRegistroMonitor() {
		return this.vistaRegistroMonitor;
	}
	
	/**
	 * Getter
	 * 
	 * @return PlanesPorMonitorPanel se obtiene la vista de los planes que oferta un monitor
	 */
	public PlanesPorMonitorPanel getVistaPlanesPorMonitor() {
		return this.vistaPlanesPorMonitor;
	}
	
	/**
	 * Getter
	 * 
	 * @return CambiarPrecioTarifa se obtiene la vista del cambio de precio de una tarifa
	 */
	public CambiarPrecioTarifa getVistaCambiarPrecioTarifa() {
		return this.vistaCambiarPrecioTarifa;
	}
	
	/**
	 * Getter
	 * 
	 * @return PanelCreacionActividadGrupal se obtiene la vista de la creacion de una actividad grupal
	 */
	public PanelCreacionActividadGrupal getVistaCrearActividadGrupal(){
		return this.vistaCreacionActividad;
	}
	
	/**
	 * Getter
	 * 
	 * @return PanelCreacionSesionActividadGrupal se obtiene la vista de la creacion de una sesion de una actividad grupal
	 */
	public PanelCreacionSesionActividadGrupal getVistaCrearActividadGrupalSesion(){
		return this.vistaCreacionActividadSesion;
	}
	
	/**
	 * Getter
	 * 
	 * @return GimnasioValoresPredeterminados se obtiene la vista de la definicion de los valores predeterminados del gimnasio
	 */
	public GimnasioValoresPredeterminados getVistaGimnasioPredeterminado(){
		return this.vistaGimnasioPredeterminado;
	}
	
	/**
	 * Getter
	 * 
	 * @return OcupacionSalasPanel se obtiene la vista de la ocupacion de las salas del gimnasio
	 */
	public OcupacionSalasPanel getVistaOcupacionSalas() {
		return this.vistaOcupacionSalas;
	}
	
	/**
	 * Getter
	 * 
	 * @return VerBeneficiosPanel se obtiene la vista de los beneficios del gimnasio
	 */
	public VerBeneficiosPanel getVistaBeneficios() {
		return this.vistaVerBeneficios;
	}
	/**
	 * Getter
	 * @return AdministradorEntrenamientoLibre se obtiene la vista del panel de creacion de entrenamiento libre
	 */
	public AdministradorEntrenamientoLibre getVistaAdminEntrenamiento() {
		return this.vistaAdminEntrenamiento;
	}
	
	/**
	 * Getter
	 * 
	 * @return CrearSesionPlanPersonalizadoPanel se obtiene la vista del panel de creacion de una sesion de un plan personalizado
	 */
	public CrearSesionPlanPersonalizadoPanel getVistaCrearSesionPlan() {
		return this.vistaCrearSesionPlanPersonalizado;
	}
	
	/**
	 * Muestra el panel que le indicamos
	 * 
	 * @param carta panel que tiene que mostrar
	 */
	public void mostrarPanel(String carta) {
		CardLayout l = (CardLayout)contentPane.getLayout();
		l.show(contentPane, carta);
	}

	
}
