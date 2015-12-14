package topos.elementos;

import topos.estructura.Escenario;
import topos.estructura.Posicion;
import topos.juego.GestionJuego;

/**
 * Clase abstracta padre que implementa Clonable para clonar los elementos que forman 
 * parte de la partida y de los cuales descienden dos categorias,
 * Esta clase abstracta dota de una plantilla a las clases que extienden de ella.
 * Elemtos activos como son los topos y la rata y elementos activos que aportan algo al juego,
 * como puntuacion, tiempo extra o disparos. Construye los elementos en una posicion del escenario 
 * y hace referencia al escenario al que pertenecen.
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public abstract class Elemento implements Cloneable{

	// posicion del elemento y el escenario al que va hacer referencia el elemento.
	protected Posicion posicion;
	protected Escenario escenario;
	
	/**
	 * Constructor que crea el elemento en las coordenadas recibidas por parametro,
	 * e inicia el escenario a null.
	 * @param x	valor entero con la coordenada en el eje x.
	 * @param y	valor entero con la coordenada en el eje y.
	 */
	public Elemento (int x, int y){
		if (x < 0)
			throw new IllegalArgumentException("el valor de x debe ser mayor o igual que 0");
		if (y < 0)
			throw new IllegalArgumentException("el valor de y debe ser mayor o igual que 0"); 
		
		this.posicion = new Posicion(x,y);
		this.escenario = null;
	}
	
	/**
	 * Método abstracto que actualiza para actualizar los valores de cada elemento (puntos, tiempo, disparos).
	 * @param partida referencia a gestion de juego para actualizar la partida
	 */
	public abstract void  actualizarPartida (GestionJuego partida);
	
	/**
	 * Método abstracto que devuelve la ruta de la imagen del elemento.
	 * @return String con la ruta de referencia de la imagen del elemento.
	 */
	public abstract String getImagenElemento();
		
	/**
	 * Método que recibe por parametro el escenario al que hace referencia el elemento.
	 * @return escenario al que hace referencia el elemento.
	 */
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

	
	/**
	 *  Método sobrecargado hasCode que construye el hash de identificacion del objeto 
	 *  en base al escenario y a la posicion del elemento.
	 */
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

	/**
	 *  Método sobrecargado equals que compara si dos objetos son iguales o no,
	 *  en base al escenario y a la posicion que ocupa en el, el elemento.
	 * @param Objeto a comparar con el receptor de la llamada.
	 */
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

	/**
	 *  Método de consulta que devuelve el nombre del objeto con los valores de la posicion.
	 */
	@Override
	public String toString() {
		return getClass().getName() + " [posicion=" + posicion + "]";
	}
	
	/**
	 *  Método que devuelve una copia superficial del objeto.
	 */
	protected Elemento copiaSuperficial(){
		Elemento copia = null;
		
		try {
			copia = (Elemento)super.clone();
		} catch (CloneNotSupportedException e) {
		
			System.err.println("La clase no es Cloneable");
		}
		
		return copia;
	}
	
	/**
	 *  Método que devuelve una copia profunda del objeto 
	 *  y devuelve la copia profunda del elemento.
	 */
	public Elemento clone() {
		Elemento copia = copiaSuperficial();
		
		//Adaptaciones solucionar aliasing
		
		copia.posicion = this.posicion.clone();
		
		return copia;
	}

	/**
	 * Metodo que devuelve una copia de la posicion del elemento para evitar aliasing.
	 * @return Posicion, devuelve una copia de la posicion del elemento.
	 */
	public Posicion getPosicion() {
		// TODO Apéndice de método generado automáticamente
		return new Posicion(posicion);
	}

}
