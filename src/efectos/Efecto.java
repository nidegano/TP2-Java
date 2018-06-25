package efectos;

import cartas.Carta;
import cartas.CartaMonstruo;
import estado.Estado;
import excepciones.AtaqueIntervenidoException;
import juego.Jugador;

public abstract class Efecto {

	protected Jugador jugadorDuenio;
	protected Jugador jugadorOponente;
	protected CartaMonstruo monstruoObjetivo;
	protected Carta cartaDueña;
	
	public Efecto(Carta cartaDueña) {
		this.cartaDueña = cartaDueña;
	}

	public abstract void activar();

	public void aisgnarJugadoresEfecto(Jugador jugadorDuenio, Jugador jugadorOponente) {
		this.jugadorDuenio = jugadorDuenio;
		this.jugadorOponente = jugadorOponente;
	}

	public void asignarMonstruoObjetivo(CartaMonstruo cartaMonstruo) {
		this.monstruoObjetivo = cartaMonstruo;		
	}

	public void desasignarObjetivo() {
		this.monstruoObjetivo = null;		
	}

	public abstract void serActivadoPor(Estado estadoDeLaCarta);
	

	protected void interrumpirAtaque() {
		throw new AtaqueIntervenidoException();
	}
}
