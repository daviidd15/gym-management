package main;

import gimnasio.*;
import java.time.*;

import javax.swing.JOptionPane;

import java.io.*;

import usuarios.*;
import actividades.*;
import excepciones.ClientePenalizado;
import excepciones.NoCumpleRequisito;
import excepciones.NoExisteSesion;
import excepciones.PlanContratado;
import tarifas.*;

/**
 * 
 * @author Alvaro Casasus, David Palomares y Laura de la Cruz
 *
 */
public class TesterMain {
	/**
	 * 
	 * @param args argumentos del main 
	 */
	public static void main(String args[]) {

		
		  Gimnasio.getGimnasio().setSueldo(1080);
		  Gimnasio.getGimnasio().setSuplemento(7);
		  Gimnasio.getGimnasio().setDiasPenalizacion(10);
		  Gimnasio.getGimnasio().setReservasCanceladas(3);
		  Gimnasio.getGimnasio().setPorcentajeDevolucion(0.75);
		  Gimnasio.getGimnasio().setPorcentajeDescuento(0.25);
		  Gimnasio.getGimnasio().setPrecioSesionLibre(3);
		  Gimnasio.getGimnasio().setPrecioSesionPersonalizado(10);
		  Gimnasio.getGimnasio().setPrecioTarifaPlana(40);
		 

		Monitor m = Gimnasio.getGimnasio().registraMonitor("juan_gonzalez", "tester1234", "juan_gonzalez@gmail.com",
				"Juan Gonzalez", "58982536F");
		TipoActividad tA = new TipoActividad("Zumba");
		TarifaPlana tP = new TarifaPlana("Tarifa plana", Cuota.MENSUAL, tA);
		Tarjeta tarj = new Tarjeta("Mario", "1234567890987654", 1103);
		Tarjeta tarj2 = new Tarjeta("Jimena", "1234967858987644", 0311);
		
		
		Gimnasio.getGimnasio().definirSalaCompuesta("Sala bicicletas", "Sala para las bicis", 10, false, null, null);
		/* Creamos un cliente */
		Cliente c = Gimnasio.getGimnasio().registrarCliente("mario_alvarez", "mario1234", "Mario Alvarez", 655241569,
				LocalDate.of(1995, 11, 14), tarj, tP);
		Cliente c2 = Gimnasio.getGimnasio().registrarCliente("jimena_casasus", "jimena1234", "Jimena Rodriguez",
				675841599, LocalDate.of(1999, 12, 24), tarj2, tP);

		/* Definimos una sala en el gimnasio */
		if (Gimnasio.getGimnasio().definirSalaSimple("Sala Baile", "Sala para hacer bailes", 10, true,
				LocalTime.of(9, 0), LocalTime.of(23, 0)) == false)
			return;

		/* CremoS un tipo de actividad Grupal llamada Zumba */
		if (Gimnasio.getGimnasio().crearTipoActividadGrupal("Zumba", 5, m, -1, -1, -1, -1, -1, -1) == false)
			return;
		for(Tarifa t: Gimnasio.getGimnasio().getTarifasPlanas())
		System.out.println(t.getNombre());

		Sala s = Gimnasio.getGimnasio().getSalaByName("Sala Baile");

		ActividadGrupal zumba = Gimnasio.getGimnasio().getActividadGrupalByName("Zumba");

		if (zumba.crearSesionActividadGrupal(LocalDate.now(), LocalTime.of(16, 0), LocalTime.of(18, 0), (SalaSimple) s) == false)
			return;
		
		if (zumba.crearSesionActividadGrupal(LocalDate.now().minusMonths(1), LocalTime.of(16, 0), LocalTime.of(18, 0), (SalaSimple) s) == false)
			return;
		if (zumba.crearSesionActividadGrupal(LocalDate.now().minusMonths(1), LocalTime.of(11, 0), LocalTime.of(13, 0), (SalaSimple) s) == false)
			return;
		if (zumba.crearSesionActividadGrupal(LocalDate.now().minusMonths(1), LocalTime.of(14, 0), LocalTime.of(15, 0), (SalaSimple) s) == false)
			return;

		Sesion ss = Gimnasio.getGimnasio().getSesionByActividadMonitorizada(zumba, LocalDate.now(), LocalTime.of(16,0));
		
		
		try {
			c.reservarSesion(ss);
		} catch(ClientePenalizado e1) {
			System.out.println(e1.toString());
		}catch(NoCumpleRequisito e2){
			System.out.println(e2.toString());
		}catch(NoExisteSesion e3){
			System.out.println(e3.toString());
		}
		

		/* Procedemos a comprobar que se ha apuntado correctamente */
		System.out.print("El cliente esta apuntado a: ");
		for (Reserva r : c.getReservas()) {
			System.out.print(r.getSesion().getActividadMonitorizada().getNombre());
		}

		System.out.println("\nEl numero de reservas canceladas es: " + c.getNumCancelacion());

		/* Procedemos a cancelarlo para que se nos sume 1 a las cancelaciones */
		c.cancelarReserva(c.getReservaByName("Zumba",LocalDate.now(), LocalTime.of(16, 0)));

		/* Imprmimos de nuevo las reservas para ver que Zumba ya no estÃ¡ */

		System.out.print("\nEl cliente esta apuntado a: ");
		for (Reserva r : c.getReservas()) {
			System.out.print(r.getSesion().getActividadMonitorizada().getNombre());
		}

		System.out.println("\nEl numero de reservas canceladas es: " + c.getNumCancelacion());

		
		
		Monitor m1 = Gimnasio.getGimnasio().registraMonitor("david", "1234", "david@gmail.com",
				"David Palomares", "788544Y");
		
		Monitor m2 = Gimnasio.getGimnasio().registraMonitor("alvaro", "1234", "alvaro@gmail.com",
				"Alvaro Casasus", "4521456F");
		
		Monitor m3 = Gimnasio.getGimnasio().registraMonitor("laura", "1234", "laurita@gmail.com",
				"Laura de la Cruz", "4788541F");
		
		if (Gimnasio.getGimnasio().crearTipoPlanPersonalizado("Muevete con Alvaro", "Vamos a ponernos en forma juntos",
				Objetivo.PERDIDA_DE_PESO, m2, -1, -1, -1, -1, -1, -1) == false) {
			return;
		}
		if (Gimnasio.getGimnasio().crearTipoPlanPersonalizado("Baila con Alvaro", "Movamonos juntos",
				Objetivo.PERDIDA_DE_PESO, m2, -1, -1, -1, -1, -1, -1) == false) {
			return;
		}
		if (Gimnasio.getGimnasio().crearTipoPlanPersonalizado("Spinning con Laura Plan", "Spinning a tope",
				Objetivo.PERDIDA_DE_PESO, m3, -1, -1, -1, -1, -1, -1) == false) {
			return;
		}
		if (Gimnasio.getGimnasio().crearTipoPlanPersonalizado("Ponte fuerte con David", "Vamos a estar mas fuertes que CBUM",
				Objetivo.GANANCIA_MASA_MUSCULAR , m1, -1, -1, -1, -1, -1, -1) == false) {
			return;
		}
		if (Gimnasio.getGimnasio().crearTipoPlanPersonalizado("Rehabilitate con Laura", "¿Te duele?, dejame ayudarte",
				Objetivo.REHABILITACION , m3, -1, -1, -1, -1, -1, -1) == false) {
			return;
		}
		
		if(Gimnasio.getGimnasio().crearTipoActividadGrupal("Cardio con Laura", 20, m3, -1, -1, -1, -1, -1, -1)==false)
			return;
			
		if(Gimnasio.getGimnasio().crearTipoActividadGrupal("Boxeo con Laura", 20, m3, -1, -1, -1, -1, -1, -1)==false)
			return;
		
		ActividadGrupal cardio = Gimnasio.getGimnasio().getActividadGrupalByName("Cardio con Laura");
		ActividadGrupal boxeo = Gimnasio.getGimnasio().getActividadGrupalByName("Boxeo con Laura");
		
		if (cardio.crearSesionActividadGrupal(LocalDate.now(), LocalTime.of(21, 0), LocalTime.of(22, 0), (SalaSimple) s) == false){
					System.out.println("ERROR1");
			return;}
			
		if (cardio.crearSesionActividadGrupal(LocalDate.now(), LocalTime.of(19, 0), LocalTime.of(20, 0), (SalaSimple) s) == false){
					System.out.println("ERROR2");
			return;}
			
		if (boxeo.crearSesionActividadGrupal(LocalDate.now(), LocalTime.of(9, 0), LocalTime.of(10, 0), (SalaSimple) s) == false){
					System.out.println("ERROR3");
			return;}

		PlanPersonalizado pp = Gimnasio.getGimnasio().getPlanPersonalizadoByName("Muevete con Alvaro");
		Sesion cardioSesion = Gimnasio.getGimnasio().getSesionByActividadMonitorizada(cardio, LocalDate.now(), LocalTime.of(19,0));
		try{
			if(c.reservarSesion(cardioSesion)==false){
			System.out.println("error en la reserva");
		}
		}
		catch(NoCumpleRequisito e3) {
			System.out.println("ERROR4");
		}catch(ClientePenalizado p1p) {
			System.out.println("ERROR5");
		}catch(NoExisteSesion e_3) {
			System.out.println(e_3.toString());
		}
		
		
		try {
			c.apuntarsePlanPersonalizado(pp);
		}catch(PlanContratado e1) {
			System.out.println("El plan personalizado ya está contratado");
			return;
		} catch (NoCumpleRequisito e2) {
			System.out.println("El cliente no cumple los requisitos");
			return;
		}
		
		
		try {
			c.reservarSesion(ss);
		} catch(ClientePenalizado e3) {
			System.out.println(e3.toString());
		}catch(NoCumpleRequisito e4){
			System.out.println(e4.toString());
		}catch(NoExisteSesion e_4) {
			System.out.println(e_4.toString());
		}

		if (pp.crearSesionPersonalizada(LocalDate.now(), LocalTime.of(11, 0), LocalTime.of(12, 0), (SalaSimple) s,
				pp) == false)
			return;

		// if(zumba.crearSesionActividadGrupal(LocalDate.now(), LocalTime.of(11, 0),
		// LocalTime.of(13, 0), (SalaSimple)s, zumba)==false)
		// return;

		m.accesoHorario();
		
		

		if (Gimnasio.getGimnasio().crearSesionActividadLibre(LocalDate.now(), LocalTime.of(10, 0), LocalTime.of(10, 30),
				(SalaSimple) s) == false)
			return;

		Sesion libre = Gimnasio.getGimnasio().getSesionLibreByDateAndSala(LocalDate.now(), s);
		if (libre == null)
			return;

		try {
			if (c.reservarSesion(libre) == false) {
				System.out.println("\n\nDEVUELVE FALSE\n\n");
			}
		} catch(ClientePenalizado e5) {
			System.out.println(e5.toString());
		}catch(NoCumpleRequisito e6){
			System.out.println(e6.toString());
		}catch(NoExisteSesion e7) {
			System.out.println("En la sesion libre"+e7.toString());
		}
		
		System.out.println("Los beneficios del Gimnasio son: " + Gimnasio.getGimnasio().verBeneficios());

		/*
		 * Vamos a ver la ocupacion que hay en las salas, teniendo en cuenta que solo
		 * tenemos una persona
		 */
		Gimnasio.getGimnasio().verOcupacionSalas();

		/* Vamos a intentar apuntar a una persona a un plan personalizado ya ocupado */
		try {
			c2.apuntarsePlanPersonalizado(pp);
		}catch(PlanContratado e1) {
			System.out.println("El plan personalizado ya está contratado");
			
		} catch (NoCumpleRequisito e2) {
			System.out.println("El cliente no cumple los requisitos");
			
		}
		
		
		
		//if(c2.apuntarsePlanPersonalizado(pp)==false)
			//c2.apuntarsePlanPersonalizado(pp);

		/*
		 * Ahora vamos a ver si el otro cliente cancela, se le envia una notificacion al
		 * cliente 2
		 */

		c.cancelarPlanPersonalizado(pp);
		
		Gimnasio.getGimnasio().enviarNotificacion("Esto es un test para ver que funcionan las notificaciones", c2);
		
		/*Comprobamos que se ha enviado la notificacion automatica y la manual*/
		for (Notificacion n : c2.getNotificaciones()) {
			System.out.println(n.getContenido());
		}

		/* Ahora como esta libre nos apuntamos */
		try {
			c2.apuntarsePlanPersonalizado(pp);
		}catch(PlanContratado e1) {
			System.out.println("El plan personalizado ya está contratado");
			
		} catch (NoCumpleRequisito e2) {
			System.out.println("El cliente no cumple los requisitos");
		}
		
		

		try {
			Gimnasio.getGimnasio().escrituraGimnasio();

		} catch (IOException exc) {
			System.out.println("Error en la salida de escrituraGimnasio");
		}
		
		for(String str: m3.getHorarioSemana()[0] ){
			
				System.out.println(str);
			
		}
		System.out.println(LocalDate.now().with(DayOfWeek.valueOf("MONDAY")).toString());
		//m.accesoNomina();

	}
}
