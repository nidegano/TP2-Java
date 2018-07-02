package vista;

import cartas.CartaEspecial;
import excepciones.CapacidadMaximaException;
import javafx.scene.control.Button;

public class BotonColocarBocaAbajo extends Button {

	public BotonColocarBocaAbajo() {
		super("colocar boca abajo");
		this.setMaxSize(200, 200);
		this.setVisible(false);
	}

	public void asignarCarta(CartaEspecial unaCarta, Grilla unaGrilla) {
		this.setOnAction(value -> {
			try {
				unaCarta.colocarBocaAbajo();
				unaGrilla.actualizarGrillaPorInvocacion(unaCarta);	
			}
			catch (CapacidadMaximaException e) {}
		});
	}
}