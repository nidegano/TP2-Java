package estado;

import juego.FormaDeAfectarAlJugador;
import juego.NoRestar;
import juego.Restar;

public class ModoAtaque extends EstadoDeCartaMonstruo {

	public ModoAtaque(int puntosDeAtaque) {
		super();
		this.puntosAsociadosAlEstado = puntosDeAtaque;
	}

	//Aca quise hacer DoubleDispatchPattern (el de piedra-papel-tijera del campus)
	
	public FormaDeAfectarAlJugador determinarFormaDeAfectarAlJugadorQueCorresponda(ModoAtaque estado) {
		
		return new Restar();
	}
	
	public FormaDeAfectarAlJugador determinarFormaDeAfectarAlJugadorQueCorresponda(ModoDefensa estado) {
		
		return new NoRestar();
	}
}
