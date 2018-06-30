package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import efectos.EfectoWasteland;
import javafx.scene.image.Image;

public class Wasteland extends CartaDeCampo {

	public Wasteland() {
		super();
		this.efecto = new EfectoWasteland(this);
		this.nombre = "Wasteland";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_Wasteland.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

}
