package vista;

import cartas.Carta;
import cartas.CartaMonstruo;
import javafx.scene.control.Button;

public class BotonInvocarEnModoAtaque extends Button {

	public BotonInvocarEnModoAtaque() {
		super("Invocar en modo ataque");
		this.setMaxSize(200, 200);
		this.setVisible(false);
	}

	public void asignarCarta(CartaMonstruo unaCarta, Grilla unaGrilla) {
		this.setOnAction(value -> {

			if (this.sePuedenSeguirInvocandoMonstruos(unaCarta)) {
				unaCarta.invocarEnModoAtaque();
				unaGrilla.actualizarGrillaPorInvocacion(unaCarta);
				unaCarta.obtenerDuenio().avisarALaFaseQueSeInvocaUnMonstruo();
			}
		});
	}

	private boolean sePuedenSeguirInvocandoMonstruos(Carta unaCarta) {
		return unaCarta.obtenerDuenio().sePuedenSeguirInvocandoMonstruos();
	}
}