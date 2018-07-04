package configuraciones;

import v.PanelDeAccion;

public class MostrarOpcionesDeCartaDeCampoInvocada implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarOpcionesDeCartaDeCampoInvocada();
	}
}
