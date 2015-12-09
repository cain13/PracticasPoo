package topos.elementos;

import topos.juego.GestionJuego;

public abstract class ElementoPasivo extends Elemento {

	protected final int cantidad;
	
	public ElementoPasivo(int x, int y,int cantidad) {
		// TODO Ap�ndice de constructor generado autom�ticamente
		super(x, y);
		super.escenario = null;
		this.cantidad = cantidad;
	
	}
	
	@Override
	public void actualizarPartida(GestionJuego partida) {
		// TODO Ap�ndice de m�todo generado autom�ticamente

		partida.calculaPuntosPendientes(this.cantidad);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cantidad;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElementoPasivo otro = (ElementoPasivo) obj;
		if (cantidad != otro.cantidad)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + " [cantidad=" + cantidad + "]";
	}

}
