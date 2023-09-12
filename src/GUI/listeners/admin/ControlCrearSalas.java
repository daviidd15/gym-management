package GUI.listeners.admin;

import java.awt.event.*;
import java.time.format.*;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.JTextField;


import GUI.VentanaProyecto;
import GUI.admin.CambiarPrecioTarifa;
import GUI.admin.SalasPanel;
import gimnasio.Gimnasio;
import gimnasio.Sala;
import tarifas.Tarifa;

/**
 * Controlador que crea una sala 
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlCrearSalas implements ActionListener{
	private SalasPanel vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlCrearSalas(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaSalas();
	}

	/**
	 * Cuando se pulse el boton de crear, se crea una sala 
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
       LocalTime horaInicioClimatizacion = LocalTime.of(Integer.parseInt(vista.getHoraInicioClima()), Integer.parseInt(vista.getMinutoInicioClima()));
       LocalTime horaFinClimatizacion = LocalTime.of(Integer.parseInt(vista.getHoraFinClima()), Integer.parseInt(vista.getMinutoFinClima()));
        
		if (vista.getTipoSala().equals("Sala simple") && vista.getSalaPadre().equals("No tiene")) {
			Gimnasio.getGimnasio().definirSalaSimple(vista.getNombre(), vista.getDescripcion(), Integer.parseInt(vista.getAforo()), vista.getClimatizacion(),
					 horaInicioClimatizacion, horaFinClimatizacion);
		}
		else if (vista.getTipoSala().equals("Sala simple") && vista.getSalaPadre().equals("No tiene") == false) {
			Sala salaPadre = Gimnasio.getGimnasio().getSalaByName(vista.getSalaPadre());
			if(salaPadre.definirSubsSalaSimple(vista.getNombre(), Integer.parseInt(vista.getAforo()))==false){
				System.out.println("ERROR1");
			}
		}
		else if (vista.getTipoSala().equals("Sala compuesta") && vista.getSalaPadre().equals("No tiene") == false) {
			Sala salaPadre = Gimnasio.getGimnasio().getSalaByName(vista.getSalaPadre());
			if(salaPadre.definirSubsSalaCompuesta(vista.getNombre(), Integer.parseInt(vista.getAforo()))==false){
				System.out.println("ERROR2");
			}
		}
		else if (vista.getTipoSala().equals("Sala compuesta") && vista.getSalaPadre().equals("No tiene")) {
			if(Gimnasio.getGimnasio().definirSalaCompuesta(vista.getNombre(), vista.getDescripcion(), Integer.parseInt(vista.getAforo()), vista.getClimatizacion(),
					 horaInicioClimatizacion, horaFinClimatizacion)==false){
						 System.out.println("ERROR3");
					 }
		}
		
		mostrarPanelAdmin();
	}

	/**
	 * Método que muestra el panel principal del administrador
	 */
	private void mostrarPanelAdmin() {
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);
		// this.frame.getVistaRegistro().update();
	}
}
