package juego;

public class Juego {

	private Jugador jugadorA;
	private Jugador jugadorB;
	private Jugador deTurno;

	public Juego(Jugador jugadorA, Jugador jugadorB) {
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		this.jugadorA.asignarOponente(jugadorB);
		this.jugadorB.asignarOponente(jugadorA);

		jugadorA.asignarJuego(this);
		jugadorB.asignarJuego(this);

		this.deTurno = jugadorA;
		this.deTurno.jugar();
	}

	public void informarQueJugadorDeTurnoTocoFinalizarFase() {
		deTurno.finalizarFase();
	}

	public void informarQueElJugadorDeTurnoTerminoSuTurno() {
		this.deTurno = deTurno.oponente();
		this.deTurno.jugar();
	}

	public Jugador jugadorDeTurno() {
		return this.deTurno;

	}

}
