package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.admin.*;
import gimnasio.Gimnasio;
/**
 * Controlador que te lleva al panel de creacion de sesiones de actividad grupal
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlActividadesSesion implements ActionListener{
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;
	/**
	 * Constructor del controlador
	 * @param frame del controlador
	 */
	public ControlActividadesSesion(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
		
	}

	/**
	 * Método que actuaiza el panel de creacion de sesion de la actividad grupal cuando se pulsa el boton que te lleva a ese panel
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.getVistaCrearActividadGrupalSesion().setSalas(Gimnasio.getGimnasio().getSalasSimples());
		this.frame.getVistaCrearActividadGrupalSesion().setActividades(Gimnasio.getGimnasio().getActividadesGrupales());
		mostrarPanelCreacionActividadesSesion();
	}
	/**
	 * Método que te muestra el panel de la creacion de una sesiond de una actividad grupal
	 */
	private void mostrarPanelCreacionActividadesSesion() {
		this.frame.getVistaCrearActividadGrupalSesion().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}