package topos.elementos;

import topos.juego.GestionJuego;


/**
 *  Clase que extiende de ElementoPasivo.
 *  La clase municion aporta una cantidad de disparos al juego. 
 * @author Abel Mun�oz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class Municion extends ElementoPasivo{

	/**
	 * Constructor que construye el elemento en las coordenadas recibidas por parametro 
	 * y la cantidad de disparos que aporta al juego.
	 * @param x entero con la coordenada en el eje x.
	 * @param y entero con la coordenada en el eje y.
	 * @param puntos entero con la cantidad de disparos que aporta al juego.
	 */
	public Municion(int x, int y,int puntos){
		super(x, y, puntos);
	}

	/**
	 * M�todo sobrecargado que a�ade la cantidad de disparos que aporta el elemento al juego.
	 */
	@Override
	public void actualizarPartida(GestionJuego partida) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		partida.sumaDisparos(this.cantidad);
	}
	
	
	/**
	 * M�todo sobrecargado que devuelve la ruta en la que esta la imagen del elemento.
	 */
	@Override
	public String getImagenElemento() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return "imagenes/municion.png";
	}
	
}
