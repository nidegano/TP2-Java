package estados;

import configuraciones.ConfiguracionDeOpciones;
import configuraciones.MostrarOpcionesDeMonstruoRequiereSacrificiosSinInvocar;
import efectos.EfectoDeVolteo;
import efectos.EfectoInvocacionMonstruo;
import juego.FormaDeAfectarAlJugador;
import juego.NoRestar;

public class EstadoMonstruoRequiereSacrificioSinInvocar extends EstadoDeCartaMonstruo {

	@Override
	public FormaDeAfectarAlJugador formaDeAfectar(int diferencia) {
		return new NoRestar();
	}

	@Override
	public void activar(EfectoDeVolteo efectoDeVolteo) {
		//no activa efecto
	}

	@Override
	public void activar(EfectoInvocacionMonstruo efectoInvocacionMonstruo) {
		//no activa efecto
	}

	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpciones() {
		return new MostrarOpcionesDeMonstruoRequiereSacrificiosSinInvocar();
	}

}
