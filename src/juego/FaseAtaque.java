package juego;

import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public class FaseAtaque implements Fase {

	private boolean termino = false;
	
	@Override
	public void finalizar() {
		this.termino = true;
	}
	
	public void tomoCartaDelMazo() {
	}

	public boolean finalizaste() {
		return false;
	}

	public Fase faseSiguiente() {
		return null;
	}

	public boolean cambioDeTurno() {
		return false;
	}

	public boolean puedeTomarCarta() {
		return false;
	}

	public void ejecutar(Jugador jugadorA, Jugador jugadorB) {
	}

	public boolean obtenerVisibilidadDe(BotonCambioModoAtaque boton) {
		return true;
	}

	public boolean obtenerVisibilidadDe(BotonCambioModoDefensa boton) {
		return true;
	}

	public boolean obtenerVisibilidadDe(BotonAtacar boton) {
		return true;
	}

	public boolean obtenerVisibilidadDe(BotonInvocar boton) {
		return false;
	}

	public boolean obtenerVisibilidadDe(BotonSacrificar boton) {
		return false;
	}

	@Override
	public String nombre() {
		return "faseDeAtaque";
	}

	@Override
	public void ejecutar(Jugador jugador) {
		//se espera que se realicen los ataque y que luego el jugador toque finalzar turno
	}

	@Override
	public boolean termino() {
		return this.termino;
	}

}
