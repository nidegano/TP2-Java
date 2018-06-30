package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import juego.ContenedorDeCartas;

public class DragonArmadoOscuro extends CartaRequiereSacrificios {

	public DragonArmadoOscuro(ContenedorDeCartas sacrificios) {
		super(sacrificios);
		this.sacrificiosRequeridos = 2;
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.puntosDeAtaque = new Puntos(2800);
		this.puntosDeDefensa = new Puntos(1000);
		this.nivel = 7;
		this.nombre = "Dragon Armado Oscuro";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_DragonArmadoOscuro.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

}
