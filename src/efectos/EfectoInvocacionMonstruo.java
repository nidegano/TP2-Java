package efectos;

import cartas.Carta;
import estado.Estado;

public abstract class EfectoInvocacionMonstruo extends Efecto {

	public EfectoInvocacionMonstruo(Carta cartaDuenia) {
		super(cartaDuenia);
	}

	@Override
	public void serActivadoPor(Estado estadoDeLaCarta) {
		estadoDeLaCarta.activar(this);		
	}
}
