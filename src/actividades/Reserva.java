package actividades;

import usuarios.*;


import java.io.Serializable;


/**
 * Clase reserva
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class Reserva implements Serializable{
	private Sesion sesion;
	private Cliente cliente;

	/**
	 * Constructor de la clase
	 * 
	 * @param sesion  objeto sesion con la sesion a reservar
	 * @param cliente persona que va a realizar la reserva
	 */
	public Reserva(Sesion sesion, Cliente cliente) {
		this.sesion = sesion;
		this.cliente = cliente;
	}



	/**
	 * Getter
	 * 
	 * @return sesion de la reserva
	 */
	public Sesion getSesion() {
		return this.sesion;
	}

	/**
	 * Cancela la reserva
	 * 
	 * @return true si se ha cancelado correctamente o false en caso contrario
	 */
	public boolean cancelarReserva() {
		if (this.sesion.removeReserva(this) == true) {
			this.sesion.disminuyeNumSesiones();
			if(this.sesion.getActividadMonitorizada()!=null) {
			this.sesion.getActividadMonitorizada().getSesiones().remove(this.sesion);}
			this.cliente.devolverSesion(this.sesion);
			return true;
		}

		return false;
	}
	/**
	* Getter
	* @return cliente de la reserva
	*/
	public Cliente getCliente(){
		return this.cliente;
	}

}
