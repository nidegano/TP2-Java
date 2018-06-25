package cartas;

public class CabezaExodia extends CartaMonstruo {

	public CabezaExodia() {
		super();
		this.puntosDeAtaque = new Puntos(1000);
		this.puntosDeDefensa = new Puntos(1000);
		this.nivel = 3;
	}

	@Override
	public void sumarSiSosParteDeExodia(int suma) {
		suma++;
	}

}
