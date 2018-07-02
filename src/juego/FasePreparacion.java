package juego;

import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public class FasePreparacion implements Fase {


	public void tomoCartaDelMazo() {
	}

	public boolean finalizaste() {
		return false;
	}


	public Fase faseSiguiente() {
		return new FaseAtaque();
	}

	public boolean cambioDeTurno() {
		return false;
	}

	public boolean obtenerVisibilidadDe(BotonCambioModoAtaque boton) {
		return false;
	}

	public boolean obtenerVisibilidadDe(BotonCambioModoDefensa boton) {
		return false;
	}

	public boolean obtenerVisibilidadDe(BotonAtacar boton) {
		return false;
	}

	public boolean obtenerVisibilidadDe(BotonInvocar boton) {
		return true;
	}

	public boolean obtenerVisibilidadDe(BotonSacrificar boton) {
		return true;
	}

	public void ejecutar(Jugador jugadorA, Jugador jugadorB) {
		jugadorA.campo().renovarLaPosibilidadDeAtacarEnCartasMonstruo();
		jugadorB.campo().renovarLaPosibilidadDeAtacarEnCartasMonstruo();
	}

	public boolean puedeTomarCarta() {
		return false;
	}

}
