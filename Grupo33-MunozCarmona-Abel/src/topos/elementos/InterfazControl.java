package topos.elementos;

/**
 * Clase de tipo Interfaz que van a implementar los elementos puntuables del juego
 * que contiene un metodo get para consultar la cantidad de puntos que aporta cada
 * elemento al juego.
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public interface InterfazControl {

	/**
	 * Metodo que devuelve un valor entero con la cantidad de puntos que 
	 * aporta el elemento al juego.
	 * @return valor entero que aporta el elemento al juego.
	 */
	
	public int getPuntosElementos();
}
