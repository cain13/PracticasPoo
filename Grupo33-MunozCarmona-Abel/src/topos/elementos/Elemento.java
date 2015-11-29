package topos.elementos;

import topos.estructura.Direccion;
import topos.estructura.Escenario;
import topos.estructura.Posicion;
import topos.juego.GestionJuego;
/**
 * Los topos son los personajes del juego que se ocultan detrás de los paneles, 
 * el objetivo deljugador es disparar a los topos para eliminarlos del juego y conseguir puntos. 
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class Elemento {
	// Propiedades implementadas en la Sesion 2
	private Posicion posicionTopo;
	
	// Propiedades implementadas en la Sesion 4
	private Escenario escenario;
	
	// Propiedades implementadas en la Sesion 5
	private static final long ESPERA_MOVIMIENTOS = 1000; 
	private long instanteActual;
	
	/**
	 * Construcor que construye un objeto topo el cual inicializa en la posicion recibida por parametro x e y, 
	 * con el escenario con valor nulo para despues pasarle la referencia del escenario en el que esta el topo,
	 * inicializo el instante actual en el momento del tiempo que es creado, creando una marca de tiempo.
	 * @param x valor entero para inicializar el topo en el valor de la coordenada x.
	 * @param y valor entero para inicializar el topo en el valor de la coordenada y.
	 */
	public Elemento(int x, int y){
		this.posicionTopo = new Posicion(x,y);
		this.escenario = null;
		this.instanteActual = System.currentTimeMillis();
	}
	
	/**
	 * Método que devuelve la copia de la posicion del topo al que hace referencia la llamada.
	 * @return Posicion, devuelve una copia de la posicion del topo.
	 */
	public Posicion getPosicionTopo(){
		return new Posicion(posicionTopo);
	}
	
	/**
	 * Método para desplazar la posicion del topo en una direccion 
	 * incrementando/decrementando x o y, en un desplazamiento . 
	 * @see topos.estructura.Posicion#desplazar(int, int)
	 * @param direccion Enumerador con la direccion a desplazar. Debe ser un tipo de dato Direccion.
	 */
	public void desplazarTopo(Direccion direccion){
		this.posicionTopo.desplazar(direccion);
	}
	// Fin implementacion Sesion 2
	
	// Implementado en la Sesion 4
	/**
	 * Método que actualiza la referencia del escenario del topo al escenario en el que se encuentra.
	 * @param escenario, escenario en el que es añadido (pertenece) el topo.
	 */
	public void setEscenario(Escenario escenario){
		this.escenario = escenario;
	}
	
	/**
	 * Método que devuelve el escenario actual al que hace referencia el topo.
	 * @return escenario en el que esta el topo.
	 */
	public Escenario getEscenario(){
		return this.escenario;
	}
	// Fin implementacion Sesion 4
	
	// Implementado en la Sesion 5
	/**
	 * Método que comprueba si el topo tiene un escenario asignado y si en la posicion del topo el panel que hay es visible,
	 * despues comprueba si a pasado el tiempo de espera para poder moverse y si es asi crea una direccion aleatoria y
	 * comprueba si hay si puede desplazarse a esa direccion y si no hay un topo en esa direccion, 
	 * lo desplaza en la direccion aleatoria y actualiza el instanteActual al tiempo en el que se desplaza. 
	 */
	public void actuar(){
		if(this.getEscenario() != null && !this.getEscenario().esVisible(this.getPosicionTopo())){
			if((System.currentTimeMillis() - instanteActual) > ESPERA_MOVIMIENTOS){
				Direccion direccion = Direccion.direccionAleatoria();
				Posicion aleatoria = this.getPosicionTopo().getVecina(direccion);
				
				if(this.getEscenario().estaDentro(aleatoria) && !this.getEscenario().hayTopo(aleatoria)
						&& escenario.getPanel(aleatoria).esVisible()){
					this.desplazarTopo(direccion);
					instanteActual = System.currentTimeMillis();
				}
			}
		}
	}
	
	/**
	 * Método al cazar/golpear un topo actualiza la partida sumando un punto por atrapar un topo.
	 * @param juego referencia a GestionJuego para sumar un punto 
	 */
	public void actualizaPartida(GestionJuego juego){
		juego.sumaPuntos(1);
	}
	
	
	
	/**
	 * Método que devuelve la ruta en la que esta la imagen del topo.
	 * @return String con la ruta de la imagen del topo.
	 */
	public String getImagenTopo(){
		return "imagenes/topo.png";
	}
	// Fin implementacion Sesion 5 
}
