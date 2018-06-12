package juego;

import cartas.CartaMonstruo;
import excepciones.BatallaEmpatadaException;

public class Batalla {

	private Jugador jugadorAtacante;
	private Jugador jugadorAtacado;

	public Batalla(Jugador unJugadorAtacante, Jugador unJugadorAtacado) {
		this.jugadorAtacante = unJugadorAtacante;
		this.jugadorAtacado = unJugadorAtacado;
	}

	public void librarBatalla() {
		CartaMonstruo cartaAtacante = this.jugadorAtacante.elegirMonstruo();
		CartaMonstruo cartaAtacada = this.jugadorAtacado.elegirMonstruo();

		try {
			CartaMonstruo cartaPerdedora = this.obtenerCartaPerdedora(cartaAtacante, cartaAtacada);
			int puntosDeVidaADebilitar = cartaAtacada.obtenerPuntosDeVidaADebilitar(cartaAtacante);

			if (this.jugadorAtacado.estaLaCartaEnZonaDeMonstruo(cartaPerdedora)) {
				this.jugadorAtacado.enviarAlCementerio(cartaPerdedora);
				this.jugadorAtacado.debilitar(puntosDeVidaADebilitar);
			}
			if (this.jugadorAtacante.estaLaCartaEnZonaDeMonstruo(cartaPerdedora) && puntosDeVidaADebilitar != 0) {
				this.jugadorAtacante.enviarAlCementerio(cartaPerdedora);
				this.jugadorAtacante.debilitar(puntosDeVidaADebilitar);
			}
		} catch (BatallaEmpatadaException e) {
			this.jugadorAtacado.enviarAlCementerio(cartaAtacada);
			this.jugadorAtacante.enviarAlCementerio(cartaAtacante);
		}

	}

	private CartaMonstruo obtenerCartaPerdedora(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		if (cartaAtacada.esPerdedoraContra(cartaAtacante))
			return cartaAtacada;
		else
			return cartaAtacante;
	}

}
