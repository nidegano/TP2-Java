package configuraciones;

import vista.PanelDeAccion;

public class MostrarOpcionesDeCartaMagicaColocableBocaArriba implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarSoloLaOpcionDeColocarBocaArribaYDescartar();
	}
}
