package tarifas;
import java.io.*;
/**
 * Enumeracion con los tipos de cuota
 * de la tarifa plana
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public enum Cuota implements Serializable{
	/**
	 * Pago anual
	 */
    ANUAL(12), 
    /**
     * Pago timestral
     */
    TRIMESTRAL(3), 
    /**
     * Pago mensual
     */
    MENSUAL(1);
	/**
	 * Constructor privado
	 * 
	 * @param c numero con el que se inicializa el valor
	 */
    private Cuota(int c) { 
        valor = c; 
    }
    private final int valor; // valor interno controlado
    
    /**
     * Getter 
     * 
     * @return valor de la enumeracion
     */
    public int getValor(){
        return this.valor;
    }
}
