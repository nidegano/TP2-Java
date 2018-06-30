package vista;

import cartas.Carta;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BotonCartaEspecial extends Button {

	private Carta carta;

	public BotonCartaEspecial(String texto, ImageView imageView) {
		super(texto);
		this.setMaxSize(100, 200);
		this.setOnAction(value -> {
			imageView.setImage(this.carta.obtenerImagen());
		});
	}

	public void asignarCarta(Carta unaCarta) {
		this.carta = unaCarta;
		this.setText(unaCarta.obtenerNombre());
	}

}
