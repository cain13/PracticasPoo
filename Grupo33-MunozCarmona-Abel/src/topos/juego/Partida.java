package topos.juego;

import topos.elementos.Elemento;
import topos.elementos.TopoTorpe;
import topos.estructura.Escenario;
import topos.estructura.PanelAleatorio;
import topos.estructura.PanelFlash;
import topos.estructura.PanelResistente;


public class Partida {

	public static void main(String[] args) {
		
		// Crea el objeto escenario
		Escenario escenario = new Escenario(5,5);
		
		// Añade un PanelAleatorio
		escenario.setPanel(new PanelAleatorio(2, 2));
		
		// Añade un PanelFlash
		escenario.setPanel(new PanelFlash(3, 3));
		
		// Añade un PanelResistente
		escenario.setPanel(new PanelResistente(4, 4, 3));
		
		// Añade 3 Topos al escenario
		escenario.addElementos(new TopoTorpe(1,2), new TopoTorpe(5,2), new TopoTorpe(3,4));
		
		// Inicia la partida con 60 segundos de juego y 60 disparos
		escenario.iniciarPartida(60, 60);	
	}

}
