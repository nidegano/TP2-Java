package cartas;

import juego.Jugador;

public class AgujeroOscuro extends CartaMagica {

	public AgujeroOscuro() {
		super();
	}

	public void efecto(Jugador jugadorA, Jugador jugadorB) {
		if (estado.esActivo()) {
			jugadorA.destruirCartasEnCampo();
			jugadorB.destruirCartasEnCampo();
		}
	}

}
