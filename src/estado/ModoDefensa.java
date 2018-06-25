package estado;

import cartas.Puntos;
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

}
