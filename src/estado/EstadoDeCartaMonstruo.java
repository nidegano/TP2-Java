package estado;

import juego.FormaDeAfectarAlJugador;

public abstract class EstadoDeCartaMonstruo implements Estado {

	protected int puntosAsociadosAlEstado;

	public int puntosAsociadosAlEstado() {
		return this.puntosAsociadosAlEstado;
	}

	@Override
	public abstract FormaDeAfectarAlJugador formaDeAfectar();

}
