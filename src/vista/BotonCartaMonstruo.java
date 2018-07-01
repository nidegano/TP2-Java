package vista;

import cartas.Carta;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class BotonCartaMonstruo extends Button {

	private Carta carta;
	private ImageView imageView;
	private GridPane grillaALaQuePertenece;

	public BotonCartaMonstruo(String texto, ImageView imageView) {
		super(texto);
		this.setMaxSize(100, 200);
		this.imageView = imageView;
		this.setOnAction(value -> {
			imageView.setImage(this.carta.obtenerImagen());
		});
	}

	public void asignarCarta(Carta unaCarta, GridPane unaGrilla) {
		this.carta = unaCarta;
		this.grillaALaQuePertenece = unaGrilla;
		
		this.setText(unaCarta.obtenerNombre()); //sacar esto cuando se usen fotos
		this.setOnAction(value -> {
			this.imageView.setImage(this.carta.obtenerImagen());
		});
	}
}
