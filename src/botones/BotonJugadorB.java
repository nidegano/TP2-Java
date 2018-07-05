package botones;

import javafx.scene.control.Button;
import vista.Vista;

public class BotonJugadorB extends Button {

	@SuppressWarnings("unused")
	private Vista vista;

	public BotonJugadorB(Vista vista) {
		super("Jugador B");
		this.setMaxSize(200, 200);
		this.setVisible(true);
		
		this.vista = vista;
	}
}