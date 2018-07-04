package botones;

import javafx.scene.control.Button;
import juego.Juego;

public class BotonFinalizarFase extends Button {

	public BotonFinalizarFase(Juego juego) {
		super("Finalizar fase");
		this.setMaxSize(200, 200);
		this.setVisible(true);
		
		this.setOnAction(value -> {
			juego.informarQueJugadorDeTurnoTocoFinalizarFase();
		});
	}
}