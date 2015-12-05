package topos.pruebas;

import topos.estructura.PanelAleatorio;
import topos.estructura.PanelBasico;
import topos.estructura.PanelResistente;
import topos.estructura.Posicion;

public class PruebaEqualPosicion {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		Posicion posicion1 = new Posicion(2,0);
		Posicion posicion2 = new Posicion(2,0);
		Posicion posicion3 = new Posicion(2,1);
		
		PanelBasico panel1 = new PanelBasico(2,0);
		PanelAleatorio panel2 = new PanelAleatorio(2,0);
		PanelResistente panel3 = new PanelResistente(2,1,1);
		
		boolean verdad;
		verdad = posicion1.hashCode()== posicion2.hashCode();
		System.out.println("Son iguales 1 y 2? "+posicion1.equals(posicion2)+
				"\nnombre1 "+ posicion1.toString()+" nombre2 "+ posicion2.toString()+
				"\nHascode 1 y 2 "+verdad);
		verdad = posicion2.hashCode()== posicion1.hashCode();
		System.out.println("Son iguales 2 y 1? "+posicion2.equals(posicion1)+
				"\nnombre1 "+ posicion1.toString()+" nombre2 "+ posicion2.toString()+
				"\nHascode 2 y 1 "+verdad);
		verdad = posicion2.hashCode()== posicion3.hashCode();
		System.out.println("Son iguales 2 y 3? "+posicion2.equals(posicion3)+
				"\nnombre2 "+ posicion2.toString()+" nombre3 "+ posicion3.toString()+
				"\nHascode 2 y 3 "+verdad);
		verdad = posicion3.hashCode()== posicion1.hashCode();
		System.out.println("Son iguales 3 y 1? "+posicion3.equals(posicion1)+
				"\nnombre1 "+ posicion3.toString()+" nombre1 "+ posicion1.toString()+
				"\nHascode 3 y 1 "+verdad);
		
		verdad = panel1.hashCode()== panel2.hashCode();
		System.out.println("Son iguales panel 1 y 2? "+panel1.equals(panel2)+
				"\nnombre1 "+ panel1.toString()+" nombre2 "+ panel2.toString()+
				"\nHascode 1 y 2 "+verdad);
		
		verdad = panel2.hashCode()== panel1.hashCode();
		System.out.println("Son iguales panel 2 y 1? "+panel2.equals(panel1)+
				"\nnombre2 "+ panel2.toString()+" nombre1 "+ panel1.toString()+
				"\nHascode 2 y 1 "+verdad);
		verdad = panel3.hashCode()== panel1.hashCode();
		System.out.println("Son iguales panel 3 y 1? "+panel3.equals(panel1)+
				"\nnombre3 "+ panel3.toString()+" nombre1 "+ panel1.toString()+
				"\nHascode 3 y 1 "+verdad);
		
		verdad = panel1.getPosicionPanel().hashCode()== panel3.getPosicionPanel().hashCode();
		System.out.println("Son iguales panel 1 y 3? "+panel1.getPosicionPanel().equals(panel3.getPosicionPanel())+
				"\nnombre1 "+ panel1.getPosicionPanel().toString()+" nombre3 "+ panel3.getPosicionPanel().toString()+
				"\nHascode 1 y 3 "+verdad);
		
	}

}
