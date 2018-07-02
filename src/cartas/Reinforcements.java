package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import efectos.EfectoReinforcements;
import javafx.scene.image.Image;

public class Reinforcements extends CartaTrampa {

	public Reinforcements() {
		super();
		this.efecto = new EfectoReinforcements(this);
		this.nombre = "Reinforcements";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_Reinforcements.png");
		} catch (FileNotFoundException e) {
		}
		this.imagen = new Image(input);
	}

}
