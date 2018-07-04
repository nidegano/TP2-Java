package configuraciones;

import v.PanelDeAccion;

public class MostrarOpcionesDeCartaMagicaColocableBocaArriba implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarSoloLaOpcionDeColocarBocaArribaYDescartar();
	}
}
