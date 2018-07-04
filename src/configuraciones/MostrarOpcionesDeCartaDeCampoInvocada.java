package configuraciones;

import vista.PanelDeAccion;

public class MostrarOpcionesDeCartaDeCampoInvocada implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarOpcionesDeCartaDeCampoInvocada();
	}
}
