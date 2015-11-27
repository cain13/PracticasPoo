package topos.estructura;

import java.util.Random;

// Implementado en la Sesion 2
/**
 * Define el enumerado Direccion en el paquete topos.estructura. Los valores del enumerado son
 * las posibles direcciones en las que se puede desplazar una posicion ARRIBA, DERECHA, ABAJO e IZQUIERDA. 
 *
 * @author Abel Mun�oz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public enum Direccion {
	// Declaro las posibles direcciones en las que se puede desplazar un objeto
	ARRIBA,ABAJO,DERECHA,IZQUIERDA;
	
	/**
	 * M�todo estatico que calcula una direccion aleatoria para el desplazamiento del topo. 
	 * @return direccion aleatoria.
	 */
	public static Direccion direccionAleatoria(){
		Random random = new Random();
		int dirAleatorio = random.nextInt(4); 
		
		for(Direccion direccion : Direccion.values()){
			if(dirAleatorio == direccion.ordinal())
				return direccion;
		}
		return null;
		// HAY
	}
}


