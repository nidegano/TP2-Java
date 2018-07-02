
package juego;

public class FasePreparacion implements Fase {

	private boolean termino = false;

	public String nombre() {
		return "Fase de Preparacion";
	}

	public void ejecutar(Jugador jugador) {
		jugador.campo().renovarLaPosibilidadDeAtacarEnCartasMonstruo();
		jugador.reiniciarLaPosibilidadDeInvocarMonstruos();
	}

	public boolean termino() {
		return this.termino;
	}

	public Fase faseSiguiente() {
		return new FaseAtaque();
	}

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
