package topos.estructura;

import java.util.Random;

/**
 * Un panel aleatorio se caracteriza por su capacidad para ignorar golpes, este comportamiento lo
 * realiza de forma aleatoria con una probabilidad del 50%, así pues, cuando recibe un golpe, unas
 * veces ignorará el golpe y otras se comportará como un panel básico, se entiende por ignorar un
 * golpe no hacer nada, esto es, si está visible, seguirá visible. 
 * @author Mendigo
 *
 */
public class PanelAleatorio extends PanelBasico{

	// Implementada en la Sesion 6
	/**
	 * Constructor que crea un panel aleatorio en las coordenadas pasadas por parametro y su visibilidad.
	 * @param x entero que inicia el panel en la coordenada X.
	 * @param y entero que inicia el panel en la coordenada Y.
	 * @param visible booleana que inicia la visibilidad del panel.
	 * @see topos.estructura.PanelBasico#PanelBasico(int, int, boolean)
	 */
	public PanelAleatorio(int x, int y, boolean visible){
		super(x,y,visible);
	}
	
	/**
	 * Constructor que crea un panel aleatorio en las coordenadas pasadas por parametro.
	 * @param x entero que inicia el panel en la coordenada X.
	 * @param y entero que inicia el panel en la coordenada Y.
	 * @see topos.estructura.PanelAleatorio#PanelAleatorio(int, int, boolean)
	 */
	public PanelAleatorio(int x, int y){
		this(x,y,true);
	}
	
	/**
	 * Sobre carga de método golpear que añade un ramdon que nos dice si el panel puede ser golpeado o no.
	 * @see topos.estructura.PanelBasico#golpear() 
	 */
	@Override
	public void golpear(){
		Random random = new Random();
		int aleatorio = random.nextInt(2);
		
		if(aleatorio == 1)
			super.golpear();
	}
	
	/**
	 * Sobre carga del método getImagenPanel que devuelve la ruta de la imágen del PanelAleatorio.
	 *  @see topos.estructura.PanelBasico#getImagenPanel()
	 */
	@Override
	public String getImagenPanel(){
		return "imagenes/panel-aleatorio.png";
	}
	
	// Fin implementacion Sesion 6
	
}
