package cartas;

import juego.RecolectorDePartesDeExodia;

public class BrazoDerechoExodia extends Exodia {

	public BrazoDerechoExodia() {
		super();
		this.puntosDeAtaque = new Puntos(200);
		this.puntosDeDefensa = new Puntos(300);
		this.nivel = 1;
		this.nombre = "Exodia - Brazo Derecho";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_BrazoDerechoExodia.png");
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
		recolectorDePartesDeExodia.recolectarBrazoDerecho(this);
	}

}
