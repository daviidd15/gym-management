package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import GUI.VentanaProyecto;
import GUI.cliente.ReservasPanel;
import actividades.ActividadGrupal;
import actividades.PlanPersonalizado;
import gimnasio.Gimnasio;

/**
* Controlador para ir a las reservas de un plan personalizado
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlReservaPlanPersonalizado implements ActionListener {
	private ReservasPanel vista;
	private VentanaProyecto frame;
	
	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlReservaPlanPersonalizado(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaActividades();
	}

	
	/**
	* Al pulsar el boton se actlualiza el panel siguiente y se lleva alli
	* @param e evento 
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		List<PlanPersonalizado>planPersonalizado = Gimnasio.getGimnasio().getPlanesPersonalizados();
		String [] str = new String[planPersonalizado.size()];
		for(int i = 0; i< planPersonalizado.size(); i++){
			str[i] = planPersonalizado.get(i).getNombre();
		}
		this.frame.getVistaPlanPersonalizado().setPlanesList(str);
		
		mostrarPanelPlanPersonalizado();
	}
	
	/**
	* Muestra el panel del Plan Personalizado
	*/
	private void mostrarPanelPlanPersonalizado() {
		this.frame.getVistaPlanPersonalizado().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
}