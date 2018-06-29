package juego;

public class Juego {

	@SuppressWarnings("unused")
	private Jugador jugadorA;
	@SuppressWarnings("unused")
	private Jugador jugadorB;
	private Object perdedor;

	public Juego(Jugador jugadorA, Jugador jugadorB) {
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		jugadorA.asignarJuego(this);
		jugadorB.asignarJuego(this);
	}

	public boolean perdioJugador(Jugador jugador) {
		return this.perdedor.equals(jugador);
	}

	public void perdi(Jugador jugador) {
		this.perdedor = jugador;
	}

}
