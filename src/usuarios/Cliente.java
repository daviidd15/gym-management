package usuarios;

import actividades.*;
import tarifas.*;
import gimnasio.*;
import java.util.*;
import java.io.Serializable;
import java.time.*;

import es.uam.eps.padsof.telecard.*;
import excepciones.ClientePenalizado;
import excepciones.NoCumpleRequisito;
import excepciones.NoExisteSesion;
import excepciones.PlanContratado;

/**
 *
 * Clase cliente, hija de usuario El cliente es la persona que se va a apuntar
 * al gimnasio
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 * 
 */
@SuppressWarnings("serial")
public class Cliente extends Usuario implements Serializable {
	private String nombre;
	private int telefono;
	private LocalDate fechaNacimiento;
	private LocalDate fechaAlta;
	private int numCancelacionesSeguidas;
	private String usuario;
	private String contrasenya;
	private LocalDate penalizadoHasta;
	private List<Reserva> reservas;
	private List<PlanPersonalizado> contratos;
	private Tarifa tarifa;
	private LocalDate finDeCancelacion;
	private Tarjeta tarjeta;

	/**
	 * Constructor de la clase
	 * 
	 * @param usuario       usuario del cliente
	 * @param contrasenya   contraseña del cliente
	 * @param nombre        nombre completo del cliente
	 * @param telefono      numero de contacto del cliente
	 * @param fechaNamiento fecha en la que nacio el cliente
	 * @param fechaAlta     fecha en la que se ha dado de alta en el gimnasio
	 * @param tarifa        tipo de tarifa que elige el cliente
	 * @param tarjeta       numero de tarjeta que se va a usar para los pagos
	 */
	public Cliente(String usuario, String contrasenya, String nombre, int telefono, LocalDate fechaNamiento,
			LocalDate fechaAlta, Tarifa tarifa, Tarjeta tarjeta) {
		super(usuario, contrasenya);
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNamiento;
		this.fechaAlta = fechaAlta;
		this.numCancelacionesSeguidas = 0;
		this.tarifa = tarifa;
		this.reservas = new ArrayList<Reserva>();
		this.finDeCancelacion = null;
		this.contratos = new ArrayList<PlanPersonalizado>();
		this.tarjeta = tarjeta;
	}

	/**
	 * Getter
	 * 
	 * @return LocalDate fecha en la que se ha dado de alta el cliente
	 */
	public LocalDate getfechaAlta() {
		return this.fechaAlta;
	}

	/**
	 * Getter
	 * 
	 * @return int con el numero de cancelaciones seguidas que ha realizado el
	 *         cliente
	 */
	public int getNumCancelacion() {
		return this.numCancelacionesSeguidas;
	}

	/**
	 * Getter
	 * 
	 * @return Tarifa del cliente
	 */
	public Tarifa getTarifa() {
		return this.tarifa;
	}

	/**
	 * Getter
	 * 
	 * @return Tarjeta del cliente
	 */
	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	/**
	 * Metodo usado para los test en el que se añade una reserva ç al array de
	 * reservas del cliente
	 * 
	 * @param r reserva a añadir
	 * @return true en caso de que se haya añadido bien la reserva al array de
	 *         reservas
	 */
	public boolean addReserva(Reserva r) {
		return this.reservas.add(r);
	}

	/**
	 * Setter usado para los test
	 * 
	 * @param date fecha en la que finaliza la penalizacion del cliente
	 */
	public void setFechaFinCancelaciones(LocalDate date) {
		this.finDeCancelacion = date;
	}

	public LocalDate getFechaFinCancelaciones() {
		return this.finDeCancelacion;
	}

	/**
	 * Apunta al cliente a un plan personalizado
	 * 
	 * @param p plan personalizado
	 * @return true si el cliente se ha podido apuntar o false en caso contrario
	 */
	public boolean apuntarsePlanPersonalizado(PlanPersonalizado p) throws NoCumpleRequisito, PlanContratado {
		if (p == null)
			return false;

		List<Requisito> requisitos = p.getRequisitos();

		if (this.finDeCancelacion != null) {
			if (this.finDeCancelacion.isAfter(LocalDate.now())) {

				System.out.println("ERROR PORQUE EL CLIENTE ESTA PENALIZADO\n");
				return false;
			}
		}

		for (Requisito req : requisitos) {
			if (req.comprobar(this) == false) {
				throw new NoCumpleRequisito(req);
			}
		}

		if (p.getContratante() != null) {
			throw new PlanContratado();
		}

		p.setContratante(this);
		this.contratos.add(p);
		for (Sesion s : p.getSesiones()) {

			try {
				this.reservarSesion(s);
			} catch (ClientePenalizado pc) {
				return false;
			} catch (NoCumpleRequisito nr) {
				return false;
			} catch (NoExisteSesion ns) {
				return false;
			}

		}
		return true;
	}

	/**
	 * Getter
	 * 
	 * @return numero de sesiones del cliente
	 */
	public int getNumSesiones() {
		int contador = 0;
		for (Reserva r : this.reservas) {
			if (r != null)
				contador++;
		}
		return contador;
	}

