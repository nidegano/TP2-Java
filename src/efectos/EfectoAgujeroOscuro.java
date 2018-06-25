package efectos;

import cartas.Carta;

public class EfectoAgujeroOscuro extends EfectoEspeciales {

	public EfectoAgujeroOscuro(Carta cartaDuenia) {
		super(cartaDuenia);
	}

	@Override
	public void activar() {
		this.jugadorOponente.destruirCartasEnCampo();
		this.jugadorDuenio.destruirCartasEnCampo();
		this.cartaDuenia.matar();
	}

}
