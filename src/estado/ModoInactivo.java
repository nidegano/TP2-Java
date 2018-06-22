package estado;

import juego.FormaDeAfectarAlJugador;
import juego.NoRestar;

public class ModoInactivo implements Estado {
	
	@Override
	public FormaDeAfectarAlJugador formaDeAfectar() {
		return new NoRestar();
	}

}
