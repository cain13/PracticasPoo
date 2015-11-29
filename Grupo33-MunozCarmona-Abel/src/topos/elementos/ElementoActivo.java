package topos.elementos;

import topos.estructura.Direccion;
import topos.estructura.Posicion;

public abstract class ElementoActivo extends Elemento{
	
	public ElementoActivo(int x, int y) {
		super(x, y);
		// TODO Apéndice de constructor generado automáticamente
	}

	public abstract void desplazar(Direccion direccion);
	
	public boolean actuar(){
		if(this.getEscenario() != null){	
			Direccion direccion = Direccion.direccionAleatoria();
			Posicion aleatoria = this.getPosicion().getVecina(direccion);
			
			if(this.getEscenario().estaDentro(aleatoria) && !this.getEscenario().hayElemento(aleatoria)){
				this.desplazar(direccion);
				return true;
			}
		}
		return false;
	}
	
}
