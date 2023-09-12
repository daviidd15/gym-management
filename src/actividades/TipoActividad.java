package actividades;

import java.io.Serializable;

/**
 * Clase con el tipo de actividad que elige el cliente para la tarifa plana en
 * el registro
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class TipoActividad implements Serializable{
	private String nombre;

	/**
	 * Constructor de la clase
	 * 
	 * @param nombre string con el nombre de la actividad grupal que vamos a elegir
	 */
	public TipoActividad(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter
	 * 
	 * @return string con el nombre del tipo de actividad
	 */
	public String getNombre() {
		return this.nombre;
	}
}
