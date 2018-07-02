package vista;

import cartas.CartaEspecial;
import excepciones.CapacidadMaximaException;
import javafx.scene.control.Button;

public class BotonColocarBocaArriba extends Button {

	public BotonColocarBocaArriba() {
		super("colocar boca arriba");
		this.setMaxSize(200, 200);
		this.setVisible(false);
	}

	public void asignarCarta(CartaEspecial unaCarta, Grilla unaGrilla) {
		this.setOnAction(value -> {
			
			try {
				unaCarta.colocarBocaArriba();
				unaGrilla.actualizarGrillaPorInvocacion(unaCarta);	
			}
			catch (CapacidadMaximaException e) {}
			
			});
	}
}