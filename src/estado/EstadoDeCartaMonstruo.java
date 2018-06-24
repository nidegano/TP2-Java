package estado;

import juego.FormaDeAfectarAlJugador;

public abstract class EstadoDeCartaMonstruo implements Estado {

	protected int puntosAsociadosAlEstado;

	public int puntosAsociadosAlEstado() {
		return this.puntosAsociadosAlEstado;
	}

	public abstract FormaDeAfectarAlJugador formaDeAfectar();

}
