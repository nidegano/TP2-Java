package efectos;

import cartas.Carta;

public class EfectoInsectoComeHombres extends EfectoDeVolteo {

	public EfectoInsectoComeHombres(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public void activar() {
		this.monstruoObjetivo.matar();
		this.interrumpirAtaque();
	}
}
