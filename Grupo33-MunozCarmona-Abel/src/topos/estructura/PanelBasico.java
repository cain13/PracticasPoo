package topos.estructura;
/**
 * El escenario definen una cuadrícula donde cada seccion representa un panel 
 * que oculta el contenido de esa sección del escenario. 
 * El jugador podrá disparar contra un panel para hacerlo caer y ver el contenido
 * que tiene detrás. 
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class PanelBasico implements Cloneable{
	

	// Propiedades implementadas en la Sesion 2
	private Posicion posicion;
	private boolean visible;
	
	// Propiedades implementadas Sesion 5
	private static final long RESTAURA_VISIBILIDAD = 5000;
	// Atributo de implementacion
	public long tiempoGolpeo; 
	
	// Implementado en la Sesion 2
	/**
	 * Constructor que establece los valores iniciales que representan las coordenadas
	 * del panel en la cuadrícula y el valor inicial de la visibilidad. 
	 * @param x valor inicial de la coordenada x.
	 * @param y valor inicial de la coordenada y.
	 * @param visible valor inicial de la visibilidad del panel.
	 */
	public PanelBasico(int x, int y, boolean visible){
		this.posicion = new Posicion(x,y);
		this.visible = visible;
		this.tiempoGolpeo = 0;
	}
	/**
	 * Constructor que establece los valores iniciales que representan las coordenadas
	 * del panel en la cuadrícula y el valor inicial de la visibilidad. 
	 * @see topos.estructura.PanelBasico#PanelBasico(int, int, boolean)
	 * @param x valor inicial de la coordenada x.
	 * @param y valor inicial de la coordenada y.
	 */
	public PanelBasico(int x, int y){
		this(x,y,true);
	}
	
	/**
	 * Método que retorna la visibilidad del panel.
	 * El valor de serie se asigna en la construccion del objeto.
	 * @return visible, visibilidad del panel, valor booleano.
	 */
	public boolean esVisible(){
		return visible;
	}
	
	/**
	 * Método que golpear un panel cambia la visibilidad de dicho panel,
	 * si la visibilidad del panel es visible y crea una marca de tiempo 
	 * durante con la que se controla cada cuantos segundo vuelve a estar visible el panel.
	 * 
	 */
	public void golpear(){
		if(this.esVisible()){
			this.visible = false;
			// Implementado en la Sesion 5
			this.tiempoGolpeo = System.currentTimeMillis();
		}
	}
	
	/**
	 * Método que devuelve la copia de la posición en la que se encuentra el panel
	 * al que hace referencia la consulta.
	 * @return Posicion, devuelve una copia de una posición.
	 */
	public Posicion getPosicionPanel(){
		return new Posicion(this.posicion);
	}
	
	/**
	 * Método que modifica la posición de un panel colocandolo en otra posicion
	 * que se le pasa por parametro.
	 * @param posicion, valor de la nueva posición.
	 */
	public void setPosicionPanel(Posicion posicion){
		this.posicion = new Posicion(posicion);
	}
	
	// Fin de la implementacion Sesion 2
	
	// Implementacion Sesion 5
	/**
	 * Método que actualiza el tiempo que falta para restaurar la visibilidad de un panel
	 * que a sido golpeado y pasado el tiempo vuelve el panel visible.
	 */
	public void actualizar(){
		long ahora = System.currentTimeMillis();
		if(ahora - this.tiempoGolpeo > RESTAURA_VISIBILIDAD){
			setVisible();
		}
	}
		
	/**
	 * Método que devuelve la ruta a la imagen del panel.
	 * @return String que indica la ruta a la imagen.
	 */
	public String getImagenPanel(){
		return "imagenes/panel-basico.gif";
	}
	// Fin de la implementacion Sesion 5
	
	/**
	 * Método usado por los paneles hijos que heredan de esta clase para 
	 * cambiar la visibilidad del panel.
	 */
	protected void setVisible(){
		this.visible = true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((posicion == null) ? 0 : posicion.hashCode());
		result = prime * result + (visible ? 1231 : 1237);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PanelBasico))
			return false;
		PanelBasico other = (PanelBasico) obj;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		if (visible != other.visible)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [posicion=" + posicion + ", visible=" + visible
				+ "]";
	}
	
	protected PanelBasico copiaSuperficial(){
		PanelBasico copia = null;
		
		try {
			copia = (PanelBasico)super.clone();
		} catch (CloneNotSupportedException e) {
	
			System.err.println("La clase no es Cloneable");
		}
		
		return copia;
	}
	
	public PanelBasico clone() {
		PanelBasico copia = copiaSuperficial();
		
		//Adaptaciones solucionar aliasing
		
		copia.posicion = this.posicion.clone();
		
		return copia;
	}
}
