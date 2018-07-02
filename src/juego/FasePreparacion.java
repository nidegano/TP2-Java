package juego;

import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public class FasePreparacion implements Fase {

	@Override
	public boolean finalizaste() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Fase faseSiguiente() {
		return new FaseAtaque();
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
		return true;
	}

	@Override
	public boolean obtenerVisibilidadDe(BotonSacrificar boton) {
		return true;
	}

	@Override
	public void ejecutar(Jugador jugadorA, Jugador jugadorB) {
		
		jugadorA.campo().renovarLaPosibilidadDeAtacarEnCartasMonstruo();
		jugadorB.campo().renovarLaPosibilidadDeAtacarEnCartasMonstruo();
	}

}
