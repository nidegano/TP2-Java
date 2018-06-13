package cartas;

import estado.Estado;
import juego.Jugador;

public abstract class Carta {

	protected Estado estado;
	
	public void efecto(Jugador unJugador, Jugador otroJugador) {}

}