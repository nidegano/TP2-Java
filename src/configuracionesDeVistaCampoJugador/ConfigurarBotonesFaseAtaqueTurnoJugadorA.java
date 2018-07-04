package configuracionesDeVistaCampoJugador;

import ConfiguracionesDeVistaCampoJugador.ConfiguracionDeLaVistaCampoJugador;
import vista.Grilla;

public class ConfigurarBotonesFaseAtaqueTurnoJugadorA implements ConfiguracionDeLaVistaCampoJugador {

	@Override
	public void configurar(Grilla grilla) {
		grilla.configurarBotonesFaseAtaqueTurnoJugadorA();
	}

}
