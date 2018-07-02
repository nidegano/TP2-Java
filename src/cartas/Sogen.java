package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import efectos.EfectoSogen;
import javafx.scene.image.Image;

public class Sogen extends CartaDeCampo {

	public Sogen() {
		super();
		this.efecto = new EfectoSogen(this);
		this.nombre = "Sogen";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_Sogen.png");
		} catch (FileNotFoundException e) {
		}
		this.imagen = new Image(input);
	}

}
