package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class AlphaTheMagnetWarrior extends CartaMonstruo {

	public AlphaTheMagnetWarrior() {
		super();
		this.puntosDeAtaque = new Puntos(1400);
		this.puntosDeDefensa = new Puntos(1700);
		this.nivel = 4;
		this.nombre = "Alpha The Magnet Warrior";
		
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_AlphaTheMagnetWarrior.png");
		} catch (FileNotFoundException e) {
		}
		this.imagen = new Image(input);
	}

}
