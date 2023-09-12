package tarifas;


import java.io.*;

/**
 * Clase abstracta tarifa, padre de 
 * tarifa plana y tarifa de pago por uso
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
 
 @SuppressWarnings("serial")
public abstract class Tarifa implements Serializable{
    private String nombre;

    /**
     * Constructor de la clase
     * 
     * @param nombre nombre de la tarifa
     */
    public Tarifa(String nombre)
    {
        this.nombre = nombre;
    }
   
    
    /**
     * Getter
     * 
     * @return string con el nombre de la tarifa
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Metodo abstracto que sera implementado 
     * en la clase hija tarifa plana
     * @param precio precio a establecer en la tarifa
     */
    public abstract void setPrecio(double precio);
   
    /**
     * Metodo abstracto que sera implementado 
     * en la clase hija tarifa plana
     * @return string con el nombre del tipo de actividad grupal
     */
    public abstract String getTipoActividad();
    
    public abstract boolean esTarifaPlana();
    
    public String toString(){
        return this.nombre;
    }
}
