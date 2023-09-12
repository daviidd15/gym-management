package GUI.listeners.cliente;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import actividades.*;
import java.time.*;
import gimnasio.Gimnasio;
import GUI.VentanaProyecto;
import GUI.cliente.ActividadGrupalPanel;
import GUI.cliente.RegistroPanel;

/**
* Controlador del boton para la recarga de las actividades
* @author Alvaro Casasus, David Palomares, Laura de la Cruz
*/
public class ControlRecargaActividades implements ActionListener{
	private ActividadGrupalPanel vista;
	private VentanaProyecto frame;

	/**
	* Constructor del controlador
	* @param frame del controlador
	*/
	public ControlRecargaActividades(VentanaProyecto frame) {
		this.frame = frame;
		this.vista = this.frame.getVistaActividadGrupal();
	}

	/**
	* Boton del controlador, al puslarlo se recargan las actividades
	* @param e evento
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		List<ActividadGrupal> act = new ArrayList<>();
		for(Sesion s: Gimnasio.getGimnasio().getSesiones()){
			if(s.getFecha().equals(LocalDate.of(LocalDate.now().getYear(),Integer.parseInt(vista.getMes()),Integer.parseInt(vista.getDia())))){
				if(s.getHoraInicio().equals(LocalTime.of(Integer.parseInt(vista.getHora()), Integer.parseInt(vista.getMinuto())))){
					if(s.getActividadMonitorizada().esActividadGrupal()){			
						act.add((ActividadGrupal)s.getActividadMonitorizada());
					}
				}
			}
		}
		vista.setActividadesList(act);
		
	}

}
