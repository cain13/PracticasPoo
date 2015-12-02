package topos.elementos;

import topos.estructura.Escenario;
import topos.estructura.Posicion;
import topos.juego.GestionJuego;

public abstract class Elemento{

	protected Posicion posicion;
	protected Escenario escenario;
	
	public Elemento (int x, int y){
		this.posicion = new Posicion(x,y);
		this.escenario = null;
	}
	
	public abstract void  actualizarPartida (GestionJuego partida);
	
	public abstract String getImagenElemento();
		
	public void setEscenario(Escenario escenario){
		this.escenario = escenario;
	}
	
	/**
	 * M�todo que devuelve el escenario actual al que hace referencia el elemento.
	 * @return escenario en el que esta el elemento.
	 */
	public Escenario getEscenario(){
		return this.escenario;
	}
	public Posicion getPosicion(){
		return new Posicion(posicion);
	}
}
