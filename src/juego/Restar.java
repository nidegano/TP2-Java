package juego;



public class Restar implements FormaDeAfectarAlJugador {

	private int puntosDeVidaARestar;

	public Restar(int puntosDeVidaARestar) {
		this.puntosDeVidaARestar = Math.abs(puntosDeVidaARestar);
	}

	@Override
	public void afectar(Jugador jugador){
		jugador.debilitar(this.puntosDeVidaARestar);
	}

}
