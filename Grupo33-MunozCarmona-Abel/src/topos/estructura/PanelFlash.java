package topos.estructura;
/**
 * Un panel flash se caracteriza por restaurar su visibilidad (pasar de oculto a visible) la segunda vez
 * que el escenario solicita la acción actualizar, de este modo, una vez que es golpeado y pasa a
 * estar oculto, no vulve a ser visible asta que se actualiza dos veces. 
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class PanelFlash extends PanelBasico{
	
	// Atributo de implementacion
	private int numeroActualizaciones = 0;

	// Implementada en la Sesion 6
	/**
	 * Constructor que crea un panel flash en las coordenadas pasadas por parametro y su visibilidad.
	 * @param x entero que inicia el panel en la coordenada X.
	 * @param y entero que inicia el panel en la coordenada Y.
	 * @param visible booleana que inicia la visibilidad del panel.
	 * @see topos.estructura.PanelBasico#PanelBasico(int, int, boolean)
	 */
	public PanelFlash(int x, int y, boolean visible){
		super(x, y, visible);
	}
	
	/**
	 * Constructor que crea un panel flash en las coordenadas pasadas por parametro.
	 * @param x entero que inicia el panel en la coordenada X.
	 * @param y entero que inicia el panel en la coordenada Y.
	 * @see topos.estructura.PanelFlash#PanelFlash(int, int, boolean)
	 */
	public PanelFlash(int x, int y){
		this(x, y, true);
	}
	
	/**
	 * Sobre carga del metodo actualizar de la clase padre que implementa el tiempo 
	 * que tarda el panel restaura su visibilidad.
	 * @see topos.estructura.PanelBasico#actualizar()
	 */
	@Override
	public void actualizar(){

		if(numeroActualizaciones < 2){
			numeroActualizaciones++;
		}else{
			setVisible();
			numeroActualizaciones = 0;
		}
	}
	
	/**
	 * Sobre carga del método getImagenPanel que devuelve la ruta de la imágen del PanelFLash.
	 *  @see topos.estructura.PanelBasico#getImagenPanel()
	 */
	@Override
	public String getImagenPanel(){
		return "imagenes/panel-flash.gif";
	}
	// Fin implementacion Sesion 6
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numeroActualizaciones;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof PanelFlash))
			return false;
		PanelFlash otro = (PanelFlash) obj;
		if (numeroActualizaciones != otro.numeroActualizaciones)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "[numeroActualizaciones=" + numeroActualizaciones	+ "]";
	}

	//Redefinimos el método clone para aplicar la regla covariante
	//Todos los atributos son de tipo primitivo y se copian al hacer
	//la copia superficial sobre el objeto receptor de la llamada.
	public PanelFlash clone() {
		return (PanelFlash)super.clone();
	}
}
