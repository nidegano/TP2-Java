package estado;

import efectos.EfectoDeCampo;
import efectos.EfectoEspeciales;

public class ModoInactivo extends EstadoDeCartaEspecial {

	@Override
	public void activar(EfectoDeCampo efectoDeCampo) {}
	
	@Override
	public void activar(EfectoEspeciales efectoEspeciales) {}
}
