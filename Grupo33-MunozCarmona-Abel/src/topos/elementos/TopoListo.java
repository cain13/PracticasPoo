package topos.elementos;

import topos.estructura.Direccion;
import topos.estructura.Posicion;

/**
 * Clase que extiende de TopoPadre que implementa la interfaz de control.
 * Las TopoListo son personajes del juego que se ocultan detr�s de los paneles, 
 * un TopoListo puede moverse si la posici�n en la que se encuentra est� visible.
 * @author Abel Mun�oz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class TopoListo extends TopoPadre{

	/**
	 * Construcor que construye un objeto TopoListo el cual inicializa en la posicion recibida por parametro x e y, 
	 * @param x valor entero para inicializar el topo en el valor de la coordenada x.
	 * @param y valor entero para inicializar el topo en el valor de la coordenada y.
	 * @param puntos valor entero con los puntos que aporta el elemento al juego.
	 */
	public TopoListo(int x, int y,int puntos){
		super(x, y, puntos);
	}

	
	/**
	 * M�todo sobrecargado que comprueba si el elemento tiene un escenario asignado y si puede moverse,
	 * despues comprueba si a pasado el tiempo de espera para poder moverse y si es asi,
	 * �calcula una direcci�n de desplazamiento� evaluando la visibilidad de las posiciones
	 * vecinas de la posici�n que ocupa.
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
	
	/**
	 * M�todo que devuelve la ruta en la que esta la imagen del elemento.
	 */
	@Override
	public String getImagenElemento() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return "imagenes/topo-listo.png";
	}

	/**
	 * M�todo sobrecargado que devuelve una booleana que comprueba si la posicion es visible.
	 */
	@Override
	public boolean puedeMoverse() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		if(!this.getEscenario().esVisible(this.getPosicion())){
			return true;
		}
		return false;
	}


}
