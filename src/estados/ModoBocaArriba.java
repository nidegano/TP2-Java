package estados;

import configuraciones.ConfiguracionDeOpciones;
import configuraciones.MostrarOpcionesDeCartaNula;
import efectos.EfectoDeCampo;
import efectos.EfectoEspeciales;

public class ModoBocaArriba extends EstadoDeCartaEspecial {

	@Override
	public void activar(EfectoDeCampo efectoDeCampo) {
		efectoDeCampo.activar();
	}

	@Override
	public void activar(EfectoEspeciales efectoEspeciales) {
		efectoEspeciales.activar();
	}

	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpciones() {
		return new MostrarOpcionesDeCartaNula(); 
		//este caso no se da nunca porque uno no selecciona una carta especial boca arriba porque esta muerta para cuando se pone boca arriba
	}

}
