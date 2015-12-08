package topos.pruebas;

import java.util.HashSet;
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
		
		Posicion pos1 = new Posicion(0,0);
		Posicion pos2 = new Posicion(1,2);
		Posicion pos3 = new Posicion(0,0);
		
		 
		HashSet<Posicion> posicion = new HashSet<Posicion>();
		
		posicion.add(pos1);
		posicion.add(pos2);
		posicion.add(pos3);
		
		System.out.println("hay "+posicion.size()+" objetos posicion");
		
		for(Posicion pos: posicion)
			System.out.println("objeto posicion "+pos.toString());
		
		
	}

}
