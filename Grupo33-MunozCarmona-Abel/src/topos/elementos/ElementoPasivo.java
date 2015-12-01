package topos.elementos;

import topos.estructura.Direccion;

public abstract class ElementoPasivo extends Elemento {

	protected final int cantidad;
	
	public ElementoPasivo(int x, int y,int cantidad) {
		// TODO Apéndice de constructor generado automáticamente
		super(x, y);
		super.escenario = null;
		this.cantidad = cantidad;
	
	}
	
	
	

}
