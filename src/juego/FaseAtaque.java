package juego;

public class FaseAtaque implements Fase {

	public String nombre() {
		return "Fase de Ataque";
	}

	public void ejecutar(Jugador jugador) {
	}

	public boolean termino() {
		return false;
	}

	public Fase faseSiguiente() {
		return null;
	}

	public boolean cambioDeTurno() {
		return false;
	}

	public void tomoCartaDelMazo() {
	}

	public boolean puedeTomarCarta() {
		return false;
	}

}
