package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import efectos.EfectoFisura;
import javafx.scene.image.Image;

public class Fisura extends CartaMagica {

	public Fisura() {
		super();
		this.efecto = new EfectoFisura(this);
		this.nombre = "Fisura";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_Fisura.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

}