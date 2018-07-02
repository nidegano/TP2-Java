package vista;

import cartas.Carta;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BotonMano extends Button {

	private Carta carta;
	private ImageView imageView;

	public BotonMano(ImageView imageView) {
		super("-");
		this.setMaxSize(100, 25);
		this.setMinSize(100, 25);
		this.setDisable(true);
		this.imageView = imageView;
		this.setOnAction(value -> {
			imageView.setImage(this.carta.obtenerImagen());
		});
	}

	public void asignarCarta(Carta unaCarta, Grilla unaGrilla) {
		this.carta = unaCarta;
		this.setText(unaCarta.obtenerNombre());
		this.setDisable(false);
		this.setOnAction(value -> {
			this.imageView.setImage(this.carta.obtenerImagen());
			unaGrilla.actualizarGrillaPorSeleccionDeCartaDeMano(unaCarta);
		});
	}

	public Carta obtenerCarta() {
		return this.carta;
	}

	public void limpiar() {
		this.carta = null;
		this.setText("-");
		this.setDisable(true);
	}

}