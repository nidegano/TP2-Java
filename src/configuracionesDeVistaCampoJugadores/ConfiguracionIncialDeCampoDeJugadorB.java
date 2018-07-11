package configuracionesDeVistaCampoJugadores;

import vista.Grilla;

public class ConfiguracionIncialDeCampoDeJugadorB implements ConfiguracionDeLaVistaCampoJugadores{

	@Override
	public void configurar(Grilla grilla) {
		//no hace nada con los botones, los deja en el estado en el que estaban
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores obtenerSiguiente() {
		return new ConfigurarBotonesFaseInicialTurnoJugadorA();
	}

}
