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
