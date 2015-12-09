package topos.elementos;

import topos.estructura.Escenario;
import topos.estructura.Posicion;
import topos.juego.GestionJuego;

public abstract class Elemento implements Cloneable{

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
	 * Método que devuelve el escenario actual al que hace referencia el elemento.
	 * @return escenario en el que esta el elemento.
	 */
	

	public Escenario getEscenario() {
		// TODO Apéndice de método generado automáticamente
		return this.escenario;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((escenario == null) ? 0 : escenario.hashCode());
		result = prime * result
				+ ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Elemento))
			return false;
		Elemento otro = (Elemento) obj;
		if (escenario == null) {
			if (otro.escenario != null)
				return false;
		} else if (!escenario.equals(otro.escenario))
			return false;
		if (posicion == null) {
			if (otro.posicion != null)
				return false;
		} else if (!posicion.equals(otro.posicion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [posicion=" + posicion + "]";
	}
	
	protected Elemento copiaSuperficial(){
		Elemento copia = null;
		
		try {
			copia = (Elemento)super.clone();
		} catch (CloneNotSupportedException e) {
		
			System.err.println("La clase no es Cloneable");
		}
		
		return copia;
	}
	
	public Elemento clone() {
		Elemento copia = copiaSuperficial();
		
		//Adaptaciones solucionar aliasing
		
		copia.posicion = this.posicion.clone();
		
		return copia;
	}


	public Posicion getPosicion() {
		// TODO Apéndice de método generado automáticamente
		return new Posicion(posicion);
	}

}
