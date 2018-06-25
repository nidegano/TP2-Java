package cartas;

import estado.ModoDefensaBocaAbajo;

public class InsectoComeHombres extends CartaMonstruo {

	public InsectoComeHombres() {
		super();
		this.puntosDeAtaque = new Puntos(450);
		this.puntosDeDefensa = new Puntos(600);
		this.nivel = 2;
	}

	public void invocarEnModoDefensaBocaAbajo() {
		this.estado = new ModoDefensaBocaAbajo(this.puntosDeDefensa);
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
		// TODO Auto-generated method stub
		
	}

}
