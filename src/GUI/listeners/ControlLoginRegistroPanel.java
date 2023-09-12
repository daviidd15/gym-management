package GUI.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.*;
import tarifas.*;
import java.util.List;
import gimnasio.Gimnasio;

/**
 * Controlador que lleva al usuario a la vista del registro
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
public class ControlLoginRegistroPanel implements ActionListener {
	private LoginPanel vista;
	private VentanaProyecto frame;
	
	/**
	 * Constructor del controlador
	 * 
	 * @param frame ventana del proyecto
	 */
	public ControlLoginRegistroPanel(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = frame.getVistaLogin();
	}

	/**
	 * Metodo que actualiza la lista de tarifas y se dirige a la pantalla de registro
	 * 
	 * @param e evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Gimnasio.getGimnasio().getTarifasPlanas().isEmpty()) {
			Gimnasio.getGimnasio().setTarifasPlanas();
		}
		List<Tarifa>t = Gimnasio.getGimnasio().getTarifasPlanas();
		String [] str = new String[t.size()];
		for(int i = 0; i<t.size(); i++){
			str[i] = t.get(i).getNombre();
		}
		this.frame.getVistaRegistro().setTarifasList(str);
		mostrarPanelRegistro();
	}
	
	/**
	 * Metodo que muestra la vista de registro
	 */
	private void mostrarPanelRegistro() {
		this.frame.getVistaRegistro().setVisible(true);
		this.vista.setVisible(false);		
		//this.frame.getVistaRegistro().update();
	}
	
}