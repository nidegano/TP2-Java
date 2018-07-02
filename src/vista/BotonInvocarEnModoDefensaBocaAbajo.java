package vista;

import cartas.Carta;
import cartas.CartaMonstruo;
import javafx.scene.control.Button;

public class BotonInvocarEnModoDefensaBocaAbajo extends Button {

	public BotonInvocarEnModoDefensaBocaAbajo() {
		super("Invocar defensa boca abajo");
		this.setMaxSize(200, 200);
		this.setVisible(false);
	}

	public void asignarCarta(CartaMonstruo unaCarta, Grilla unaGrilla) {
		this.setOnAction(value -> {
			
			if(this.sePuedenSeguirInvocandoMonstruos(unaCarta)) {
				unaCarta.invocarEnModoDefensaBocaAbajo();
				unaGrilla.actualizarGrillaPorInvocacion(unaCarta);
				unaCarta.obtenerDuenio().avisarALaFaseQueSeInvocaUnMonstruo();
			}			
		});
	}

	private boolean sePuedenSeguirInvocandoMonstruos(Carta unaCarta) {
		return unaCarta.obtenerDuenio().sePuedenSeguirInvocandoMonstruos();
	}
}