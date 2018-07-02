package juego;

import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public class FaseInicioDeJuego implements Fase {
	
	private boolean termino = false;
	
	@Override
	public boolean termino() {
		return this.termino;
	}
	
	@Override
	public void ejecutar(Jugador jugador) {
		jugador.inicioJuego();
		this.termino = true;
	}

	@Override
	public Fase faseSiguiente() {
		return new FaseInicial();
	}	
	
	@Override

	public void tomoCartaDelMazo() {
	}

	public boolean finalizaste() {
		return true;
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

	public boolean puedeTomarCarta() {
		return false;
	}

	public boolean obtenerVisibilidadDe(BotonInvocar boton) {
		return false;
	}

	public boolean obtenerVisibilidadDe(BotonSacrificar boton) {
		return false;
	}

	public void ejecutar(Jugador jugadorA, Jugador jugadorB) {
	}

	@Override
	public String nombre() {
		return "faseInicioDeJuego";
	}

	@Override
	public void finalizar() {
		this.termino = true;
	}
}
