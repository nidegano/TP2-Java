package cartas;

import estado.Estado;
import estado.EstadoMuerto;
import juego.Jugador;

public abstract class Carta {

	protected Estado estado;
	
	public void efecto(Jugador unJugador, Jugador otroJugador) {}
	
	public boolean estaMuerta() {
		
		return this.estado.estaMuerta();
	}
	
	public void matar() {
		this.estado = new EstadoMuerto();		
	}

}