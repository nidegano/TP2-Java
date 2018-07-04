package efectos;

import cartas.Carta;
import estados.Estado;

public abstract class EfectoEspeciales extends Efecto {

	public EfectoEspeciales(Carta cartaDuenia) {
		super(cartaDuenia);
	}

	@Override
	public abstract void activar();

	@Override
	public void serActivadoPor(Estado estadoDeLaCarta) {
		estadoDeLaCarta.activar(this);
	}

}
