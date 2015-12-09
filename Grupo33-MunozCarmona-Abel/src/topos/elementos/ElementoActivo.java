package topos.elementos;

import topos.estructura.Direccion;
import topos.juego.GestionJuego;

public abstract class ElementoActivo extends Elemento implements InterfazControl{
	
	protected static final int ESPERA_MOVIMIENTOS = 1000;
	protected long instanteActual;
	protected final int puntos;
	
	public ElementoActivo(int x, int y,int puntos) {
		// TODO Apéndice de constructor generado automáticamente
		super(x, y);
		super.escenario = null;
		this.instanteActual = System.currentTimeMillis();
		this.puntos = puntos;
	}
	
	
	public abstract boolean puedeMoverse();
	public abstract Direccion calculaDireccion();
	
	public void desplazar(Direccion direccion) {
		
		this.posicion.desplazar(direccion);
	}
	
	/**
	 * Método al cazar/golpear un topo actualiza la partida sumando un punto por atrapar un topo.
	 * @param juego referencia a GestionJuego para sumar un punto 
	 */
	@Override
	public void actualizarPartida(GestionJuego partida) {
		// TODO Apéndice de método generado automáticamente
		
		partida.calculaPuntosPendientes(this.puntos);
	}
	

	@Override
	public int getPuntosElementos() {
		// TODO Apéndice de método generado automáticamente
		return this.puntos;
	}
	
	public boolean actuar(){
		if(this.getEscenario() != null && puedeMoverse()){	
			if((System.currentTimeMillis() - this.instanteActual) > ESPERA_MOVIMIENTOS){
				calculaDireccion();
				this.desplazar(calculaDireccion());
				this.instanteActual = System.currentTimeMillis();
				return true;
				
			}
		}
		return false;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + puntos;
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
		ElementoActivo otro = (ElementoActivo) obj;
		if (puntos != otro.puntos)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return  super.toString() + " [puntos=" + puntos + "]";
	}
	

}
