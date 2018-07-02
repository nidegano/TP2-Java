package juego;

public class FaseFinal implements Fase {

	private boolean termino;

	@Override
	public String nombre() {
		return "Fase Final";
	}

	@Override
	public void ejecutar(Jugador jugador) {
	}

	@Override
	public boolean termino() {
		return this.termino;
	}

	@Override
	public Fase faseSiguiente() {
		return new FaseInicial();
	}

	@Override
	public boolean puedeTomarCarta() {
		return false;
	}

	@Override
	public void tomoCartaDelMazo() {
	}

	@Override
	public void finalizar() {
		this.termino = true;
	}

}
