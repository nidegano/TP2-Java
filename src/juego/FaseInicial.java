package juego;

import excepciones.NoSePuedeTomarMasCartasDelMazoException;
import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public class FaseInicial implements Fase {

	private int contador = 0;

	public void tomoCartaDelMazo() {
		if (this.contador >= 1)
			throw new NoSePuedeTomarMasCartasDelMazoException();
		this.contador = this.contador + 1;
	}

	public boolean finalizaste() {
		return this.contador >= 1;
	}

	public Fase faseSiguiente() {
		return new FasePreparacion();
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
		return false;
	}

	public boolean obtenerVisibilidadDe(BotonSacrificar boton) {
		return false;
	}

	public boolean puedeTomarCarta() {
		return true;
	}

	public void ejecutar(Jugador jugadorA, Jugador jugadorB) {
	}

}
