package efectos;

import cartas.Carta;
import cartas.CartaMonstruo;

public class EfectoReinforcements extends EfectoEspeciales {

	public EfectoReinforcements(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public void activar() {
		CartaMonstruo c;
		((CartaMonstruo) this.cartaDueña).aumentarPuntosDeAtaqueEn(500);
		this.cartaDueña.matar();
	}

}
