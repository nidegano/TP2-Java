package juego;

public class FaseAtaque implements Fase {

	@Override
	public void tomoCartaDelMazo() {
	}

	@Override
	public boolean finalizaste() {
		return false;
	}

	@Override
	public Fase faseSiguiente() {
		return null;
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
