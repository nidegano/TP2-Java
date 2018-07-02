
package vista;

import cartas.Carta;
import cartas.CartaMonstruo;
import javafx.scene.control.Button;

public class BotonInvocarEnModoDefensa extends Button {

	public BotonInvocarEnModoDefensa() {
		super("Invocar modo defensa");
		this.setMaxSize(200, 200);
		this.setVisible(false);
	}

	public void asignarCarta(CartaMonstruo unaCarta, Grilla unaGrilla) {
		this.setOnAction(value -> {
			
			if(this.sePuedenSeguirInvocandoMonstruos(unaCarta)) {
				unaCarta.invocarEnModoDefensa();
				unaGrilla.actualizarGrillaPorInvocacion(unaCarta);
				unaCarta.obtenerDuenio().avisarALaFaseQueSeInvocaUnMonstruo();
			}			
		});
	}

	private boolean sePuedenSeguirInvocandoMonstruos(Carta unaCarta) {
		return unaCarta.obtenerDuenio().sePuedenSeguirInvocandoMonstruos();
	}
}
