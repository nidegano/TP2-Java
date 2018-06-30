package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import efectos.EfectoAgujeroOscuro;
import javafx.scene.image.Image;

public class AgujeroOscuro extends CartaMagica {

	public AgujeroOscuro() {
		super();
		this.efecto = new EfectoAgujeroOscuro(this);
		this.nombre = "Agujero Oscuro";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_AgujeroOscuro.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

}
