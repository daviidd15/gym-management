package tarifas;
import java.io.*;
import java.time.*;

import es.uam.eps.padsof.telecard.*;

import usuarios.*;
import actividades.*;
import gimnasio.Gimnasio;

/**
 * Clase tarifa plana, hija de tarifa
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
 
 @SuppressWarnings("serial")
public class TarifaPlana extends Tarifa implements Serializable {
    private Cuota cuota;
    private String nombre;
    private TipoActividad tipoActividad;
    private LocalDate inicio;
    private LocalDate fin;
    private double precio;
    
    /**
     * Constructor de la clase
     * 
     * @param nombre nombre de la tarifa
     * @param cuota tipo de cuota de la tarifa
     * @param actividad tipo de actividad grupal que elige en el registro
     */
    public TarifaPlana(String nombre, Cuota cuota, TipoActividad actividad) {
        super(nombre);
        this.cuota = cuota;
        this.inicio = LocalDate.now();
		this.tipoActividad = actividad;
        this.precio = (Gimnasio.getGimnasio().getPrecioTarifaPlana())*cuota.getValor();
        this.fin = inicio.plusMonths(this.cuota.getValor());
        
    }

    // @Override
    /**
     * Renueva la tarifa plana, comprobando si ya se 
     * ha vencido la fecha de fin
     * 
     * @param c cuota de la tarifa
     * @return true si la ha renovado bien o false
     * en caso contrario
     */
    public boolean renovar(Cuota c) {
    	
        if (LocalDate.now().equals(this.fin) == true || LocalDate.now().isAfter(this.fin) == true) {
            this.precio = this.precio * c.getValor();
            this.fin = LocalDate.now().plusMonths(c.getValor());
            return true;
        }
        return false;

    }
    
    /**
     * Hace el pago de una tarifa plana 
     * 
     * @param c cliente que realiza el pago
     * @return true si se ha realizado el pago correctamente o
     * false en caso contrario
     */
    public boolean pagarTarifaPlana(Cliente c){
		if (precio == 0)
			return true;
		if (TeleChargeAndPaySystem.isValidCardNumber(c.getTarjeta().getNumTarjeta()) == false) {
			return false;
		}
		try {
			TeleChargeAndPaySystem.charge(c.getTarjeta().getNumTarjeta(),
					"Pago de tarifa", this.precio, true);
		} catch (InvalidCardNumberException number) {
			return false;
		} catch (FailedInternetConnectionException internet) {
			return false;
		} catch (OrderRejectedException rejected) {
			return false;
		}
		return true;
	}
    
    /**
     * Getter
     * 
     * @return string con el nombre del tipo de actividad
     */
    public String getTipoActividad(){
        return this.tipoActividad.getNombre();
    }

    /**
     * Setter utilizado para los tests
     * 
     * @param precio coste de la tarifa
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Setter utilizado para los tests
     * 
     * @param date fecha con el fin de la tarifa
     */
    public void setFechaFin(LocalDate date) {
        this.fin = date;
    }
    
    /**
     * Setter utilizado para los tests
     * 
     * @param date fecha con el inicio de la tarifa
     */
    public void setFechaInicio(LocalDate date) {
        this.inicio = date;
    }
    
     public boolean esTarifaPlana(){
         return true;
     }
     
     public Cuota getCuota() {
    	 return this.cuota;
     }
}
