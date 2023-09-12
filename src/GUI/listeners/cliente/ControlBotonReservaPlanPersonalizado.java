package GUI.listeners.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.cliente.ActividadGrupalPanel;
import GUI.cliente.PlanPersonalizadoPanel;
import actividades.ActividadGrupal;
import actividades.PlanPersonalizado;
import actividades.Sesion;
import excepciones.NoCumpleRequisito;
import excepciones.PlanContratado;
import gimnasio.Gimnasio;
import usuarios.Cliente;

/**
* Controlador del boton para reservar un plan personalizado
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlBotonReservaPlanPersonalizado implements ActionListener {
	private PlanPersonalizadoPanel vista;
	private VentanaProyecto frame;
	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlBotonReservaPlanPersonalizado(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaPlanPersonalizado();
	}


	@Override
	public void actionPerformed(ActionEvent e) {	
		Cliente cliente = (Cliente)Gimnasio.getGimnasio().getUsuarioActualOperando();
		
		PlanPersonalizado planPersonalizado = vista.getPlanPersonalizado();
		
		try {
			if(cliente.apuntarsePlanPersonalizado(planPersonalizado)){
				JOptionPane.showMessageDialog(vista, "Estas apuntado al plan", "OK", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(vista, "Error al apuntarse", "No puedes apuntarte", JOptionPane.ERROR_MESSAGE);
			}
		}catch(PlanContratado e1) {
			if (vista.getListaEspera().equals("Si")) {
				planPersonalizado.getListaDeEspera().apuntar(cliente);
				JOptionPane.showMessageDialog(vista, e1.toString(), "No puedes apuntarte", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(vista, e1.toString(), "No puedes apuntarte", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (NoCumpleRequisito e2) {
			JOptionPane.showMessageDialog(vista, e2.toString(), "No puedes apuntarte", JOptionPane.ERROR_MESSAGE);
			mostrarPanelActividades();
		}

	}
	
	private void mostrarPanelActividades() {
		this.frame.getVistaActividades().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
	
}
