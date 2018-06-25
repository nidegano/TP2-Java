package efectos;

import cartas.Carta;

public class EfectoOllaDeLaCodicia extends EfectoEspeciales {

	public EfectoOllaDeLaCodicia(Carta cartaDueña) {
		super(cartaDueña);
	}

	@Override
	public void activar() {
		this.jugadorDuenio.tomarCartaDelMazo();
		this.jugadorDuenio.tomarCartaDelMazo();
		this.cartaDueña.matar();
	}

}
