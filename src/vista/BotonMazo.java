package vista;

import javafx.scene.control.Button;
import juego.Mazo;

public class BotonMazo extends Button {

	private Mazo mazo;

	public BotonMazo(String texto) {
		super(texto);
	}
	
	public void asignarMazo(Mazo unMazo) {
		this.mazo = unMazo;
	}

}
