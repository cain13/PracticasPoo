package topos.juego;

import topos.estructura.Escenario;

/**Esta clase es la responsable de gestionar el estado del juego (tiempo restante, disparos pendientes, etc.) y el
 * funcionamiento de las partidas, la dinámica del juego depende necesariamente del control del tiempo, la estrategia que
 * utilizaremos para gestionar el paso del tiempo es el uso de marcas de tiempo.
 * Hemos implementado unas funcionalidades extras para gestionar el texto mostrado en la barra del juego y controlar
 * la cantidad de topos cazados.
 * @author Abel Munñoz Carmona G.3.3 y Pedro Enrique Raja Martinez G.1.1
 *
 */
public class GestionJuego {
	// Implementado en la Sesion 4
	private long segundos;
	private long inicio;
	private int puntosPendientes;
	private final int puntosTotales;

	private int disparosRestantes;
	
	// Implementacion "EXTRA"
	private Escenario escenario;
	private String textoPartida;
	
	// Implementacion Sesion 4 
	/**
	 * Contructor que crea el objeto GestionJuego que cotrolara la gestion de la partida, establece el tiempo de duracion 
	 * de la partida instroducido por parametro y el numero de disparos disponibles para el jugador instroducido por parametro,
	 * se iniciliza los puntos, inicio y toposJugando a 0, el escenario se inicializa a null y texto partida a vacio "".
	 * Hemos implementado 
	 * @param segundos
	 * @param disparosRestantes
	 */
	public GestionJuego(long segundos, int disparosRestantes,int puntosEnJuego){
		this.segundos = segundos;
		this.disparosRestantes = disparosRestantes;
	
		this.puntosPendientes = puntosEnJuego; 
		this.puntosTotales = puntosEnJuego; 
		this.inicio = 0;
		this.escenario = null;
		textoPartida = "";
		
	}
	
	/**
	 * Método de consulta que calcula el tiempo restante y devuelve los segundos restantes.
	 * @return long que devuelve los segundos restantes
	 */
	public long getSegundosRestates(){
		long ahora = System.currentTimeMillis();
		long tiempo = ahora - this.inicio;
		
		if(segundos - (tiempo)/1000 < 0)
			return -1;
		else
			return segundos - (tiempo)/1000;
	}
	
	/**
	 * Método de consulta que devuelve los segundos restantes de juego.
	 * @return long devuelve los segundos restantes.
	 */
	public long getSegundos(){
		return this.segundos;
	}
	
	/**
	 * Método que devuelve los disparos restantes disponibles para el jugador.
	 * @return entero que devuelve los disparos restantes
	 */
	public int getDisparosRestantes(){
		return this.disparosRestantes;
	}
	
	/**
	 * Método que decrementa los disparos restantes del juego.
	 */
	public void restaDisparo(){
		if(this.disparosRestantes > 0){
			this.disparosRestantes--;
		}
	}
	

	public void sumaDisparos(int disparos){
		this.disparosRestantes += disparos;
	}
	public void sumaTiempo(int tiempo){
		this.segundos += tiempo;
	}
	
	/**
	 * Método que crea una marca de tiempo al iniciar la partida.
	 */
	public void arrancaPartida(){
		this.inicio = System.currentTimeMillis();
	}
	
	/**
	 * Método de consulta que comprueba si la partida a finalizado o se esta jugando.
	 * @return boolean que devuelve si esta en juego o no.
	 */
	public boolean enJuego(){
		
		if(!this.esFinalizada() && this.disparosRestantes > 0 && getPuntosPendientes() > 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Método de consulta que comprueba si a terminado el tiempo de juego.
	 * @return boolean que devuelve si queda tiempo o no. 
	 */
	public boolean esFinalizada(){
		if(this.getSegundosRestates() < 0){
			return true;
		}else{
			return false;
		}
	}
	// Fin implementacion Sesion 4 
	
	// Implementacion "EXTRA"
	/**
	 * Método que hace referencia al escenario en el que se esta jugando e inserta la cantidad de topos
	 * que hay al comenzar la partida.
	 * @param escenario escenario actual en el que se esta jugando.
	 */
	public void setEscenario(Escenario escenario){
		this.escenario = escenario;
		escenario.getCantidadTopos();
		
	}
	
	/**
	 * Método de conulta que devuelve el escenario actual al que se hace referencia.
	 * @return devuelve el escenario actual.
	 */
	public Escenario getEscenario(){
		return this.escenario;
	}
	
	
	
	/**
	 * Método actualiza el mensaje a mostrar en la barra de la ventana de juego.
	 * @param mensaje String con el texto a mostrar.
	 */
	public void setTextoEstadoPartido(String mensaje){
		this.textoPartida = mensaje;
	}
	
	/**
	 * Método que devuelve el mensaje a mostrar en la barra de la ventana de juego.
	 * @return String que devuelve el texto a mostrar en la barra.
	 */
	public String getTextoEstadoPartido(){
		if(getPuntosPendientes()<=0){
			setTextoEstadoPartido("HAS GANADO !! HAS CONESGUIDO TODOS LOS PUNTOS ");
		}else if(this.disparosRestantes <= 0){
			setTextoEstadoPartido("GAME OVER !! NO QUEDAN DISPAROS");
		}else if(esFinalizada()){
			setTextoEstadoPartido("GAME OVER !! SE ACABO EL TIEMPO");
		}
		return textoPartida;
	}
	// Fin Implementacion "EXTRA"

	public int getPuntosPendientes() {
		return puntosPendientes;
	}

	public void calculaPuntosPendientes(int puntosPendientes) {
		this.puntosPendientes -= puntosPendientes;
	}

	public int getPuntosTotales() {
		return puntosTotales;
	}

}
