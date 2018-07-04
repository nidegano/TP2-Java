package configuraciones;

import v.PanelDeAccion;

public class MostrarOpcionesDeCartaNula implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.noMostrarNingunaOpcion();
	}
}
