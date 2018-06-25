package estado;

import cartas.Puntos;
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

}
