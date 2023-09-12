package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.admin.CambiarPrecioTarifa;
import GUI.cliente.RegistroPanel;
import gimnasio.Gimnasio;

/**
 * Controlador que cambia el precio de la tarifa
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlBotonCambiarPrecioTarifas implements ActionListener{
	private CambiarPrecioTarifa vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlBotonCambiarPrecioTarifas(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaCambiarPrecioTarifa();
	}

	/**
	 * Cuando se pulse el boton cambiar, llama al metodo de gimnasio y cambia el precio de la tarifa que se haya seleccionado
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (Gimnasio.getGimnasio().cambiarPrecioTarifas(vista.getTarifa(), vista.getCosteTarifa())==false) {
			JOptionPane.showMessageDialog(vista, "Error al cambiar el precio de la tarifa", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(vista, "Se cambio el precio correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
			mostrarPanelPrincipal();
		}
			
	}
	
	/**
	 * Método que muestra el panel principal del administrador
	 */
	private void mostrarPanelPrincipal() {
		this.frame.getVistaActividades().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}

}
