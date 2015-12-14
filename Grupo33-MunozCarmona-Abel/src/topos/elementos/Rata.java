package topos.elementos;

import topos.estructura.Direccion;
import topos.estructura.Posicion;
/**
 * Clase que extiende de ElementoActivo e implementa la interfaz de contro.
 * Las ratas son personajes del juego que se ocultan detrás de los paneles, 
 * si el jugador le disparar suma un punto a la puntuacion del juego. 
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class Rata extends ElementoActivo implements InterfazControl{

	/**
	 * Construcor que construye un objeto Rata el cual inicializa en la posicion recibida por parametro x e y, 
	 * @param x valor entero para inicializar el topo en el valor de la coordenada x.
	 * @param y valor entero para inicializar el topo en el valor de la coordenada y.
	 * @param puntos valor entero con los puntos que aporta el elemento al juego.
	 */
	public Rata(int x, int y,int puntos){
		super(x, y, puntos);
	}

	
	/**
	 * Método que comprueba si el elemento tiene un escenario asignado y si puede moverse,
	 * despues comprueba si a pasado el tiempo de espera para poder moverse y si es asi,
	 * comprueba de derecha, a arriba, a izquierda, a abajo si puede moverse en ese orden y se mueve en
	 * la primera direccion posible en ese orden. 
	 */
	@Override
	public boolean actuar(){
		if(this.getEscenario() != null && puedeMoverse()){
			if((System.currentTimeMillis() - instanteActual) > ESPERA_MOVIMIENTOS){
				
				for(int i = 0; i < 4; i++){
					Posicion aleatoria = null;
					switch(i){
					case 0:
						aleatoria = this.getPosicion().getVecina(Direccion.DERECHA);
						if(this.getEscenario().estaDentro(aleatoria) && !this.getEscenario().hayElemento(aleatoria)
								&& escenario.getPanel(aleatoria).esVisible()){
							this.desplazar(Direccion.DERECHA);
							instanteActual = System.currentTimeMillis();
							return true;
						}
						break;
					case 1:
						aleatoria = this.getPosicion().getVecina(Direccion.ARRIBA);
						if(this.getEscenario().estaDentro(aleatoria) && !this.getEscenario().hayElemento(aleatoria)
								&& escenario.getPanel(aleatoria).esVisible()){
							this.desplazar(Direccion.ARRIBA);
							instanteActual = System.currentTimeMillis();
							return true;
						}
						break;
					case 2:
						aleatoria = this.getPosicion().getVecina(Direccion.IZQUIERDA);
						if(this.getEscenario().estaDentro(aleatoria) && !this.getEscenario().hayElemento(aleatoria)
								&& escenario.getPanel(aleatoria).esVisible()){
							this.desplazar(Direccion.IZQUIERDA);
							instanteActual = System.currentTimeMillis();
							return true;
						}
						break;
					case 3:
						aleatoria = this.getPosicion().getVecina(Direccion.ABAJO);
						if(this.getEscenario().estaDentro(aleatoria) && !this.getEscenario().hayElemento(aleatoria)
								&& escenario.getPanel(aleatoria).esVisible()){
							this.desplazar(Direccion.ABAJO);
							instanteActual = System.currentTimeMillis();
							return true;
						}
						break;
					default:
						Direccion direccion = calculaDireccion();
						aleatoria = this.getPosicion().getVecina(direccion);
						
						if(this.getEscenario().estaDentro(aleatoria) && !this.getEscenario().hayElemento(aleatoria)){
							this.desplazar(direccion);
							instanteActual = System.currentTimeMillis();
							return true;
						}
						break;
					}
				}
			}
		}
		return false;
	}


	/**
	 * Método sobrecargado que devuelve la ruta en la que esta la imagen del topo.
	 */
	@Override
	public String getImagenElemento() {
		// TODO Apéndice de método generado automáticamente
		return "imagenes/rata.png";
	}

	/**
	 * Método sobrecargado que devuelve booleana si puede moverse el objeto.
	 */
	@Override
	public boolean puedeMoverse() {
		// TODO Apéndice de método generado automáticamente
		if(!this.getEscenario().esVisible(this.getPosicion())){
			return true;
		}
		return false;
	}

	/**
	 * Método sobrecargado que devuelve una direccion calculada.
	 */
	@Override
	public Direccion calculaDireccion() {
		Direccion direccion = Direccion.direccionAleatoria();
		
		return direccion;
	}

}
