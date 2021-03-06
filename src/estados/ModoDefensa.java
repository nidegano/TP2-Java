package estados;

import cartas.Puntos;
import configuraciones.ConfiguracionDeOpciones;
import configuraciones.MostrarOpcionesDeModoDefensa;
import efectos.EfectoDeVolteo;
import efectos.EfectoInvocacionMonstruo;

import juego.FormaDeAfectarAlJugador;
import juego.NoRestar;

public class ModoDefensa extends EstadoDeCartaMonstruo {

	public ModoDefensa(Puntos puntosDeDefensa) {
		super();
		this.puntosAsociadosAlEstado = puntosDeDefensa;
	}

	@Override
	public FormaDeAfectarAlJugador formaDeAfectar(int diferencia) {
		return new NoRestar();
	}

	@Override
	public void activar(EfectoDeVolteo efecto) {
	}

	@Override
	public void activar(EfectoInvocacionMonstruo efectoInvocacionMonstruo){
		efectoInvocacionMonstruo.activar();
	}

	@Override
	public ConfiguracionDeOpciones obtenerConfiguracionDeOpciones() {
		return new MostrarOpcionesDeModoDefensa();
	}

}
