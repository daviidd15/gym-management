package gimnasio;

import java.io.*;
import java.time.LocalTime;


/**
 * Clase sala simple
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class SalaSimple extends Sala implements Serializable {

	/**
	 * Constructor de Sala Simple
	 * @param nombre          nombre de la sala
	 * @param desc            descripcion de la sala
	 * @param aforo             aforo de la sala
	 * @param climatizacion            boolean que establece si la sala esta climatizada
	 * @param horarioInicioClima hora en la que se inicia la climatizacion
	 * @param horarioFinClima    hora en la finaliza la climatizacion
	 */
	public SalaSimple(String nombre, String desc, int aforo, boolean climatizacion, LocalTime horarioInicioClima,
			LocalTime horarioFinClima) {
		super(nombre, desc, aforo, climatizacion, horarioInicioClima, horarioFinClima);
	}
	
	/**
	 * @return aforo de la sala
	 */
	public int getAforo() {
		return super.getAforo();
	}

	
	/**
	 * La implementacion devuelve false ya que no se pueden añadir salas a una sala simple
	 *  
	 * @param nombre de la sala
	 * @param aforo de la sala
	 */
	public boolean definirSubsSalaCompuesta(String nombre, int aforo) {
		return false;
	}

	
	/**
	 * La implementacion devuelve false ya que no se pueden añadir salas a una sala
	 * simple
	 * @param nombre de la sala
	 * @param aforo de la sala
	 */
	public boolean definirSubsSalaSimple(String nombre, int aforo) {
		return false;
	}
	
	public boolean esCompuesta(){
		return false;
	}
}
