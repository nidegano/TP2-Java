package cartas;

import juego.RecolectorDePartesDeExodia;

public class PiernaIzquierdaExodia extends Exodia {

	public PiernaIzquierdaExodia() {
		super();
		this.puntosDeAtaque = new Puntos(200);
		this.puntosDeDefensa = new Puntos(300);
		this.nivel = 1;
		this.nombre = "Exodia - Pierna Izquierda";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_PiernaIzquierdaExodia.png");
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
		recolectorDePartesDeExodia.recolectarPiernaIzquierda(this);
	}

}
