package cartas;

import excepciones.TengoTodasLasPartesDeExodiaException;
import juego.RecolectorDePartesDeExodia;

public class CabezaExodia extends Exodia {

	public CabezaExodia() {
		super();
		this.puntosDeAtaque = new Puntos(1000);
		this.puntosDeDefensa = new Puntos(1000);
		this.nivel = 3;
		this.nombre = "Exodia - Cabeza";
		this.colocarImagenEnCartaDesdeArchivoDeRuta("resources/images/carta_CabezaExodia.png");
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) throws TengoTodasLasPartesDeExodiaException {
		recolectorDePartesDeExodia.recolectarCabeza(this);
	}

}
