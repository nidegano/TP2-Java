package efectos;

import cartas.Carta;
import estados.Estado;

public abstract class EfectoDeVolteo extends Efecto {

	public EfectoDeVolteo(Carta cartaDuenia) {
		super(cartaDuenia);
	}

	@Override
	public void serActivadoPor(Estado estadoDeLaCarta) {
		estadoDeLaCarta.activar(this);
	}

}
