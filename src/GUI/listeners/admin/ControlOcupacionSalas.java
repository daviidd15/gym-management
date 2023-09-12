package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JTable;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorPrincipalPanel;
import GUI.admin.OcupacionSalasPanel;
import GUI.cliente.ReservasPanel;
import actividades.Reserva;
import actividades.Sesion;
import gimnasio.Gimnasio;
import gimnasio.Sala;
import usuarios.Cliente;

/**
 * Controlador que lleva al administrador desde la vista principal del admin
 * a la vista de ocupacion de salas
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlOcupacionSalas implements ActionListener {
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;

	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlOcupacionSalas(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
	}

	/**
	 * Cuando se pulse el boton de ocupacion se actualizan los valores de las ocupaciones
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JTable tabla;
		String[] titulos = { "Nombre sala","Ocupación"};
		int n = 0;
		
		n = Gimnasio.getGimnasio().getSalas().size();
		Object[][] filas = new String[n][3];

		int i = 0;
		
		for (Sala sala: Gimnasio.getGimnasio().getSalas()) {
			filas[i][0] = sala.getNombre();
			int cont=0;
			for(Sesion s: Gimnasio.getGimnasio().getSesiones()){
				if(s.getHoraInicio().isAfter(LocalTime.now()) && s.getHoraFin().isBefore(LocalTime.now())){
					if(s.getSala().equals(sala)){
						
							cont=s.getReservas().size();
						
					}
				}
			}
			filas[i][1] = Integer.toString(cont);
			i++;
		}

		tabla = new JTable(filas, titulos);
		this.frame.getVistaOcupacionSalas().setNewTable(tabla);

		mostrarOcupacionSalas();
	}

	/**
	 * Método que muestra el panel de ocupacion de salas del gimnasio
	 */
	private void mostrarOcupacionSalas() {
		this.frame.getVistaOcupacionSalas().setVisible(true);
		this.vista.setVisible(false);
		// this.frame.getVistaRegistro().update();
	}
}