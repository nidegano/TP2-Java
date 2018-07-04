package configuraciones;

import vista.PanelDeAccion;

public class MostrarOpcionesDeModoDefensaBocaAbajo implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarOpcionesModoDefensaBocaAbajo();
	}

}
