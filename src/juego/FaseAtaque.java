package juego;

import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public class FaseAtaque implements Fase {

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

	@Override
	public String nombre() {
		return "faseDeAtaque";
	}

	@Override
	public void ejecutar(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean termino() {
		// TODO Auto-generated method stub
		return false;
	}

}
