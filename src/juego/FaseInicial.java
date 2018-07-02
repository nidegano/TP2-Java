package juego;

import excepciones.NoSePuedeTomarMasCartasDelMazoException;

public class FaseInicial implements Fase {

	private int contador = 0;

	public String nombre() {
		return "Fase Inicial";
	}

	public void ejecutar(Jugador jugador) {
	}

	public boolean termino() {
		return this.contador >= 1;
	}

	public Fase faseSiguiente() {
		return new FasePreparacion();
	}

	public boolean cambioDeTurno() {
		return false;
	}

	public void tomoCartaDelMazo() {
		if (this.contador >= 1)
			throw new NoSePuedeTomarMasCartasDelMazoException();
		this.contador = this.contador + 1;
	}

	public boolean puedeTomarCarta() {
		return true;
	}

}
