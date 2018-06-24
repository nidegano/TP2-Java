package efectos;

import juego.Jugador;

public abstract class Efecto {
	
	protected Jugador jugadorDueño;
	protected Jugador jugadorOponente;

	public void aisgnarJugadoresEfecto(Jugador jugadorDueño,Jugador jugadorOponente) {
		this.jugadorDueño = jugadorDueño;
		this.jugadorOponente = jugadorOponente;
	}

	public abstract void activar();

}
