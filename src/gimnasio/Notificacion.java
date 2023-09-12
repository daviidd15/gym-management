package gimnasio;

import java.io.Serializable;

/**
 * Clase notificacion
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class Notificacion implements Serializable{
	private String contenido;

	/**
	 * Constructor de la clase
	 * 
	 * @param contenido string con el contenido de la notificacion
	 */
	public Notificacion(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * Getter
	 * 
	 * @return string con el contenido de la notificacion
	 */
	public String getContenido() {
		return this.contenido;
	}
}
