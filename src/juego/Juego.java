package juego;

import cartas.Carta;

import vista.ControladorVisual;

public class Juego {

	private Jugador jugadorA;
	private Jugador jugadorB;
	private Jugador deTurno;
	private ControladorVisual controladorVisual;
	private String ganador;

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
		//this.controladorVisual.actualizarPorCambioDeTurno(this.deTurno);
	}

	public void asignarVista(ControladorVisual vista) {
		this.controladorVisual = vista;
	}

	public void informarQueJugadorDeTurnoTocoFinalizarFase(){
		deTurno.finalizarFase();
	}

	public void informarQueElJugadorDeTurnoTerminoSuTurno(){
		this.deTurno = deTurno.oponente();
		this.controladorVisual.actualizarPorCambioDeTurno(this.deTurno);
		this.deTurno.jugar();
	}

	public Jugador jugadorDeTurno() {
		return this.deTurno;

	}

	public void seTomoEstaCartaDelMazo(Carta unaCarta) {
		this.controladorVisual.seTomoEstaCartaDelMazo(unaCarta);
	}

	public void perdioJugador(Jugador jugador){
		this.ganador = jugador.oponente().nombre();
		this.controladorVisual.terminarJuego(jugador.nombre());
	}

	public String ganador() {
		return this.ganador;
	}

}
