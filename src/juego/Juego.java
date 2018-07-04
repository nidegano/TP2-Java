package juego;

import cartas.Carta;
import vista.Vista;

public class Juego {

	private Jugador jugadorA;
	private Jugador jugadorB;
	private Jugador deTurno;
	private Vista vista;

	public Juego(Jugador jugadorA, Jugador jugadorB) {
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		this.jugadorA.asignarOponente(jugadorB);
		this.jugadorB.asignarOponente(jugadorA);

		jugadorA.asignarJuego(this);
		jugadorB.asignarJuego(this);

		this.deTurno = jugadorA;
	}

	public void asignarVista(Vista vista) {
		this.vista = vista;
	}

	public void informarQueJugadorDeTurnoTocoFinalizarFase() {
		deTurno.finalizarFase();
		this.vista.actualizarPorCambioDeFaseALaFase(deTurno.obtenerFase());
	}

	public void informarQueElJugadorDeTurnoTerminoSuTurno() {
		this.vista.actualizarPorCambioDeTurno(this.deTurno);
		this.deTurno = deTurno.oponente();
		this.deTurno.jugar();
	}

	public Jugador jugadorDeTurno() {
		return this.deTurno;

	}

	public void seTomoEstaCartaDelMazo(Carta unaCarta) {
		this.vista.seTomoEstaCartaDelMazo(unaCarta);
	}

}
