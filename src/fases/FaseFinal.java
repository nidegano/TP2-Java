package fases;

import configuracionesDeVistaCampoJugadores.ConfiguracionDeLaVistaCampoJugadores;
import configuracionesDeVistaCampoJugadores.ConfigurarBotonesFaseFinalTurnoJugadorA;
import configuracionesDeVistaCampoJugadores.ConfigurarBotonesFaseFinalTurnoJugadorB;
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
		jugador.renovarLaPosibilidadDeAtacarDeTodasLasCartasMonstruo();
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
	public void chequearSiSePuedeInvocaMonstruo() throws NoSePuedeInvocarMonstruosEnEstaFase {
		throw new NoSePuedeInvocarMonstruosEnEstaFase();		
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores determinarElEstadoDeLaVistaCampoJugadoresConJugadorBEnTurno() {
		return new ConfigurarBotonesFaseFinalTurnoJugadorB();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores determinarElEstadoDeLaVistaCampoJugadoresConJugadorAEnTurno() {
		return new ConfigurarBotonesFaseFinalTurnoJugadorA();
	}

}
