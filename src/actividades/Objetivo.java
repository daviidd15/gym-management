package actividades;

import java.io.Serializable;

/**
 * Enumeracion de objetivo del plan personalizado
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public enum Objetivo implements Serializable{
	/**
	 * Objetivo para la perdida de peso 
	 */
	PERDIDA_DE_PESO(1),
	/**
	 * Objetivo para la ganancia de masa muscular
	 */
	GANANCIA_MASA_MUSCULAR(2),
	/**
	 * Objetivo para rehabilitacion
	 */
	REHABILITACION(3);

	/**
	 * Constructor privado de la clase
	 * 
	 * @param c numero con el que se inicializa el valor
	 */
	private Objetivo(int c) {
		valor = c;
	}

	private final int valor; // valor interno controlado

	/**
	 * Getter
	 * 
	 * @return valor de la enumeracion
	 */
	public int valor() {
		return valor;
	}
}
