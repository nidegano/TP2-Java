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

	public void actualizar() {
		Fase fase = this.deTurno.obtenerFase();
		if (fase.termino())
			this.deTurno.siguienteFase();
		if (fase.cambioDeTurno()) {
			if (this.deTurno.equals(jugadorA))
				this.deTurno = this.jugadorB;
			else
				this.deTurno = this.jugadorA;
			this.deTurno.iniciarTurno();
		}
	}

	public void informarQueTerminoElTurnoDe(Jugador jugador) {
		this.deTurno = jugador.oponente();
		this.deTurno.jugar();
	}

	public Jugador jugadorDeTurno() {
		return this.deTurno;

	}

}
