package tarifas;
import java.io.*;

/**
 * Clase tarifa pago por uso, clase hija de tarifa
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
 
 @SuppressWarnings("serial")
public class TarifaPagoPorUso extends Tarifa implements Serializable{
    private String nombre;
    
    /**
     * Constructor de la clase
     * 
     * @param nombre nombre de la tarifa 
     */
    public TarifaPagoPorUso (String nombre)
    {
        super(nombre);
    }
    
    /**
     * No hace nada porque el cliente paga por cada
     * sesion que reserva
     */
	public void setPrecio(double precio){
        return;
    }
    
	/**
	 * Getter (no funciona para esta clase)
	 * 
	 * @return null porque no tiene ningun tipo de actividad
	 */
    public String getTipoActividad(){
        return null;
    }
    
     public boolean esTarifaPlana(){
         return false;
     }
}
