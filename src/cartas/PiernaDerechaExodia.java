package cartas;

import juego.RecolectorDePartesDeExodia;

public class PiernaDerechaExodia extends Exodia {

	public PiernaDerechaExodia() {
		super();
		this.puntosDeAtaque = new Puntos(200);
		this.puntosDeDefensa = new Puntos(300);
		this.nivel = 1;
		this.nombre = "Exodia - Pierna Derecha";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_PiernaDerechaExodia.png");
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
		recolectorDePartesDeExodia.recolectarPiernaDerecha(this);
	}

}
