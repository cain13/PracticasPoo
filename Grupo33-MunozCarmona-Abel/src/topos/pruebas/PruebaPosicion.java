package topos.pruebas;

import topos.estructura.Direccion;
import topos.estructura.Posicion;

public class PruebaPosicion {

	public static void main(String[] args) {
		System.out.println("Practica POO topo - Sesion1");
		
		// Creo la posicion1 y la muestro por pantalla
		Posicion posicion1 = new Posicion(1,3);
		System.out.printf("Posicion1 (%d,%d)\n",posicion1.getX(),posicion1.getY());
		
		// Creo la posicion2 y la muestro por pantalla
		Posicion posicion2 = new Posicion();
		System.out.printf("Posicion2 (%d,%d)\n",posicion2.getX(),posicion2.getY());
		
		// Creo la posicion3 y en base a la copia de la posicion1 y la muestro por pantalla
		Posicion posicion3 = new Posicion(posicion1);
		System.out.printf("Posicion3 (%d,%d)\n",posicion3.getX(),posicion3.getY());
		
		// Creo la posicion4 asignandole el objeto posicion2 y la muestro por pantalla
		Posicion posicion4 = posicion2;
		System.out.printf("Posicion4 (%d,%d)\n",posicion4.getX(),posicion4.getY());
		
		// Desplazo la posicion2 a las coordenadas (1,2) y muestro el desplazamiento por pantalla
		posicion2.desplazar(1,2);
		System.out.printf("Posicion2 desplazada a (%d,%d)\n",posicion2.getX(),posicion2.getY());
		
		// Muestro la posicion4 despues de haber desplazado la posicion2
		System.out.printf("Posicion4 (%d,%d)\n",posicion4.getX(),posicion4.getY());
		
		System.out.println("Practica POO topo - Sesion2");
		// Creo la posicion5 en las coordenadas (1,1) y lo muestro por pantalla
		Posicion posicion5 = new Posicion(1,1);
		System.out.printf("Posicion5 creada en = (%d, %d)\n", posicion5.getX(),posicion5.getY());
		
		// Desplazo la posicion5 en todas las direcciones pasando por parameto la direccion
		// Utilizando la sobrecarga del metodo desplazar
		posicion5.desplazar(Direccion.ARRIBA);
		System.out.printf("Posicion5 desaplazada ARRIBA = (%d, %d)\n", posicion5.getX(),posicion5.getY());
		posicion5.desplazar(Direccion.ABAJO);
		System.out.printf("Posicion5 desaplazada ABAJO = (%d, %d)\n", posicion5.getX(),posicion5.getY());
		posicion5.desplazar(Direccion.DERECHA);
		System.out.printf("Posicion5 desaplazada DERECHA = (%d, %d)\n", posicion5.getX(),posicion5.getY());
		posicion5.desplazar(Direccion.IZQUIERDA);
		System.out.printf("Posicion5 desaplazada IZQUIERDA = (%d, %d)\n", posicion5.getX(),posicion5.getY());
		
		// Creo la posicion6 en las coordenadas (3,3) y lo muestro por pantalla
		Posicion posicion6 = new Posicion(3,3);
		System.out.printf("Posicion6 (%d, %d)\n", posicion6.getX(),posicion6.getY());
		
		// Consutla la vecina de posicion6 en todas las direcciones pasando por parameto la direccion
		System.out.printf("Posicion6 Vecina ARRIBA (%d, %d)\n", posicion6.getVecina(Direccion.ARRIBA).getX(),
				posicion6.getVecina(Direccion.ARRIBA).getY());
		System.out.printf("Posicion6 Vecina ABAJO (%d, %d)\n", posicion6.getVecina(Direccion.ABAJO).getX(),
				posicion6.getVecina(Direccion.ABAJO).getY());
		System.out.printf("Posicion6 Vecina DERECHA (%d, %d)\n", posicion6.getVecina(Direccion.DERECHA).getX(),
				posicion6.getVecina(Direccion.DERECHA).getY());
		System.out.printf("Posicion6 Vecina IZQUIERDA (%d, %d)\n", posicion6.getVecina(Direccion.IZQUIERDA).getX(),
				posicion6.getVecina(Direccion.IZQUIERDA).getY());
		
		
	}

}
