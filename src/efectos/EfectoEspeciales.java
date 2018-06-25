package efectos;

import cartas.Carta;
import estado.Estado;

public abstract class EfectoEspeciales extends Efecto {

	public EfectoEspeciales(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public abstract void activar();

	@Override
	public void serActivadoPor(Estado estadoDeLaCarta) {
		estadoDeLaCarta.activar(this);
	}
}