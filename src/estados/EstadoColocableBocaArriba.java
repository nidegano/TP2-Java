package estados;

import configuraciones.ConfiguracionDeOpciones;
import configuraciones.MostrarOpcionesDeCartaMagicaColocableBocaArriba;
import efectos.EfectoDeCampo;
import efectos.EfectoEspeciales;

public class EstadoColocableBocaArriba extends EstadoDeCartaEspecial {

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
		return new MostrarOpcionesDeCartaMagicaColocableBocaArriba();
	}

}
