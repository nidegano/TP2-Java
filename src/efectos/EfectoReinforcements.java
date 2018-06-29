package efectos;

import cartas.Carta;

public class EfectoReinforcements extends EfectoEspeciales {

	public EfectoReinforcements(Carta cartaDuenia) {
		super(cartaDuenia);
	}

	@Override
	public void activar() {
		this.monstruoPropioObjetivo.aumentarPuntosDeAtaqueEn(500);
		this.cartaDuenia.matar();
	}

}
