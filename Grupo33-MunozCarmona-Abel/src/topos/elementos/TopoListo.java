package topos.elementos;

import topos.estructura.Direccion;
import topos.estructura.Posicion;
import topos.juego.GestionJuego;
/**
 * Los topos son los personajes del juego que se ocultan detrás de los paneles, 
 * el objetivo deljugador es disparar a los topos para eliminarlos del juego y conseguir puntos. 
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class TopoListo extends ElementoActivo{

	/**
	 * Construcor que construye un objeto topo el cual inicializa en la posicion recibida por parametro x e y, 
	 * con el escenario con valor nulo para despues pasarle la referencia del escenario en el que esta el topo,
	 * inicializo el instante actual en el momento del tiempo que es creado, creando una marca de tiempo.
	 * @param x valor entero para inicializar el topo en el valor de la coordenada x.
	 * @param y valor entero para inicializar el topo en el valor de la coordenada y.
	 */
	public TopoListo(int x, int y,int puntos){
		super(x, y, puntos);
	}

	
	/**
	 * Método que comprueba si el topo tiene un escenario asignado y si en la posicion del topo el panel que hay es visible,
	 * despues comprueba si a pasado el tiempo de espera para poder moverse y si es asi crea una direccion aleatoria y
	 * comprueba si hay si puede desplazarse a esa direccion y si no hay un topo en esa direccion, 
	 * lo desplaza en la direccion aleatoria y actualiza el instanteActual al tiempo en el que se desplaza. 
	 * @return 
	 */
	@Override
	public boolean actuar(){
		if(this.getEscenario() != null && puedeMoverse()){
			if((System.currentTimeMillis() - instanteActual) > ESPERA_MOVIMIENTOS){
				Direccion direccion = calculaDireccion();
				Posicion aleatoria = this.getPosicion().getVecina(direccion);
				
				if(this.getEscenario().estaDentro(aleatoria) && !this.getEscenario().hayElemento(aleatoria)
						&& escenario.getPanel(aleatoria).esVisible()){
					this.desplazar(direccion);
					instanteActual = System.currentTimeMillis();
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
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
		partida.sumaPuntos(this.puntos);
	}
	/**
	 * Método que devuelve la ruta en la que esta la imagen del topo.
	 * @return String con la ruta de la imagen del topo.
	 */
	@Override
	public String getImagenElemento() {
		// TODO Apéndice de método generado automáticamente
		return "imagenes/topo-listo.png";
	}


	@Override
	public boolean puedeMoverse() {
		// TODO Apéndice de método generado automáticamente
		if(!this.getEscenario().esVisible(this.getPosicion())){
			return true;
		}
		return false;
	}


	@Override
	public Direccion calculaDireccion() {
		Direccion direccion = Direccion.direccionAleatoria();
		
		return direccion;
	}


	
}
