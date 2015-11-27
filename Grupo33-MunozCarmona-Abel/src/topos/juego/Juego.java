package topos.juego;

import topos.estructura.Escenario;

public class Juego {

	public static void main(String[] args) {
	
		// Clase Extra que muestra los metodos extras aleatorios
		
		// Crea el objeto escenario
		Escenario escenario = new Escenario(5,5);
		
	   /* Los topos y los sub Paneles se agregan aleatoriamente con 2 metodos extra implementados.
		* El metodo extra llamado toposAleatorios implementa la misma cantidad de topos 
		* que ancho tiene el escenario y el metodo extra llamado panelesAleatorios inserta
		* primeramente un sub Panel de cada clase en las 3 primeras columnas y despues inserta un
		* un sub Panel aleatoriamente en las siguientes columnas. 
		* Ambos metodos son llamados en el metodo menuInicio.
		*/
		
		
		// Es un metodo extra que muestra una ventana de menu y tras pulsar una tecla
		//comienza el juego llamando a inicioPartida y pasandole 60 segundos y 60 disparos
		escenario.menuInicio(60,60);
	}
}
