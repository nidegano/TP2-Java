package cartas;

import estado.ModoAtaque;
import estado.ModoDefensa;
import excepciones.BatallaEmpatadaException;

public abstract class CartaMonstruo extends Carta {

	protected int puntosDeAtaque;
	protected int puntosDeDefensa;
	protected int nivel;

	public void colocarEnModoAtaque() {
		this.estado = new ModoAtaque();
	}

	public boolean estaEnModoAtaque() {
		return this.estado.esModoAtaque();
	}

	public void colocarEnModoDefensa() {
		this.estado = new ModoDefensa();
	}

	public boolean estaEnModoDefensa() {
		return this.estado.esModoDefensa();
	}

	public boolean esPerdedoraContra(CartaMonstruo cartaAtacante) {
		if ((this.estado.esModoAtaque()) && (this.puntosDeAtaque < cartaAtacante.puntosDeAtaque))
			return true;
		if ((this.estado.esModoDefensa()) && (this.puntosDeDefensa < cartaAtacante.puntosDeAtaque))
			return true;
		if ((this.puntosDeAtaque == cartaAtacante.puntosDeAtaque) || (this.puntosDeDefensa == cartaAtacante.puntosDeAtaque))
			throw new BatallaEmpatadaException();
		return false;
	}

	public int obtenerPuntosDeVidaADebilitar(CartaMonstruo cartaAtacante) {
		int puntosDeVida = 0;
		if (this.estado.esModoAtaque())
			puntosDeVida = (cartaAtacante.puntosDeAtaque - this.puntosDeAtaque);

		if (puntosDeVida < 0)
			puntosDeVida = puntosDeVida * (-1);
		return puntosDeVida;
	}

}
