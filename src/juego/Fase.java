package juego;

public interface Fase {

	public abstract void tomoCartaDelMazo();

	public abstract boolean finalizaste();

	public abstract Fase faseSiguiente();

	public abstract boolean cambioDeTurno();

	public abstract boolean puedeTomarCarta();

}