	/**
	 * Comprueba si el cliente ha contratado un plan personalizado
	 * 
	 * @param p plan personalizado
	 * @return true si ha contratado el plan o false en caso contrario
	 */
	public boolean tienePlanPersonalizado(PlanPersonalizado p) {
		if (p == null)
			return false;

		for (PlanPersonalizado per : this.contratos) {
			if (per.equals(p))
				return true;
		}

		return false;
	}

	/**
	 * Cancela un plan personalizado que ha contratado el cliente
	 * 
	 * @param p plan personalizado
	 * @return true si ha podido cancelar el plan o false en caso contrario
	 */
	public boolean cancelarPlanPersonalizado(PlanPersonalizado p) {
		if (p == null)
			return false;

		for (PlanPersonalizado per : this.contratos) {
			if (per.equals(p) == true) {
				p.getListaDeEspera().notificar();
				p.setContratante(null);
				this.contratos.remove(p);
				this.numCancelacionesSeguidas++;
				return true;
			}
		}
		return false;

	}

	/**
	 * Calcula la edad del cliente
	 * 
	 * @return entero con la edad del cliente
	 */
	public int calcularEdad() {
		LocalDate hoy = LocalDate.now();
		Period anyos = Period.between(this.fechaNacimiento, hoy);
		return anyos.getYears();
	}

	/**
	 * Reserva una sesion
	 * 
	 * @param s sesion
	 * @return true si ha reservado la sesion o false en caso contrario
	 */
	public boolean reservarSesion(Sesion s) throws ClientePenalizado, NoCumpleRequisito, NoExisteSesion {
		/*
		 * si actividad monitorizada contiene la sesion
		 */
		if (Gimnasio.getGimnasio().getSesiones().contains(s) == false) {
			throw new NoExisteSesion();
		}

		if (s == null) {
			System.out.println("ERROR, la sesion no existe");
			return false;
		}

		if (s.getFecha().isAfter(LocalDate.now().plusDays(2)) == true) {
			System.out.println("Error en la fecha\n");
			return false;
		}

		if (this.finDeCancelacion != null) {
			if (this.finDeCancelacion.isAfter(LocalDate.now())) {
				System.out.println("ERROR PORQUE EL CLIENTE ESTA PENALIZADO\n");
				throw new ClientePenalizado();
			}
		}

		if (s.getActividadMonitorizada() != null) {
			List<Requisito> requisitos = s.getActividadMonitorizada().getRequisitos();
			for (Requisito req : requisitos) {
				if (req.comprobar(this) == false) {
					System.out.println("Error requisitos");
					throw new NoCumpleRequisito(req);
				}
			}
			if ((s.getActividadMonitorizada().esPlanPersonalizado()) == true) {
				if (tienePlanPersonalizado((PlanPersonalizado) s.getActividadMonitorizada()) == false) {
					return false;
				}

			}
		}

		if (s.getNumReservas() == s.getSala().getAforo()) {
			System.out.println("Error aforo");
			return false;
		}

		if (s.getActividadMonitorizada() == null) {
			if (this.getReservaByName("Entrenamiento libre", s.getFecha(), s.getHoraInicio()) != null) {
				System.out.println("Ya se habia apuntado");
				return false;
			}
		} else {
			if (this.getReservaByName(s.getActividadMonitorizada().getNombre(), s.getFecha(),
					s.getHoraInicio()) != null) {
				System.out.println("Ya se habia apuntado");
				return false;
			}
		}

		if (pagarSesion(s) == false) {
			System.out.println("Error al pagar");
			return false;
		}

		Reserva r = new Reserva(s, this);
		this.reservas.add(r);
		s.anadirReserva(r);
		return true;
	}

	/**
	 * Cancela una reserva
	 * 
	 * @param r reserva
	 * @return true si ha podido cancelar la reserva o false en caso contrario
	 */
	public boolean cancelarReserva(Reserva r) {
		if (r == null)
			return false;

		if (r.cancelarReserva() == true) {
			this.numCancelacionesSeguidas++;
			this.reservas.remove(r);
			return true;
		}
		return false;
	}

	/**
	 * Renueva la tarifa plana
	 * 
	 * @param tarifa tarifa plana
	 * @param c      cuota
	 * @return true si ha renovado la tarifa plana o false en caso contrario
	 */
	public boolean renovarTarifaPlana(TarifaPlana tarifa, Cuota c) {

		if (tarifa == null || c == null) {
			return false;
		}
		if (tarifa.renovar(c) == true) {
			if (tarifa.pagarTarifaPlana(this) == true)
				return true;
		}

		return false;
	}

