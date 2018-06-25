package efectos;

import cartas.Carta;

public class EfectoAgujeroOscuro extends EfectoEspeciales {

	public EfectoAgujeroOscuro(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public void activar() {
		this.jugadorDuenio.destruirCartasEnCampo();
		this.jugadorOponente.destruirCartasEnCampo();
		this.cartaDueña.matar();
	}

}
