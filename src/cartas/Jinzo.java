package cartas;

import efectos.EfectoJinzo;

public class Jinzo extends CartaMonstruo {

	public Jinzo() {
		super();
		this.puntosDeAtaque = new Puntos(500);
		this.puntosDeDefensa = new Puntos(400);
		this.nivel = 2;
		this.efecto = new EfectoJinzo();
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
		// TODO Auto-generated method stub
		
	}

}
