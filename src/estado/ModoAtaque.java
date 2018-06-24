package estado;

import juego.FormaDeAfectarAlJugador;
import juego.Restar;

public class ModoAtaque extends EstadoDeCartaMonstruo {

	public ModoAtaque(int puntosDeAtaque) {
		super();
		this.puntosAsociadosAlEstado = puntosDeAtaque;
	}
	
	@Override
	public FormaDeAfectarAlJugador formaDeAfectar(int diferencia) {
		return new Restar(diferencia);
	}

}
