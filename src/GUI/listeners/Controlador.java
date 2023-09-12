package GUI.listeners;

import GUI.VentanaProyecto;
import GUI.listeners.admin.*;
import GUI.listeners.cliente.*;
import GUI.listeners.monitor.*;
import gimnasio.Gimnasio;

/**
 * Controlador principal del proyecto, inicializa todos los controladores
 * 
 * @author  Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class Controlador {
	private ControlLoginNormal contLoginNormal;
	
	private ControlLoginRegistroPanel contLoginRegistro;
	
	//cliente
	private ControlReservaGrupal contReservaGrupal;
	private ControlReservaPlanPersonalizado contReservaPlanPersonalizado;
	private ControlReservaEntrenamientoLibre contReservaEntrenamientoLibre;
	private ControlRegistro contRegistro;
	private ControlBotonReservaActividadGrupal contBotonReservaActividadGrupal;
	private ControlBackEntrenamientoLibre contBackEntrenamientoLibre;
	private ControlBackPlanPersonalizado contBackPlanPersonalizado;
	private ControlNotificaciones contNotificacionesCliente;
	private ControlVerReservas contVerReservas;
	private ControlCancelarVerReservas contCancelarVerReservas;
	private ControlBackVerReservas contBackVerReservas;
	private ControlBackNotificaciones contBackNotificaciones;
	private ControlBackActividadGrupal contBackActividadGrupal;
	private ControlBotonReservaPlanPersonalizado contBotonReservaPlanPersonalizado;
	private ControlBotonReservaEntrenamientoLibre contBotonReservaEntrenamientoLibre;
	private ControlBackRegistro contBackRegistro;
	private ControlRecargaActividades contRecarga;
	
	//monitor
	private ControlAccesoNomina contAccesoNomina;
	private ControlAccesoHorario contAccesoHorario;
	private ControlBackNomina contBackNomina;
	private ControlCrearPlanPersonalizado contCrearPlanPersonalizado;
	private ControlCancelarClase contCancelarClase;
	private ControlDescargaNomina contDescargaNomina;
	private ControlCrearPlanPersonalizadoBoton contCrearPlanPersonalizadoBoton;
	private ControlBackAccesoHorario contBackAccesoHorario;
	private ControlBackCrearPlan contBackCrearPlan;
	private ControlBackCancelarClase contBackCancelarClase;
	private ControlCancelarClaseBoton contCancelarClaseBoton;
	private ControlBackConsultarNotificaciones contBackConsultarNotificaciones;
	private ControlConsultarNotificaciones contConsultarNotificaciones;
	private ControlBackSesionPlanPersonalizado contBackCrearSesionPlan;
	private ControlBotonCrearSesionPlan contBotonCrearSesionPlan;
	private ControlCrearSesionPlanPersonalizado contCrearSesionPlan;
	
	//logout
	private ControlLogoutAdmin contLogoutAdmin;
	private ControlLogoutCliente contLogoutCliente;
	private ControlLogoutMonitor contLogoutMonitor;
	
	//admin
	private ControlBackup contBackup;
	private ControlBackupGuardar contBackupGuardar;
	private ControlPanelControlMonitor contPanelControlMonitores;
	private ControlRegistroMonitor contRegistroMonitor;
	private ControlMonitorRegistrado contMonitorRegistrado;
	private ControlPlanesPorMonitor contPlanesPorMonitor;
	private ControlCambiarPrecioTarifa contCambiarPrecioTarifa;
	private ControlBackRegistroMonitor contBackRegistroMonitor;
	private ControlBackPanelControl contBackPanelControl;
	private ControlBackPlanesPorMonitor contBackPlanesPorMonitor;
	private ControlBackPrecioTarifas contBackPrecioTarifas;
	private ControlBackSalas contBackSalas;
	private ControlSalasAdmin contSalas;
	private ControlCrearSalas contCrearSalas;
	private ControlActividades contCrearActividades;
	private ControlActividadesSesion contCrearActividadesSesion;
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
	
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador 
	 * 
	 * @param frame ventana del proyecto
	 */
	public Controlador(VentanaProyecto frame) {
		this.frame = frame;
		
		this.contLoginRegistro = new ControlLoginRegistroPanel(frame);
		this.contLoginNormal = new ControlLoginNormal(frame);
		
		//Cliente
		this.contReservaGrupal = new ControlReservaGrupal(frame);
		this.contReservaPlanPersonalizado = new ControlReservaPlanPersonalizado(frame);
		this.contReservaEntrenamientoLibre = new ControlReservaEntrenamientoLibre(frame);
		this.contRegistro = new ControlRegistro(frame); 
		this.contBotonReservaActividadGrupal = new ControlBotonReservaActividadGrupal(frame); 
		this.contBackEntrenamientoLibre = new ControlBackEntrenamientoLibre(frame);
		this.contBackPlanPersonalizado = new ControlBackPlanPersonalizado(frame);
		this.contNotificacionesCliente = new ControlNotificaciones(frame);
		this.contVerReservas = new ControlVerReservas(frame);
		this.contBackVerReservas = new ControlBackVerReservas(frame);
		this.contBackNotificaciones = new ControlBackNotificaciones(frame);
		this.contBackActividadGrupal = new ControlBackActividadGrupal(frame);
		this.contBotonReservaPlanPersonalizado = new ControlBotonReservaPlanPersonalizado(frame);
		this.contBotonReservaEntrenamientoLibre = new ControlBotonReservaEntrenamientoLibre(frame);
		this.contCancelarVerReservas = new ControlCancelarVerReservas(frame);
		this.contBackRegistro = new ControlBackRegistro(frame);
		this.contRecarga = new ControlRecargaActividades(frame);
		
		//monitor
		this.contAccesoNomina = new ControlAccesoNomina(frame);
		this.contAccesoHorario = new ControlAccesoHorario(frame);
		this.contDescargaNomina = new ControlDescargaNomina(frame);
		this.contBackNomina = new ControlBackNomina(frame);
		this.contCancelarClase = new ControlCancelarClase(frame);
		this.contCrearPlanPersonalizadoBoton = new ControlCrearPlanPersonalizadoBoton(frame);
		this.contBackAccesoHorario = new ControlBackAccesoHorario(frame);
		this.contBackCrearPlan = new ControlBackCrearPlan(frame);
		this.contBackCancelarClase = new ControlBackCancelarClase(frame);
		this.contCancelarClaseBoton = new ControlCancelarClaseBoton(frame);
		this.contBackConsultarNotificaciones = new ControlBackConsultarNotificaciones(frame);
		this.contConsultarNotificaciones = new ControlConsultarNotificaciones(frame);
		this.contBackCrearSesionPlan = new ControlBackSesionPlanPersonalizado(frame);
		this.contBotonCrearSesionPlan = new ControlBotonCrearSesionPlan(frame);
		this.contCrearSesionPlan = new ControlCrearSesionPlanPersonalizado(frame);
		
		//admin
		this.contLogoutAdmin = new ControlLogoutAdmin(frame);
		this.contLogoutCliente = new ControlLogoutCliente(frame);
		this.contLogoutMonitor = new ControlLogoutMonitor(frame);
		this.contBackup = new ControlBackup(frame);
		this.contBackupGuardar = new ControlBackupGuardar(frame);
		this.contRegistroMonitor = new ControlRegistroMonitor(frame);
		this.contPanelControlMonitores = new ControlPanelControlMonitor(frame);
		this.contCrearPlanPersonalizado = new ControlCrearPlanPersonalizado(frame);
		this.contMonitorRegistrado = new ControlMonitorRegistrado(frame);
		this.contPlanesPorMonitor = new ControlPlanesPorMonitor(frame);
		this.contCambiarPrecioTarifa = new ControlCambiarPrecioTarifa(frame);
		this.contBackRegistroMonitor = new ControlBackRegistroMonitor(frame);
		this.contBackPanelControl = new ControlBackPanelControl(frame);
		this.contBackPrecioTarifas = new ControlBackPrecioTarifas(frame);
		this.contBackPlanesPorMonitor = new ControlBackPlanesPorMonitor(frame);
		this.contSalas = new ControlSalasAdmin(frame);
		this.contBackSalas = new ControlBackSalas(frame);
		this.contCrearSalas = new ControlCrearSalas(frame);
		this.contCrearActividades = new ControlActividades(frame);
		this.contCrearActividadesSesion = new ControlActividadesSesion(frame);
		this.contGimnasioPredeterminado = new ControlGimnasioPredeterminado(frame);
		this.contGuardarValores = new ControlGuardarValores(frame);
		this.contBackValores = new ControlBackValores(frame);
		this.contBackCrearSesionActividades = new ControlBackCrearSesionActividades(frame);
		this.contBackCrearActividades = new ControlBackCrearActividades(frame);
		this.contCrearActividad = new ControlCrearActividad(frame);
		this.contCrearSesionActividad= new ControlCrearSesionActividad(frame);
		this.contOcupacionSalas = new ControlOcupacionSalas(frame);
		this.contBackOcupacion = new ControlBackOcupacion(frame);
		this.contVerBeneficios = new ControlVerBeneficios(frame);
		this.contBackVerBeneficios = new ControlBackVerBeneficios(frame);
		this.contAdminEntrenamiento = new ControlAdminEntrenamiento(frame);
		this.contBackAdminEntrenamiento = new ControlBackAdminEntrenaiento(frame);
		this.contCrearEntrenamiento = new ControlCrearSesionEntrenamiento(frame);
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlLoginNormal controlador del login 
	 */
	public ControlLoginNormal getControlLoginNormal() {
		return this.contLoginNormal;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlLoginRegistroPanel
	 */
	public ControlLoginRegistroPanel getControlLoginRegistro() {
		return this.contLoginRegistro;
	}
	

	
	/**
	 * Getter
	 * 
	 * @return ControlReservaGrupal
	 */
	public ControlReservaGrupal getControlReservaGrupal() {
		return this.contReservaGrupal;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackCancelarClase
	 */
	public ControlBackCancelarClase getControlBackCancelarClase(){
		return this.contBackCancelarClase;
	}

	/**
	 * Getter
	 * 
	 * @return ControlReservaPlanPersonalizado
	 */
	public ControlReservaPlanPersonalizado getControlReservaPlanPersonalizado() {
		return this.contReservaPlanPersonalizado;
	}

	/**
	 * Getter
	 * 
	 * @return ControlReservaEntrenamientoLibre
	 */
	public ControlReservaEntrenamientoLibre getControlReservaEntrenamientoLibre() {
		return this.contReservaEntrenamientoLibre;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlCancelarVerReservas
	 */
	public ControlCancelarVerReservas getControlCancelarVerReservas(){
		return this.contCancelarVerReservas;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlRegistro
	 */
	public ControlRegistro getControlRegistro() {
		return this.contRegistro;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlCancelarClaseBoton
	 */
	public ControlCancelarClaseBoton getControlCancelarClaseBoton(){
		return this.contCancelarClaseBoton;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackEntrenamientoLibre
	 */
	public ControlBackEntrenamientoLibre getControlBackEntrenamientoLibre() {
		return this.contBackEntrenamientoLibre;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBotonReservaActividadGrupal
	 */
	public ControlBotonReservaActividadGrupal getControlBotonReservaGrupal() {
		return this.contBotonReservaActividadGrupal;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlAccesoNomina
	 */
	public ControlAccesoNomina getControlAccesoNomina() {
		return this.contAccesoNomina;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlAccesoHorario
	 */
	public ControlAccesoHorario getControlAccesoHorario() {
		return this.contAccesoHorario;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlCancelarClase
	 */
	public ControlCancelarClase getControlCancelarClase() {
		return this.contCancelarClase;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlConsultarNotificaciones
	 */
	public ControlConsultarNotificaciones getControlConsultarNotificaciones(){
		return this.contConsultarNotificaciones;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackConsultarNotificaciones
	 */
	public ControlBackConsultarNotificaciones getControlBackConsultarNotificaciones(){
		return this.contBackConsultarNotificaciones;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackNomina
	 */
	public ControlBackNomina getControlBackNomina() {
		return this.contBackNomina;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlCrearPlanPersonalizado
	 */
	public ControlCrearPlanPersonalizado getControlCrearPlanPersonalizado() {
		return this.contCrearPlanPersonalizado;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlCrearPlanPersonalizadoBoton
	 */
	public ControlCrearPlanPersonalizadoBoton getControladorCrearPlanPersonalizadoBoton() {
		return this.contCrearPlanPersonalizadoBoton;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackAccesoHorario
	 */
	public ControlBackAccesoHorario getControladorBackAccesoHorario() {
		return this.contBackAccesoHorario;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackPlanesPorMonitor
	 */
	public ControlBackPlanesPorMonitor getControladorPlanesPorMonitor() {
		return this.contBackPlanesPorMonitor;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlLogoutAdmin
	 */
	public ControlLogoutAdmin getControlLogoutAdmin(){
		return this.contLogoutAdmin;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlLogoutCliente
	 */
	public ControlLogoutCliente getControlLogoutCliente(){
		return this.contLogoutCliente;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlLogoutMonitor
	 */
	public ControlLogoutMonitor getControlLogoutMonitor(){
		return this.contLogoutMonitor;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackup
	 */
	public ControlBackup getControlBackup(){
		return this.contBackup;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackupGuardar
	 */
	public ControlBackupGuardar getControlBackupGuardar(){
		return this.contBackupGuardar;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlPlanesPorMonitor
	 */
	public ControlPlanesPorMonitor getControlPlanesPorMonitor() {
		return this.contPlanesPorMonitor;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackPrecioTarifas
	 */
	public ControlBackPrecioTarifas getControlBackPrecioTarifas() {
		return this.contBackPrecioTarifas;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlPanelControlMonitor
	 */
	public ControlPanelControlMonitor getControlPanelControl() {
		return this.contPanelControlMonitores;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlRegistroMonitor
	 */
	public ControlRegistroMonitor getControlRegistroMonitor() {
		return this.contRegistroMonitor;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlMonitorRegistrado
	 */
	public ControlMonitorRegistrado getControlMonitorRegistrado() {
		return this.contMonitorRegistrado;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlDescargaNomina
	 */
	public ControlDescargaNomina getControladorDescargaNomina() {
		return this.contDescargaNomina;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackCrearPlan
	 */
	public ControlBackCrearPlan getControladorBackPlan() {
		return this.contBackCrearPlan;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlCambiarPrecioTarifa
	 */
	public ControlCambiarPrecioTarifa getControladorCambiarPrecioTarifa() {
		return this.contCambiarPrecioTarifa;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackRegistroMonitor
	 */
	public ControlBackRegistroMonitor getControlBackRegistroMonitor() {
		return this.contBackRegistroMonitor;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackPanelControl
	 */
	public ControlBackPanelControl getControlBackPanelControl() {
		return this.contBackPanelControl;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackPlanPersonalizado
	 */
	public ControlBackPlanPersonalizado getControlBackPlanPersonalizado() {
		return this.contBackPlanPersonalizado;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackSalas
	 */
	public ControlBackSalas getControlBackSalas() {
		return this.contBackSalas;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlSalasAdmin
	 */
	public ControlSalasAdmin getControlSalas() {
		return this.contSalas;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlCrearSalas
	 */
	public ControlCrearSalas getControlSalasCreadas() {
		return this.contCrearSalas;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlNotificaciones
	 */
	public ControlNotificaciones getControlNotificacionesCliente() {
		return this.contNotificacionesCliente;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlActividades
	 */
	public ControlActividades getControlCrearActividades(){
		return this.contCrearActividades;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlActividadesSesion
	 */
	public ControlActividadesSesion getControlCrearActividadesSesion(){
		return this.contCrearActividadesSesion;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlVerReservas
	 */
	public ControlVerReservas getControlVerReservas() {
		return this.contVerReservas;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackVerReservas
	 */
	public ControlBackVerReservas getControlBackVerReservas() {
		return this.contBackVerReservas;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlGimnasioPredeterminado
	 */
	public ControlGimnasioPredeterminado getControlGimnasioPredeterminado() {
		return this.contGimnasioPredeterminado;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlGuardarValores
	 */
	public ControlGuardarValores getControlGuardarValores() {
		return this.contGuardarValores;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackValores
	 */
	public ControlBackValores getControlBackValores() {
		return this.contBackValores;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackCrearSesionActividades
	 */
	public ControlBackCrearSesionActividades getControlBackCrearSesionActividades() {
		return this.contBackCrearSesionActividades;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackCrearActividades
	 */
	public ControlBackCrearActividades getControlBackCrearActividades() {
		return this.contBackCrearActividades;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackNotificaciones
	 */
	public ControlBackNotificaciones getControlBackNotificaciones() {
		return this.contBackNotificaciones;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackActividadGrupal
	 */
	public ControlBackActividadGrupal getControlBackActividadGrupal() {
		return this.contBackActividadGrupal;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBotonReservaPlanPersonalizado
	 */
	public ControlBotonReservaPlanPersonalizado getControlBotonReservaPlanPersonalizado() {
		return this.contBotonReservaPlanPersonalizado;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlCrearActividad
	 */
	public ControlCrearActividad getControlCrearActividad(){
		return this.contCrearActividad;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlCrearSesionActividad
	 */
	public ControlCrearSesionActividad getControlCrearSesionActividad(){
		return this.contCrearSesionActividad;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlOcupacionSalas
	 */
	public ControlOcupacionSalas getControlOcupacionSalas() {
		return this.contOcupacionSalas;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackOcupacion
	 */
	public ControlBackOcupacion getControlBackOcupacion() {
		return this.contBackOcupacion;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBotonReservaEntrenamientoLibre
	 */
	public ControlBotonReservaEntrenamientoLibre getControlBotonReservaEntrenamientoLibre() {
		return this.contBotonReservaEntrenamientoLibre;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackRegistro
	 */
	public ControlBackRegistro getControlBackRegistro() {
		return this.contBackRegistro;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlRecargaActividades
	 */
	public ControlRecargaActividades getControlRecarga(){
		return this.contRecarga;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlVerBeneficios
	 */
	public ControlVerBeneficios getControlVerBeneficios() {
		return this.contVerBeneficios;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackVerBeneficios
	 */
	public ControlBackVerBeneficios getControlBackVerBeneficios() {
		return this.contBackVerBeneficios;
	}
	/**
	 * Getter
	 * @return ControlAdminEntrenamiento
	 */
	public ControlAdminEntrenamiento getControlAdminENtrenamiento() {
		return this.contAdminEntrenamiento;
	}
	/**
	 * Getter
	 * @return ControlBackAdminENtrenamiento
	 */
	public ControlBackAdminEntrenaiento getControlBackAdminEntrenamiento() {
		return this.contBackAdminEntrenamiento;
	}
	/**
	 * Getter
	 * @return ControlCrearSesionEntrenamiento
	 */
	public ControlCrearSesionEntrenamiento getControlCrearEntrenamiento() {
		return this.contCrearEntrenamiento;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBackSesionPlanPersonalizado
	 */
	public ControlBackSesionPlanPersonalizado getControlBackSesionPersonalizada() {
		return this.contBackCrearSesionPlan;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlBotonCrearSesionPlan
	 */
	public ControlBotonCrearSesionPlan getControlCrearSesionPlan() {
		return this.contBotonCrearSesionPlan;
	}
	
	/**
	 * Getter
	 * 
	 * @return ControlCrearSesionPlanPersonalizado
	 */
	public ControlCrearSesionPlanPersonalizado getControlSesionPlan() {
		return this.contCrearSesionPlan;
	}
}
