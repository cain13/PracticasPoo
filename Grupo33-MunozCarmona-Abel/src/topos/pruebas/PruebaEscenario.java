package topos.pruebas;

import java.util.LinkedList;

import topos.elementos.Elemento;
import topos.elementos.TopoTorpe;
import topos.estructura.Direccion;
import topos.estructura.Escenario;
import topos.estructura.PanelBasico;
import topos.estructura.Posicion;

public class PruebaEscenario {

	public static void main(String[] args) {
		System.out.println("Practica POO topo - Sesion3");
		
		// Creo un escenario de 5 de ancho por 5 de alto
		Escenario escenario = new Escenario(5,5);
		
		// Creo una lista local que va a guardar los paneles del escenario
		LinkedList<PanelBasico> listaPaneles = new LinkedList<PanelBasico>();
		listaPaneles = escenario.getListaPaneles();
				
		// Muestro las propiedades del escenario: anchura, altura, y la lista de paneles y posicion de los paneles.
		System.out.printf("Medidas del escenario: anchura %d, altura %d\n",
				escenario.getAncho(),escenario.getAlto());
		// Variable local para que nombre el numero de panel que es
		int numPanel = 0; //NOTA: Es solo por legibilidad al mostrar la lista
		for(PanelBasico pb : listaPaneles){
			System.out.printf("Panel-%d Posicion (%d,%d)\n",numPanel,pb.getPosicionPanel().getX(),
					pb.getPosicionPanel().getY());
			numPanel++;
		}
		
		// Muestro por consola el resultado de comprobar si la posicion (1,2) esta dentro del escenario
		System.out.println("la posicion (1,2) esta dentro del escenario? "
				+escenario.estaDentro(new Posicion(1,2)));
		
		// Muestro por consola el resultado de comprobar si la posicion (5,1) esta dentro del escenario
		System.out.println("la posicion (5,1) esta dentro del escenario? "
				+escenario.estaDentro(new Posicion(5,1)));
		
		// Creo un panel en la posicion 2,3 y lo añado al escenario
		PanelBasico panel1 = new PanelBasico(2,3,false);
		escenario.setPanel(panel1);
		
		// Muesto por pantalla si son iguales el panel1 y el panel añadadio en la posicion (2,3)
		System.out.println("Es igual el panel1 al panel en la posicion(2,3)? "+
				panel1.equals(escenario.getPanel(new Posicion(2,3))));
		
		// Muestro si es visible el panel en la posicion(2,3)
		System.out.println("Es visible el panel de la posicion(2,3)? "+
				escenario.getPanel(new Posicion(2,3)).esVisible());
		
		// Desplazo el objetivo a la derecha y muestro la posicion del objetivo despues de desplazarlo
		escenario.desplazarObjetivo(Direccion.DERECHA);
		System.out.printf("Posicion del objetivo es (%d,%d)\n",
				escenario.getObjetivo().getX(),escenario.getObjetivo().getY());

		// PRACTICA 4
		System.out.println("Practica POO topo - Sesion4");
		
		// Creo el topo1 en la posicion (1,2) y el topo2 en la posicion (2,3)
		Elemento topo1 = new TopoTorpe(1,2,1);
		Elemento topo2 = new TopoTorpe(2,3,1);

		// Añado los topos 1 y 2 a la lista y compruebo si alguno es rechazado
		System.out.println("Topos rechazados: "+escenario.addElementos(topo1, topo2));
		
		// Muestro el tamaño de la lista que tiene que ser igual a 2
		System.out.println("Topos en el escenario "+escenario.getElementos().size());

		// Compruebo si el topo1 es igual al topo que esta en la posicion (1,2) de la lista
		System.out.println("Son iguales el topo en la posicion (1,2) y el topo1? "+
				topo1.equals(escenario.getElemento(new Posicion(1,2))));
		
		// Creo el topo3 en la posicion (2,3)
		Elemento topo3 = new TopoTorpe(2,3,1);
		
		// Lo añado a la lista y compruebo que es rechazado
		System.out.println("Topos rechazados: "+escenario.addElementos(topo3));
		
		// Compruebo el tamaño de la lista para ver que el topo3 no a sido añadido
		System.out.println("Topos en el escenario "+escenario.getElementos().size());
		
		// Compruebo que el topo tiene escenario y que es igual al esceanrio actual
		System.out.println("El topo1 esta en el escenario " + topo1.getEscenario()+
				"\ny el escenario actual es " + escenario);
		System.out.println("Es igual el escenario de topo1 al escenario actual? "+ 
				topo1.getEscenario().equals(escenario));
	
	}

	
	
	
	
	
	
	
}
