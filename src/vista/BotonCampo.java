package vista;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BotonCampo extends Button {

	public BotonCampo(ImageView imageView) {
		super("Campo");
		this.setMaxSize(100, 25);
		this.setMinSize(100, 25);
		this.setDisable(true);
	}

}