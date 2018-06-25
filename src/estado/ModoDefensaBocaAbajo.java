package estado;

import cartas.Puntos;
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

}
