package juego;

public class Juego {
	
	private Jugador jugadorA;
	private Jugador jugadorB;

	public Juego(Jugador jugadorA, Jugador jugadorB) {
		
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
	}

	public boolean perdioJugador(Jugador jugador) {
		return jugador.perdiste();
	}

}
