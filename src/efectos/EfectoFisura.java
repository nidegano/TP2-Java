package efectos;

import cartas.CartaMonstruo;

public class EfectoFisura extends Efecto {

	@Override
	public void activar() {
		CartaMonstruo monstruo = this.jugadorOponente.campo().obtenerElMonstruoDeMenorAtaque();
		monstruo.matar();
	}

}
