package cartas;

import estado.ModoAtaque;

public class MonstruoRequiereUnSacrificio extends CartaMonstruo {

	public void colocarEnModoAtaque(CartaMonstruo unMonstruo) {
		unMonstruo.matar();
		this.estado = new ModoAtaque(puntosDeAtaque);
	}
}
