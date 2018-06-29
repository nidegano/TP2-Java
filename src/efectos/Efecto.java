package efectos;

import cartas.Carta;
import cartas.CartaMonstruo;
import estado.Estado;
import excepciones.AtaqueIntervenidoException;
import juego.Jugador;

public abstract class Efecto {

	protected Jugador jugadorDuenio;
	protected Jugador jugadorOponente;
	protected CartaMonstruo monstruoEnemigoObjetivo;
	protected CartaMonstruo monstruoPropioObjetivo;
	protected Carta cartaDuenia;

	public Efecto(Carta cartaDuenia) {
		this.cartaDuenia = cartaDuenia;
	}

	public abstract void activar();
	
	public abstract void serActivadoPor(Estado estadoDeLaCarta);

	public void aisgnarJugadoresEfecto(Jugador jugadorDuenio, Jugador jugadorOponente) {
		this.jugadorDuenio = jugadorDuenio;
		this.jugadorOponente = jugadorOponente;
	}

	public void asignarMonstruoEnemigoObjetivo(CartaMonstruo cartaMonstruo) {
		this.monstruoEnemigoObjetivo = cartaMonstruo;
	}

	public void asignarMonstruoPropioObjetivo(CartaMonstruo cartaMonstruo) {
		this.monstruoPropioObjetivo = cartaMonstruo;
	}

	public void desasignarObjetivo() {
		this.monstruoEnemigoObjetivo = null;
		this.monstruoPropioObjetivo = null;
	}

	protected void interrumpirAtaque() {
		throw new AtaqueIntervenidoException();
	}

}
