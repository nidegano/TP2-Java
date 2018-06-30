package vista;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BotonCampo extends Button {

	public BotonCampo(String texto, ImageView imageView) {
		super(texto);
		this.setMaxSize(100, 200);
	}

}
