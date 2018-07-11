package configuracionesDeVistaCampoJugadores;

import vista.Grilla;

public class ConfigurarBotonesFasePreparacionTurnoJugadorB implements ConfiguracionDeLaVistaCampoJugadores {

	@Override
	public void configurar(Grilla grilla) {
		grilla.configurarBotonesFasePreparacionTurnoJugadorB();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores obtenerSiguiente() {
		return new ConfigurarBotonesFaseAtaqueTurnoJugadorA();
	}

}
