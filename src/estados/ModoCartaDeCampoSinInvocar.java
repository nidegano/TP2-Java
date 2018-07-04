package estados;

import configuraciones.ConfiguracionDeOpciones;
import configuraciones.MostrarOpcionesDeCartaDeCampoSinInvocar;
import efectos.EfectoDeCampo;
import efectos.EfectoEspeciales;

public class ModoCartaDeCampoSinInvocar extends EstadoDeCartaEspecial {

	@Override
	public void activar(EfectoDeCampo efectoDeCampo) {
		//no activa efectos
	}

	@Override
	public void activar(EfectoEspeciales efectoEspeciales) {
		//no activa efectos
	}

	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpciones() {
		return new MostrarOpcionesDeCartaDeCampoSinInvocar();
	}

}
