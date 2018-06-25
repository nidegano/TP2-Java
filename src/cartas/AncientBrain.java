package cartas;

public class AncientBrain extends CartaMonstruo {

	public AncientBrain() {
		super();
		this.puntosDeAtaque = new Puntos(1000);
		this.puntosDeDefensa = new Puntos(700);
		this.nivel = 3;
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
	}
}