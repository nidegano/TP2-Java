package configuraciones;

import vista.PanelDeAccion;

public class MostrarOpcionesDeCartaNula implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.noMostrarNingunaOpcion();
	}
}
