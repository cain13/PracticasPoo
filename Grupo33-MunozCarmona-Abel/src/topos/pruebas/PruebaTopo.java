package topos.pruebas;

import topos.elementos.Topo;
import topos.estructura.Direccion;
import topos.estructura.Posicion;

public class PruebaTopo {

	public static void main(String[] args) {
		System.out.println("Practica POO topo - Sesion2");
		
		// Creo un topo en la posicion (0,0)
		Topo topo = new Topo(0,0);
		
		// Desplazo el topo a la derecha
		topo.desplazarTopo(Direccion.DERECHA);
		
		// Creo una variable de Posicion posicion1 para guardar la posicion del topo 
		// y muestro las coordenadas de posicion1
		Posicion posicion1 = new Posicion(topo.getPosicionTopo());
		System.out.printf("Posicion posicion1 (%d,%d)\n", posicion1.getX(), posicion1.getY());
		
		// Desplazo el topo hacia arriba
		topo.desplazarTopo(Direccion.ARRIBA);
		
		// Creo una variable de Posicion posicion1 para guardar la posicion del topo 
		// y muestro las coordenadas de posicion1
		Posicion posicion2 = new Posicion(topo.getPosicionTopo());
		System.out.printf("Posicion posicion2 (%d,%d)\n", posicion2.getX(), posicion2.getY());
		
		
	}

}
