
package fases;

import configuracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
import configuracionesDeVistaCampoJugador.ConfigurarBotonesFaseAtaqueTurnoJugadorA;
import configuracionesDeVistaCampoJugador.ConfigurarBotonesFaseAtaqueTurnoJugadorB;
import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import juego.Jugador;

public class FaseAtaque implements Fase {

	private boolean termino = false;

	public String nombre() {
		return "Fase de Ataque";
	}

	public void ejecutar(Jugador jugador) {
	}

	public boolean termino() {
		return this.termino;
	}

	public Fase faseSiguiente() {
		return new FaseFinal();
	}

	boolean cambioDeTurno() {
		return false;
	}

	public void tomoCartaDelMazo() {
	}

	public boolean puedeTomarCarta() {
		return false;
	}

	@Override
	public void finalizar() {
		this.termino = true;
	}

	@Override
	public void chequearSiSePuedeInvocaMonstruo() throws NoSePuedeInvocarMonstruosEnEstaFase {
		throw new NoSePuedeInvocarMonstruosEnEstaFase();		
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresConJugadorBEnTurno() {
		return new ConfigurarBotonesFaseAtaqueTurnoJugadorB();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresConJugadorAEnTurno() {
		return new ConfigurarBotonesFaseAtaqueTurnoJugadorA();
	}
}
