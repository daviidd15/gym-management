package gimnasio;

import java.time.LocalTime;
import java.io.*;
/**
 * Clase abstracta sala, es padre de sala simple y sala compuesta
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public abstract class Sala implements Serializable {
	private String nombre;
	protected String descripcion;
	protected int aforo;
	protected boolean climatizacion;
	protected LocalTime horaInicioClimatizacion;
	protected LocalTime horaFinClimatizacion;
	private boolean ocupada;

	/**
	 * Constructor de sala
	 * 
	 * @param nom             nombre de la sala
	 * @param descr           descripcion de la sala
	 * @param afo             aforo de la sala
	 * @param clim            boolean que establece si la sala esta climatizada
	 * @param horaInicioClima hora en la que se inicia la climatizacion
	 * @param horaFinClima    hora en la finaliza la climatizacion
	 */
	public Sala(String nom, String descr, int afo, boolean clim, LocalTime horaInicioClima, LocalTime horaFinClima) {
		this.climatizacion = clim;
		this.ocupada = false;
		/* Así controlamos que haya podido introducir mal el horario */
		if (clim == false) {
			// Tambien se le puede dar valor con el horario = LocalDate.of();
			this.horaInicioClimatizacion = null;
			this.horaFinClimatizacion = null;
		} else {
			this.horaFinClimatizacion = horaFinClima;
			this.horaInicioClimatizacion = horaInicioClima;
		}

		this.nombre = nom;
		this.descripcion = descr;
		this.aforo = afo;
	}

	/**
	 * Getter
	 * 
	 * @return entero con el aforo de la sala
	 */
	public int getAforo() {
		return this.aforo;
	}

	/**
	 * Getter
	 * 
	 * @return true si la sala esta climatizada o false en caso contrario
	 */
	public boolean getClimatizacion() {
		return this.climatizacion;
	}

	/**
	 * Getter
	 * 
	 * @return true si la sala esta ocupada o false en caso contrario
	 */
	public boolean getOcupacion() {
		return this.ocupada;
	}

	/**
	 * Getter
	 * 
	 * @return hora en la que se inicia la climatizacion
	 */
	public LocalTime getHorarioInicioClima() {
		return this.horaInicioClimatizacion;
	}

	/**
	 * Getter
	 * 
	 * @return hora en la que finaliza la climatizacion
	 */
	public LocalTime getHorarioFinClima() {
		return this.horaFinClimatizacion;
	}

	/**
	 * Getter
	 * 
	 * @return nombre de la sala
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Setter
	 * 
	 * @param estado boolean con el que establece si la sala esta ocupada o no
	 */
	public void setOcupacion(boolean estado) {
		this.ocupada = estado;

	}

	/**
	 * Setter
	 * 
	 * @param climatizacion boolean con el que establece si la sala esta climatizada
	 *                      o no
	 */
	public void setClimatizacion(boolean climatizacion) {
		this.climatizacion = climatizacion;
		if (climatizacion == false) {
			this.horaInicioClimatizacion = null;
			this.horaFinClimatizacion = null;
		}
	}

	/**
	 * Setter
	 * 
	 * @param horaInicio hora en la que establece que inicia la climatizacion
	 * @return true si se ha establecido bien la hora
	 */
	public boolean setHoraInicioClimatizacion(LocalTime horaInicio) {
		if (horaInicio == null)
			return false;

		if (this.climatizacion == true) {
			this.horaInicioClimatizacion = horaInicio;
			return true;
		}
		return false;
	}

	/**
	 * Setter
	 * 
	 * @param horaFin hora en la que establece que finaliza la climatizacion
	 * @return true si se ha establecido bien la hora
	 */
	public boolean setHoraFinClimatizacion(LocalTime horaFin) {
		if (horaFin == null)
			return false;

		if (this.climatizacion == true) {
			this.horaFinClimatizacion = horaFin;
			return true;
		}
		return false;
	}

	/**
	 * Metodo abstracto que se va a implementar en su hija sala compuesta
	 * @param nombre nombre de la sala
	 * @param aforo aforo que se desea para dicha sala
	 * @return true o false
	 */
	public abstract boolean definirSubsSalaSimple(String nombre, int aforo);

	/**
	 * Metodo abstracto que se va a implementar en su hija sala compuesta
	 * @param nombre nombre de la sala
	 * @param aforo aforo que se desea para dicha sala
	 * @return true o false
	 */
	public abstract boolean definirSubsSalaCompuesta(String nombre, int aforo);
	
	/**
	 * Metodo que determina si una sala es compuesta
	 * 
	 * @return boolean true si es una sala compuesta o false en caso contrario
	 */
	public abstract boolean esCompuesta();

}
