package estado;

import cartas.Puntos;
import juego.FormaDeAfectarAlJugador;

public abstract class EstadoDeCartaMonstruo implements Estado {

	protected Puntos puntosAsociadosAlEstado;

	public int puntosAsociadosAlEstado() {
		return this.puntosAsociadosAlEstado.valor();
	}

	public abstract FormaDeAfectarAlJugador formaDeAfectar(int diferencia);

}
