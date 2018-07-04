package estado;

import configuraciones.ConfiguracionDeOpciones;
import configuraciones.MostrarOpcionesDeCartaDeCampoInvocada;
import efectos.EfectoDeCampo;
import efectos.EfectoEspeciales;

public class ModoCartaDeCampoInvocada extends EstadoDeCartaEspecial {

	@Override
	public void activar(EfectoDeCampo efectoDeCampo) {
		efectoDeCampo.activar();
	}

	@Override
	public void activar(EfectoEspeciales efectoEspeciales) {
		//no activa efectos de carta especial
	}

	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpciones() {
		return new MostrarOpcionesDeCartaDeCampoInvocada();
	}
}
