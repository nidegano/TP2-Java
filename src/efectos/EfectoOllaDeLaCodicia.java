package efectos;

import cartas.Carta;


public class EfectoOllaDeLaCodicia extends EfectoEspeciales {

	public EfectoOllaDeLaCodicia(Carta cartaDuenia) {
		super(cartaDuenia);
	}

	@Override
	public void activar(){
		this.jugadorDuenio.tomarCartaDelMazo();
		this.jugadorDuenio.tomarCartaDelMazo();
		this.cartaDuenia.matar();
	}

}
