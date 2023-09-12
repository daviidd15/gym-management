package actividades;

import java.io.Serializable;

import usuarios.*;

/**
 * Clase con el requisito de sesiones, hija de requisito
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class ReqSesiones extends Requisito implements Serializable{

	/**
	 * Constructor de la clase
	 * 
	 * @param min requisito minimo de sesiones
	 * @param max requisito maximo de sesiones
	 */
	public ReqSesiones(int min, int max) {
		super(min, max);
	}

	/**
	 * Comprueba si el cliente comprueba los requisitos de sesiones del gimnasio
	 * 
	 * @param c Cliente en el que se comprueba el requisito
	 * @return true si el cliente cumple los requisitos o false en caso contrario
	 */
	@Override
	public boolean comprobar(Cliente c) {
		if (this.min == -1 || this.max == -1)
			return true;

		if (c.getNumSesiones() <= this.max && c.getNumSesiones() >= this.min)
			return true;
		else {
			System.out.println("No cumple el requisito de las sesiones\n");
			return false;
		}

	}
}
