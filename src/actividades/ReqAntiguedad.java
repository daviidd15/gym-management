package actividades;

import java.io.Serializable;
import java.time.*;
import java.time.temporal.ChronoUnit;


import usuarios.*;

/**
 * Clase con el requisito de antiguedad, hija de requisito
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class ReqAntiguedad extends Requisito implements Serializable{

	/**
	 * Constructor de la clase
	 * 
	 * @param min requisito minimo de antiguedad
	 * @param max requisito maximo de antiguedad
	 */
	public ReqAntiguedad(int min, int max) {
		super(min, max);
	}

	/**
	 * Comprueba si el cliente comprueba los requisitos de antiguedad del gimnasio
	 * 
	 * @param c Cliente en el que se comprueba el requisito
	 * @return true si el cliente cumple los requisitos o false en caso contrario
	 */
	@Override
	public boolean comprobar(Cliente c) {
		long nDias = 0;

		if (this.min == -1 || this.max == -1)
			return true;

		LocalDate antes = c.getfechaAlta();
		LocalDate despues = LocalDate.now();

		nDias = ChronoUnit.DAYS.between(antes, despues);

		if (nDias >= this.min && nDias <= this.max)
			return true;
		else {
			System.out.println("No cumple el requisito de la antiguedad\n");
			return false;
		}

	}
}
