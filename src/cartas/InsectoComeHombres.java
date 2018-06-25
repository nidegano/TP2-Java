package cartas;

import efectos.EfectoInsectoComeHombres;

public class InsectoComeHombres extends CartaMonstruo {

	public InsectoComeHombres() {
		super();
		this.puntosDeAtaque = new Puntos(450);
		this.puntosDeDefensa = new Puntos(600);
		this.nivel = 2;
		this.efecto = new EfectoInsectoComeHombres(this);
	}
}
