package vista;

import javafx.scene.control.Button;
import juego.Mazo;

public class BotonMazo extends Button {

	private Mazo mazo;

	public BotonMazo() {
		super("Mazo");
		this.setMaxSize(100, 200);
	}

	public void asignarMazo(Mazo unMazo) {
		this.mazo = unMazo;
	}

}