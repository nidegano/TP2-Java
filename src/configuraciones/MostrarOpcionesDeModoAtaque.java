package configuraciones;

import v.PanelDeAccion;

public class MostrarOpcionesDeModoAtaque implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarOpcionesModoAtaque();
	}

}
