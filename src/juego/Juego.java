package juego;

public class Juego {

	@SuppressWarnings("unused")
	private Jugador jugadorA;
	@SuppressWarnings("unused")
	private Jugador jugadorB;

	private Jugador deTurno;
	
	public Juego(Jugador jugadorA, Jugador jugadorB) {
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		
		jugadorA.inicioJuego( this );
		jugadorB.inicioJuego( this );
		
		deTurno = jugadorA;
 		
		deTurno.iniciarTurno();
	}
	
	public void actualizar() {
		Fase fase = deTurno.obtenerFase();
		if ( fase.finalizaste() )
			deTurno.siguienteFase();
		
		if ( fase.cambioDeTurno() ) {
			deTurno = jugadorB;
		    deTurno.iniciarTurno();
		}
	}

}
