package cartas;

import juego.Jugador;

public class AgujeroOscuro extends CartaMagica {

	public AgujeroOscuro() {
		super();
	}

	public void efecto(Jugador jugadorA, Jugador jugadorB) {
		if (this.estaBocaArriba()) {
			jugadorA.destruirCartasEnCampo();
			jugadorB.destruirCartasEnCampo();
		}
	}

}
