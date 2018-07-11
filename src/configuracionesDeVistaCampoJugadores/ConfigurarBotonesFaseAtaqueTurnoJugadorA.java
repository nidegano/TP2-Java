package configuracionesDeVistaCampoJugadores;

import vista.Grilla;

public class ConfigurarBotonesFaseAtaqueTurnoJugadorA implements ConfiguracionDeLaVistaCampoJugadores {

	@Override
	public void configurar(Grilla grilla) {
		grilla.configurarBotonesFaseAtaqueTurnoJugadorA();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores obtenerSiguiente() {
		return new ConfigurarBotonesFaseAtaqueTurnoJugadorB();
	}

}
