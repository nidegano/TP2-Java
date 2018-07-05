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
	
	public void iniciar(){
		this.deTurno.jugar();
		this.vista.actualizarPorCambioDeTurno(this.deTurno);
	}

	public void asignarVista(Vista vista) {
		this.vista = vista;
	}

	public void informarQueJugadorDeTurnoTocoFinalizarFase(){
		deTurno.finalizarFase();
	}

	public void informarQueElJugadorDeTurnoTerminoSuTurno(){
		this.deTurno = deTurno.oponente();
		this.vista.actualizarPorCambioDeTurno(this.deTurno);
		this.deTurno.jugar();
	}

	public Jugador jugadorDeTurno() {
		return this.deTurno;

	}

	public void seTomoEstaCartaDelMazo(Carta unaCarta) {
		this.vista.seTomoEstaCartaDelMazo(unaCarta);
	}

	public void perdioJugador(Jugador jugador){
		this.vista.terminarJuego(jugador.nombre());
	}

}
