package estado;

import efectos.Efecto;

public class ModoInactivo extends EstadoDeCartaEspecial {

	@Override
	public void activar(Efecto efecto) {} //no hace nada con el efecto

}
