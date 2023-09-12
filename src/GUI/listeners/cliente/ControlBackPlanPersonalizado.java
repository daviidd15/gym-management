package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.VentanaProyecto;
import GUI.cliente.PlanPersonalizadoPanel;
import GUI.monitor.AccesoHorarioMonitorPanel;

	/**
	 * Clase del Control del Back del Plan Personalizado
	 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
	 */
public class ControlBackPlanPersonalizado implements ActionListener{
	private PlanPersonalizadoPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * @param frame del controlador
	 */
	public ControlBackPlanPersonalizado(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPlanPersonalizado();
	}
	
	
	/**
	 * muestra el panel anterior
	 * @param e la accion que realizará
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mostrarPanelAnterior();
	}
	
	/**
	 * muestran panel anterior
	 */
	private void mostrarPanelAnterior() {
		this.frame.getVistaActividades().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
}
