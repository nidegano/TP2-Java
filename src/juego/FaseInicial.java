package juego;

import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public class FaseInicial implements Fase {


	@Override
	public void ejecutar(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Fase faseSiguiente() {
		return new FasePreparacion();
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
