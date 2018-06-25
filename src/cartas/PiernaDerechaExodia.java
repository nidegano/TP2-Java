package cartas;

public class PiernaDerechaExodia extends CartaMonstruo {

	public PiernaDerechaExodia() {
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
