package configuraciones;

import v.PanelDeAccion;

public class MostrarOpcionesDeModoBocaAbajo implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.noMostrarNingunaOpcion();
	}
}
