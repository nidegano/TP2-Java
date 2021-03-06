package configuracionesDeVistaCampoJugadores;

import vista.Grilla;

public class ConfigurarBotonesFasePreparacionTurnoJugadorA implements ConfiguracionDeLaVistaCampoJugadores {

	@Override
	public void configurar(Grilla grilla) {
		grilla.configurarBotonesFasePreparacionTurnoJugadorA();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores obtenerSiguiente() {
		return new ConfigurarBotonesFasePreparacionTurnoJugadorB();
	}

}
