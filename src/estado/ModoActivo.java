package estado;

import efectos.Efecto;

public class ModoActivo extends EstadoDeCartaEspecial {

	@Override
	public void activar(Efecto efecto) {
		efecto.activar();
	}
}
