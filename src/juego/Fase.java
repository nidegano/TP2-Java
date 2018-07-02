package juego;

public interface Fase {

	public abstract String nombre();

	public abstract void ejecutar(Jugador jugador);
	
	public abstract boolean termino();

	public abstract Fase faseSiguiente();

	public abstract boolean cambioDeTurno();

	public abstract void tomoCartaDelMazo();

	public abstract boolean puedeTomarCarta();

}
