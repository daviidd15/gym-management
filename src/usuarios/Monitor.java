package usuarios;

import actividades.*;

import es.uam.eps.padsof.payrolls.*;
import es.uam.eps.padsof.payrolls.exceptions.InvalidPeriod;
import es.uam.eps.padsof.payrolls.exceptions.NonExistentFileException;
import es.uam.eps.padsof.payrolls.exceptions.UnsupportedImageTypeException;
import gimnasio.*;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoField;
import java.io.*;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * Clase monitor, hija de usuario Monitor va a impartir actividades grupales y
 * planes personalizados
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
 @SuppressWarnings("serial")
public class Monitor extends Usuario implements IEmployeeInfo, Serializable{
	private String correo;
	private String nombre;
	private String dni;
	private int horasTrabajadas;
	private double sueldoFinal;
	private List<ActividadMonitorizada> horario;

	/**
	 * Constructor de la clase
	 * 
	 * @param usuario     usuario del monitor
	 * @param contrasenya contraseña del monitor
	 * @param correo      correo electronico del monitor
	 * @param nombre      nombre completo del monitor
	 * @param dni         documento de identidad del monitor
	 */
	public Monitor(String usuario, String contrasenya, String correo, String nombre, String dni) {
		super(usuario, contrasenya);
		this.correo = correo;
		this.horasTrabajadas = 0;
		this.sueldoFinal = 0;
		this.nombre = nombre;
		this.dni = dni;
		this.horario = new ArrayList<ActividadMonitorizada>();
	}

	/**
	 * Getter Obtiene el objetivo a traves de su valor
	 * 
	 * @param numObjetivo numero del objetivo
	 * @return objetivo
	 */
	public Objetivo getObjetivo(int numObjetivo) {
		Objetivo[] ob = new actividades.Objetivo[numObjetivo];
		return ob[numObjetivo];
	}

	/**
	 * Getter
	 * 
	 * @return nombre del monitor
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Getter
	 * 
	 * @return lista de actividades monitorizadas de un monitor
	 */
	public List<ActividadMonitorizada> getHorario(){
		return this.horario;
	}
	
	/**
	 * Metodo que obtiene el horario de una semana del monitor
	 * 
	 * @return matriz con el horario
	 */
	public String[][] getHorarioSemana(){
		int n=0;
		for(ActividadMonitorizada act: this.horario){
			for(Sesion ses: act.getSesiones()){
				n++;
			}
		}
		String[][] aux = new String[n][4];
		
		int i=0; 
		for (ActividadMonitorizada a: this.horario) {		
			for (Sesion s: a.getSesiones()) {
				
					if (this.fechaEnSemana(s.getFecha()) == true && a.getSesiones().contains(s)) {
					aux[i][0]= s.getFecha().getDayOfWeek().toString();
					aux[i][1] = a.getNombre();
					aux[i][2]= String.valueOf(s.getHoraInicio());
					aux[i][3]= String.valueOf(s.getHoraFin());
					i++;
			
				}
				
				
			}
			
		}
		return aux;
	}
	
	/**
	 * Determina si una fecha esta en la semana actual
	 * 
	 * @param fecha
	 * @return
	 */
	public boolean fechaEnSemana(LocalDate fecha) {
       
        int semanaFecha = fecha.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        
        LocalDate hoy = LocalDate.now();
        int semanaHoy = hoy.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        
        
        return semanaFecha == semanaHoy;
    }

	/**
	 * Getter
	 * 
	 * @return dni del monitor
	 */
	public String getDni() {
		return this.dni;
	}

	/**
	 * Getter
	 * 
	 * @return horas trabajadas del monitor
	 */
	public int getHorasTrabajadas() {
		return this.horasTrabajadas;
	}

	/**
	 * Añade una actividad al horario del monitor
	 * 
	 * @param act actividad monitorirzada
	 * @return true si lo ha añadido bien o false en caso contrario
	 */
	public boolean addActividad(ActividadMonitorizada act) {
		if(this.horario.contains(act)==false){
		return this.horario.add(act);}
		return false;
	}
	
	/**
	 * Metodo del cual se accedera a la nomina
	 * 
	 * genera la nomina del monitor
	 */
	public void accesoNomina() {
		try {
			PayrollSystem.createPayroll(Gimnasio.getGimnasio(), this , LocalDate.now().minusMonths(1).getMonth(),
				Year.now(),  this.horasTrabajadas, "./");
		} catch(NonExistentFileException fileExc){
			System.out.println("Error NonExistenFile");
			
		}catch(UnsupportedImageTypeException imgExc){
			System.out.println("Error Unsupported Image Type");
		}catch(InvalidPeriod perExc){
			System.out.println("Error Invalid Period");	
		}
		return;
	}
	
	/**
	 * Metodo desde donde e accedera al horario
	 */
	public void accesoHorario() {
		System.out.print("El monitor " + this.nombre + " tiene las siguientes Actividades pendientes:");

		for (ActividadMonitorizada act : this.horario) {
			System.out.print(" " + act.getNombre());
		}
		System.out.print("\n");
		return;

	}
	
	/**
	 * Aumenta las horas trabajadas del monitor
	 * 
	 * @param horas a aumentar
	 * @return true en caso de que se hayan comentado correctamente
	 * o false en caso contrario
	 */
	public boolean aumentarHorasTrabajadas(int horas) {
		if (horas <= 0)
			return false;

		this.horasTrabajadas += horas;
		return true;
	}
	
	//@Override
	public String getName() {
		
		return this.nombre;
	}

	//@Override
	public String getNif() {
		return this.dni;
	}

	/**
	 * Calcula el sueldo final del monitor, con sus horas extras
	 * 
	 * @return sueldo final del monitor
	 */
	public double calcularSueldoFinal() {
		double sueldoMonitor = 0;

		sueldoMonitor += Gimnasio.getGimnasio().getSueldo();
		sueldoMonitor += Gimnasio.getGimnasio().getSuplemento() * this.horasTrabajadas;
		
		sueldoFinal = sueldoMonitor;
		return sueldoMonitor;

	}	
	
	/**
	 * Cancela una sesion de un monitor
	 * 
	 * @param nombre nombre de la sesion
	 * @return true si se ha cancelado correctamente o false en caso contrario
	 */
	public boolean cancelarClaseMonitor(String nombre, LocalTime horaInicio, LocalDate fecha) {
		if(Gimnasio.getGimnasio().cancelarClase(nombre, horaInicio, fecha)==true){
			
			return true;
		}
		return false;
	}

	@Override
	public boolean isAdministrador() {
		return false;
	}

	@Override
	public boolean isMonitor() {
		return true;
	}

	@Override
	public boolean isCliente() {
		return false;
	}

}