package estado;

import efectos.EfectoDeVolteo;
import efectos.EfectoInvocacionMonstruo;
import efectos.EfectoNulo;

public abstract class EstadoDeCartaEspecial extends Estado {

	@Override
	public void activar(EfectoNulo efectoNulo) {
	}

	@Override
	public void activar(EfectoDeVolteo efectoDeVolteo) {
	}

	@Override
	public void activar(EfectoInvocacionMonstruo efectoInvocacionMonstruo) {
	}
}
