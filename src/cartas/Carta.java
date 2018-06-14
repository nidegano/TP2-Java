package cartas;

import estado.Estado;
import estado.Muerto;
import estado.ModoInactivo;
import juego.Jugador;

public abstract class Carta {

	protected Estado estado;

	public Carta() {
		this.estado = new ModoInactivo();
	}

	public void efecto(Jugador unJugador, Jugador otroJugador) {
	}

	public boolean estaMuerta() {
		return this.estado.estaMuerta();
	}

	public void matar() {
		this.estado = new Muerto();
	}

}
