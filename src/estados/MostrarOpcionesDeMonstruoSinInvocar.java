package estados;

import configuraciones.ConfiguracionDeOpciones;
import vista.PanelDeAccion;

public class MostrarOpcionesDeMonstruoSinInvocar implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarOpcionesDeMonstruoSinInvocar();
	}

}