	/**
	 * Realiza el pago de una sesion
	 * 
	 * @param se sesion
	 * @return true si se ha realizado el pago correctamente o false en caso
	 *         contrario
	 */
	public boolean pagarSesion(Sesion se) {
		String concepto;
		if (this.tarjeta == null) {
			System.out.println("Null Credit Card");
			return false;
		}
		double precio = se.calcularPrecio(this);
		if (precio == 0)
			return true;
		if (TeleChargeAndPaySystem.isValidCardNumber(this.tarjeta.getNumTarjeta()) == false) {
			System.out.println("Invalid Credit Card ERROR");
			return false;
		}

		if (se.getActividadMonitorizada() != null)
			concepto = "Pago de sesion " + se.getActividadMonitorizada().getNombre();
		else
			concepto = "Pago de sesion de entrenamiento libre";
		try {
			TeleChargeAndPaySystem.charge(this.tarjeta.getNumTarjeta(), concepto, precio, true);
		} catch (InvalidCardNumberException number) {
			System.out.println("Invalid Credit Card Number ERROR");
			return false;

		} catch (FailedInternetConnectionException internet) {
			System.out.println("Failed Internet Connection ERROR");
			return false;
		} catch (OrderRejectedException rejected) {
			System.out.println("Order rejected ERROR");
			return false;
		}
		return true;
	}

	/**
	 * Devuelve el dinero de una sesion que ha sido cancelada por un monitor
	 * 
	 * @param se sesion de la cual se devuelve el dinero
	 * @return true si se ha devuelto el dinero correctamente o false en caso
	 *         contrario
	 */
	public boolean devolverSesion(Sesion se) {
		String concepto;
		if (this.tarjeta == null) {
			System.out.println("Null Credit Card");
			return false;
		}
		double precio = se.calcularPrecio(this);
		if (precio == 0)
			return true;
		precio = precio * -1;
		precio = precio * Gimnasio.getGimnasio().getPorcentajeDevolucion();
		if (TeleChargeAndPaySystem.isValidCardNumber(this.tarjeta.getNumTarjeta()) == false) {
			System.out.println("Invalid Credit Card ERROR");
			return false;
		}

		if (se.getActividadMonitorizada() != null)
			concepto = "Pago de sesion " + se.getActividadMonitorizada().getNombre();
		else
			concepto = "Pago de sesion de entrenamiento libre";
		try {
			TeleChargeAndPaySystem.charge(this.tarjeta.getNumTarjeta(), concepto, precio);
		} catch (InvalidCardNumberException number) {
			System.out.println("Invalid Credit Card Number ERROR");
			return false;

		} catch (FailedInternetConnectionException internet) {
			System.out.println("Failed Internet Connection ERROR");
			return false;
		} catch (OrderRejectedException rejected) {
			System.out.println("Order rejected ERROR");
			return false;
		}
		return true;
	}

	/**
	 * Comprueba si el cliente ha cancelado mas reservas de las permitidas
	 * 
	 * @return true si no ha cancelado mas de las reservas permitidas o false en
	 *         caso contrario
	 */
	public boolean comprobarCancelaciones() {

		if (Gimnasio.getGimnasio().getReservasCanceladas() <= this.getNumCancelacion()) {
			this.finDeCancelacion = LocalDate.now().plusDays(Gimnasio.getGimnasio().getDiasPenalizacion());
			return false;
		}

		return true;

	}

	/**
	 * Muestra los contratos que ha realizado el cliente
	 */
	public void mostrarContratos() {

		for (PlanPersonalizado p : this.contratos) {
			System.out.println(p.getNombre());
			System.out.println("\n");
		}
	}

	/**
	 * Getter
	 * 
	 * @return lista de reservas del cliente
	 */
	public List<Reserva> getReservas() {
		return this.reservas;
	}

	/**
	 * Cancela una reserva de una sesion de un plan personalizado
	 * 
	 * @param s sesion
	 * @return true si se ha cancelado la reserva o false en caso contrario
	 */
	public boolean cancelarReservaPlanPersonalizado(Sesion s) {

		for (Reserva r : this.reservas) {
			if (r.getSesion().equals(s)) {
				if (reservas.remove(r) == true) {
					cancelarReserva(r);
					return true;
				}

			}
		}
		return false;
	}

	/**
	 * Obtiene la reserva a partir de su nombre
	 * 
	 * @param nombre nombre de la reserva a buscar
	 * @return la reserva
	 */
	public Reserva getReservaByName(String nombre, LocalDate fecha, LocalTime horaInicio) {

		if (nombre.equals("Entrenamiento libre")) {
			for (Reserva r : this.reservas) {
				if (r.getSesion().getActividadMonitorizada() == null && r.getSesion().getFecha().equals(fecha)
						&& r.getSesion().getHoraInicio().equals(horaInicio)) {
					return r;
				}
			}
			return null;
		} else {
			for (Reserva r : this.reservas) {
				if (r.getSesion().getActividadMonitorizada() != null) {
					if (r.getSesion().getActividadMonitorizada().getNombre().equals(nombre)
							&& r.getSesion().getFecha().equals(fecha)
							&& r.getSesion().getHoraInicio().equals(horaInicio)) {
						return r;
					}
				}
			}
			return null;
		}

	}

	@Override
	public boolean isAdministrador() {
		return false;
	}

	@Override
	public boolean isMonitor() {
		return false;
	}

	@Override
	public boolean isCliente() {
		return true;
	}

}
