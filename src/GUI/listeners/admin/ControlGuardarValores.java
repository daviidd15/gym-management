package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.VentanaProyecto;
import GUI.admin.*;
import gimnasio.Gimnasio;
/**
*
* Controlador para gaurdar los valores predeterminados del gimnasio
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlGuardarValores implements ActionListener{
	private GimnasioValoresPredeterminados vista;
	private VentanaProyecto frame;
	
	/**
	* Construsctor del controlador
	* @param frame del controlador
	*/
	public ControlGuardarValores(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaGimnasioPredeterminado();
		
	}

	/**
	* Metodo que guarda los valores predeterminados al pulsar eñl boton
	* @param e evento
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		 Gimnasio.getGimnasio().setSueldo(Double.parseDouble(this.frame.getVistaGimnasioPredeterminado().getSueldo()));
		  Gimnasio.getGimnasio().setSuplemento(Double.parseDouble(this.frame.getVistaGimnasioPredeterminado().getSuplemento()));
		  Gimnasio.getGimnasio().setDiasPenalizacion(Integer.parseInt(this.frame.getVistaGimnasioPredeterminado().getDiasPenalizacion()));
		  Gimnasio.getGimnasio().setReservasCanceladas(Integer.parseInt(this.frame.getVistaGimnasioPredeterminado().getReservasCanceladas()));
		  Gimnasio.getGimnasio().setPorcentajeDevolucion(Double.parseDouble(this.frame.getVistaGimnasioPredeterminado().getPorcentajeDevolucion()));
		  Gimnasio.getGimnasio().setPorcentajeDescuento(Double.parseDouble(this.frame.getVistaGimnasioPredeterminado().getPorcentajeDescuento()));
		  Gimnasio.getGimnasio().setPrecioSesionLibre(Double.parseDouble(this.frame.getVistaGimnasioPredeterminado().getPrecioSesionLibre()));
		  Gimnasio.getGimnasio().setPrecioSesionPersonalizado(Double.parseDouble(this.frame.getVistaGimnasioPredeterminado().getPrecioSesionPersonalizado()));
		  Gimnasio.getGimnasio().setPrecioTarifaPlana(Double.parseDouble(this.frame.getVistaGimnasioPredeterminado().getPrecioTarifaPlana()));
		  JOptionPane.showMessageDialog(vista, "Se han guardado correctamente los valores", "Valores registrados", JOptionPane.INFORMATION_MESSAGE);
		  mostrarPanelAnterior();
	}
	/**
	 * Metodo que muestra el panel principal del administrador
	 */
	private void mostrarPanelAnterior() {
		this.frame.getVistaAdminPrincipal().setVisible(true);
		this.vista.setVisible(false);
	}

}
