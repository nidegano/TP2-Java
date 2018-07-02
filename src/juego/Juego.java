package juego;

public class Juego {

	private Jugador jugadorA;
	private Jugador jugadorB;
	private Jugador deTurno;

	public Juego(Jugador jugadorA, Jugador jugadorB) {
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		jugadorA.inicioJuego(this);
		jugadorB.inicioJuego(this);
		this.deTurno = jugadorA;
		this.deTurno.iniciarTurno();
	}

	public void actualizar() {
		Fase fase = this.deTurno.obtenerFase();
		if (fase.finalizaste())
			this.deTurno.siguienteFase();
		if (fase.cambioDeTurno()) {
			if (this.deTurno.equals(jugadorA))
				this.deTurno = this.jugadorB;
			else
				this.deTurno = this.jugadorA;
			this.deTurno.iniciarTurno();
		}
	}

	public Jugador jugadorDeTurno() {
		return this.deTurno;
	}

}
