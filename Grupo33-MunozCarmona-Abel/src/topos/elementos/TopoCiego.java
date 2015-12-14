package topos.elementos;

import topos.estructura.Direccion;
import topos.estructura.Posicion;
/**
 * Clase que extiende de TopoPadre que implementa la interfaz de control.
 * Las ToposCiegos son personajes del juego que se ocultan detrás de los paneles, 
 * un topo ciego puede moverse siempre. 
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class TopoCiego extends TopoPadre{

	private Direccion ultimaDireccion;

	/**
	 * Construcor que construye un objeto TopoCiego el cual inicializa en la posicion recibida por parametro x e y, 
	 * @param x valor entero para inicializar el topo en el valor de la coordenada x.
	 * @param y valor entero para inicializar el topo en el valor de la coordenada y.
	 * @param puntos valor entero con los puntos que aporta el elemento al juego.
	 */
	public TopoCiego(int x, int y,int puntos){
		super(x, y, puntos);
	}

	
	/**
	 * Método que comprueba si el elemento tiene un escenario asignado y si puede moverse,
	 * despues comprueba si a pasado el tiempo de espera para poder moverse y si es asi,
	 * calcula una direccion aleatoria y se desplaza. 
	 */
	@Override
	public boolean actuar(){
		if(this.getEscenario() != null && puedeMoverse()){
			if((System.currentTimeMillis() - instanteActual) > ESPERA_MOVIMIENTOS){
				Direccion direccion = calculaDireccion();
				Posicion aleatoria = this.getPosicion().getVecina(direccion);
				
				if(this.getEscenario().estaDentro(aleatoria) && !this.getEscenario().hayElemento(aleatoria)){
					this.desplazar(direccion);
					instanteActual = System.currentTimeMillis();
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * Método que devuelve la ruta en la que esta la imagen del elemento.
	 */
	@Override
	public String getImagenElemento() {
		// TODO Apéndice de método generado automáticamente
		return "imagenes/topo-ciego.png";
	}

	/**
	 * Método sobrecargado que devuelve una direccion calculada menos la ultima en la que se a desplazado.
	 */
	@Override
	public Direccion calculaDireccion() {
		Direccion direccion = Direccion.direccionAleatoria();
		while(direccion == ultimaDireccion){
			direccion = Direccion.direccionAleatoria();
		}
		ultimaDireccion = direccion;
		return direccion;
	}
	
}