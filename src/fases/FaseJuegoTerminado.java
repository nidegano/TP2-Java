package fases;

import configuracionesDeVistaCampoJugadores.BloquearTodo;
import configuracionesDeVistaCampoJugadores.ConfiguracionDeLaVistaCampoJugadores;
import excepciones.CapacidadMaximaException;
import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import excepciones.NoSePuedeTomarMasCartasDelMazoExceptionPorqueYaSeTomoUnaEnFaseInicial;
import excepciones.SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;
import juego.Jugador;

public class FaseJuegoTerminado implements Fase{

	@Override
	public String nombre() {
		return "Juego Terminado";
	}

	@Override
	public void ejecutar(Jugador jugador) throws CapacidadMaximaException {
	}

	@Override
	public boolean termino() {
		return false;
	}

	@Override
	public Fase faseSiguiente() {
		return new FaseInicioDeJuego();
	}

	@Override
	public boolean puedeTomarCarta() {
		return false;
	}

	@Override
	public void tomoCartaDelMazo() throws NoSePuedeTomarMasCartasDelMazoExceptionPorqueYaSeTomoUnaEnFaseInicial {
	}

	@Override
	public void finalizar() {
	}

	@Override
	public void chequearSiSePuedeInvocaMonstruo()
			throws NoSePuedeInvocarMonstruosEnEstaFase, SoloSePuedeInvocarUnSoloMonstruoEnEstaFase {
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores determinarElEstadoDeLaVistaCampoJugadoresConJugadorBEnTurno() {
		return new BloquearTodo();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores determinarElEstadoDeLaVistaCampoJugadoresConJugadorAEnTurno() {
		return new BloquearTodo();
	}

}
