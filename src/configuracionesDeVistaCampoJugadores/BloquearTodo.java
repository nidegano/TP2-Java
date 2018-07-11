package configuracionesDeVistaCampoJugadores;

import vista.Grilla;

public class BloquearTodo implements ConfiguracionDeLaVistaCampoJugadores {

	@Override
	public void configurar(Grilla grilla) {
		grilla.deshabilitarTodosLosBotones();
	}

	@Override
	public ConfiguracionDeLaVistaCampoJugadores obtenerSiguiente() {
		return null;
	}

}
