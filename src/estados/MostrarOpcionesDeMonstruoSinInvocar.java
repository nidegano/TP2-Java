package estados;

import configuraciones.ConfiguracionDeOpciones;
import v.PanelDeAccion;

public class MostrarOpcionesDeMonstruoSinInvocar implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarOpcionesDeMonstruoSinInvocar();
	}

}
