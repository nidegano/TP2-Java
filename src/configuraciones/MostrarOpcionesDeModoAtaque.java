package configuraciones;

import vista.PanelDeAccion;

public class MostrarOpcionesDeModoAtaque implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarOpcionesModoAtaque();
	}

}
