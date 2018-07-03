package juego;

import excpeciones.NoSePuedeInvocarMonstruosEnEstaFase;

public class FaseInicioDeJuego implements Fase {

	private boolean termino = false;

	public String nombre() {
		return "Fase Inicio de Juego";
	}

	public void ejecutar(Jugador jugador) {
		jugador.inicioJuego();
		this.termino = true;
	}

	public boolean termino() {
		return this.termino;
	}

	public Fase faseSiguiente() {
		return new FaseInicial();
	}

	public boolean cambioDeTurno() {
		return false;
	}

	public void tomoCartaDelMazo() {
	}

	public boolean puedeTomarCarta() {
		return false;
	}

	@Override
	public void finalizar() {
		// la unica forma de finalizar esta fase es ejecutandola
	}

	@Override
	public void chequearSiSePuedeInvocaMonstruo() {
		throw new NoSePuedeInvocarMonstruosEnEstaFase();		
	}
}
