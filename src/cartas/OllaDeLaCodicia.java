package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import efectos.EfectoOllaDeLaCodicia;
import javafx.scene.image.Image;

public class OllaDeLaCodicia extends CartaMagica {

	public OllaDeLaCodicia() {
		super();
		this.efecto = new EfectoOllaDeLaCodicia(this);
		this.nombre = "Olla de la Codicia";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_OllaDeLaCodicia.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

}
