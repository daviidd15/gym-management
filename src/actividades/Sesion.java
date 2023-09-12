package actividades;
import gimnasio.*;
import tarifas.*;
import usuarios.*;

import java.util.*;
import java.io.Serializable;
import java.time.*;

/**
 * Clase sesion
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class Sesion implements Serializable{
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private List<Reserva> reservas;
	private SalaSimple salaSimple;
	private ListaEspera listaEspera;
	private int edad;
	private int numReservas;
	protected ActividadMonitorizada actividadMonitorizada;

	/**
	 * Constructor de la clase
	 * 
	 * @param fecha                 en la que se va a efectuar la sesion
	 * @param horaInicio            hora en la que se inicia la sesion
	 * @param horaFin               hora en la que finaliza la sesion
	 * @param sala                  en la que se va a impartir la sesion
	 * @param actividadMonitorizada actividad que se va a llevar a cabo en esa
	 *                              sesion
	 */
	public Sesion(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, SalaSimple sala,
			ActividadMonitorizada actividadMonitorizada) {
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.salaSimple = sala;
		this.reservas = new ArrayList<Reserva>();
		this.listaEspera = new ListaEspera();
		this.numReservas = 0;
		this.actividadMonitorizada = actividadMonitorizada;
		if (actividadMonitorizada != null)
			this.actividadMonitorizada.getSesiones().add(this);

	}
	
	/**
	 * Getter
	 * 
	 * @return hora en la que comienza la sesion
	 */
	public LocalTime getHoraInicio() {
		return this.horaInicio;
	}
	
	/**
	 * Getter
	 * 
	 * @return hora en la que finaliza la sesion
	 */
	public LocalTime getHoraFin() {
		return this.horaFin;
	}
	
	/**
	 * Getter
	 * 
	 * @return ActividadMonitorizada
	 */
	public ActividadMonitorizada getActividadMonitorizada() {
		return this.actividadMonitorizada;
	}

	/**
	 * Getter
	 * 
	 * @return lista con las reservas de la sesion
	 */
	public List<Reserva> getReservas() {
		return this.reservas;
	}

	/**
	 * Getter
	 * 
	 * @return numero de reservas de la sesion
	 */
	public int getNumReservas() {
		return this.numReservas;
	}

	/**
	 * Getter
	 * 
	 * @return fecha en la que se imparte la sesion
	 */
	public LocalDate getFecha() {
		return this.fecha;
	}

	/**
	 * Getter
	 * 
	 * @return sala en la que se imparte la sesion
	 */
	public SalaSimple getSala() {
		return this.salaSimple;
	}

	/**
	 * Asigna una sala a la sesion
	 * 
	 * @param s sala a asignar
	 * @return true si se ha asignado correctamente o false en caso contrario
	 */
	public boolean asignarSala(SalaSimple s) {
		if (s == null)
			return false;
		this.salaSimple = s;
		return true;
	}

	/**
	 * Añade una reserva al array de reservas de la sesion
	 * 
	 * @param r reserva a añadir
	 * @return true si se ha añadido correctamente o false en caso contrario
	 */
	public boolean anadirReserva(Reserva r) {
		if (r == null)
			return false;
		this.reservas.add(r);
		this.numReservas++;
		return true;
	}

	/**
	 * Disminuye el numero de sesiones reservadas
	 */
	public void disminuyeNumSesiones() {
		this.numReservas--;
	}

	/**
	 * Elimina una reserva del array de reservas de la sesion
	 * 
	 * @param r reserva a eliminar
	 * @return true si se ha eliminado correctamente o false en caso contrario
	 */
	public boolean removeReserva(Reserva r) {
		if (r == null)
			return false;

		this.numReservas--;
		return this.reservas.remove(r);
	}

	/**
	 * Calcula el precio de la sesion dependiendo de si es una actividad grupal, un
	 * plan personalizado o un entrenamiento libre
	 * 
	 * @param c Cliente sobre el que se van a obtener los datos para calcular el
	 *          precio de la sesion
	 * @return precio de la sesion
	 */
	public double calcularPrecio(Cliente c) {
		if (c == null)
			return -1;
		if(this.actividadMonitorizada==null) {
			return Gimnasio.getGimnasio().getPrecioSesionLibre();
		}
		if (this.actividadMonitorizada.esPlanPersonalizado() == true) {
			if (c.getTarifa().esTarifaPlana() == true) {
				return Gimnasio.getGimnasio().getPrecioSesionPersonalizado()
						- (Gimnasio.getGimnasio().getPrecioSesionPersonalizado()
								* Gimnasio.getGimnasio().getPorcentajeDescuento());
			} else {
				return Gimnasio.getGimnasio().getPrecioSesionPersonalizado();
			}

		}
		if (this.actividadMonitorizada.esActividadGrupal() == true) {
			if (c.getTarifa().esTarifaPlana() == true) {
				if (c.getTarifa().getTipoActividad().equals(this.actividadMonitorizada.getNombre())) {
					return 0;
				} else {
					return this.actividadMonitorizada.getPrecio();
				}
			} else {
				return this.actividadMonitorizada.getPrecio();
			}
		}
		return Gimnasio.getGimnasio().getPrecioSesionLibre();
	}
	
	
	

}
