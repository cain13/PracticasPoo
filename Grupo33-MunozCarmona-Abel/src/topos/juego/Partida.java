package topos.juego;

import topos.elementos.Elemento;
import topos.elementos.Monedas;
import topos.elementos.Municion;
import topos.elementos.Tiempo;
import topos.elementos.TopoCiego;
import topos.elementos.TopoListo;
import topos.elementos.TopoTorpe;
import topos.elementos.Rata;
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
		Elemento elemento1 = new TopoTorpe(1,2,1);
		Elemento elemento2 = new TopoCiego(2,2,2);
		Elemento elemento3 = new TopoListo(3,4,3);
		Elemento elemento4 = new Rata(0,4,-1);
		Elemento elemento5 = new Monedas(1,3,5);
		Elemento elemento6 = new Tiempo(4,2,5);
		Elemento elemento7 = new Municion(2,4,5);
		
		escenario.addElementos(elemento1,elemento2,elemento3,elemento4,elemento5,elemento6,elemento7);
		
		// Inicia la partida con 60 segundos de juego y 60 disparos
		escenario.iniciarPartida(60, 60);	
	}

}
