package configuracionesDeVistaCampoJugadores;

import vista.Grilla;

public class ConfigurarBotonesFaseAtaqueTurnoJugadorB implements ConfiguracionDeLaVistaCampoJugadores {

	@Override
	public void configurar(Grilla grilla) {
		grilla.configurarBotonesFaseAtaqueTurnoJugadorB();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores obtenerSiguiente() {
		return new ConfigurarBotonesFaseFinalTurnoJugadorA();
	}

}
