package efectos;

import cartas.Carta;
import cartas.CartaMonstruo;
import excepciones.ContenedorDeCartasVacioException;

public class EfectoFisura extends EfectoEspeciales {

	public EfectoFisura(Carta cartaDuenia) {
		super(cartaDuenia);
	}

	@Override
	public void activar() {
		try {
			CartaMonstruo monstruo = this.jugadorOponente.campo().obtenerElMonstruoDeMenorAtaque();
			monstruo.matar();
			this.cartaDuenia.matar();
		}
		catch (ContenedorDeCartasVacioException e) {
			e.printStackTrace();
		}
	}

}
