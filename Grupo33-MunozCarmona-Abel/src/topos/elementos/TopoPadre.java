package topos.elementos;

import topos.estructura.Direccion;

/**
 * Clase abstracta que extiende de elementoActivo e implementa la interfaz de control de elementos puntuables.
 * Los topos son los personajes del juego que se ocultan detrás de los paneles, 
 * el objetivo deljugador es disparar a los topos para eliminarlos del juego y conseguir puntos.
 * De esta clase extienden 3 clase de topos. 
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public abstract class TopoPadre extends ElementoActivo implements InterfazControl{
	
	/**
	 * Construcor que construye un objeto Topo el cual inicializa en la posicion recibida por parametro x e y, 
	 * @param x valor entero para inicializar el topo en el valor de la coordenada x.
	 * @param y valor entero para inicializar el topo en el valor de la coordenada y.
	 * @param puntos valor entero con los puntos que aporta el elemento al juego.
	 */
	public TopoPadre(int x, int y,int puntos){
		super(x, y, puntos);
	}

	
	/**
	 * Método que comprueba si el topo tiene un escenario asignado y si en la posicion del topo el panel que hay es visible,
	 * despues comprueba si a pasado el tiempo de espera para poder moverse y si es asi crea una direccion aleatoria y
	 * comprueba si hay si puede desplazarse a esa direccion y si no hay otro elemento en esa direccion.
	 */
	@Override
	public abstract boolean actuar();
	

	/**
	 * Método sobrecargado que devuelve una booleana que comprueba si la posicion es visible.
	 */
	@Override
	public boolean puedeMoverse() {
		return true;
	}

	/**
	 * Método sobrecargado que devuelve una direccion calculada menos la ultima en la que se a desplazado.
	 */
	@Override
	public Direccion calculaDireccion() {
		Direccion direccion = Direccion.direccionAleatoria();
		
		return direccion;
	}


	
}
