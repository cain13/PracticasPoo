package topos.elementos;

public abstract class ElementoPasivo extends Elemento {

	protected final int cantidad;
	
	public ElementoPasivo(int x, int y,int cantidad) {
		// TODO Ap�ndice de constructor generado autom�ticamente
		super(x, y);
		super.escenario = null;
		this.cantidad = cantidad;
	
	}
	
	
	

}
