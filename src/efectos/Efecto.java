package efectos;

import juego.Jugador;

public abstract class Efecto {

	protected Jugador jugadorDuenio;
	protected Jugador jugadorOponente;

	public abstract void activar();

	public void aisgnarJugadoresEfecto(Jugador jugadorDuenio, Jugador jugadorOponente) {
		this.jugadorDuenio = jugadorDuenio;
		this.jugadorOponente = jugadorOponente;
	}

}
