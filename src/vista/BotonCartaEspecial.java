package vista;

import cartas.Carta;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BotonCartaEspecial extends Button {

	private Carta carta;
	private ImageView imageView;

	public BotonCartaEspecial(String texto, ImageView imageView) {
		super(texto);
		this.setMaxSize(100, 25);
		this.setMinSize(100, 25);
		this.setDisable(true);
		this.carta = null;
		this.imageView = imageView;
		this.setOnAction(value -> {
			imageView.setImage(this.carta.obtenerImagen());
		});
	}

	public void asignarCarta(Carta unaCarta, Grilla unaGrilla) {
		this.carta = unaCarta;
		this.setText(unaCarta.obtenerNombre());
		this.setOnAction(value -> {
			this.imageView.setImage(this.carta.obtenerImagen());
			unaGrilla.actualizarGrillaPorSeleccionDeCartaEspecial();
		});
	}

	public boolean estaLibre() {
		return this.carta == null;
	}

}