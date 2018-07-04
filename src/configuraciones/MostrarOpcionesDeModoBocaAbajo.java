package configuraciones;

import vista.PanelDeAccion;

public class MostrarOpcionesDeModoBocaAbajo implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.noMostrarNingunaOpcion();
	}
}
