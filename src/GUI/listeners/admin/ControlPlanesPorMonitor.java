package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import GUI.VentanaProyecto;
import GUI.admin.AdministradorPrincipalPanel;
import actividades.ActividadMonitorizada;
import actividades.PlanPersonalizado;
import gimnasio.Gimnasio;
import usuarios.Monitor;
import usuarios.Usuario;

/**
 * Controlador que lleva al administrador desde el panel principal de administrador
 * a la vista de los planes personalizados ofertados por cada monitor
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlPlanesPorMonitor implements ActionListener {
	
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlPlanesPorMonitor(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
	}

	/**
	 * Cuando se pulse el boton de planes por monitor, se actualizan los valores de los planes por monitor
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JTable tabla;
		String[] titulos = { "Nombre", "Monitor", "Contratado", "Descripcion", "Objetivo" };
		int n=0;
		for(Usuario u: Gimnasio.getGimnasio().getUsuarios()){
			if(u.isMonitor()){
				for(ActividadMonitorizada a : ((Monitor)u).getHorario()) {
					if(a.esPlanPersonalizado()) {
						n++;
					}
				}
			}
		}
		Object[][] filas = new String[n][5];
		int i = 0;
		for(Usuario u: Gimnasio.getGimnasio().getUsuarios()){
			if(u.isMonitor()){
				for(ActividadMonitorizada a : ((Monitor)u).getHorario()) {
					if(a.esPlanPersonalizado()) {
						filas[i][0]=a.getNombre();
						filas[i][1]=a.getMonitor().getName();
						if(((PlanPersonalizado)a).getContratante()==null) {
							filas[i][2] = "No";
						}
						else {
							filas[i][2] = "Si";
						}
						filas[i][3]= ((PlanPersonalizado)a).getDescripcion();
						filas[i][4] = ((PlanPersonalizado)a).getObjetivo().toString();
						i++;
					}
				}
			}
		}
		
		tabla = new JTable(filas, titulos);
		this.frame.getVistaPlanesPorMonitor().setNewTable(tabla);
		mostrarPanelNomina();
	}
	
	/**
	 * Método que te lleva a los planes por monitor
	 */
	private void mostrarPanelNomina() {
		this.frame.getVistaPlanesPorMonitor().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
}
