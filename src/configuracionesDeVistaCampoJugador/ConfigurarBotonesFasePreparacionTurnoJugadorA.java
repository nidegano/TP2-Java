package configuracionesDeVistaCampoJugador;

import ConfiguracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
import vista.Grilla;

public class ConfigurarBotonesFasePreparacionTurnoJugadorA implements ConfiguracionDeLaVistaCampoJugador {

	@Override
	public void configurar(Grilla grilla) {
		grilla.configurarBotonesFasePreparacionTurnoJugadorA();
	}

}
