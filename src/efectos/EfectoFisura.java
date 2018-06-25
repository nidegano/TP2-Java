package efectos;

import cartas.Carta;
import cartas.CartaMonstruo;

public class EfectoFisura extends EfectoEspeciales {

	public EfectoFisura(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public void activar() {
		CartaMonstruo monstruo = this.jugadorOponente.campo().obtenerElMonstruoDeMenorAtaque();
		monstruo.matar();
		this.cartaDueña.matar();
	}
}
