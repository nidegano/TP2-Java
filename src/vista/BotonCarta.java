package vista;

import cartas.Carta;
import javafx.scene.control.Button;

public class BotonCarta extends Button {

	private Carta carta;

	public BotonCarta(String texto) {
		super(texto);
	}
	
	public void asignarCarta(Carta unaCarta) {
		this.carta = unaCarta;
		this.setText(unaCarta.obtenerNombre());
	}

}
