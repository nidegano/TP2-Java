package botones;

import javafx.scene.control.Button;
import vista.Vista;

public class BotonJugadorA extends Button {

	private Vista vista;

	public BotonJugadorA(Vista vista) {
		super("Jugador A");
		this.setMaxSize(200, 200);
		this.setVisible(true);
		
		this.vista = vista;
	}
}