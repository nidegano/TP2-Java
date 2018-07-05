package estados;

import cartas.Puntos;
import configuraciones.ConfiguracionDeOpciones;
import configuraciones.MostrarOpcionesDeModoAtaque;
import efectos.EfectoDeVolteo;
import efectos.EfectoInvocacionMonstruo;

import juego.FormaDeAfectarAlJugador;
import juego.Restar;

public class ModoAtaque extends EstadoDeCartaMonstruo {

	public ModoAtaque(Puntos puntosDeAtaque) {
		super();
		this.puntosAsociadosAlEstado = puntosDeAtaque;
	}

	@Override
	public FormaDeAfectarAlJugador formaDeAfectar(int diferencia) {
		return new Restar(diferencia);
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
		return new MostrarOpcionesDeModoAtaque();
	}

}
