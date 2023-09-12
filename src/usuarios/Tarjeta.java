package usuarios;

import java.io.Serializable;

/**
 * Clase tarjeta con la que va a realizar los pagos el cliente
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
 
 @SuppressWarnings("serial")
public class Tarjeta implements Serializable{
	String nombreTitular;
	String numTarjeta;
	int pin;
	
	/**
	 * Constructor de la clase
	 * 
	 * @param nombreTitular nombre del titular de la tarjeta
	 * @param numTarjeta numero de la tarjeta 
	 * @param pin pin de la tarjeta
	 */
	public Tarjeta(String nombreTitular, String numTarjeta, int pin)
	{
		this.nombreTitular = nombreTitular;
		this.numTarjeta = numTarjeta;
		this.pin = pin;
	}
	
	/**
	 * Getter
	 * 
	 * @return numero de la tarjeta
	 */
	public String getNumTarjeta(){
		return this.numTarjeta;
	}
	
}
