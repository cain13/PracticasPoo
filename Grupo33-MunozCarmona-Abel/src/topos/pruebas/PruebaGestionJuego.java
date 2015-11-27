package topos.pruebas;

import topos.juego.GestionJuego;

public class PruebaGestionJuego {

	public static void main(String[] args) {
		System.out.println("Practica POO topo - Sesion4");
		
		// Creo el onjeto GestionJuego con 60 segundos y 3 disparos
		GestionJuego juego  = new GestionJuego(60,3);
		
		// Arranco la partida
		juego.arrancaPartida();
		
		// Muestro por pantalla que si la partida a comenzado y la puntuacion
		System.out.println("Ha comenzado la partida? "+ juego.enJuego());
		System.out.println("Puntucion: "+ juego.getPuntos());
	
		// Disparo 4 veces y muestro como decrementan los disparos
		System.out.println("Disparos = "+ juego.getDisparosRestantes());
		juego.restaDisparo();
		System.out.println("Disparos = "+ juego.getDisparosRestantes());
		juego.restaDisparo();
		System.out.println("Disparos = "+ juego.getDisparosRestantes());
		juego.restaDisparo();
		System.out.println("Disparos = "+ juego.getDisparosRestantes());
		juego.restaDisparo();
		
		// Añado 5 puntos
		juego.sumaPuntos(5);
		
		// Hago una pausa de 4 segundos
		long fin = System.currentTimeMillis() + 4000;
		while (System.currentTimeMillis() < fin);
		
		// Muestro por pantalla los segundos restantes, si se a acabado el tiempo,
		// si continua la partida y los puntos
		System.out.println("Segundos Restantes " + juego.getSegundosRestates());
		System.out.println("Ha finalizado el tiempo? " + juego.esFinalizada());
		System.out.println("Continua la partida? " + juego.enJuego());
		System.out.println("Puntos " + juego.getPuntos());
	}

}
