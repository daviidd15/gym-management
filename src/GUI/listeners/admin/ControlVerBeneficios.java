package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JTable;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorPrincipalPanel;
import actividades.ActividadGrupal;
import actividades.PlanPersonalizado;
import actividades.Sesion;
import gimnasio.Gimnasio;
import gimnasio.Sala;

/**
 * Controlador que lleva al administrador desde la vista principal del administrador
 *  a la vista de los beneficios del gimnasio
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlVerBeneficios implements ActionListener{
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlVerBeneficios(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
	}

	/**
	 * Cuando se pulse el boton de ver beneficios, se actualizan los valores de la vista de los beneficios
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JTable tabla;
		String[] titulos = { "Nombre actividad", "Beneficio" };
		int n = 0, libre=0;
		
		for (ActividadGrupal act : Gimnasio.getGimnasio().getActividadesGrupales()) {
			for (Sesion s : act.getSesiones()) {
				
				n++;
				
			}
		}
		
		for (Sesion s : Gimnasio.getGimnasio().getSesiones()) {
			if (s.getActividadMonitorizada() == null)
				
					libre++;
					n++;
				
		}
		
		for (PlanPersonalizado p : Gimnasio.getGimnasio().getPlanesPersonalizados()) {
			for (Sesion s : p.getSesiones())
				
					n++;
				
		}
		n++;
		Object[][] filas = new String[n][2];
		int i = 0;
		
		Double actividadGrupalBeneficio = 0.0;
		Double sesionLibreBeneficio = 0.0;
		Double planPersonalizadoBeneficio = 0.0;
		
		for (ActividadGrupal act : Gimnasio.getGimnasio().getActividadesGrupales()) {
			for (Sesion s : act.getSesiones()) {
				if(s.getFecha().getMonth().equals((LocalDate.now().getMonth()))){
				actividadGrupalBeneficio += act.getPrecio() * s.getReservas().size();
				}
			}
			filas[i][0] = act.getNombre();
			filas[i][1] = actividadGrupalBeneficio.toString();
			i++;
		}
		for (Sesion s : Gimnasio.getGimnasio().getSesiones()) {
			if (s.getActividadMonitorizada() == null) {
				if(s.getFecha().getMonth().equals((LocalDate.now().getMonth()))){
					sesionLibreBeneficio += Gimnasio.getGimnasio().getPrecioSesionLibre() * s.getReservas().size();
					
				}
			}
		}
		filas[i][0] = "Entrenamiento libre";
		filas[i][1] = sesionLibreBeneficio.toString();
		i++;
	if(Gimnasio.getGimnasio().getPlanesPersonalizados().isEmpty()==false){
		for (PlanPersonalizado p : Gimnasio.getGimnasio().getPlanesPersonalizados()) {
			for (Sesion s : p.getSesiones()) {
				if(s.getFecha().getMonth().equals((LocalDate.now().getMonth()))){
					planPersonalizadoBeneficio += Gimnasio.getGimnasio().getPrecioSesionPersonalizado() * s.getReservas().size();
				}
			}
			filas[i][0] = p.getNombre();
			filas[i][1] = planPersonalizadoBeneficio.toString();
			i++;
		}
	}
		
		tabla = new JTable(filas, titulos);
		this.frame.getVistaBeneficios().setNewTable(tabla);
		mostrarPanelBeneficios();
	}

	/**
	 * Método que muestra la vista de los beneficios del gimnasio
	 */
	private void mostrarPanelBeneficios() {
		this.frame.getVistaBeneficios().setVisible(true);
		this.vista.setVisible(false);
	}
	
}
