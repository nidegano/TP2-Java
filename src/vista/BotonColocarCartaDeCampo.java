package vista;

import cartas.Carta;
import cartas.CartaDeCampo;
import javafx.scene.control.Button;

public class BotonColocarCartaDeCampo extends Button {

	public BotonColocarCartaDeCampo() {
		super("colocar carta de campo");
		this.setMaxSize(200, 200);
		this.setVisible(false);
	}

	public void asignarCarta(CartaDeCampo unaCarta, Grilla unaGrilla) {
		this.setOnAction(value -> {

			if (!this.hayYaUnaCartaDeCampo(unaCarta, unaGrilla)) {
				unaCarta.colocarBocaArriba();
				unaGrilla.actualizarGrillaPorInvocacion(unaCarta);
			}
		});
	}

	private boolean hayYaUnaCartaDeCampo(Carta unaCarta, Grilla unaGrilla) {
		return unaCarta.obtenerDuenio().campo().obtenerZonaCartasDeCampo().hayCartas();
	}
}