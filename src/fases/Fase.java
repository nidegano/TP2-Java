package fases;

import configuracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
import excepciones.CapacidadMaximaException;
import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import excepciones.NoSePuedeTomarMasCartasDelMazoException;
import excepciones.SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;
import juego.Jugador;

public interface Fase {

	public abstract String nombre();

	public abstract void ejecutar(Jugador jugador) throws CapacidadMaximaException;

	public abstract boolean termino();

	public abstract Fase faseSiguiente();

	public abstract boolean puedeTomarCarta();

	public abstract void tomoCartaDelMazo() throws NoSePuedeTomarMasCartasDelMazoException;

	public abstract void finalizar();

	public abstract void chequearSiSePuedeInvocaMonstruo() throws NoSePuedeInvocarMonstruosEnEstaFase, SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;

	public abstract ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresConJugadorBEnTurno();

	public abstract ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresConJugadorAEnTurno();
}
