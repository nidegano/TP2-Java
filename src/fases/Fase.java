package fases;

import configuracionesDeVistaCampoJugadores.ConfiguracionDeLaVistaCampoJugadores;
import excepciones.CapacidadMaximaException;

import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import excepciones.NoSePuedeTomarMasCartasDelMazoExceptionPorqueYaSeTomoUnaEnFaseInicial;
import excepciones.SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;
import juego.Jugador;

public interface Fase {

	public abstract String nombre();

	public abstract void ejecutar(Jugador jugador) throws CapacidadMaximaException;

	public abstract boolean termino();

	public abstract Fase faseSiguiente();

	public abstract boolean puedeTomarCarta();

	public abstract void tomoCartaDelMazo() throws NoSePuedeTomarMasCartasDelMazoExceptionPorqueYaSeTomoUnaEnFaseInicial;

	public abstract void finalizar();

	public abstract void chequearSiSePuedeInvocaMonstruo() throws NoSePuedeInvocarMonstruosEnEstaFase, SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;

	public abstract ConfiguracionDeLaVistaCampoJugadores determinarElEstadoDeLaVistaCampoJugadoresConJugadorBEnTurno();

	public abstract ConfiguracionDeLaVistaCampoJugadores determinarElEstadoDeLaVistaCampoJugadoresConJugadorAEnTurno();
}
