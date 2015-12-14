package topos.elementos;

import topos.estructura.Direccion;
import topos.juego.GestionJuego;

/**
 * Clase abstracta  que extiende de Elemento y de la que van a extender los elementos activos 
 * como son los topos y la rata. Construye los elementos en una posicion del escenario, 
 * hace referencia al escenario al que pertenecen y aportan una puntuacion al juego.
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public abstract class ElementoActivo extends Elemento implements InterfazControl{
	
	protected static final int ESPERA_MOVIMIENTOS = 1000;
	protected long instanteActual;
	protected final int puntos;
	
	/**
	 * Constructor que crea los elementos activos en base a las coordenadas recibidas por parametro
	 * y la cantidad de puntos que aportan al juego.
	 * @param x	valor entero con la coordenada en el eje x.
	 * @param y valor entero con la coordenada en el eje x.
	 * @param puntos valor entero con la cantidad de puntos que aporta al juego.
	 */
	public ElementoActivo(int x, int y,int puntos) {
		// TODO Apéndice de constructor generado automáticamente
		super(x, y);
		super.escenario = null;
		this.instanteActual = System.currentTimeMillis();
		this.puntos = puntos;
	}
	
	/**
	 * Método abstracto que devuelve un valor booleano informando 
	 * si el objeto puede realizar un movimiento o no. 
	 * @return boolean que devuelve si puede o no moverse el objeto.
	 */
	public abstract boolean puedeMoverse();
	
	/**
	 * Método abstracto que devuelve la direccion calculada a la que el 
	 * objeto puede moverse. 
	 * @return Direccion, devuelve la direccion en la que el objeto puede moverse.
	 */
	public abstract Direccion calculaDireccion();
	
	/**
	 * Metodo que recibe por parametro la direccion en la que se desea desplazar el objeto.
	 * @param direccion en la que se desea desplazar el objeto.
	 */
	public void desplazar(Direccion direccion) {
		
		this.posicion.desplazar(direccion);
	}
	
	/**
	 * Método al cazar/golpear un topo actualiza la partida sumando un punto por atrapar un topo.
	 * @param juego referencia a GestionJuego para sumar un punto 
	 */
	@Override
	public void actualizarPartida(GestionJuego partida) {
		// TODO Apéndice de método generado automáticamente
		
		partida.calculaPuntosPendientes(this.puntos);
	}
	
	/**
	 * Metodo sobrecargado que devuelve la puntuacion del objeto.
	 */
	@Override
	public int getPuntosElementos() {
		// TODO Apéndice de método generado automáticamente
		return this.puntos;
	}
	
	/**
	 * valor booleano informando si el elemento puede actuar o no,
	 * lo desplaza en una direccion calculada si cumple los requisitos.
	 * @return valor booleano informando si el elemento puede actuar o no.
	 */
	public boolean actuar(){
		if(this.getEscenario() != null && puedeMoverse()){	
			if((System.currentTimeMillis() - this.instanteActual) > ESPERA_MOVIMIENTOS){
				calculaDireccion();
				this.desplazar(calculaDireccion());
				this.instanteActual = System.currentTimeMillis();
				return true;
				
			}
		}
		return false;
	}

	/**
	 * Metodo sobrecargado que calcula el hash segun los puntos que vale el elemento.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + puntos;
		return result;
	}

	/**
	 * Metodo sobrecargado que compara dos objetos segun los parametros del padre
	 * y los puntos que aporta el elemento.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElementoActivo otro = (ElementoActivo) obj;
		if (puntos != otro.puntos)
			return false;
		return true;
	}

	/**
	 * Metodo sobrecargado que calcula el nombre del objeto incrementando al que genera el padre
	 * los puntos que vale el elemento.
	 */
	@Override
	public String toString() {
		return  super.toString() + " [puntos=" + puntos + "]";
	}
	

}
