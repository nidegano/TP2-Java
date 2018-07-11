package botones;

import javafx.scene.control.Button;
import vista.ControladorVisual;

public class BotonJugadorB extends Button {

	private ControladorVisual controladorVisual;

	public BotonJugadorB(ControladorVisual vista) {
		super("Jugador B");
		this.setMaxSize(200, 200);
		this.setVisible(true);
		
		this.controladorVisual = vista;
		
		this.setOnAction(value -> {
			this.controladorVisual.avisarDeLaSeleccionDeJugador();
		});
	}
}
