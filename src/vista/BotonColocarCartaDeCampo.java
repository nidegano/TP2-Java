package vista;

import cartas.Carta;
import javafx.scene.control.Button;

public class BotonColocarCartaDeCampo extends Button {

	public BotonColocarCartaDeCampo() {
		super("colocar carta de campo");
		this.setMaxSize(200, 200);
		this.setVisible(false);
	}

	public void asignarCarta(Carta unaCarta, Grilla unaGrilla) {
		this.setOnAction(value -> {
			
			if(this.sePuedenSeguirInvocandoMonstruos(unaCarta)) {
				unaGrilla.actualizarGrillaPorInvocacion(unaCarta);
				unaCarta.obtenerDuenio().avisarALaFaseQueSeInvocaUnMonstruo();
			}			
		});
	}

	private boolean sePuedenSeguirInvocandoMonstruos(Carta unaCarta) {
		return unaCarta.obtenerDuenio().sePuedenSeguirInvocandoMonstruos();
	}
}