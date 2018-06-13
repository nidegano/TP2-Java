package cartas;

import estado.ModoAtaque;

public class MonstruoRequiereDosSacrificios extends CartaMonstruo {

	public void colocarEnModoAtaque(CartaMonstruo unMonstruo,CartaMonstruo otroMonstruo) {
		
		unMonstruo.matar();
		otroMonstruo.matar();
		
		this.estado = new ModoAtaque();
		this.puntosSegunEstado = this.puntosDeAtaque;
	}
}
