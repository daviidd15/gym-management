package main;

import gimnasio.*;
import java.time.*;
import java.io.*;

import usuarios.*;
import tarifas.*;

/**
 * 
 * @author Alvaro Casasus, David Palomares y Laura de la Cruz
 *
 */
public class TesterMain2 {

	/**
	 * Main que ha de ejecutarse después del main1 porque este se crea a partir de la copia creada del otro.
	 * @param args argumentos del main
	 */
	public static void main(String args[]) {
	File directory = new File("./copias/copia_" + LocalDate.now());
	File file = new File(directory, "copia_" + LocalDate.now()+".txt");
	try {
		Gimnasio.getGimnasio().lecturaGimnasio(file);
	}catch(IOException ios){
		System.out.println("Error en la lectura de la copia de seguridad");
		
	}
		
		Monitor m =(Monitor)Gimnasio.getGimnasio().getUsuarioByUser("juan_gonzalez");
		
		
		for(Tarifa t: Gimnasio.getGimnasio().getTarifasPlanas()) {
			System.out.println(t.getNombre());
		}
		}
}
