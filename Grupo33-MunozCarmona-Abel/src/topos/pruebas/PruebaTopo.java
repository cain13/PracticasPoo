package topos.pruebas;

import topos.elementos.Elemento;
import topos.estructura.Direccion;
import topos.estructura.Posicion;

public class PruebaTopo {

	public static void main(String[] args) {
		System.out.println("Practica POO topo - Sesion2");
		
		// Creo un topo en la posicion (0,0)
		Elemento elemento = new Elemento(0,0);
		
		// Desplazo el topo a la derecha
		elemento.desplazarTopo(Direccion.DERECHA);
		
		// Creo una variable de Posicion posicion1 para guardar la posicion del topo 
		// y muestro las coordenadas de posicion1
		Posicion posicion1 = new Posicion(elemento.getPosicionTopo());
		System.out.printf("Posicion posicion1 (%d,%d)\n", posicion1.getX(), posicion1.getY());
		
		// Desplazo el topo hacia arriba
		elemento.desplazarTopo(Direccion.ARRIBA);
		
		// Creo una variable de Posicion posicion1 para guardar la posicion del topo 
		// y muestro las coordenadas de posicion1
		Posicion posicion2 = new Posicion(elemento.getPosicionTopo());
		System.out.printf("Posicion posicion2 (%d,%d)\n", posicion2.getX(), posicion2.getY());
		
		
	}

}
