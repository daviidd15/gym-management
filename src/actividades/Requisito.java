package actividades;

import java.io.Serializable;

import usuarios.*;

/**
 * Clase abstracta requisito, tiene tres hijos edad, antiguedad y sesiones
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public abstract class Requisito implements Serializable{
	protected int min;
	protected int max;

	/**
	 * Constructor de la clase
	 * 
	 * @param min requisito minimo
	 * @param max requisito maximo
	 */
	public Requisito(int min, int max) {
		this.min = min;
		this.max = max;
	}

	/**
	 * Metodo abstracto que implementaremos en las clases hijas
	 * 
	 * @param c cliente del cual se van a comprobar los requisitos
	 * @return true o false
	 */
	public abstract boolean comprobar(Cliente c);

	/**
	 * Getter
	 * 
	 * @return entero con el minimo del requisito
	 */
	public int getMin() {
		return this.min;
	}

	/**
	 * Getter
	 * 
	 * @return entero con el maximo del requisito
	 */
	public int getMax() {
		return this.max;
	}
}
