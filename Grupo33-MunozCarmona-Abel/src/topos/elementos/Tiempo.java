package topos.elementos;

import topos.juego.GestionJuego;

/**
 * Clase que extiende de ElementoPasivo.
 * La clase Tiempo aporta una cantidad de teimpo extra al juego. 
 * @author Abel Mun�oz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class Tiempo extends ElementoPasivo{

	/**
	 * Constructor que construye el elemento en las coordenadas recibidas por parametro 
	 * y la cantidad de tiempo extra que aporta al juego.
	 * @param x entero con la coordenada en el eje x.
	 * @param y entero con la coordenada en el eje y.
	 * @param puntos entero con la cantidad de tiempo extra que aporta al juego.
	 */
	public Tiempo(int x, int y,int puntos){
		super(x, y, puntos);
	}

	/**
	 * M�todo sobrecargado que a�ade la cantidad de tiempo extra que aporta el elemento al juego.
	 */
	@Override
	public void actualizarPartida(GestionJuego partida) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		partida.sumaTiempo(this.cantidad);
	}
	
	/**
	 * M�todo sobrecargado que devuelve la ruta en la que esta la imagen del elemento.
	 */
	@Override
	public String getImagenElemento() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return "imagenes/reloj.png";
	}

}
