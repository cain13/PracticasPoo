package topos.estructura;

import java.util.Random;

/**
 * Un panel aleatorio se caracteriza por su capacidad para ignorar golpes, este comportamiento lo
 * realiza de forma aleatoria con una probabilidad del 50%, as� pues, cuando recibe un golpe, unas
 * veces ignorar� el golpe y otras se comportar� como un panel b�sico, se entiende por ignorar un
 * golpe no hacer nada, esto es, si est� visible, seguir� visible. 
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
	 * Sobre carga de m�todo golpear que a�ade un ramdon que nos dice si el panel puede ser golpeado o no.
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
	 * Sobre carga del m�todo getImagenPanel que devuelve la ruta de la im�gen del PanelAleatorio.
	 *  @see topos.estructura.PanelBasico#getImagenPanel()
	 */
	@Override
	public String getImagenPanel(){
		return "imagenes/panel-aleatorio.png";
	}
	
	// Fin implementacion Sesion 6
	
}
