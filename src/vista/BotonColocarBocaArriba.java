package vista;

import cartas.Carta;
import javafx.scene.control.Button;

public class BotonColocarBocaArriba extends Button {

	public BotonColocarBocaArriba() {
		super("colocar boca arriba");
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