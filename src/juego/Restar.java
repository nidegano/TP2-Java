package juego;

public class Restar implements FormaDeAfectarAlJugador {

	@Override
	public void afectar(Jugador jugador, int puntosDeVidaADebilitar) {

		jugador.debilitar(puntosDeVidaADebilitar);
	}

}
