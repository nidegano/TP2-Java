package juego;

import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public interface Fase {
	
	public abstract void ejecutar(Jugador jugadorA, Jugador jugadorB);

	public abstract Fase faseSiguiente();

	public abstract boolean cambioDeTurno();
	
	public abstract void tomoCartaDelMazo();

	public abstract boolean puedeTomarCarta();
	
	public abstract boolean finalizaste();

	public abstract boolean obtenerVisibilidadDe(BotonCambioModoAtaque boton);
	
	public abstract boolean obtenerVisibilidadDe(BotonCambioModoDefensa boton);
	
	public abstract boolean obtenerVisibilidadDe(BotonAtacar boton);
	
	public abstract boolean obtenerVisibilidadDe(BotonInvocar boton);
	
	public abstract boolean obtenerVisibilidadDe(BotonSacrificar boton);

}
