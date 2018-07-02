package juego;

import excepciones.NoSePuedeTomarMasCartasDelMazoException;

public class FaseInicial implements Fase {

	private int contador = 0;

	@Override
	public void tomoCartaDelMazo() {
		if (this.contador >= 1)
			throw new NoSePuedeTomarMasCartasDelMazoException();
		this.contador = this.contador + 1;
	}

	@Override
	public boolean finalizaste() {
		return this.contador >= 1;
	}

	@Override
	public Fase faseSiguiente() {
		return new FasePreparacion();
	}

	@Override
	public boolean cambioDeTurno() {
		return false;
	}

	@Override
	public boolean puedeTomarCarta() {
		return true;
	}

}
