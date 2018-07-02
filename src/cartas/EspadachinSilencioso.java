package cartas;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class EspadachinSilencioso extends CartaRequiereSacrificios {

	public EspadachinSilencioso() {
		super();
		this.sacrificiosRequeridos = 1;
		this.puntosDeAtaque = new Puntos(2300);
		this.puntosDeDefensa = new Puntos(1000);
		this.nivel = 5;
		this.nombre = "Espadachin Silencioso";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_EspadachinSilencioso.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

}
