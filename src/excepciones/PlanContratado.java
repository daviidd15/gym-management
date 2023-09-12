package excepciones;



@SuppressWarnings("serial")
/**
 * clase PlanContratado, excepcion que se lanza cuando un cliente
 * intenta apuntarse a un plan que ya está contratado por otro cliente 
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class PlanContratado  extends Exception {

	/**
	 * Constructor de la clase
	 */
	public PlanContratado() {
		
	}
	
	/**
	 * Metodo que representa la instancia de la excepcion
	 * 
	 * @return String con la excepcion
	 */
	public String toString() {
		return "El plan ya esta contratado";
	}
}
