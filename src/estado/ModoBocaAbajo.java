package estado;

import configuraciones.ConfiguracionDeOpciones;
import configuraciones.MostrarOpcionesDeModoBocaAbajo;
import efectos.EfectoDeCampo;
import efectos.EfectoEspeciales;

public class ModoBocaAbajo extends EstadoDeCartaEspecial {

	@Override
	public void activar(EfectoDeCampo efectoDeCampo) {
	}

	@Override
	public void activar(EfectoEspeciales efectoEspeciales) {
	}

	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpciones() {		
		return new MostrarOpcionesDeModoBocaAbajo();
	}

}
