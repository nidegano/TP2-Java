package estado;

import cartas.Puntos;
import efectos.EfectoDeVolteo;
import efectos.EfectoInvocacionMonstruo;
import juego.FormaDeAfectarAlJugador;
import juego.NoRestar;

public class ModoDefensaBocaAbajo extends EstadoDeCartaMonstruo {

	public ModoDefensaBocaAbajo(Puntos puntosDeDefensa) {
		super();
		this.puntosAsociadosAlEstado = puntosDeDefensa;
	}

	@Override
	public FormaDeAfectarAlJugador formaDeAfectar(int diferencia) {
		return new NoRestar();
	}

	@Override
	public void activar(EfectoDeVolteo efecto) {
		efecto.activar();
	}

	@Override
	public void activar(EfectoInvocacionMonstruo efectoInvocacionMonstruo) {}
}
