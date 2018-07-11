package configuracionesDeVistaCampoJugadores;

import vista.Grilla;

public class ConfigurarBotonesFaseInicialTurnoJugadorB implements ConfiguracionDeLaVistaCampoJugadores {

	@Override
	public void configurar(Grilla grilla) {
		grilla.configurarBotonesFaseInicialTunoJugadorB();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores obtenerSiguiente() {
		return new ConfigurarBotonesFasePreparacionTurnoJugadorA();
	}
}
