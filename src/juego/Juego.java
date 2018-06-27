package juego;

public class Juego {
	
	private Jugador jugadorA;
	private Jugador jugadorB;
	private Object perdedor;

	public Juego(Jugador jugadorA, Jugador jugadorB) {
		
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		jugadorA.asignarJuego(this);
		jugadorB.asignarJuego(this);
	}

	public boolean perdioJugador(Jugador jugador) {
		return perdedor.equals(jugador);
	}

	public void perdi(Jugador jugador) {
		perdedor = jugador;
	}

}
