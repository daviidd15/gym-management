package actividades;

import java.io.Serializable;

import usuarios.*;

/**
 * Clase con el requisito de la edad, hija de requisito
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class ReqEdad extends Requisito implements Serializable{

	/**
	 * Constructor de la clase
	 * 
	 * @param min requisito minimo de edad
	 * @param max requisito maximo de edad
	 */
	public ReqEdad(int min, int max) {
		super(min, max);
	}

	/**
	 * Comprueba si el cliente comprueba los requisitos de edad del gimnasio
	 * 
	 * @param c Cliente en el que se comprueba el requisito
	 * @return true si el cliente cumple los requisitos o false en caso contrario
	 */
	@Override
	public boolean comprobar(Cliente c) {
		int edad = c.calcularEdad();

		if (this.min == -1 || this.max == -1)
			return true;

		if (edad >= this.min && edad <= this.max) {
			return true;
		} else {
			System.out.println("No cumple el requisito de la edad\n");
			return false;
		}

	}
}
