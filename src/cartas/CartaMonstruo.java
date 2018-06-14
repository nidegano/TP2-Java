package cartas;

import estado.ModoAtaque;
import estado.ModoDefensa;
import excepciones.BatallaEmpatadaException;
import java.lang.Math;

public abstract class CartaMonstruo extends Carta {

	protected int puntosDeAtaque;
	protected int puntosDeDefensa;
	protected int puntosSegunEstado;
	protected int nivel;

	public void colocarEnModoAtaque() {
		this.estado = new ModoAtaque();
		this.puntosSegunEstado = this.puntosDeAtaque;
	}

	public void colocarEnModoDefensa() {
		this.estado = new ModoDefensa();
		this.puntosSegunEstado = this.puntosDeDefensa;
	}
	
	public boolean estaEnModoAtaque() {
		return this.estado.esModoAtaque();
	}

	public boolean estaEnModoDefensa() {
		return this.estado.esModoDefensa();
	}

	public boolean esPerdedoraContra(CartaMonstruo cartaAtacante) {
		if (this.puntosSegunEstado == cartaAtacante.puntosDeAtaque)
			throw new BatallaEmpatadaException();
		return (this.puntosSegunEstado < cartaAtacante.puntosDeAtaque);
	}

	public int obtenerPuntosDeVidaADebilitar(CartaMonstruo cartaAtacante) {
		int puntosDeVida = 0;
		if (this.estado.esModoAtaque())
			puntosDeVida = Math.abs(cartaAtacante.puntosDeAtaque - this.puntosDeAtaque);
		return puntosDeVida;
	}

}
