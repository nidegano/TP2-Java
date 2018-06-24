package estado;

import juego.FormaDeAfectarAlJugador;
import juego.NoRestar;

public class ModoDefensa extends EstadoDeCartaMonstruo {

	public ModoDefensa(int puntosDeDefensa) {
		super();
		this.puntosAsociadosAlEstado = puntosDeDefensa;
	}
	
	@Override
	public FormaDeAfectarAlJugador formaDeAfectar(int diferencia) {
		return new NoRestar();
	}

}
