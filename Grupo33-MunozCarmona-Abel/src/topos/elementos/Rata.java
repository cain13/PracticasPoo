package topos.elementos;

import topos.estructura.Direccion;
import topos.estructura.Posicion;
/**
 * Los topos son los personajes del juego que se ocultan detrás de los paneles, 
 * el objetivo deljugador es disparar a los topos para eliminarlos del juego y conseguir puntos. 
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class Rata extends ElementoActivo implements InterfazControl{

	/**
	 * Construcor que construye un objeto topo el cual inicializa en la posicion recibida por parametro x e y, 
	 * con el escenario con valor nulo para despues pasarle la referencia del escenario en el que esta el topo,
	 * inicializo el instante actual en el momento del tiempo que es creado, creando una marca de tiempo.
	 * @param x valor entero para inicializar el topo en el valor de la coordenada x.
	 * @param y valor entero para inicializar el topo en el valor de la coordenada y.
	 */
	public Rata(int x, int y,int puntos){
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
	 * Método que devuelve la ruta en la que esta la imagen del topo.
	 * @return String con la ruta de la imagen del topo.
	 */
	@Override
	public String getImagenElemento() {
		// TODO Apéndice de método generado automáticamente
		return "imagenes/rata.png";
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
