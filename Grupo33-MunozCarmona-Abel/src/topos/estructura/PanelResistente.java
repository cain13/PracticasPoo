package topos.estructura;

import java.util.LinkedList;
/**
 * Un panel resistente se caracteriza por su capacidad para soportar varios golpes consecutivos
 * antes de ser derribado (quedar oculto), esta característica la proporciona su propiedad dureza,
 * que se establece en la construcción y no cambia, un panel resistente será derribado si recibe un
 * número de golpes consecutivos igual a su dureza en menos de un segundo. 
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class PanelResistente extends PanelBasico{

	// Implementada en la Sesion 6
	private static final long TIEMPO_ENTRE_GOLPES = 1000;
	private final int dureza;
	private LinkedList<Long> instantesGolpes;

	/**
	 * Constructor que crea un objeto panel resistente que hereda de panel basico,
	 * inicializando la posicion del panel, la visibilidad y la dureza del panel.
	 * @param x entero que inicia el panel en la coordenada X.
	 * @param y entero que inicia el panel en la coordenada Y.
	 * @param visible booleana que inicia la visibilidad del panel.
	 * @param dureza entero que inicia la cantidad de golpes que resiste el panel.
	 * @see topos.estructura.PanelBasico#PanelBasico(int, int, boolean)
	 */
	public PanelResistente(int x, int y, boolean visible, int dureza) {
		super (x, y, visible);
		this.dureza = dureza;
		instantesGolpes = new LinkedList<Long>();
	}
	
	/**
	 * Constructor que crea un objeto panel resistente que hereda de panel basico,
	 * inicializando la posicion del panel y la dureza del panel.
	 * @param x entero que inicia el panel en la coordenada X.
	 * @param y entero que inicia el panel en la coordenada Y.
	 * @param dureza entero que inicia la cantidad de golpes que resiste el panel.
	 * @see topos.estructura.PanelResistente#PanelResistente(int, int, boolean, int)
	 */
	public PanelResistente(int x, int y, int dureza) {
		this(x, y, true, dureza);
	}
	
	/**
	 * Sobre carga del metodo padre golpear que añade la funcionalidad de resitencia del panel, 
	 * cantidad de golpes que aguanta antes de cambiar la visibilidad.
	 * @see topos.estructura.PanelBasico#golpear()
	 */
	@Override
	public void golpear(){
		instantesGolpes.add(System.currentTimeMillis());
		
		if(instantesGolpes.size() == dureza){
			if ((instantesGolpes.getLast()-instantesGolpes.getFirst()) <= TIEMPO_ENTRE_GOLPES){
				super.golpear();
				instantesGolpes.clear();
			}else{
				instantesGolpes.removeFirst();
			}
		}
	}
	
	/**
	 * Sobre carga del método getImagenPanel para que retorne la imagen del PanelResistente.
	 * @see topos.estructura.PanelBasico#getImagenPanel()
	 */
	@Override
	public String getImagenPanel(){
		return "imagenes/panel-resistente.gif";
	}
	
	// Fin implementacion Sesion 6
}
