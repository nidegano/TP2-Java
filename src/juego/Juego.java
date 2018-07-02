package juego;

public class Juego {

	private Jugador jugadorA;
	private Jugador jugadorB;
	private Jugador deTurno;

	public Juego(Jugador jugadorA, Jugador jugadorB) {
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		
		jugadorA.asignarJuego(this);
		jugadorB.asignarJuego(this);
		
		deTurno = jugadorA;
		deTurno.jugar();
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

	public void informarQueTerminoElTurnoDe(Jugador jugador) {
		deTurno = jugador.oponente();
		deTurno.jugar();
	}
	
	public Jugador jugadorDeTurno() {
		return this.deTurno;

	}

}
