package fases;

import ConfiguracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
import configuracionesDeVistaCampoJugador.ConfigurarBotonesFaseFinalTurnoJugadorA;
import configuracionesDeVistaCampoJugador.ConfigurarBotonesFaseFinalTurnoJugadorB;
import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import juego.Jugador;

public class FaseFinal implements Fase {

	private boolean termino;

	@Override
	public String nombre() {
		return "Fase Final";
	}

	@Override
	public void ejecutar(Jugador jugador) {
		jugador.asignarATodasLasCartasMagicasUnEstadoDeColocablesBocaArriba();
	}

	@Override
	public boolean termino() {
		return this.termino;
	}

	@Override
	public Fase faseSiguiente() {
		return new FaseInicial();
	}

	@Override
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
	public void chequearSiSePuedeInvocaMonstruo() {
		throw new NoSePuedeInvocarMonstruosEnEstaFase();		
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresConJugadorBEnTurno() {
		return new ConfigurarBotonesFaseFinalTurnoJugadorB();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresConJugadorAEnTurno() {
		return new ConfigurarBotonesFaseFinalTurnoJugadorA();
	}

}
