package actividades;

import usuarios.*;

import java.io.Serializable;
import java.util.*;

/**
 * Clase lista de espera de las sesiones y de los planes personalizados
 * 
 * @author Alvaro Casasus, David Palomares, Laura de la Cruz
 *
 */
@SuppressWarnings("serial")
public class ListaEspera implements Serializable{
	List<Cliente> listaClientes;

	/**
	 * Constructor de la clase
	 */
	public ListaEspera() {
		listaClientes = new ArrayList<Cliente>();
	}

	/**
	 * Apunta a un cliente a la lista de espera
	 * 
	 * @param c cliente a añadir a la lista de espera
	 * @return true en caso de que el cliente se haya añadido bien a la lista de
	 *         espera o false en caso contrario
	 */
	public boolean apuntar(Cliente c) {
		if (c == null)
			return false;

		return listaClientes.add(c);
	}
	
	/**
	 * Getter
	 * 
	 * @return lista de cliente
	 */
	public List<Cliente> getListaClientes() {
		return this.listaClientes;
	}

	/**
	 * Se envia una notificacion al cliente diciendo cuando ha quedado un hueco
	 * libre
	 */
	public void notificar() {
		for (Cliente c : this.listaClientes) {
			c.addNotificacion(
					"\nHa quedado libre un espacio en la sesión o plan personalizado en el que te encuentras en lista de espera\n");
		}
	}
}
