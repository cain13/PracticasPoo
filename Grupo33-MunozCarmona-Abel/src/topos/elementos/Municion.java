package topos.elementos;

import topos.juego.GestionJuego;

/**
 * Los topos son los personajes del juego que se ocultan detr�s de los paneles, 
 * el objetivo deljugador es disparar a los topos para eliminarlos del juego y conseguir puntos. 
 * @author Abel Mun�oz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class Municion extends ElementoPasivo{

	/**
	 * Construcor que construye un objeto topo el cual inicializa en la posicion recibida por parametro x e y, 
	 * con el escenario con valor nulo para despues pasarle la referencia del escenario en el que esta el topo,
	 * inicializo el instante actual en el momento del tiempo que es creado, creando una marca de tiempo.
	 * @param x valor entero para inicializar el topo en el valor de la coordenada x.
	 * @param y valor entero para inicializar el topo en el valor de la coordenada y.
	 */
	public Municion(int x, int y,int puntos){
		super(x, y, puntos);
	}

	
	@Override
	public void actualizarPartida(GestionJuego partida) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		partida.sumaDisparos(this.cantidad);
	}
	
	
	/**
	 * M�todo que devuelve la ruta en la que esta la imagen del topo.
	 * @return String con la ruta de la imagen del topo.
	 */
	@Override
	public String getImagenElemento() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return "imagenes/municion.png";
	}
	
}
