package usuarios;

import gimnasio.*;

import java.io.Serializable;
import java.util.*;

/**
 * Clase abstacta usuario
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
 
 @SuppressWarnings("serial")
public abstract class Usuario implements Serializable{
	private String usuario;
	private String contrasenya;
	private List<Notificacion> notificaciones;
	private boolean sesionIniciada;
	
	/**
	 * Constructor de la clase
	 * 
	 * @param usuario nombre de usuario
	 * @param contrasenya contraseña del usuario
	 */
	public Usuario(String usuario, String contrasenya) {
		this.usuario = usuario;
		this.contrasenya = contrasenya;
		this.notificaciones = new ArrayList<Notificacion>();
		this.sesionIniciada = false;
	}
	
	/**
	 * Getter
	 * 
	 * @return devuelve el usuario
	 */
	public String getUsuario() {
		return this.usuario;
	}
	/**
	* Getter
	* @return contrasenia del usuario
	*/
	public String getContrasenya() {
		return this.contrasenya;
	}

	/**
	 * Getter
	 * 
	 * @return lista de notificaciones del usuario
	 */
	public List<Notificacion> getNotificaciones() {
		return this.notificaciones;
	}
	
	/**
	 * añade una notificacion al usuario
	 * 
	 * @param contenido el contenido de la notificacion
	 * @return true si se realizo todo bien o false en caso contrario
	 */
	public boolean addNotificacion(String contenido) {
		Notificacion n;
		
		if (contenido == null)
			return false;

		n = new Notificacion(contenido);

		this.notificaciones.add(n);
		return true;

	}
	
	
	/**
	* Cierra la sesion del usuario
	* 
	* @return true si fue todo bien
	*/
	public boolean logout(){
		this.sesionIniciada=false;
		return true;
	}
	/**
	*	obtiene la sesion iniciada del usuario
	*
	*	@return la sesion iniciada
	*/
	public boolean getLogin(){
		return this.sesionIniciada;
	}
	
	//Usado para los test
	
	/**
	 * Obtiene una notificacion en especifico dentro del array de notificaciones
	 * 
	 * @param i indice de la notificacion
	 * @return notificacion
	 */
	public Notificacion getXNotificacion(int i){
		return this.notificaciones.get(i);
	}
	
	public void setSesionIniciado(boolean valor){
		this.sesionIniciada=valor;
	}
	/**
	 * Usado para identificiaar si un usuario es administrador
	 * @return true si lo es, false si no
	 */
	public abstract boolean isAdministrador();
	/**
	 * Usado para identificiaar si un usuario es monitor
	 * @return true si lo es, false si no
	 */
	public abstract boolean isMonitor();
	/**
	 * Usado para identificiaar si un usuario es cliente
	 * @return true si lo es, false si no
	 */
	public abstract boolean isCliente();
}