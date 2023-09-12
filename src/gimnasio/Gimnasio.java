package gimnasio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import es.uam.eps.padsof.payrolls.*;
import actividades.*;
import tarifas.*;
import usuarios.*;

/**
 * Clase gimnasio
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class Gimnasio implements ICompanyInfo, Serializable {

	private static Gimnasio GIMNASIO;
	private int numeroSalas;
	private double sueldo;
	private double suplemento;
	private int diasPenalizacion;
	private int reservasCanceladas;
	private double porcentajeDevolucion;
	private double porcentajeDescuento;
	private double precioSesionLibre;
	private double precioSesionPersonalizado;
	private double precioTarifaPlana;
	private Usuario usuarioActualOperando;
	private List<Usuario> usuarios;
	private List<Sala> salas;
	private List<PlanPersonalizado> planPersonalizados;
	private List<Tarifa> tarifas;
	private List<ActividadGrupal> actividadesGrupales;
	private List<Sesion> sesiones;
	private TipoActividad tipoactividad;

	/**
	 * Constructor privado de gimnasio
	 */
	private Gimnasio() {
		this.numeroSalas = 0;
		this.usuarios = new ArrayList<Usuario>();
		this.salas = new ArrayList<Sala>();
		this.planPersonalizados = new ArrayList<PlanPersonalizado>();
		this.tarifas = new ArrayList<Tarifa>();
		this.actividadesGrupales = new ArrayList<ActividadGrupal>();
		this.sesiones = new ArrayList<Sesion>();
		this.usuarios.add(new Administrador("admin", "admin"));
		this.definirTarifaPagoPorUso("Tarifa Pago por uso");


	}

	/**
	 * Getter
	 * 
	 * @return gimnasio
	 */
	public static Gimnasio getGimnasio() {
		if (GIMNASIO == null)
			GIMNASIO = new Gimnasio();
		return GIMNASIO;
	}

	/**
	 * Getter
	 * 
	 * @return lista de usuarios del gimnasio
	 */
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	/**
	 * Metodo que obtiene un monitor a partir de su nombre
	 * 
	 * @param nombre nombre del monitor
	 * @return Monitor obtenido
	 */
	public Monitor getMonitorByName(String nombre) {
		if (nombre == null)
			return null;

		for (Usuario u : this.usuarios) {
			if (u.isMonitor()) {
				if (((Monitor) u).getName().equals(nombre)) {
					return ((Monitor) u);
				}
			}
		}
		return null;
	}

	/**
	 * Getter
	 * 
	 * @return lista de monitores
	 */
	public List<Monitor> getMonitores() {
		List<Monitor> mon = new ArrayList<>();
		for (Usuario u : this.usuarios) {
			if (u.isMonitor()) {
				mon.add((Monitor) u);
			}
		}
		return mon;
	}
	/**
	* Getter
	* @return lista de planes
	*/
	public List<PlanPersonalizado> getPlanesByMonitor(Monitor m){
		List<PlanPersonalizado> planes = new ArrayList<>();
		for(PlanPersonalizado p: Gimnasio.getGimnasio().getPlanesPersonalizados()){
			if(p.getMonitor().equals(m)){
				planes.add(p);
			}
		}
		return planes;
	}

	/**
	 * Getter
	 * 
	 * @return double con el porcentaje de devolucion
	 */
	public double getPorcentajeDevolucion() {
		return this.porcentajeDevolucion;
	}

	/**
	 * Getter
	 * 
	 * @return lista de actividades grupales
	 */
	public List<ActividadGrupal> getActividadesGrupales() {
		return this.actividadesGrupales;
	}

	/**
	 * Setter
	 * 
	 * @param num numero de salas
	 * @return true si se han definido bien las salas o false en caso contrario
	 */
	public boolean setNumeroSalas(int num) {
		if (num < 1)
			return false;
		this.numeroSalas = num;
		return true;
	}

	/**
	 * Setter del sueldo del monitor
	 * 
	 * @param sueldoBase del monitor
	 */
	public void setSueldo(double sueldoBase) {
		this.sueldo = sueldoBase;
	}

	/**
	 * Setter
	 * 
	 * @param suplem suplemento del sueldo del monitor
	 */
	public void setSuplemento(double suplem) {
		this.suplemento = suplem;
	}

	/**
	 * Getter
	 */
	public List<Sala> getSalasComp() {
		List<Sala> salasComp = new ArrayList<>();
		for (Sala s : this.salas) {
			if (s.esCompuesta())
				salasComp.add(s);
		}
		return salasComp;
	}

	/**
	 * Getter
	 */
	public List<SalaSimple> getSalasSimples() {
		List<SalaSimple> salasSimple = new ArrayList<>();
		for (Sala s : this.salas) {
			if (s.esCompuesta() == false)
				salasSimple.add((SalaSimple) s);
		}
		return salasSimple;
	}

	/**
	 * Setter
	 * 
	 * @param dias que esta penalizado el cliente en el caso de que supere las
	 *             cancelaciones de reservas propuestas
	 */
	public void setDiasPenalizacion(int dias) {
		this.diasPenalizacion = dias;
	}

	/**
	 * Getter
	 * 
	 * @param precio de la tarifa plana
	 */
	public void setPrecioTarifaPlana(double precio) {
		this.precioTarifaPlana = precio;
		
	}
	/**
	 * Setter
	 */
	public void setTarifasPlanas() {
		this.tarifas.add(new TarifaPlana("Tarifa Plana Mensual", Cuota.MENSUAL, null));
		this.tarifas.add(new TarifaPlana("Tarifa Plana Trimestral", Cuota.TRIMESTRAL, null));
		this.tarifas.add(new TarifaPlana("Tarifa Plana Anual", Cuota.ANUAL, null));
	}
	
	/**
	 * Incrementa el numero de salas
	 * 
	 */
	public void incrementaSalas() {
		this.numeroSalas++;
	}

	/**
	 * Setter
	 * 
	 * @param numRes numero de reservas maximas que puede cancelar el cliente
	 */
	public void setReservasCanceladas(int numRes) {
		this.reservasCanceladas = numRes;
	}

	/**
	 * Setter
	 * 
	 * @param dev porcentaje de devolucion en caso de que se cancele una sesion
	 */
	public void setPorcentajeDevolucion(double dev) {
		this.porcentajeDevolucion = dev;
	}

	/**
	 * Cancela la clase de un monitor
	 * 
	 * @param nombreActividad nombre de la actividad que quiere cancelar
	 * @return true si se ha cancelado correctamente o false en caso contrario
	 */
	public boolean cancelarClase(String nombreActividad, LocalTime hora, LocalDate fecha) {
		Sesion s = null;
		if(nombreActividad.equals("Entrenamiento libre")){
			s=this.getSesionByActividadMonitorizada(null, fecha, hora);
		}
		if(s==null){
		s=this.getSesionByActividadMonitorizada(this.getActividadGrupalByName(nombreActividad), fecha, hora);}
		
		if(s==null){
		
		s = this.getSesionByActividadMonitorizada( this.getPlanPersonalizadoByName(nombreActividad) , fecha, hora);}
		for (Reserva reserva : s.getReservas()) {
							reserva.cancelarReserva();
							Gimnasio.getGimnasio().enviarNotificacion("Se ha cancelado la clase de " + nombreActividad + "del " + fecha.toString() + " a las "+ hora.toString(), reserva.getCliente());
						}
		s.getActividadMonitorizada().getSesiones().remove(s);
		
		
		return Gimnasio.getGimnasio().getSesiones().remove(s);
		
		
	}

	/**
	 * Setter
	 * 
	 * @param desc porcentaje de descuento para los clientes que tengan la tarifa
	 *             plana y vayan a contratar un plan personalizado
	 */
	public void setPorcentajeDescuento(double desc) {
		this.porcentajeDescuento = desc;
	}

	/**
	 * Setter
	 * 
	 * @param precio de la sesion libre
	 */
	public void setPrecioSesionLibre(double precio) {
		this.precioSesionLibre = precio;
	}

	/**
	 * Setter
	 * 
	 * @param precio de la sesion del plan personalizado
	 */
	public void setPrecioSesionPersonalizado(double precio) {
		this.precioSesionPersonalizado = precio;
	}

	/**
	 * Getter
	 * 
	 * @return las reservas canceladas permitidas
	 */
	public int getReservasCanceladas() {
		return this.reservasCanceladas;
	}

	/**
	 * Getter
	 * 
	 * @param usuario nombre de usuario a buscar
	 * @return usuario
	 */
	public Usuario getUsuarioByUser(String usuario) {
		for (Usuario u : this.usuarios) {
			if (u.getUsuario().equals(usuario)) {
				return u;
			}
		}
		return null;
	}

	/**
	 * Getter
	 * 
	 * @return dias que el cliente esta penalizado por superar las cancelaciones max
	 */
	public int getDiasPenalizacion() {
		return this.diasPenalizacion;
	}

	/**
	 * Getter
	 * 
	 * @return precio de la tarifa plana
	 */
	public double getPrecioTarifaPlana() {
		return this.precioTarifaPlana;
	}

	/**
	 * Getter
	 * 
	 * @return suplemento del monitor
	 */
	public double getSuplemento() {
		return this.suplemento;
	}

	/**
	 * Getter
	 * 
	 * @return sueldo del monitor
	 */
	public double getSueldo() {
		return this.sueldo;
	}

	/**
	 * Getter
	 * 
	 * @return precio de la sesion personalizada
	 */
	public double getPrecioSesionPersonalizado() {
		return this.precioSesionPersonalizado;
	}

	/**
	 * Getter
	 * 
	 * @return precio de la sesion libre
	 */
	public double getPrecioSesionLibre() {
		return this.precioSesionLibre;
	}

	/**
	 * Getter
	 * 
	 * @return porcentaje de descuento
	 */
	public double getPorcentajeDescuento() {
		return this.porcentajeDescuento;
	}

	/**
	 * Getter
	 * 
	 * @return lista de sesiones
	 */
	public List<Sesion> getSesiones() {
		return this.sesiones;
	}

	/**
	 * Getter
	 * 
	 * @return lista de tarifas planas
	 */
	public List<Tarifa> getTarifasPlanas() {
		List<Tarifa> t = new ArrayList<Tarifa>();
		for (Tarifa tarifa : this.tarifas) {
			if (tarifa.getNombre().equals("Tarifa Pago por uso") == false) {
				t.add(tarifa);
			}
		}
		return t;
	}

	/**
	 * Getter
	 * 
	 * @return lista de tarifas
	 */
	public List<Tarifa> getTarifas() {
		return this.tarifas;
	}

	/**
	 * Registra a un cliente
	 * 
	 * @param usuario         del cliente que se va a registrar
	 * @param contrasenya     del cliente
	 * @param nombre          del cliente
	 * @param telefono        numero de telefono del cliente
	 * @param fechaNacimiento fecha de nacimiento del cliente
	 * @param tarjeta         numero de tarjeta con la que va a realizar el pago
	 * @param tarifa          tipo de tarifa que elige el cliente
	 * @return cliente que ha sido registrado o null en el caso de que no lo haya
	 *         podido registrar
	 */
	public Cliente registrarCliente(String usuario, String contrasenya, String nombre, int telefono,
			LocalDate fechaNacimiento, Tarjeta tarjeta, Tarifa tarifa) {
		Cliente c;
		if (usuario == null || contrasenya == null || nombre == null || telefono == 0 || fechaNacimiento == null
				|| tarjeta == null) // || tarifa == null)
			return null;
		for (Usuario u : this.usuarios) {
			if (u.getUsuario().equals(usuario)) {
				return null;
			}
		}
		c = new Cliente(usuario, contrasenya, nombre, telefono, fechaNacimiento, LocalDate.now(), tarifa, tarjeta);
		if (tarifa.esTarifaPlana() == true) {
			if (((TarifaPlana) tarifa).pagarTarifaPlana(c) == false) {
				return null;
			}
		}
		this.usuarios.add(c);
		return c;
	}

	/**
	 * Registra a un monitor
	 * 
	 * @param usuario     del monitor que se va a registrar
	 * @param contrasenya del monitor
	 * @param correo      correo electronico del monitor
	 * @param nombre      del monitor
	 * @param dni         del monitor
	 * @return monitor registrado o null en el caso de que no lo haya podido
	 *         registrar
	 */
	public Monitor registraMonitor(String usuario, String contrasenya, String correo, String nombre, String dni) {
		Monitor m;
		if (usuario == null || contrasenya == null || correo == null || nombre == null || dni == null) {
			return null;
		}
		if (this.usuarios.isEmpty() == false) {
			for (Usuario u : this.usuarios) {
				if (u.getUsuario().equals(usuario)) {
					return null;
				}
			}
		}
		m = new Monitor(usuario, contrasenya, correo, nombre, dni);
		this.usuarios.add(m);
		return m;
	}

	/**
	 * Define una sala simple en el gimnasio
	 * 
	 * @param nombre                  de la sala
	 * @param descripcion             de la sala
	 * @param aforo                   de la sala
	 * @param climatizacion           indica si la sala tiene climatizacion
	 * @param horaInicioClimatizacion hora en la que inicia la climatizacion
	 * @param horaFinClimatizacion    hora en la que finaliza la climatizacion
	 * @return true si se ha definido la sala simple correctamente o false en caso
	 *         contrario
	 */
	public boolean definirSalaSimple(String nombre, String descripcion, int aforo, boolean climatizacion,
			LocalTime horaInicioClimatizacion, LocalTime horaFinClimatizacion) {
		SalaSimple ss;
		if (nombre == null || descripcion == null || aforo < 0)
			return false;
		ss = new SalaSimple(nombre, descripcion, aforo, climatizacion, horaInicioClimatizacion, horaFinClimatizacion);
		incrementaSalas();
		return this.salas.add(ss);
	}

	/**
	 * Define una sala compuesta en el gimnasio
	 * 
	 * @param nombre                  de la sala
	 * @param descripcion             de la sala
	 * @param aforo                   de la sala
	 * @param climatizacion           indica si la sala tiene climatizacion
	 * @param horaInicioClimatizacion hora en la que inicia la climatizacion
	 * @param horaFinClimatizacion    hora en la que finaliza la climatizacion
	 * @return true si se ha definido la sala simple correctamente o false en caso
	 *         contrario
	 */
	public boolean definirSalaCompuesta(String nombre, String descripcion, int aforo, boolean climatizacion,
			LocalTime horaInicioClimatizacion, LocalTime horaFinClimatizacion) {
		SalaCompuesta sc;
		if (nombre == null || descripcion == null || aforo < 0)
			return false;
		sc = new SalaCompuesta(nombre, descripcion, aforo, climatizacion, horaInicioClimatizacion,
				horaFinClimatizacion);
		return this.salas.add(sc);
	}

	/**
	 * Obtiene los planes que ha ofertado un monitor
	 * 
	 * @param m monitor
	 * @return lista con los planes personalizados
	 */
	public List<PlanPersonalizado> verPlanesPersonalizados(Monitor m) {
		List<PlanPersonalizado> planes;
		if (m == null)
			return null;
		planes = new ArrayList<PlanPersonalizado>();
		for (PlanPersonalizado p : this.planPersonalizados) {
			if (p.getMonitor() == m)
				planes.add(p);
		}
		return planes;
	}

	/**
	 * Envia una notificacion a un usuario
	 * 
	 * @param contenido string con el contenido de la notificacion
	 * @param user      usuario al que se le envia la notificacion
	 * @return true si se ha podido enviar la notificacion o false en caso contrario
	 */
	public boolean enviarNotificacion(String contenido, Usuario user) {
		if (user == null || contenido == null)
			return false;

		return user.addNotificacion(contenido);

	}

	/**
	 * Cambia el precio de la tarifa plana
	 * 
	 * @param t      tarifa
	 * @param precio nuevo a poner
	 * @return true si se ha podido establecer el nuevo precio o false en caso
	 *         contrario
	 */
	public boolean cambiarPrecioTarifas(Tarifa t, double precio) {
		if (t == null)
			return false;

		for (Tarifa tar : this.tarifas) {
			if (t.equals(tar) == true) {
				tar.setPrecio(precio);
				return true;
			}
		}
		return false;
	}

	/**
	 * Define el horario de Climatizacion
	 *
	 * @param s          Sala en la que se definira la climatizacion
	 * @param horaInicio La hora a la que empezara la climatizacion
	 * @param horaFin    La hora a la que termine la climatizacion
	 * @return true si todo fue correcto, false si hubo alguno error
	 */
	public boolean definirHorarioClimatizacion(Sala s, LocalTime horaInicio, LocalTime horaFin) {
		if (s == null || horaInicio == null || horaFin == null) {
			return false;
		}

		if (horaInicio.compareTo(horaFin) > 0) {
			return false;
		}

		if (s.getClimatizacion() == true) {
			if (s.setHoraInicioClimatizacion(horaInicio) == false)
				return false;
			if (s.setHoraFinClimatizacion(horaFin) == false)
				return false;
			return true;
		}
		return false;
	}

	/**
	 * Obtiene el aforo de una sala
	 * 
	 * @param s La sala de donde se sacara el aforo
	 * @return devuelve el aforo de la sala o -1 en caso de error
	 */
	public int obtenerAforo(Sala s) {
		if (s == null)
			return -1;

		for (Sala sala : this.salas) {
			if (s.equals(sala) == true)
				return s.getAforo();
		}
		return -1;
	}

	/**
	 * Muestra las ocupaciones de las salas
	 */
	public void verOcupacionSalas() {
		System.out.print("\n");
		for (Sesion ss : this.sesiones) {
			if (ss.getActividadMonitorizada() != null) {
				System.out.println("En la sala llamada " + ss.getSala().getNombre() + " hay " + ss.getReservas().size()
						+ "/" + ss.getSala().getAforo() + " personas" + " en la sesion de "
						+ ss.getActividadMonitorizada().getNombre());
			} else {
				System.out.println("En la sala llamada " + ss.getSala().getNombre() + " hay " + ss.getReservas().size()
						+ "/" + ss.getSala().getAforo() + " personas" + " en la sesion de entrenamiento libre");
			}
		}
	}

	/**
	 * Crea un tipo actividad grupal
	 * 
	 * @param nombre                el nombre de dicha actividad
	 * @param precio                el precio de la actividad
	 * @param m                     monitor que asesorara la clase
	 * @param sesionesRequeridasMin sesiones minimas que se requieren para acceder
	 * @param sesionesRequeridasMax sesiones maximas que se requieren para acceder
	 * @param edadMinima            edad minima para la acceder a la actividad
	 * @param edadMaxima            edad maxima para la acceder a la actividad
	 * @param antiguedadMin         antiguedad minima para acceder a la actividad
	 * @param antiguedadMax         antiguedad maxima para acceder a la actividad
	 * @return devuelve true si todo fue bien o error en caso contrario
	 */
	public boolean crearTipoActividadGrupal(String nombre, int precio, Monitor m, int sesionesRequeridasMin,
			int sesionesRequeridasMax, int edadMinima, int edadMaxima, int antiguedadMin, int antiguedadMax) {

		if (nombre == null || precio < 0 || m == null || sesionesRequeridasMax < sesionesRequeridasMin
				|| edadMaxima < edadMinima || antiguedadMax < antiguedadMin)
			return false;

		this.actividadesGrupales.add(new ActividadGrupal(nombre, precio, m, sesionesRequeridasMin,
				sesionesRequeridasMax, edadMinima, edadMaxima, antiguedadMin, antiguedadMax));
		TipoActividad act = new TipoActividad(nombre);
		this.definirTarifaPlana("Tarifa Plana Mensual con " + nombre, Cuota.MENSUAL, act);
		this.definirTarifaPlana("Tarifa Plana Trimestral con " + nombre, Cuota.TRIMESTRAL, act);
		this.definirTarifaPlana("Tarifa Plana Anual con " + nombre, Cuota.ANUAL, act);
		return true;
	}

	/**
	 * Crea un tipo plan personalizado
	 * 
	 * @param nombre                el nombre del plan personalizado
	 * @param descripcion           la descripcion de dicho plan
	 * @param objetivo              el objetivo del plan
	 * @param monitor               el monitor que lo asesosara
	 * @param sesionesRequeridasMin sesiones requeridas para la sesion
	 * @param sesionesRequeridasMax sesiones maximas para la sesion
	 * @param edadMinima            edad minima para poder acceder al plan
	 * @param edadMaxima            edad maxima para poder acceder al plan
	 * @param antiguedadMin         antiguedad minima para acceder el plan
	 * @param antiguedadMax         antiguedad maxima para acceder el plan
	 * @return devuelve true si todo fue bien o false si hubo un error
	 */
	public boolean crearTipoPlanPersonalizado(String nombre, String descripcion, Objetivo objetivo, Monitor monitor,
			int sesionesRequeridasMin, int sesionesRequeridasMax, int edadMinima, int edadMaxima, int antiguedadMin,
			int antiguedadMax) {

		if (nombre == null || descripcion == null || objetivo == null || monitor == null
				|| sesionesRequeridasMax < sesionesRequeridasMin || edadMaxima < edadMinima
				|| antiguedadMax < antiguedadMin)
			return false;

		this.planPersonalizados.add(new PlanPersonalizado(nombre, descripcion, objetivo, monitor, sesionesRequeridasMin,
				sesionesRequeridasMax, edadMinima, edadMaxima, antiguedadMin, antiguedadMax));

		return true;
	}

	/**
	 * Crea una sesion de actividad libre
	 * 
	 * @param fecha      la fecha de la actividad libre
	 * @param horaInicia hora de inicio de la actividad
	 * @param horaFin    hora final de la actividad
	 * @param sala       la sala donde se realizará
	 * @return devuelve true si todo fue bien o false si hubo un error
	 */
	public boolean crearSesionActividadLibre(LocalDate fecha, LocalTime horaInicia, LocalTime horaFin,
			SalaSimple sala) {
		if (fecha == null || horaInicia == null || horaFin == null || sala == null
				|| LocalDate.now().isAfter(fecha) == true || horaInicia.isAfter(horaFin) == true) {
			return false;
		}

		Sesion s;
		s = new Sesion(fecha, horaInicia, horaFin, sala, null);
		this.sesiones.add(s);
		return true;
	}

	/**
	 * muestra los beneficios totales del gimnnasio
	 * 
	 * @return un string con los beneficios1
	 * 
	 */
	public String verBeneficios() {
		Double actividadGrupalBeneficio = 0.0;
		Double sesionLibreBeneficio = 0.0;
		Double planPersonalizadoBeneficio = 0.0;

		for (ActividadGrupal act : this.actividadesGrupales) {
			for (Sesion s : act.getSesiones()) {
				actividadGrupalBeneficio += act.getPrecio() * s.getReservas().size();
			}

		}
		for (Sesion s : this.sesiones) {
			if (s.getActividadMonitorizada() == null)
				sesionLibreBeneficio += this.precioSesionLibre * s.getReservas().size();
		}

		for (PlanPersonalizado p : this.planPersonalizados) {
			for (Sesion s : p.getSesiones())
				planPersonalizadoBeneficio += this.precioSesionPersonalizado * s.getReservas().size();
		}

		return "\nActividad Grupales Beneficios: " + actividadGrupalBeneficio + "\nSesiones Libres Beneficios : "
				+ sesionLibreBeneficio + " \nPlanes Personalizados Beneficios: " + planPersonalizadoBeneficio
				+ "\ntotal: " + (actividadGrupalBeneficio + sesionLibreBeneficio + planPersonalizadoBeneficio);
	}

	/**
	 * Escribe en un fichero los datos de gimnasio
	 * 
	 * @throws IOException excepcion
	 */
	public void escrituraGimnasio() throws IOException {
		File directory = new File("./copias/copia_" + LocalDate.now());
		if (!directory.exists())
			directory.mkdir();
		File file = new File(directory, "copia_" + LocalDate.now() + ".txt");
		FileOutputStream stream = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(stream);
		oos.writeObject(this);
		// salida.flush();
		// salida.close();

	}

	/**
	 * lee los datos de un fichero y los guarda en gimnasio
	 * 
	 * @param file el fichero donde se leeran los ficheros
	 * @throws IOException excepcion
	 */
	public void lecturaGimnasio(File file) throws IOException {
		FileInputStream stream = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(stream);

		try {
			GIMNASIO = (Gimnasio) ois.readObject();
		} catch (IOException ioex) {
			System.out.println("Error IOException en l ectura del archivo");
		} catch (ClassNotFoundException classNot) {
			System.out.println("Error Class Not Foun en lectura del archivo");
		}

	}

	/**
	 * obtiene la actividad grupal a partir de su nombre
	 * 
	 * @param nombre el nombre desde donde se buscara la actividad
	 * @return devuelve la
	 */
	public ActividadGrupal getActividadGrupalByName(String nombre) {
		for (ActividadGrupal a : this.actividadesGrupales) {
			if (a.getNombre().equals(nombre) == true)
				return a;
		}
		return null;
	}

	/**
	 * obtiene una sesion libre a partir de una fecha y una sala
	 * 
	 * @param fecha la fecha desde donde se encuentre
	 * @param s     la sala desde donde se buscara la sesion
	 * @return la sesion que se desee
	 */
	public Sesion getSesionLibreByDateAndSala(LocalDate fecha, Sala s) {
		for (Sesion ss : this.sesiones) {
			if (ss.getActividadMonitorizada() == null && ss.getSala().equals(s)
					&& (ss.getFecha().equals(fecha) == true))
				return ss;
		}
		return null;
	}

	/**
	 * obtiene el plan personalizado a partir de un nombre
	 * 
	 * @param nombre el nombre desde que se buscara el plan
	 * @return un plan personalizado
	 */
	public PlanPersonalizado getPlanPersonalizadoByName(String nombre) {
		for (PlanPersonalizado p : this.planPersonalizados) {
			if (p.getNombre().equals(nombre) == true)
				return p;
		}
		return null;
	}

	/**
	 * obtiene una sesion a partir de una actividad monotorizada
	 * 
	 * @param act        la actividad monotizada desde donde se buscara la sesion
	 * @param fecha      fecha de la que se busca la sesion
	 * @param horaInicio hora en la que se inicia la sesion que busquemos
	 * @return la sesion deseada
	 */
	public Sesion getSesionByActividadMonitorizada(ActividadMonitorizada act, LocalDate fecha, LocalTime horaInicio) {
		if (fecha == null || horaInicio == null) {
			return null;
		}
		
		for (Sesion s : this.sesiones) {
			if (s.getActividadMonitorizada() != null) {
				if (s.getActividadMonitorizada().equals(act) == true && s.getHoraInicio().equals(horaInicio) == true
						&& s.getFecha().equals(fecha) == true)
					return s;
			}
			
		}
		return null;
	}

	/**
	 * obtiene una sala a partir de un nombre
	 * 
	 * @param nombre el nombre desde donde se buscara la sala
	 * @return la sala deseada o null en caso de error
	 */
	public Sala getSalaByName(String nombre) {
		for (Sala sa : this.salas) {
			if (sa.getNombre().equals(nombre) == true)
				return sa;
		}
		return null;
	}

	/**
	 * define una tarifa plana
	 * 
	 * @param nombre el nombre de la tarifa
	 * @param c      la cuota que se desee
	 * @param ta     el tipo de actividad
	 * @return devuelve true si todo fue correcto o error en caso contrario
	 */
	public boolean definirTarifaPlana(String nombre, Cuota c, TipoActividad ta) {
		if (c == null || ta == null || nombre == null) {
			return false;
		}
		return this.tarifas.add(new TarifaPlana(nombre, c, ta));
	}

	/**
	 * define una tarifa por pago de uso
	 * 
	 * @param nombre el nombre de dicha tarifa
	 * @return devuelve true si todo fue correcto o false en caso contrario
	 */
	public boolean definirTarifaPagoPorUso(String nombre) {
		if (nombre == null)
			return false;

		return this.tarifas.add(new TarifaPagoPorUso(nombre));
	}

	/**
	 * obtiene una tarifa a partir de un nombre
	 * 
	 * @param nombre el nombre a buscar
	 * @return la tarifa deseada o null si hubo un error
	 */
	public Tarifa getTarifaByName(String nombre) {
		for (Tarifa t : this.tarifas) {
			if ((t.getNombre().equals(nombre) == true))
				return t;
		}
		return null;
	}

	/**
	 * Obtiene la tarifa de apgo por uso
	 * 
	 * @return
	 */
	public Tarifa getTarifaPagoPorUso() {
		for (Tarifa t : this.tarifas) {
			if ((t.getNombre().equals("Pago por Uso") == true))
				return t;
		}
		return null;
	}

	@Override
	public String getName() {
		return "LADFIT";
	}

	@Override
	public String getLogo() {
		return "./resources/logo.jpg";
	} // jpg, gif and png formats are supported

	@Override
	public String getCif() {
		return "ES-00877893X";
	}

	@Override
	public double getBaseSalaryPerMonth() {
		return getSueldo();
	}

	@Override
	public double getRateHour() {
		return getSuplemento();
	}

	/**
	 * Inicia la sesion del ususario
	 * 
	 * @param usuario
	 * @param contrasenia del usuario
	 * @return true si se realizo todo bien o false en caso contrario
	 */
	public boolean login(String usuario, String contrasenia) {
		for (Usuario u : this.usuarios) {
			if ((u.getUsuario().equals(usuario)) && (u.getContrasenya().equals(contrasenia))) {
				u.setSesionIniciado(true);
				this.usuarioActualOperando = u;
				return true;
			}
		}
		return false;
	}

	/**
	 * Devuelve el usuario que esta con la sesion iniciada en el momento
	 * 
	 * @return usuario que ha iniciado sesion
	 */
	public Usuario getUsuarioActualOperando() {
		return this.usuarioActualOperando;
	}

	/**
	 * Metodo que realiza el logout del usuario
	 * 
	 * @param u usuario del que se realiza el logout
	 * @return
	 */
	public boolean logout(Usuario u) {
		this.usuarioActualOperando = null;
		u.logout();
		return true;
	}

	/**
	 * Getter
	 * 
	 * @return lista de salas del gimnasio
	 */
	public List<Sala> getSalas() {
		return this.salas;
	}

	/**
	 * Getter
	 * 
	 * @return lista con los planes personalizados que hay en el gimnasio
	 */
	public List<PlanPersonalizado> getPlanesPersonalizados() {
		return this.planPersonalizados;
	}
}
