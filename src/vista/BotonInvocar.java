package vista;

import cartas.Carta;
import javafx.scene.control.Button;

public class BotonInvocar extends Button {

	public BotonInvocar() {
		super("Invocar");
		this.setMaxSize(200, 200);
		this.setVisible(false);
	}

	public void asignarCarta(Carta unaCarta, Grilla unaGrilla) {
		this.setOnAction(value -> {
			unaGrilla.actualizarGrillaPorInvocacionDeMonstruo(unaCarta);
		});
	}

}
