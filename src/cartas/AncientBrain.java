package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class AncientBrain extends CartaMonstruo {

	public AncientBrain() {
		super();
		this.puntosDeAtaque = new Puntos(1000);
		this.puntosDeDefensa = new Puntos(700);
		this.nivel = 3;
		this.nombre = "Ancient Brain";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_AncientBrain.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

}
