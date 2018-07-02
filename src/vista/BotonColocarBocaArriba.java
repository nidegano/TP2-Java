package vista;

import cartas.CartaEspecial;
import javafx.scene.control.Button;

public class BotonColocarBocaArriba extends Button {

	public BotonColocarBocaArriba() {
		super("colocar boca arriba");
		this.setMaxSize(200, 200);
		this.setVisible(false);
	}

	public void asignarCarta(CartaEspecial unaCarta, Grilla unaGrilla) {
		this.setOnAction(value -> {//no se puede poner boca arriba en fase de preparacion
			});
	}
}