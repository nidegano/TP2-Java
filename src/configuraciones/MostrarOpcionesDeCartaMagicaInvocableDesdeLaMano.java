package configuraciones;

import vista.PanelDeAccion;

public class MostrarOpcionesDeCartaMagicaInvocableDesdeLaMano implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarSoloLaOpcionDeColocarBocaArribaLaDeColocarBocaAbajoYDescartar();
	}

}
