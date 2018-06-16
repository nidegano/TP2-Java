package cartas;

import estado.ModoActivo;
import juego.Jugador;

public class AgujeroOscuro extends CartaMagica {

	public AgujeroOscuro() {
		super();
	}

	public void efecto(Jugador jugadorA, Jugador jugadorB) {
		if (estado instanceof ModoActivo) {
			jugadorA.destruirCartasEnCampo();
			jugadorB.destruirCartasEnCampo();
		}
	}

}
