package fases;

import ConfiguracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
import juego.Jugador;

public interface Fase {

	public abstract String nombre();

	public abstract void ejecutar(Jugador jugador);

	public abstract boolean termino();

	public abstract Fase faseSiguiente();

	public abstract boolean puedeTomarCarta();

	public abstract void tomoCartaDelMazo();

	public abstract void finalizar();

	public abstract void chequearSiSePuedeInvocaMonstruo();

	public abstract ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresConJugadorBEnTurno();

	public abstract ConfiguracionDeLaVistaCampoJugador determinarElEstadoDeLaVistaCampoJugadoresConJugadorAEnTurno();
}
