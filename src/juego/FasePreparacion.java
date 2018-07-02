
package juego;

public class FasePreparacion implements Fase {

	public String nombre() {
		return "Fase de Preparacion";
	}

	public void ejecutar(Jugador jugador) {
		jugador.campo().renovarLaPosibilidadDeAtacarEnCartasMonstruo();
	}

	public boolean termino() {
		return true;
	}

	public Fase faseSiguiente() {
		return new FaseAtaque();
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

