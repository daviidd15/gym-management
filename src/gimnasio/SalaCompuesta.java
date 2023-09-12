package gimnasio;
import java.io.*;
import java.util.*;
import java.time.*;

/**
 * Clase sala compuesta que es hija de sala
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class SalaCompuesta extends Sala implements Serializable{
	private List<Sala> subsalas;

	/**
	 * Constructor de sala
	 * 
	 * @param nombre             nombre de la sala
	 * @param desc           descripcion de la sala
	 * @param aforo             aforo de la sala
	 * @param climatizacion            boolean que establece si la sala esta climatizada
	 * @param horarioInicioClima hora en la que se inicia la climatizacion
	 * @param horarioFinClima    hora en la finaliza la climatizacion
	 */
	public SalaCompuesta(String nombre, String desc, int aforo, boolean climatizacion, LocalTime horarioInicioClima,
			LocalTime horarioFinClima) {
		super(nombre, desc, aforo, climatizacion, horarioInicioClima, horarioFinClima);
		subsalas = new ArrayList<Sala>();
	}

	/**
	 * Define una sala simple dentro de la sala compuesta
	 * 
	 * @param nombre nombre de la sala simple
	 * @param aforo  entero con el numero de personas de aforo de la sala simple
	 * @return true si la salasimple se ha creado correctamente o false en caso
	 *         contrario
	 */
	public boolean definirSubsSalaSimple(String nombre, int aforo) {
		boolean st = false;

		if (aforo <= 0 || nombre == null)
			return false;

		SalaSimple ss = new SalaSimple(nombre, this.descripcion, aforo, this.climatizacion,
				this.horaInicioClimatizacion, this.horaFinClimatizacion);
		st = this.subsalas.add(ss);
		if (st == true)
			this.aforo = this.aforo + aforo;
		return st;
	}

	/**
	 * Define una sala compuesta dentro de una sala compuesta
	 * 
	 * @param nombre nombre de la sala simple
	 * @param aforo  entero con el numero de personas de aforo de esa sala compuesta
	 * @return true si se ha creado correctamente la sala compuesta o false en caso
	 *         contrario
	 */
	public boolean definirSubsSalaCompuesta(String nombre, int aforo) {
		boolean st = false;
		if (aforo <= 0 || nombre == null)
			return false;
		SalaCompuesta sc = new SalaCompuesta(nombre, this.descripcion, aforo, this.climatizacion,
				this.horaInicioClimatizacion, this.horaFinClimatizacion);
		st = this.subsalas.add(sc);
		if (st == true)
			this.aforo = this.aforo + aforo;
		return st;
	}
	
	/**
	 * Metodo que determina si una sala es compuesta
	 * 
	 * @return true ya que es una sala compuesta
	 */
	public boolean esCompuesta(){
		return true;
	}

}
