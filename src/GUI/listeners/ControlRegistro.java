package GUI.listeners;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.LoginPanel;
import GUI.VentanaProyecto;
import GUI.cliente.RegistroPanel;
import gimnasio.Gimnasio;
import tarifas.Tarifa;
import usuarios.Tarjeta;

/**
 * Controlador que lleva al usuario a la vista del registro
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlRegistro implements ActionListener {
	private RegistroPanel vista;
	private VentanaProyecto frame;

	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlRegistro(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaRegistro();
	}
	
	/**
	 * Metodo que registra a un cliente cuando pulsa el boton registrar, y posteriomente lo logea
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(Gimnasio.getGimnasio().registrarCliente(vista.getUsuario(), vista.getContrasenia(), vista.getNombre(), Integer.parseInt(vista.getTelefono()), vista.getFechaNacimiento(), new Tarjeta(vista.getNumeroTarjeta(), vista.getNumeroTarjeta(), Integer.parseInt(vista.getPin())), Gimnasio.getGimnasio().getTarifaByName(vista.getTarifa() ) )!=null){
			if(Gimnasio.getGimnasio().login(vista.getUsuario(), vista.getContrasenia())){
				JOptionPane.showMessageDialog(vista, "Se ha registrado y logueado correctamente. ", "Registro Finalizado", JOptionPane.INFORMATION_MESSAGE);
				mostrarPanelActividades();
				}
			}
		else
			JOptionPane.showMessageDialog(vista, "Error en el registro. ", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Metodo que muestra la pantalla principal del cliente
	 */
	private void mostrarPanelActividades() {
		this.frame.getVistaActividades().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
	 
	

}