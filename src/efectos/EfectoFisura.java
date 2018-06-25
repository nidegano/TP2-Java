package efectos;

import cartas.Carta;
import cartas.CartaMonstruo;

public class EfectoFisura extends EfectoEspeciales {

	public EfectoFisura(Carta cartaDuenia) {
		super(cartaDuenia);
	}

	@Override
	public void activar() {
		CartaMonstruo monstruo = this.jugadorOponente.campo().obtenerElMonstruoDeMenorAtaque();
		monstruo.matar();
		this.cartaDuenia.matar();
	}
}
