package configuraciones;

import vista.PanelDeAccion;

public class MostrarOpcionesDeCartaDeCampoSinInvocar implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarOpcionesDeCartaDeCampoSinInvocar();
	}

}
