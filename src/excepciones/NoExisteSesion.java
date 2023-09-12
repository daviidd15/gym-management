package excepciones;

/**
 * clase NoExisteSesion, excepcion que se lanza si un cliente
 * intenta reservar una sesion que no exise
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class NoExisteSesion extends Exception{
	
	/**
	 * Constructor de la clase
	 */
	public NoExisteSesion() {
		
	}
	
	/**
	 * Metodo que representa la instancia de la excepcion
	 * 
	 * @return String con la excepcion
	 */
	public String toString() {
		return "No existe una sesion a esa hora";
	}
}
