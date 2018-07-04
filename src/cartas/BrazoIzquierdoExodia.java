package cartas;

import juego.RecolectorDePartesDeExodia;

public class BrazoIzquierdoExodia extends Exodia {

	public BrazoIzquierdoExodia() {
		super();
		this.puntosDeAtaque = new Puntos(200);
		this.puntosDeDefensa = new Puntos(300);
		this.nivel = 1;
		this.nombre = "Exodia - Brazo Izquierdo";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_BrazoIzquierdoExodia.png");
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
		recolectorDePartesDeExodia.recolectarBrazoIzquierdo(this);
	}

}
