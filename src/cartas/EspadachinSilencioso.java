package cartas;

import juego.ContenedorDeCartas;

public class EspadachinSilencioso extends CartaMonstruo {

	public EspadachinSilencioso() {
		super();
		this.puntosDeAtaque = new Puntos(2300);
		this.puntosDeDefensa = new Puntos(1000);
		this.nivel = 4;
	}
}
