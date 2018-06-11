package cartas;

import estado.ModoAtaque;
import estado.ModoDefensa;

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

	public void atacar(CartaMonstruo otroMonstruo) {

	}

}
