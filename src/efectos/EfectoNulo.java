package efectos;

import cartas.Carta;
import estado.Estado;

public class EfectoNulo extends Efecto {

	public EfectoNulo(Carta cartaDuenia) {
		super(cartaDuenia);
	}

	@Override
	public void serActivadoPor(Estado estadoDeLaCarta) {
		estadoDeLaCarta.activar(this);
	}

	@Override
	public void activar() {
		// NO TIENE EFECTO
	}

}
