package topos.pruebas;

import topos.estructura.Direccion;
import topos.estructura.PanelBasico;
import topos.estructura.Posicion;

public class PruebaPanelBasico {

	public static void main(String[] args) {
		System.out.println("Practica POO topo - Sesion2");
		
		// Creo dos paneles: panel1 en la (0,0) y panel 2 en la (0,1) y visibilidad a false
		// y muestro por pantalla sus propiedades
		PanelBasico panel1 = new PanelBasico(0,0);
		PanelBasico panel2 = new PanelBasico(0,1,false);
		
		System.out.printf("Panel1 posicion (%d,%d) visibilidad %b\n",panel1.getPosicionPanel().getX(),
				panel1.getPosicionPanel().getY(),panel1.esVisible());
		System.out.printf("Panel1 posicion (%d,%d) visibilidad %b\n",panel2.getPosicionPanel().getX(),
				panel2.getPosicionPanel().getY(),panel2.esVisible());
		
		// Creo la posicion en (2,2) y situo el panel1 en la posicion, 
		// pasandole una copia de la posicion creada
		Posicion posicion = new Posicion(2,2);
		panel1.setPosicionPanel(new Posicion(posicion));
		
		// Desplazo la posicion en la direccion arriba 
		// y situo el panel2 en la posicion desplazada arriba
		posicion.desplazar(Direccion.ARRIBA);
		panel2.setPosicionPanel(new Posicion(posicion));
		
		// Compruebo que la posicion se desplazado a la poscion (2,3) 
		// y que el panel1 sigue estando en la posicion (2,2) y el panel2 esta en la (2,3) 
		System.out.printf("Posicion desplazada ARRIBA(%d,%d)\n", posicion.getX(),posicion.getY());
		System.out.printf("Posicion panel1 (%d,%d)\n", panel1.getPosicionPanel().getX(),
				panel1.getPosicionPanel().getY());
		System.out.printf("Posicion panel2 (%d,%d)\n", panel2.getPosicionPanel().getX(),
				panel2.getPosicionPanel().getY());
		
		// Situo la posicion en la posicion de panel1 (2,2) y desplazo la posicion a la derecha
		// y muestro por pantalla la posicion desplazada a la derecha y la posicion de panel1
		posicion = panel1.getPosicionPanel();
		posicion.desplazar(Direccion.DERECHA);
		System.out.printf("Posicion desplazada DERECHA(%d,%d)\n", posicion.getX(),posicion.getY());
		System.out.printf("Posicion panel1 (%d,%d)\n", panel1.getPosicionPanel().getX(),
				panel1.getPosicionPanel().getY());
		
		// Aplico la operacion golpear a los dos paneles y muestro su visivilidad
		panel1.golpear();
		panel2.golpear();
		System.out.printf("Golpeo el panel1 y su visibilidad es %b\n", panel1.esVisible());
		System.out.printf("Golpeo el panel2 y su visibilidad es %b\n", panel2.esVisible());
	}

}
