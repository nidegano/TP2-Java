package juego;

import excepciones.NoSePuedeTomarMasCartasDelMazoException;
import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public class FaseInicial implements Fase {

	private int contador = 0;

	@Override
	public boolean finalizaste() {
		return contador >= 1;
	}

	@Override
	public Fase faseSiguiente() {
		return new FasePreparacion();
	}

	@Override
	public boolean cambioDeTurno() {
		return false;
	}
	
	@Override
	public boolean obtenerVisibilidadDe(BotonCambioModoAtaque boton) {
		return false;
	}

	@Override
	public boolean obtenerVisibilidadDe(BotonCambioModoDefensa boton) {
		return false;
	}

	@Override
	public boolean obtenerVisibilidadDe(BotonAtacar boton) {
		return false;
	}

	@Override
	public boolean obtenerVisibilidadDe(BotonInvocar boton) {
		return false;
	}

	@Override
	public boolean obtenerVisibilidadDe(BotonSacrificar boton) {
		return false;
	}

}
