package topos.estructura;
/**
 * Esta clase representa una posici�n en el plano XY de n�meros enteros. 
 * @author Abel Mun�oz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 */

public class Posicion implements Cloneable{
	// Propiedades implementadas en la Sesion 1
	private int x;
	private int y;
	
	// Implementado en la Sesion 1
	/**
	 * Constructor con dos argumentos: inicializa las coordenadas del objeto posici�n a 
	 * partir de los par�metros x e y. 
	 * @param x valor inicial de x.
	 * @param y valor inicial de y.
	 */
	
	public Posicion(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor sin argumentos: inicializa la posici�n en el origen de coordenadas (0,0).
	 *  Por tanto, este constructor no tiene ning�n par�metro y establece el valor inicial
	 *  de x e y en 0.
	 *  @see topos.estructura.Posicion#Posicion(int, int)
	 */
	public Posicion(){
		this(0,0);
	}
	
	/**
	 * Constructor de copia: establece las coordenadas de la posici�n a partir de las
	 * coordenadas de otra posici�n. 
	 * @param posicion establece el valor inicial en la posicion de la copia recibida. 
	 */
	public Posicion(Posicion posicion){
		this(posicion.x, posicion.y);
	}
	
	/**
	 * M�todo que actualiza el valor de x al valor recibido por parametro.
	 * @param y establece el valor de x al pasado por parametro, 
	 * debe ser un valor entero. 
	 */
	public void setX(int x){
		this.x = x;
	}
	
	/**
	 * M�todo que actualiza el valor de y al valor recibido por parametro.
	 * @param y establece el valor de y al pasado por parametro, 
	 * debe ser un valor entero. 
	 */
	public void setY(int y){
		this.y = y;
	}
	
	/**
	 * M�todo que retorna el valor de x que tiene asignado.
	 * El valor de serie se asigna en la construccion del objeto.
	 * @return coordenada x, valor entero.
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * M�todo que retorna el valor de y que tiene asignado.
	 * El valor de serie se asigna en la construccion del objeto.
	 * @return coordenada y, valor entero.
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * M�todo que modif�ca los valores de las coordenadas x e y, en la cantidad 
	 * que se especifica como par�metro.
	 * Desplaza un incremento en x y un incremento en y. 
	 * @param x incremento/decremento de x. Debe ser un valor entero.
	 * @param y incremento/decremento de y. Debe ser un valor entero.
	 */
	public void desplazar(int x, int y){
		this.x += x;
		this.y += y;
	}
	// fin  la implementacion Sesion 1
	
	// Implementacion Sesion 2
	
	/**
	 * M�todo para desplazar la posicion en una direccion 
	 * incrementando/decrementando x o y en un desplazamiento (versi�n sobrecargada). 
	 * @see topos.estructura.Posicion#desplazar(int, int)
	 * @param direccion Enumerador con la direccion a desplazar. Debe ser un tipo de dato Direccion.
	 */
	public void desplazar(Direccion direccion){
		
		switch (direccion) {
		case ARRIBA:
			desplazar(0,1);
			break;
		case ABAJO:
			desplazar(0,-1);
			break;
		case DERECHA:
			desplazar(1,0);
			break;
		case IZQUIERDA:
			desplazar(-1,0);
			break;	
		default:
			break;
		}
	}
	// Fin implementacion Sesion 2
	
	// Implementado en la Sesion 3
	/**
	 *  M�todo que construye un nuevo objeto posici�n que sea adyacente al objeto receptor 
	 *  de la llamada en la direcci�n que se establece como par�metro.
	 * @param direccion Enumerador con la direccion a consultar, debe ser un tipo de dato Direccion.
	 * @return posicion, devuelve la  posici�n adyacente.
	 */
	public Posicion getVecina(Direccion direccion){
	
		Posicion posicion = new Posicion(this);
		posicion.desplazar(direccion);
		return posicion;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)  return true;  
		
		if (obj == null)  return false;
		
		if (this.getClass() != obj.getClass())  return false;
		
		Posicion otro = (Posicion)obj;
		
		return (this.x == otro.x && this.y == otro.y);
	}
	
	@Override
	public int hashCode() {
		int primo = 31;
		int result = 1;
		
		result = result * primo + x;
		result = result * primo + y;
		
		return result;
	}
	
	public String toString(){
		return getClass().getName() + "[x = " + x +	", y = " + y + "]";
	}

	private Posicion copiaSuperficial(){
		Posicion copia = null;
		
		try {
			
			copia = (Posicion)super.clone();
		
		} catch (CloneNotSupportedException e) {
			System.err.println("La clase no es cloneable");
		}  //hace una copia superficial del objeto receptor
		
		return copia;
	}
	
	@Override
	public Posicion clone() {
		Posicion copia = copiaSuperficial();
		return copia;
	}
	
}
