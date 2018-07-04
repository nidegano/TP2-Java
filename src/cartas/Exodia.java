package cartas;

import excepciones.TengoTodasLasPartesDeExodiaException;
import juego.RecolectorDePartesDeExodia;

public abstract class Exodia extends CartaMonstruo {

	@Override
	public abstract void serRecolectadaPorElRecolectorDePartesDeExodia(
			RecolectorDePartesDeExodia recolectorDePartesDeExodia) throws TengoTodasLasPartesDeExodiaException;

}
