package configuracionesDeVistaCampoJugadores;

import vista.Grilla;

public class ConfigurarBotonesFaseFinalTurnoJugadorA implements ConfiguracionDeLaVistaCampoJugadores {

	@Override
	public void configurar(Grilla grilla) {
		grilla.configurarBotonesFaseFinalTurnoJugadorA();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores obtenerSiguiente() {
		return new ConfigurarBotonesFaseFinalTurnoJugadorB();
	}

}
