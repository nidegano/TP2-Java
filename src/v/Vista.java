package v;

import juego.Juego;
import juego.JugadorA;
import juego.JugadorB;
import vista.Grilla;

public class Vista {
	
	private Juego juego;
	private JugadorA jugadorA;
	private JugadorB jugadorB;
	
	private Grilla grilla;
	private VistaCampoJugadores vistaCampoJugadores;
	private PanelDeAccion panelDeAccion;
	private TextoDisplay textoDisplay;
	
	public Vista(JugadorA jugadorA, JugadorB jugadorB, Juego juego) throws Exception {
		
		this.juego = juego;
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		
		this.grilla = new Grilla(jugadorA,jugadorB,juego,this); //se contruye y coloca todo lo necesario (botones y labels)
		this.vistaCampoJugadores = new VistaCampoJugadores(grilla);
		this.panelDeAccion = new PanelDeAccion(grilla);
		this.textoDisplay = new TextoDisplay();
	}

}
