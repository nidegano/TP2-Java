package vista;

import cartas.Carta;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BotonCartaMonstruo extends Button {

	private Carta carta;

	public BotonCartaMonstruo(String texto, ImageView imageView) {
		super(texto);
		this.setOnAction(value -> {
			imageView.setImage(this.carta.obtenerImagen());
		});
	}

	public void asignarCarta(Carta unaCarta) {
		this.carta = unaCarta;
		this.setText(unaCarta.obtenerNombre());
	}

}
