package excepciones;

import actividades.*;

@SuppressWarnings("serial")
/**
 * clase NoCumpleRequisito, excepcion que se lanza cuando un 
 * cliente no cumple un requisito
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class NoCumpleRequisito  extends Exception {
	private Requisito requisito;
	
	/**
	 * Constructor de la clase
	 * 
	 * @param requisito que no cumple el cliente
	 */
	public NoCumpleRequisito(Requisito requisito) {
		this.requisito = requisito;
	}
	
	/**
	 * Metodo que representa la instancia de la excepcion
	 * 
	 * @return String con el requisito que no cumple el cliente
	 */
	public String toString() {
		return "El cliente no cumple "+this.requisito.getClass();
	}
}
