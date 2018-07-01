package juego;

public class FasePreparacion implements Fase {

	@Override
	public void tomoCartaDelMazo() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean finalizaste() {
		// TODO Auto-generated method stub
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

}
