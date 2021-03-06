package configuracionesDeVistaCampoJugadores;

import vista.Grilla;

public class ConfigurarBotonesFaseFinalTurnoJugadorB implements ConfiguracionDeLaVistaCampoJugadores {

	@Override
	public void configurar(Grilla grilla) {
		grilla.configurarBotonesFaseFinalTurnoJugadorB();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores obtenerSiguiente() {
		return new ConfigurarBotonesFaseInicialTurnoJugadorA();
	}

}
