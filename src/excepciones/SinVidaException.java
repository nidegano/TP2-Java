package excepciones;

import juego.Jugador;

public class SinVidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
   
	private Jugador jugador;
	
	public SinVidaException(Jugador jugador) {
		this.jugador = jugador;
	}
}
