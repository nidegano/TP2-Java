package estado;

import configuraciones.ConfiguracionDeOpciones;
import efectos.EfectoDeCampo;
import efectos.EfectoDeVolteo;
import efectos.EfectoEspeciales;
import efectos.EfectoInvocacionMonstruo;
import efectos.EfectoNulo;
import juego.FormaDeAfectarAlJugador;
import juego.NoRestar;

public class EstadoMonstruoSinInvocar extends EstadoDeCartaMonstruo {

	@Override
	public void activar(EfectoDeVolteo efectoDeVolteo) {}

	@Override
	public void activar(EfectoInvocacionMonstruo efectoInvocacionMonstruo) {}

	@Override
	public void activar(EfectoNulo efectoNulo) {}

	@Override
	public void activar(EfectoDeCampo efectoDeCampo) {}

	@Override
	public void activar(EfectoEspeciales efectoEspeciales) {
		efectoEspeciales.activar();
	}

	@Override
	public FormaDeAfectarAlJugador formaDeAfectar(int diferencia) {
		return new NoRestar();
	}

	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpciones() {
		return new MostrarOpcionesDeMonstruoSinInvocar();
	}
}