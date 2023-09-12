package actividades;

import java.util.*;

import gimnasio.SalaSimple;

import java.io.Serializable;
import java.time.*;

import usuarios.*;

/**
 * Clase abstracta actividad monitorizada, padre de actividad grupal y de plan
 * personalizado
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public abstract class ActividadMonitorizada implements Serializable{
	private String nombre;
	private List<Requisito> requisitos;
	private Monitor monitor;
	protected List<Sesion> sesiones;

	/**
	 * Constructor de la clase actividad monitorizada
	 * 
	 * @param nombre                de la actividad
	 * @param monitor               que imparte la actividad
	 * @param sesionesRequeridasMin requisito minimo de sesiones
	 * @param sesionesRequeridasMax requisito maximo de sesiones
	 * @param edadMinima            requisito minimo de edad
	 * @param edadMaxima            requisito maximo de edad
	 * @param antiguedadMin         requisito minimo de antiguedad en el gimnasio
	 * @param antiguedadMax         requisito maximo de antiguedad en el gimnasio
	 */
	public ActividadMonitorizada(String nombre, Monitor monitor, int sesionesRequeridasMin, int sesionesRequeridasMax,
			int edadMinima, int edadMaxima, int antiguedadMin, int antiguedadMax) {
		this.nombre = nombre;
		this.requisitos = new ArrayList<Requisito>();
		this.requisitos.add(new ReqSesiones(sesionesRequeridasMin, sesionesRequeridasMax));
		this.requisitos.add(new ReqEdad(edadMinima, edadMaxima));
		this.requisitos.add(new ReqAntiguedad(antiguedadMin, antiguedadMax));
		this.monitor = monitor;
		this.sesiones = new ArrayList<Sesion>();
		this.monitor.addActividad(this);
	}

	/**
	 * Getter
	 * 
	 * @return Monitor de la actividad
	 */
	public Monitor getMonitor() {
		return this.monitor;
	}

	/**
	 * Getter
	 * 
	 * @return cadena con el nombre de la actividad
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Getter
	 * 
	 * @return lista de requisitos
	 */
	public List<Requisito> getRequisitos() {
		return this.requisitos;
	}
	


	/**
	 * Getter
	 * 
	 * @return lista de sesiones
	 */
	public List<Sesion> getSesiones() {
		return this.sesiones;
	}

	/**
	 * Metodo abstracto creado para la clase hija actividad grupal
	 * @return precio
	 */
	public abstract double getPrecio();

	/**
	 * Comprueba si existe un requsito con un minimo y un maximo en el array de
	 * requisitos de la actividad
	 * 
	 * @param min minimo del requisito a buscar
	 * @param max maximo del requisito a buscar
	 * @return true en caso de que haya encontrado el requisito o false en el caso
	 *         contrario
	 */
	public boolean tieneRequisito(int min, int max) {
		for (Requisito req : this.requisitos) {
			if (req.getMin() == min && req.getMax() == max)
				return true;
		}

		return false;
	}
	
	/**
	 * Metodo que determina si es un plan personalizado
	 * 
	 * @return boolean true en caso de que sea un plan personalizado
	 * y false en caso contrario
	 */
	public abstract boolean esPlanPersonalizado();
	
	/**
	 * Metodo que determina si es una actividad grupal
	 * 
	 * @return boolean true en caso de que sea un plan personalizado
	 * y false en caso contrario
	 */
	public abstract boolean esActividadGrupal();
	
	
	/**
	 * Obtiene una sesion a partir de la sala y de la hora
	 * 
	 * @param sala sala que utilizaremos para obtener la sesion
	 * @param horaInicio hora que utilizaremos para obtener la sesion
	 * @return Sesion que encontramos en el array de sesiones de actividad monitorizada
	 */
	public Sesion getSesionBySalaHora(SalaSimple sala, LocalTime horaInicio) {
		if (sala == null || horaInicio == null)
			return null;
		
		
		for (Sesion s: this.sesiones) {
			if (s.getSala().equals(sala) && s.getHoraInicio().equals(horaInicio)) {
				return s;
			}
		}
		
		return null;
	}
	
	/**
	 * Método que comprueba si existe una sesion a partir de su sala
	 * y de su hora de inicio
	 * 
	 * @param sala sala que utilizaremos para obtener si existe la sesion
	 * @param horaInicio hora que utilizaremos para obtener si existe la sesion
	 * @return true en caso de que exista la sesion o false en caso contrario
	 */
	public boolean existeSesion(SalaSimple sala, LocalTime horaInicio, LocalDate dia) {
		if (sala == null || horaInicio == null || dia ==null)
			return false;
		
		
		for (Sesion s: this.sesiones) {
			if (s.getSala().equals(sala) && s.getHoraInicio().equals(horaInicio) && s.getFecha().equals(dia)) {
				return true;
			}
		}
		
		return false;
	}

}
