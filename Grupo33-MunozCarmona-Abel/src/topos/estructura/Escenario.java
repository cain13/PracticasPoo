package topos.estructura;

import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import topos.elementos.Elemento;
import topos.elementos.ElementoActivo;
import topos.elementos.InterfazControl;
import topos.elementos.Monedas;
import topos.elementos.Municion;
import topos.elementos.Rata;
import topos.elementos.Tiempo;
import topos.elementos.TopoCiego;
import topos.elementos.TopoListo;
import topos.elementos.TopoTorpe;
import topos.juego.GestionJuego;
import topos.vista1.Alarma;
import topos.vista1.Pantalla;
/**
 * El escenario del juego organiza el espacio en secciones definiendo una cuadrícula,
 * cada sección se identifica por la posición de la cuadrícula que ocupa,
 * la sección situada en la esquina inferior izquierda ocupa la posición (0, 0) del escenario,
 * todas las secciones tienen el mismo tamaño y tiene asociado un panel,
 * el jugador utiliza un arma para disparar contra los paneles y los elementos del escenario,
 * el objetivo del arma está situado en alguna de las secciones del escenario.
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class Escenario {
	
	// Propiedades implementadas en la Sesion 3
	private final int ancho;
	private final int alto;
	private PanelBasico[][] paneles;
	private Posicion objetivo;

	// Propiedades implementadas en la Sesion 4
	private Map<Posicion,Elemento> elementos;
	
	// Propiedades implementadas en la Sesion 5
	private static final int TIEMPO_PAUSA = 200;
	private static final Color COLOR_FONDO = Color.GREEN;
	private static final int ANCHO_LADO = 50;
	private GestionJuego partida;
	private Pantalla pantalla; 
	
	// Propiedades implementadas "EXTRA"
	private int cantidaTopos; 
	/**
	 * Constructor que construye estableciendo las dimensiones: ancho y alto,
	 * en el proceso de construcción se inicializa la tabla que almacena los paneles, 
	 * se crearán tantos paneles visibles como secciones tenga la cuadrícula del escenario 
	 * y se situarán adecuadamente en la tabla, se fijará el objetivo en la posición (0, 0). 
	 * El ancho y el alto toman los valores recividos por parametro y no se pueden modificar, son constantes,
	 * tabla de paneles bidimensional que guarda en cada posicion un panel basico,
	 * el valor inicial de objetivo es (0,0),
	 * los valores iniciales de pantalla y partida son nulos.
	 * @param ancho valor entero para establecer el ancho del escenario.
	 * @param alto valor entero para establecer el alto del escenario.
	 */
	public Escenario(int ancho, int alto){
		if (ancho < 1)
			throw new IllegalArgumentException("ancho debe ser un valor mayor que 0");
		 if (alto < 1)
			throw new IllegalArgumentException("alto debe ser un valor mayor que 0"); 
		 
		this.ancho = ancho;
		this.alto = alto;
		paneles = new PanelBasico[ancho][alto];
		this.objetivo = new Posicion();
		this.elementos = new HashMap<Posicion,Elemento>();
		this.partida = null;
		this.pantalla = null;
		this.cantidaTopos = 0;
		for(int y = 0; y < alto; y++){
			for(int x = 0; x < ancho; x++){
				paneles[x][y] = new PanelBasico(x,y);
			}
		}
	}
	
	/**
	 * Método de consulta que devuelve una lista de tipo PanelBasico con todos los paneles que
	 * componen el escenario.
	 * @return lista de tipo PanelBasico.
	 */
	public LinkedList<PanelBasico> getListaPaneles(){
		LinkedList<PanelBasico> lista = new LinkedList<PanelBasico>();
	
		for(int y = 0; y < alto; y++){
			for(int x = 0; x < ancho; x++){
				lista.add(paneles[x][y]);
			}
		}	
		return lista;
	}
	
	/**
	 * Método de consulta que dada una posicion pasada por parametro devuelve el panel situado en esa posicion.
	 * @param posicion del panel que se quiere obtener.
	 * @return PanelBasico, devuelve el panel en esa posicion.
	 */
	public PanelBasico getPanel(Posicion posicion){
		// Compruebo que la posicion este dentro del escenario
		
		if(estaDentro(posicion)){
			Posicion copia = posicion.clone();
			return paneles[copia.getX()][copia.getY()];
		}
		return null;
	}
	
	/**
	 * Método que inserta/sustituye un panel recibido por parametro en su posicion dentro del escenario.
	 * @param panel para insertar en la tabla.
	 */
	public void setPanel(PanelBasico panel){
		// Compruebo que el panel este dentro del escenario antes de añadirlo
		if(estaDentro(panel.getPosicionPanel())) {
			PanelBasico copiaPanel = panel.clone();
			paneles[panel.getPosicionPanel().getX()][panel.getPosicionPanel().getY()] = copiaPanel;
		}
	}
	
	/**
	 * Método que dada una posicion por parametro comprueba la visibilidad del panel en esa posicion.
	 * @param posicion del panel a consultar.
	 * @return boolean que devuelve la visibilidad del panel.
	 */
	public boolean esVisible(Posicion posicion){
		// Compruebo que la posicion este dentro del escenario
		if(estaDentro(posicion))
			return !paneles[posicion.getX()][posicion.getY()].esVisible();
		return false;
	}
	
	/**
	 * Método que comprueba si una posicion dada por parametro se encuentra dentro de los limites del escenario.
	 * @param posicion a consultar si esta dentro del escenario.
	 * @return boolean que devuelve si esta o no dentro del escenario.
	 */
	public boolean estaDentro(Posicion posicion){

		if(posicion.getX() >= 0 && posicion.getX() < ancho){
			if(posicion.getY() >= 0 && posicion.getY() < alto){
				return true;
			}
		}
		return false;
	}

	/**
	 * Método para desplazar el objetivo a un dirección pasada por parametro, comprueba si la posición pasada por 
	 * parametro es una posición valida, si es valida desplaza el objetivo a esa posición.
	 * @param direccion a la que se desea desplazar el objetivo.
	 * @return boolean que devuelve si la direccion es valida.
	 */
	public boolean desplazarObjetivo(Direccion direccion){
		if(estaDentro(objetivo.getVecina(direccion))){
			this.objetivo.desplazar(direccion);
			return true;
		}
		return false;
	}
	
	/**
	 * Método de consulta para consultar la posición del objetivo.
	 * @return posicion, devuelve la posición del objetivo.
	 */
	public Posicion getObjetivo(){
		return new Posicion(objetivo);
	}
	
	/**
	 * Método de consulta para consultar el alto del escenario.
	 * @return entero con el valor del alto del escenario.
	 */
	public int getAlto(){
		return this.alto;
	}
	
	/**
	 * Método de consulta para consultar el ancho del escenario.
	 * @return entero con el valor del ancho del escenario.
	 */
	public int getAncho(){
		return this.ancho;
	}
	// Fin implementacion Sesion 3
	
	// Implementacion Sesion 4
	/**
	 * Metodo que añade los topos pasados por parametro dinamico, comprueba no haya ninguno topo en la posicion
	 * del topo a insertar y que la posición del topo esta dentro del escenario en ese caso lo añade a la lista topos, 
	 * en caso contrario lo inserta en una lista con los topos rechazados y devuelve la lista de topos rechazados. 
	 * @param topos los topos que se quieren insertar en el ecenario.
	 * @return devuelve la lista de topos rechazados.
	 */
	public Collection<Elemento> addElementos(Elemento... elementos){
		LinkedList<Elemento> elementosRechazados = new LinkedList<Elemento>();
		
		for(Elemento elemento : elementos){
			if(!hayElemento(elemento.getPosicion())){
				elemento.setEscenario(this);
				// Compruebo que el topo este dentro del escenario antes de insertarlo
				if(estaDentro(elemento.getPosicion()))
					this.elementos.put(elemento.getPosicion(), elemento);
			}else{
				elementosRechazados.add(elemento);
			}	
		}
		return elementosRechazados;
	}
	
	/**
	 * Método de consulta que consulta la posición de un topo pasado por parametro.
	 * @param posicion la cual queremos comprobar si hay topo.
	 * @return devuelve el objeto topo que se encuentra en esa posción o nulo si no hay topo.
	 */
	public Elemento getElemento(Posicion posicion){
		return elementos.get(posicion);

	}
	
	/**
	 * Método de consulta para consultar si hay un topo en una posición pasada por parametro.
	 * @param posicion la cual queremos comprobar si hay topo. 
	 * @return boolean que devulve si hay o no topo en esa posición.
	 */
	public boolean hayElemento(Posicion posicion){
		if(getElemento(posicion) != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Método que devuelve una copia de la lista de topos que en el escenario.
	 * @return devuelve una copia de la lista de topos que hay en el escenario
	 */
	public Collection<Elemento> getElementos(){
		
		return this.elementos.values();
				
	}
	// Fin implementacion Sesion 4
	
	// Implementacion Sesion 5
	/**
	 * Método que hace referencia al objeto gestion de juego encargado de la partida.
	 * @return devuelve el objeto Gestion de Juego actual.
	 */
	public GestionJuego getPartida(){
		return this.partida;
	}
	
	/**
	 * Método para inicializar la partida que recibe como parametros el tiempo de duración de la partida y la cantidad 
	 * de disparos posibles por el jugador, crea la ventana de juego y se encarga del estado del juego.
	 * @param segundos entero con la duración de la partida.
	 * @param disparos entero con la cantidad de disparos posibles.
	 */
	public void iniciarPartida(int segundos, int disparos){
		
		int puntosEnJuego = getElementosPuntables(getElementos());
		partida = new GestionJuego(segundos, disparos,puntosEnJuego);
		partida.arrancaPartida();
		partida.setEscenario(this);
		pantalla = new Pantalla(this.ancho, this.alto,ANCHO_LADO,COLOR_FONDO);
	
		this.refrescarPantalla();
		
		while(partida.enJuego()){
			
			if(pantalla.hayTecla()){
				String tecla = pantalla.leerTecla();
				switch (tecla) {
				case "i":
					desplazarObjetivo(Direccion.ARRIBA);
					break;
				case "k":
					desplazarObjetivo(Direccion.ABAJO);
					break;
				case "j":
					desplazarObjetivo(Direccion.IZQUIERDA);
					break;
				case "l":
					desplazarObjetivo(Direccion.DERECHA);
					break;
				case "d":
					this.disparo();
					break;

				default:
					break;
				}
			}
			
			this.actualiza();
		
			this.refrescarPantalla();
			Alarma.dormir(TIEMPO_PAUSA);
		}
		this.pantalla.setBarraEstado(partida.getTextoEstadoPartido());
		
	}
	
	/**
	 * Método encargado de actualizar tanto los paneles que forman el escenario, 
	 * como el estado de los topos en la partida.
	 */
	public void actualiza(){
		for(int y = 0; y < alto; y++){
			for(int x = 0; x < ancho; x++){
				paneles[x][y].actualizar();
			}
		}
		
		LinkedList<Elemento> copia = new LinkedList<Elemento>(getElementos());
		
		for(Elemento elemento : copia){
			if(elemento instanceof ElementoActivo){
				ElementoActivo activo = (ElementoActivo)elemento;
				Posicion posOld = activo.getPosicion();
				activo.actuar();
				Posicion posNueva = activo.getPosicion();
				
				if(!posOld.equals(posNueva)){
						
					elementos.remove(posOld);
					elementos.put(posNueva, elemento);
					
				}
			}
		}
	}

	/**
	 * Método para disparar sobre los objetos del juego, solo se puede disparar sobre los paneles visibles o 
	 * sobre los topos que hay en el escenario.
	 */
	public void disparo(){
		
		if(partida.enJuego()){
			if(!this.esVisible(new Posicion(this.objetivo))){
				this.partida.restaDisparo(); // Resto un disparo
				this.getPanel(new Posicion(this.objetivo)).golpear();
			}else{
				if(this.hayElemento(new Posicion(this.objetivo))){
					System.out.println("AQUI SI");
					// Variable local para guardar la referencia al topo.
					Elemento elementoAuxiliar = this.getElemento(this.objetivo);
					this.partida.restaDisparo(); // Resto un disparo
				
					elementoAuxiliar.actualizarPartida(this.partida);
					elementoAuxiliar.setEscenario(null);
					if(elementos.containsKey(elementoAuxiliar.getPosicion()))
						elementos.remove(elementoAuxiliar.getPosicion());
					
				}
			}
		}
	}
	
	/**
	 * Método que refresca la pantalla, primero resetear las imagenes que hay en pantalla y 
	 * despues actualiza las imagenes y vuelve a dibujarlas.
	 */
	public void refrescarPantalla(){
		pantalla.resetear();
		
		for(int y = 0; y < alto; y++){
			for(int x = 0; x < ancho; x++){
				if(paneles[x][y].esVisible()){
					pantalla.addImagen(x, y, paneles[x][y].getImagenPanel());
				}
			}
		}
		for (Map.Entry<Posicion, Elemento> elemento : elementos.entrySet()) {
			Elemento elemento1 = elemento.getValue();
			if(esVisible(elemento.getKey())){
				pantalla.addImagen(elemento1.getPosicion().getX(), elemento1.getPosicion().getY(),
						elemento1.getImagenElemento());
			}
		}

		pantalla.addImagen(this.objetivo.getX(), this.objetivo.getY(), "imagenes/objetivo.png");

		pantalla.setBarraEstado("Time: " + partida.getSegundosRestates() + 
				" Bullets: " + partida.getDisparosRestantes() + " Score: " + partida.getPuntosPendientes() +
				"/"+ partida.getPuntosTotales());
		pantalla.dibujar();
	}
	// Fin implementacion Sesion 5	
	
	// Implementacion "EXTRA" 
	/**
	 * Metodo que crea una ventana con el menu del juego mostrando el titulo del juego y esperando que pulses
	 * cualquier tecla para comenzar la partida.
	 * @param segundos entero con la cantidad de segundos que quieres que dure la partida.
	 * @param disparos entero con la cantidad de disparos que quieres que tenga la partida.
	 */
	public void menuInicio(int segundos, int disparos){
		pantalla = new Pantalla(1, 1,250,Color.black);
		pantalla.addImagen(0,0, "imagenes/splash.png");
		while(!pantalla.hayTecla()){
			
			pantalla.setBarraEstado("By: Abel Muñoz y Enrique Raja");
			pantalla.dibujar();
		}
		panelesAleatorios();
		ElementosActivosAleatorios();
		ElementosPasivosAleatorios();
		this.iniciarPartida(segundos,disparos);
		
	}
	
	/**
	 * Método que añade un numero de topos segun el ancho del escenario y 
	 * los posiciona aleatoriamente en el escenario, 
	 */
	private void ElementosActivosAleatorios(){
		Random random = new Random();
		int x = random.nextInt(ancho-1);
		int y = random.nextInt(alto-1);
		Elemento elemento = null;
		for(int i = 0; i < ancho; i++){
			while(hayElemento(new Posicion(x,y))){
				x = random.nextInt(ancho-1);
				y = random.nextInt(alto-1);
			}
			switch(i%4){
				case 0:
					elemento = new TopoTorpe(x,y,1);
					addElementos(elemento);
					break;
				case 1:
					elemento = new TopoCiego(x,y,2);
					addElementos(elemento);
					break;
				case 2:
					elemento = new TopoListo(x,y,3);
					addElementos(elemento);
					break;
				case 3:
					elemento = new Rata(x,y,-1);
					addElementos(elemento);
					break;
				
				default:
					elemento = new TopoCiego(x,y,2);
					addElementos(elemento);		
				break;
			}
		}
	}
	private void ElementosPasivosAleatorios(){
		Random random = new Random();
		int x = random.nextInt(ancho-1);
		int y = random.nextInt(alto-1);
		Elemento elemento = null;
		for(int i = 0; i < ancho; i++){
			while(hayElemento(new Posicion(x,y))){
				x = random.nextInt(ancho-1);
				y = random.nextInt(alto-1);
			}
			switch(i%3){
		
				case 0:
					elemento= new Monedas(x,y,5);
					addElementos(elemento);
					break;
				case 1:
					elemento= new Municion(x,y,5);
					addElementos(elemento);
					break;
				case 2:
					elemento= new Tiempo(x,y,5);
					addElementos(elemento);
					break;
				default:
					elemento = new Monedas(x,y,5);
					addElementos(elemento);		
				break;
			}
		}
	}
	/**
	 * Método que coloca en las tres primeras columnas un tipo distinto de panel heredado de panel basico y
	 * el resto de columnas asta completar el ancho coloca un tipo de panel heredad aleatoriamente.
	 */
	private void panelesAleatorios(){
		Random random = new Random();
		int aleatorio = 0;
		int y = 0;
		for(int x = 0; x < ancho; x++){
			// Cuando la x sea mayor que 2 hago un Random aleatorio de los 3 
			// posibles Paneles: Aleatorio, Flash, Resistente. 
			// Asi me aseguro que primnero salga 1 panel de cada subclase 
			if(x > 2){
				aleatorio = random.nextInt(3);
			}else{
				aleatorio = x;
			}
			// Random aleatorio para situarlo en la columna en y
			y = random.nextInt(alto);
			switch (aleatorio) {
			case 0:
				PanelAleatorio panelAleatorio = new PanelAleatorio(x, y);
				this.setPanel(panelAleatorio);
				break;
			case 1:
				PanelFlash panelFlash = new PanelFlash(x, y);
				this.setPanel(panelFlash);
				break;
			case 2:
				PanelResistente panelResistente = new PanelResistente(x, y,3);
				this.setPanel(panelResistente);
				break;

			default:
				break;
			}
		}
	}
	
	/**
	 * Método que inserta el numero de topos que hay en el escenario, 
	 * para poder contabilizar la cantidad de topos con el que se inicializa un escenario.
	 * @param cantidadTopos valor entero con la cantidad de topos con el que se inicializa la partida. 
	 */
	public int getElementosPuntables(Collection<Elemento> collection){
		System.out.println("AQui");
		int puntosTotales = 0;
		for (Map.Entry<Posicion, Elemento > elemento : elementos.entrySet()) {
			Elemento elemento1 = elemento.getValue();
			if(elemento1 instanceof InterfazControl ){
				if(!(elemento1 instanceof Rata))
				puntosTotales += ((InterfazControl) elemento1).getPuntosElementos();
			}
		}
		/*
		for(Elemento elemento : collection){
			if(elemento instanceof InterfazControl ){
				if(!(elemento instanceof Rata))
				puntosTotales += ((InterfazControl) elemento).getPuntosElementos();
			}
		}*/
		return puntosTotales;
	}
	
	/**
	 * Método de consulta que me devuelve la cantidad de topos que quedan en el escenario.
	 * @return
	 */
	public int getCantidadTopos(){
		return this.cantidaTopos;
	}
	// Fin mplementacion "EXTRA" 
}
