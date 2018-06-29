package estado;

import efectos.EfectoDeCampo;
import efectos.EfectoEspeciales;

public class ModoActivo extends EstadoDeCartaEspecial {

	@Override
	public void activar(EfectoDeCampo efectoDeCampo) {
		efectoDeCampo.activar();
	}

	@Override
	public void activar(EfectoEspeciales efectoEspeciales) {
		efectoEspeciales.activar();
	}

}
