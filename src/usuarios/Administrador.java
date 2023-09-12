package usuarios;

import java.io.Serializable;

/**
 * Clase administrador, persona que administra
 * todo el gimnasio
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
 @SuppressWarnings("serial")
public class Administrador extends Usuario implements Serializable{

	/**
	 * Constructor de la clase
	 * 
	 * @param usuario string con el usuario del administrador
	 * @param contrasenya string con la contraseña del administrador
	 */
	public Administrador(String usuario, String contrasenya) {
		super(usuario, contrasenya);
	}

	@Override
	public boolean isAdministrador() {
		return true;
	}

	@Override
	public boolean isMonitor() {
		return false;
	}

	@Override
	public boolean isCliente() {
		return false;
	}
}
