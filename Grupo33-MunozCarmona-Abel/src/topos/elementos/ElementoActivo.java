package topos.elementos;

import topos.estructura.Direccion;

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
	

	public abstract void desplazar(Direccion direccion);
	
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
	
	public abstract boolean puedeMoverse();
	public abstract Direccion calculaDireccion();

}
