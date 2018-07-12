package botones;


import javafx.scene.control.Button;
import vista.ControladorVisual;

public class BotonJugadorA extends Button {

	private ControladorVisual controladorVisual;

	public BotonJugadorA(ControladorVisual vista) {
		super("Jugador A");
		this.setMaxSize(100, 100);
		this.setVisible(true);
		
		this.controladorVisual = vista;
		
		this.setOnAction(value -> {
			this.controladorVisual.avisarDeLaSeleccionDeJugador();
		});
	}
}