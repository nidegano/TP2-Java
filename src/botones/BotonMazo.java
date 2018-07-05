package botones;

import javafx.scene.control.Button;
import juego.Juego;

public class BotonMazo extends Button {

	public BotonMazo(Juego juego) {
		super("Mazo");
		this.setMaxSize(200, 200);
		this.setVisible(true);
		
		this.setOnAction(value -> {
			juego.jugadorDeTurno().tomarCartaDelMazo();
			this.setDisable(true);
		});
	}
}
