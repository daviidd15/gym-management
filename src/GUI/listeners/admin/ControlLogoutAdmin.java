package GUI.listeners.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import GUI.VentanaProyecto;
import GUI.admin.AdministradorPrincipalPanel;
import gimnasio.Gimnasio;
import GUI.LoginPanel;
/**
* Controlador del boton logout del administrador
*/
public class ControlLogoutAdmin implements ActionListener{
	private AdministradorPrincipalPanel vista;
	private VentanaProyecto frame;
	/**
	* Constructor  del controlador del logout
	* @param frame del controlador
	*/
	public ControlLogoutAdmin(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaAdminPrincipal();
	}
	/**
	* Al pulsar el boton se hace logout y se te lleva al login
	* @param e evento
	*/
	public void actionPerformed(ActionEvent e) {
			if(Gimnasio.getGimnasio().getUsuarioActualOperando().logout())
				mostrarPanelLogin();
			else
				JOptionPane.showMessageDialog(vista, "Error al hacer Logout", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	/**
	* Metodo que te meustra el panel del login
	*/
	private void mostrarPanelLogin() {
		this.frame.getVistaLogin().setVisible(true);
		this.vista.setVisible(false);		
		
	}
	
	
	
}
