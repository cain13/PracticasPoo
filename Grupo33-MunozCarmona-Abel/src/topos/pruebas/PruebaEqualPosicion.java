package topos.pruebas;

import topos.estructura.Posicion;

public class PruebaEqualPosicion {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Posicion posicion1 = new Posicion(2,0);
		Posicion posicion2 = new Posicion(2,0);
		Posicion posicion3 = new Posicion(2,1);
		boolean verdad;
		verdad = posicion1.hashCode()==posicion2.hashCode();
		System.out.println("Son iguales 1 y 2? "+posicion1.equals(posicion2)+
				"\nnombre1 "+ posicion1.toString()+" nombre2 "+ posicion2.toString()+
				"\nHascode 1 y 2 "+verdad);
		verdad = posicion2.hashCode()==posicion1.hashCode();
		System.out.println("Son iguales 2 y 1? "+posicion2.equals(posicion1)+
				"\nnombre1 "+ posicion1.toString()+" nombre2 "+ posicion2.toString()+
				"\nHascode 2 y 1 "+verdad);
		verdad = posicion2.hashCode()==posicion3.hashCode();
		System.out.println("Son iguales 2 y 3? "+posicion2.equals(posicion3)+
				"\nnombre2 "+ posicion2.toString()+" nombre3 "+ posicion3.toString()+
				"\nHascode 2 y 3 "+verdad);
		verdad = posicion3.hashCode()==posicion1.hashCode();
		System.out.println("Son iguales 3 y 1? "+posicion3.equals(posicion1)+
				"\nnombre1 "+ posicion3.toString()+" nombre1 "+ posicion1.toString()+
				"\nHascode 3 y 1 "+verdad);
		
	}

}
