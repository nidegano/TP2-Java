package fases;

import configuracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
import configuracionesDeVistaCampoJugador.ConfigurarBotonesFaseInicialTurnoJugadorA;
import configuracionesDeVistaCampoJugador.ConfigurarBotonesFaseInicialTurnoJugadorB;
import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import excepciones.NoSePuedeTomarMasCartasDelMazoException;
import juego.Jugador;

public class FaseInicial implements Fase {

	private int contador;

	public FaseInicial() {
		this.contador = 0;
	}

	public String nombre() {
		return "Fase Inicial";
	}

	public void ejecutar(Jugador jugador) {
		jugador.asignarATodasLasCartasMagicasUnEstadoDeBocaAbajo(); //osea no colocableBocaArriba
	}

	public boolean termino() {
		return this.contador >= 1;
	}

	public Fase faseSiguiente() {
		return new FasePreparacion();
	}

	public void tomoCartaDelMazo() throws NoSePuedeTomarMasCartasDelMazoException {
		if (this.contador >= 1)
			throw new NoSePuedeTomarMasCartasDelMazoException();
		this.contador = this.contador + 1;
	}

	public boolean puedeTomarCarta() {
		return !this.termino();
	}

	@Override
	public void finalizar() {
		// la unica forma de finalizar esta fase es tomando una carta del mazo
	}
	
	@Override
	public void chequearSiSePuedeInvocaMonstruo() throws NoSePuedeInvocarMonstruosEnEstaFase {
		throw new NoSePuedeInvocarMonstruosEnEstaFase();		
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresConJugadorBEnTurno() {
		return new ConfigurarBotonesFaseInicialTurnoJugadorB();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresConJugadorAEnTurno() {
		return new ConfigurarBotonesFaseInicialTurnoJugadorA();
	}

}
