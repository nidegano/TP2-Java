package cartas;

import estado.ModoActivo;
import estado.ModoInactivo;
import juego.Jugador;

public class AgujeroOscuro extends CartaMagica {

	public AgujeroOscuro() {
		this.estado = new ModoInactivo();
	}

	public void colocarBocaAbajo() {
		this.estado = new ModoInactivo();
	}

	public boolean estaBocaAbajo() {
		return this.estado.esInactivo();
	}

	public void colocarBocaArriba() {
		this.estado = new ModoActivo();
	}
	
	public void efecto(Jugador jugadorA, Jugador jugadorB) {
		if(estado.esActivo()) {
			jugadorA.destruirCartasEnCampo();
			jugadorB.destruirCartasEnCampo();
		}
	}

}
