package excepciones;



@SuppressWarnings("serial")
/**
 * clase ClientePenalizado, excepcion que se lanza cuando
 * un cliente esta penalizado y no puede reservar
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ClientePenalizado extends Exception {
	
	/**
	 * Constructor de la clase
	 */
	public ClientePenalizado() {
	}
	
	/**
	 * Metodo que representa la instancia de la excepcion
	 * 
	 * @return String con la excepcion
	 */
	public String toString() {
		return "El cliente está penalizado";
	}
}
