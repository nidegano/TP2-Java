package cartas;

import efectos.EfectoInsectoComeHombres;
import estado.ModoDefensaBocaAbajo;

public class InsectoComeHombres extends CartaMonstruo {

	public InsectoComeHombres() {
		super();
		this.puntosDeAtaque = new Puntos(450);
		this.puntosDeDefensa = new Puntos(600);
		this.nivel = 2;
		this.efecto = new EfectoInsectoComeHombres(this);
	}

	public void invocarEnModoDefensaBocaAbajo() {
		this.estado = new ModoDefensaBocaAbajo(this.puntosDeDefensa);
	}

}
