package topos.pruebas;

import topos.elementos.ElementoActivo;
import topos.elementos.TopoTorpe;
import topos.estructura.Direccion;
import topos.estructura.Posicion;

public class PruebaTopo {

	public static void main(String[] args) {
		System.out.println("Practica POO topo - Sesion2");
		
		// Creo un topo en la posicion (0,0)
		ElementoActivo elemento = new TopoTorpe(0,0,1);
		
		// Desplazo el topo a la derecha
		elemento.desplazar(Direccion.DERECHA);
		
		// Creo una variable de Posicion posicion1 para guardar la posicion del topo 
		// y muestro las coordenadas de posicion1
		Posicion posicion1 = new Posicion(elemento.getPosicion());
		System.out.printf("Posicion posicion1 (%d,%d)\n", posicion1.getX(), posicion1.getY());
		
		// Desplazo el topo hacia arriba
		elemento.desplazar(Direccion.ARRIBA);
		
		// Creo una variable de Posicion posicion1 para guardar la posicion del topo 
		// y muestro las coordenadas de posicion1
		Posicion posicion2 = new Posicion(elemento.getPosicion());
		System.out.printf("Posicion posicion2 (%d,%d)\n", posicion2.getX(), posicion2.getY());
		
		
		
	}

}
