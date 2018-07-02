package juego;

public class FasePreparacion implements Fase {

	@Override
	public void tomoCartaDelMazo() {
	}

	@Override
	public boolean finalizaste() {
		return false;
	}

	@Override
	public Fase faseSiguiente() {
		return new FaseAtaque();
	}

	@Override
	public boolean cambioDeTurno() {
		return false;
	}

	@Override
	public boolean puedeTomarCarta() {
		return false;
	}

}
