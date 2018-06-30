package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import juego.ContenedorDeCartas;

public class DragonBlancoDeOjosAzules extends CartaRequiereSacrificios {

	public DragonBlancoDeOjosAzules(ContenedorDeCartas sacrificios) {
		super(sacrificios);
		this.sacrificiosRequeridos = 2;
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.puntosDeAtaque = new Puntos(3000);
		this.puntosDeDefensa = new Puntos(2500);
		this.nivel = 8;
		this.nombre = "Dragon Blanco de Ojos Azules";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_DragonBlancoDeOjosAzules.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

}
