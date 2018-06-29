package cartas;

import juego.RecolectorDePartesDeExodia;

public class CabezaExodia extends Exodia {

	public CabezaExodia() {
		super();
		this.puntosDeAtaque = new Puntos(1000);
		this.puntosDeDefensa = new Puntos(1000);
		this.nivel = 3;
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
		recolectorDePartesDeExodia.recolectarCabeza(this);
	}

}
