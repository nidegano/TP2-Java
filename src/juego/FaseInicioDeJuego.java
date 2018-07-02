package juego;

import excepciones.NoSePuedeTomarMasCartasDelMazoException;
import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public class FaseInicioDeJuego implements Fase {


	@Override
	public Fase faseSiguiente() {
		return new FaseInicial();
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

	@Override
	public void ejecutar(Jugador jugadorA, Jugador jugadorB) {
		// TODO Auto-generated method stub
		
	}

}
