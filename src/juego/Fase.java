package juego;

public interface Fase {

	void tomoCartaDelMazo();

	boolean finalizaste();

	Fase faseSiguiente();

	boolean cambioDeTurno();

}
