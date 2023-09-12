package actividades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.time.temporal.ChronoUnit;

import gimnasio.*;
import usuarios.*;

/**
 * Clase de actividad grupal, la cual es hija de actividad monitorizada
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class ActividadGrupal extends ActividadMonitorizada implements Serializable{
	private double precio;

	/**
	 * Constructor de la clase Actividad Grupal
	 * 
	 * @param nombre                de la actividad
	 * @param precio                de la actividad grupal
	 * @param monitor               que imparte la actividad
	 * @param sesionesRequeridasMin requisito minimo de sesiones
	 * @param sesionesRequeridasMax requisito maximo de sesiones
	 * @param edadMinima            requisito minimo de edad
	 * @param edadMaxima            requisito maximo de edad
	 * @param antiguedadMin         requisito minimo de antiguedad en el gimnasio
	 * @param antiguedadMax         requisito maximo de antiguedad en el gimnasio
	 */
	public ActividadGrupal(String nombre, double precio, Monitor monitor, int sesionesRequeridasMin,
			int sesionesRequeridasMax, int edadMinima, int edadMaxima, int antiguedadMin, int antiguedadMax) {
		super(nombre, monitor, sesionesRequeridasMin, sesionesRequeridasMax, edadMinima, edadMaxima, antiguedadMin,
				antiguedadMax);
		this.precio = precio;

	}

	/**
	 * Getter
	 * 
	 * @return lista de requisitos de la clase padre
	 */
	@Override
	public List<Requisito> getRequisitos() {
		return super.getRequisitos();
	}

	/**
	 * Getter
	 * 
	 * @return precio de la actividad grupal
	 */
	public double getPrecio() {
		return this.precio;
	}

	/**
	 * Se crea una nueva sesion de la actividad grupal
	 * 
	 * @param fecha      en la que se crea la sesion
	 * @param horaInicio hora en la que se inicia la sesion
	 * @param horaFin    hora en la que finaliza la sesion
	 * @param simple     sala en la que se imparte la sesion
	 * @return true en caso de que se haya creado bien la actividad grupal o false
	 *         en caso de que haya ocurrido algun error
	 */
	public boolean crearSesionActividadGrupal(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
			SalaSimple simple) {
		int nHoras = 0;

		if (fecha == null || horaInicio == null || horaFin == null || simple == null)
			return false;
			
		/*if(mono.getMonitor().getHorario().contains(mono)){
			System.out.println("Da error aqui\n");
			return false;
		}*/

		if (horaInicio.compareTo(horaFin) > 0) {
			System.out.println("ERROR HORA INICIO FIN\n");
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

		for(Sesion ss: Gimnasio.getGimnasio().getSesiones()){
			if(ss.getFecha().equals(fecha)){
			if(ss.getHoraInicio().equals(horaInicio) || ss.getHoraFin().equals(horaFin)||( horaInicio.isAfter(ss.getHoraInicio()) && horaInicio.isBefore(ss.getHoraFin())) ||  ( horaFin.isAfter(ss.getHoraInicio()) && horaFin.isBefore(ss.getHoraFin()))){
				return false;
			}
		}
		}

		nHoras = (int) ChronoUnit.HOURS.between(horaInicio, horaFin);
		Sesion s = new Sesion(fecha, horaInicio, horaFin, simple, this);
		if (s!=null) {
			Gimnasio.getGimnasio().getSesiones().add(s);
			return this.getMonitor().aumentarHorasTrabajadas(nHoras);
		}
		return false;
	}
	


	/**
	 * Metodo que determina si es un plan personalizado
	 * 
	 * @return false porque no es un plan personalizado
	 */
	public boolean esPlanPersonalizado(){
		return false;
	}
	
	/**
	 * Metodo que determina que es una actividad grupal
	 * 
	 * @return true porque es una actividad grupal
	 */
	public boolean esActividadGrupal(){
		return true;
	}
}
