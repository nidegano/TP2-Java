package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import efectos.EfectoJinzo;
import javafx.scene.image.Image;

public class Jinzo extends CartaMonstruo {

	public Jinzo() {
		super();
		this.puntosDeAtaque = new Puntos(500);
		this.puntosDeDefensa = new Puntos(400);
		this.nivel = 2;
		this.efecto = new EfectoJinzo(this);
		this.nombre = "Jinzo";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_Jinzo.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

}
