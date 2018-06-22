package estado;

import juego.FormaDeAfectarAlJugador;
import juego.NoRestar;

public class ModoActivo implements Estado {

	@Override
	public FormaDeAfectarAlJugador formaDeAfectar() {
		return new NoRestar();
	}

}
