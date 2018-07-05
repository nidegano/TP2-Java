
package fases;

import configuracionesDeVistaCampoJugadores.ConfiguracionDeLaVistaCampoJugadores;
import configuracionesDeVistaCampoJugadores.ConfigurarBotonesFasePreparacionTurnoJugadorA;
import configuracionesDeVistaCampoJugadores.ConfigurarBotonesFasePreparacionTurnoJugadorB;
import excepciones.SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;
import juego.Jugador;

public class FasePreparacion implements Fase {

	private boolean termino = false;
	private boolean yaSeInvocoUnMonstruo = false;

	public String nombre() {
		return "Fase de Preparacion";
	}

	public void ejecutar(Jugador jugador) {
	}

	public boolean termino() {
		return this.termino;
	}

	public Fase faseSiguiente() {
		return new FaseAtaque();
	}

	public boolean puedeTomarCarta() {
		return false;
	}

	@Override
	public void tomoCartaDelMazo() {
	}

	@Override
	public void finalizar() {
		
		this.termino = true;
	}
	
	@Override
	public void chequearSiSePuedeInvocaMonstruo() throws SoloSePuedeInvocarUnSoloMonstruoEnEstaFase {
		if (this.yaSeInvocoUnMonstruo) {
			throw new SoloSePuedeInvocarUnSoloMonstruoEnEstaFase();
		}
	}
	
	public void avisarAFaseQueSeInvocoMonstruo() {
		this.yaSeInvocoUnMonstruo = true;
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores determinarElEstadoDeLaVistaCampoJugadoresConJugadorBEnTurno() {
		return new ConfigurarBotonesFasePreparacionTurnoJugadorB();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores determinarElEstadoDeLaVistaCampoJugadoresConJugadorAEnTurno() {
		return new ConfigurarBotonesFasePreparacionTurnoJugadorA();
	}
}
