package estado;

import juego.FormaDeAfectarAlJugador;
import juego.NoRestar;
import juego.Restar;

public class ModoAtaque extends EstadoDeCartaMonstruo {

	public ModoAtaque(int puntosDeAtaque) {
		super();
		this.puntosAsociadosAlEstado = puntosDeAtaque;
	}

	//Aca quise hacer DoubleDispatchPattern (el de piedra-papel-tijera del campus) (no me salio)
	
	public FormaDeAfectarAlJugador determinarFormaDeAfectarAlJugadorQueCorresponda(Estado estado) {
		
		FormaDeAfectarAlJugador formaDeAfectar = null;
		
		if (estado.getClass().equals(ModoAtaque.class))
			formaDeAfectar = new Restar();
		if (estado.getClass().equals(ModoDefensa.class)) {
			formaDeAfectar = new NoRestar();
		}
		return formaDeAfectar;
	}
}
