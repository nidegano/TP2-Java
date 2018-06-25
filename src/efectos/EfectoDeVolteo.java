package efectos;

import cartas.Carta;
import estado.Estado;

public abstract class EfectoDeVolteo extends Efecto {

	public EfectoDeVolteo(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public void serActivadoPor(Estado estadoDeLaCarta) {
		estadoDeLaCarta.activar(this);		
	}
}
