package vista;

import javafx.scene.control.Button;
import juego.Mazo;

public class BotonMazo extends Button {

	private Mazo mazo;

	public BotonMazo() {
		super("Mazo");
		this.setMaxSize(100, 25);
		this.setMinSize(100, 25);
	}

	public void asignarMazo(Mazo unMazo) {
		this.mazo = unMazo;
	}

}