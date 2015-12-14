package topos.elementos;
/**
 * Clase que extiende de ElementoPasivo e implementa la interfaz de control.
 * La clase monedas aporta una cantidad de puntos al juego. 
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class Monedas extends ElementoPasivo implements InterfazControl{

	/**
	 * Constructor que construye el elemento en las coordenadas recibidas por parametro 
	 * y la cantidad de puntos que aporta al juego.
	 * @param x entero con la coordenada en el eje x.
	 * @param y entero con la coordenada en el eje y.
	 * @param puntos entero con la cantidad de puntos que aporta al juego.
	 */
	public Monedas(int x, int y,int puntos){
		super(x, y, puntos);
	}


	/**
	 * Método sobrecargado que devuelve la ruta en la que esta la imagen del elemento.
	 */
	@Override
	public String getImagenElemento() {
		// TODO Apéndice de método generado automáticamente
		return "imagenes/monedas.png";
	}

	/**
	 * Metodo sobrecargado que devuelve los puntos que aporta el elemento al juego.
	 */
	@Override
	public int getPuntosElementos() {
		// TODO Apéndice de método generado automáticamente
		return this.cantidad;
		
	}



	
}
