package vista;

import cartas.Carta;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BotonCartaMonstruo extends Button {

	private Carta carta;
	private ImageView imageView;

	public BotonCartaMonstruo(String texto, ImageView imageView) {
		super(texto);
		this.setMaxSize(100, 200);
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
			unaGrilla.actualizarGrillaPorSeleccionDeCartaMonstruo();
		});
	}
}