package cartas;

import estado.Estado;
import juego.Jugador;

public abstract class Carta {

	protected Estado estado;
	protected Jugador duenioDeLaCarta;

	
	public void asignarDuenioDeLaCarta(Jugador jugador) {
		this.duenioDeLaCarta = jugador;
	}
}