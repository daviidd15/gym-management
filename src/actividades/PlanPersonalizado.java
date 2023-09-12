package actividades;

import usuarios.*;
import gimnasio.*;

import java.util.*;
import java.io.Serializable;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Clase plan personalizado hija de actividad monitorizada
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class PlanPersonalizado extends ActividadMonitorizada implements Serializable{
	private String descripcion;
	private Objetivo objetivo;
	private Cliente clienteContratante;
	private ListaEspera listaEspera;
	private Cliente contratante;
	private Monitor monitor;

	/**
	 * Constructor de la clase
	 * 
	 * @param nombre                del plan personalizado
	 * @param descripcion           de lo que se va a llevar a cabo en el plan
	 * @param objetivo              del plan personalizado
	 * @param monitor               que imparte el plan personalizado
	 * @param sesionesRequeridasMin requisito minimo de sesiones
	 * @param sesionesRequeridasMax requisito maximo de sesiones
	 * @param edadMinima            requisito minimo de edad
	 * @param edadMaxima            requisito maximo de edad
	 * @param antiguedadMin         requisito minimo de antiguedad en el gimnasio
	 * @param antiguedadMax         requisito maximo de antiguedad en el gimnasio
	 */
	public PlanPersonalizado(String nombre, String descripcion, Objetivo objetivo, Monitor monitor,
			int sesionesRequeridasMin, int sesionesRequeridasMax, int edadMinima, int edadMaxima, int antiguedadMin,
			int antiguedadMax) {
		super(nombre, monitor, sesionesRequeridasMin, sesionesRequeridasMax, edadMinima, edadMaxima, antiguedadMin,
				antiguedadMax);
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		listaEspera = new ListaEspera();
	}

	/**
	 * devuelve -1 porque el precio es de la sesion del plan personalizado y no del
	 * plan en general
	 */
	public double getPrecio() {
		return -1;
	}
	
	/**
	 * Getter 
	 * 
	 * @return String con la descripcion del plan personalizado
	 */
	public String getDescripcion() {
		return this.descripcion;
	}
	
	/**
	 * Getter
	 * 
	 * @return Objetivo con el objetivo del plan personalizado
	 */
	public Objetivo getObjetivo() {
		return this.objetivo;
	}

	/**
	 * Setter
	 * 
	 * @param c cliente que contrata el plan
	 */
	public void setContratante(Cliente c) {
		this.contratante = c;
	}

	/**
	 * getter
	 * 
	 * @return contratante
	 */
	public Cliente getContratante() {
		return this.contratante;
	}

	/**
	 * Getter
	 * 
	 * @return lista de espera
	 */
	public ListaEspera getListaDeEspera() {
		return this.listaEspera;
	}

	/**
	 * Getter
	 * 
	 * @return lista de requisitos
	 */
	@Override
	public List<Requisito> getRequisitos() {
		return super.getRequisitos();
	}

	/**
	 * Se crea una nueva sesion del plan personalizado
	 * 
	 * @param fecha      en la que se crea la sesion
	 * @param horaInicio hora en la que se inicia la sesion
	 * @param horaFin    hora en la que finaliza la sesion
	 * @param simple     sala en la que se imparte la sesion
	 * @param mono       tipo de actividad monitorizada (actividad grupal)
	 * @return true en caso de que se haya creado bien la actividad grupal o false
	 *         en caso de que haya ocurrido algun error
	 */
	public boolean crearSesionPersonalizada(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, SalaSimple simple,
			ActividadMonitorizada mono) {
		int nHoras = 0;

		if (horaInicio.compareTo(horaFin) > 0 || simple == null || mono == null) {
			return false;
		}

		if (simple.getClimatizacion() == true) {
			// en horaInicio mayor que 0 porque la hora no debe de ser anterior al argumento
			// en horaFin menor que 0 porque la hora no tiene que ser posterior al argumento
			if (simple.getHorarioInicioClima().compareTo(horaInicio) > 0
					|| simple.getHorarioFinClima().compareTo(horaFin) < 0) {
				System.out.println("ERROR HORARIO CLIMA\n");
				return false;
			}
		}

		if (simple.getOcupacion() == true) {
			System.out.println("ERROR OCUPACION\n");
			return false;
		}

		nHoras = (int)ChronoUnit.HOURS.between(horaInicio, horaFin);
		Sesion s = new Sesion(fecha, horaInicio, horaFin, simple, mono);

		Gimnasio.getGimnasio().getSesiones().add(s);
		return this.getMonitor().aumentarHorasTrabajadas(nHoras);

	}
	
	
	/**
	 * Metodo que determina si es un plan personalizado
	 * 
	 * @return true porque es un plan personalizado
	 */
	public boolean esPlanPersonalizado(){
		return true;
	}
	
	/**
	 * Metodo que determina si es una actividad grupal
	 * 
	 * @return false porque no es una actividad grupal
	 */
	public boolean esActividadGrupal(){
		return false;
	}


}
