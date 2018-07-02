package juego;

import vista.BotonAtacar;
import vista.BotonCambioModoAtaque;
import vista.BotonCambioModoDefensa;
import vista.BotonInvocar;
import vista.BotonSacrificar;

public interface Fase {
	
	void ejecutar(Jugador jugador);

	Fase faseSiguiente();

	boolean obtenerVisibilidadDe(BotonCambioModoAtaque boton);
	
	boolean obtenerVisibilidadDe(BotonCambioModoDefensa boton);
	
	boolean obtenerVisibilidadDe(BotonAtacar boton);
	
	boolean obtenerVisibilidadDe(BotonInvocar boton);
	
	boolean obtenerVisibilidadDe(BotonSacrificar boton);

	boolean termino();

}
