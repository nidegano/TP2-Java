package estado;

import juego.FormaDeAfectarAlJugador;
import juego.NoRestar;
import juego.Restar;

public class ModoAtaque extends EstadoDeCartaMonstruo {

	public ModoAtaque(int puntosDeAtaque) {
		super();
		this.puntosAsociadosAlEstado = puntosDeAtaque;
	}

	public FormaDeAfectarAlJugador determinarFormaDeAfectarAlJugadorQueCorresponda(Estado estado) {
		FormaDeAfectarAlJugador formaDeAfectar = null;
		if (estado instanceof ModoAtaque)
			formaDeAfectar = new Restar();
		if (estado instanceof ModoDefensa)
			formaDeAfectar = new NoRestar();
		return formaDeAfectar;
	}

}
