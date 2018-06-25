package cartas;

public class BrazoDerechoExodia extends CartaMonstruo {

	public BrazoDerechoExodia() {
		super();
		this.puntosDeAtaque = new Puntos(200);
		this.puntosDeDefensa = new Puntos(300);
		this.nivel = 1;
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
		suma++;
	}

}
