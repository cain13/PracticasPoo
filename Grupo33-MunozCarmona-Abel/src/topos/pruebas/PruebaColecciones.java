package topos.pruebas;

import java.util.HashMap;
import java.util.Map;

import topos.estructura.Posicion;

public class PruebaColecciones {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		
		/* Crear un conjunto de posiciones.
		 * Crear posiciones p1 = (0,0), p2 = (1,2) y p3 = (0,0)
		 * Añadir los objetos Posicion al conjunto.
		 * Recorre el conjunto de posiciones mostrando en la consola las propiedades de los objetos
		 * que contiene (método toString) y comprueba que no contiene objetos iguales. 
		*/
		
		// Creo 3 Posiciones 
		Posicion pos1 = new Posicion(0,0);
		Posicion pos2 = new Posicion(1,2);
		Posicion pos3 = new Posicion(0,0);
	
		// Creo el mapa y como clave le paso la posicion asi 
		// si hay un objeto posicion en la misma posicion no lo inserta en el mapa
		Map<Posicion,Posicion> posicion = new HashMap<Posicion,Posicion>();
		
		posicion.put(pos1,pos1);
		posicion.put(pos2,pos2);
		posicion.put(pos3,pos3);
		
		// Recorro el mapa mostrando todas las posiciones que se han insertado en el mapa.
		for (Map.Entry<Posicion, Posicion > posiciones : posicion.entrySet()) {
			Posicion pos = posiciones.getValue();
			System.out.println(pos.toString());
		}
			
		
		
	}

}
