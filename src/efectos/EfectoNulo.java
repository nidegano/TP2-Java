package efectos;

import cartas.Carta;
import estado.Estado;

public class EfectoNulo extends Efecto {

	public EfectoNulo(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public void serActivadoPor(Estado estadoDeLaCarta) {
		estadoDeLaCarta.activar(this);		
	}

	@Override
	public void activar() {
		// TODO Auto-generated method stub
		
	}

}
