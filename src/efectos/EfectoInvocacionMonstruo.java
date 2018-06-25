package efectos;

import cartas.Carta;
import estado.Estado;

public abstract class EfectoInvocacionMonstruo extends Efecto {

	public EfectoInvocacionMonstruo(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public void serActivadoPor(Estado estadoDeLaCarta) {
		estadoDeLaCarta.activar(this);		
	}
}
