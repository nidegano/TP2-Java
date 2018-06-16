package juego;

public class Restar extends FormaDeAfectarAlJugador {

	@Override
	public void afectar(Jugador jugador, int puntosDeVidaADebilitar) {

		jugador.debilitar(puntosDeVidaADebilitar);
	}

}
