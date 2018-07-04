package estado;

import configuraciones.ConfiguracionDeOpciones;
import configuraciones.MostrarOpcionesDeCartaEspecialSinInvocar;
import efectos.EfectoDeCampo;
import efectos.EfectoEspeciales;

public class ModoCartaEspecialSinInvocar extends EstadoDeCartaEspecial {

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
		return new MostrarOpcionesDeCartaEspecialSinInvocar();
	}

}
