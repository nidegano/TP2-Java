package efectos;

import cartas.Carta;

public class EfectoAgujeroOscuro extends EfectoEspeciales {

	public EfectoAgujeroOscuro(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public void activar() {
		this.jugadorOponente.destruirCartasEnCampo();
		this.jugadorDuenio.destruirCartasEnCampo();
		this.cartaDueña.matar();
	}

}
