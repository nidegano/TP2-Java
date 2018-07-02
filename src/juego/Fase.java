package juego;

import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public interface Fase {
	
	void ejecutar(Jugador jugadorA, Jugador jugadorB);

	Fase faseSiguiente();

	boolean cambioDeTurno();

	boolean obtenerVisibilidadDe(BotonCambioModoAtaque boton);
	
	boolean obtenerVisibilidadDe(BotonCambioModoDefensa boton);
	
	boolean obtenerVisibilidadDe(BotonAtacar boton);
	
	boolean obtenerVisibilidadDe(BotonInvocar boton);
	
	boolean obtenerVisibilidadDe(BotonSacrificar boton);

}
