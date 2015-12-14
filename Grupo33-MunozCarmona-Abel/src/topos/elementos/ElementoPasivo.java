package topos.elementos;

import topos.juego.GestionJuego;

/**
 * Clase abstracta  que extiende de Elemento y de la que van a extender los elementos pasivos 
 * como son las monedas, tiempo extra y municion. Construye los elementos en una posicion del escenario, 
 * hace referencia al escenario al que pertenecen y aportan una cantidad al juego.
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public abstract class ElementoPasivo extends Elemento {

	protected final int cantidad;
	
	/**
	 * Constructor que crea los elementos pasivos en base a las coordenadas recibidas por parametro
	 * y la cantidad que aportan al juego.
	 * @param x	valor entero con la coordenada en el eje x.
	 * @param y valor entero con la coordenada en el eje x.
	 * @param valor entero con la cantidad que aporta al juego.
	 */
	public ElementoPasivo(int x, int y,int cantidad) {
		// TODO Apéndice de constructor generado automáticamente
		super(x, y);
		if (cantidad < 0)
			throw new IllegalArgumentException("el valor de cantidad debe ser mayor o igual que 0");
		super.escenario = null;
		this.cantidad = cantidad;
	
	}
	
	/**
	 * Metodo sobrecargado con la cantidad que aporta el elemento al juego.
	 */
	@Override
	public void actualizarPartida(GestionJuego partida) {
		// TODO Apéndice de método generado automáticamente

		partida.calculaPuntosPendientes(this.cantidad);
	}
	
	/**
	 * Metodo sobrecargado que calcula el hash segun la cantidad que aporta el elemento.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cantidad;
		return result;
	}

	/**
	 * Metodo sobrecargado que compara dos objetos segun los parametros del padre
	 * y la cantidad que aporta el elemento al juego. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElementoPasivo otro = (ElementoPasivo) obj;
		if (cantidad != otro.cantidad)
			return false;
		return true;
	}
	
	/**
	 * Metodo sobrecargado que calcula el nombre del objeto incrementando al que genera el padre
	 * los puntos que vale el elemento.
	 */
	@Override
	public String toString() {
		return super.toString() + " [cantidad=" + cantidad + "]";
	}

}
