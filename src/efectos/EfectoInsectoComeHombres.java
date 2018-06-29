package efectos;

import cartas.Carta;

public class EfectoInsectoComeHombres extends EfectoDeVolteo {

	public EfectoInsectoComeHombres(Carta cartaDuenia) {
		super(cartaDuenia);
	}

	@Override
	public void activar() {
		this.monstruoEnemigoObjetivo.matar();
		this.interrumpirAtaque();
	}

}
