package configuraciones;

import vista.PanelDeAccion;

public class MostrarOpcionesDeModoDefensa implements ConfiguracionDeOpciones {

	@Override
	public void configurar(PanelDeAccion panelDeAccion) {
		panelDeAccion.mostrarOpcionesModoDefensa();
	}

}
