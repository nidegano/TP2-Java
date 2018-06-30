package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import juego.ContenedorDeCartas;

public class DragonDefinitivo extends CartaRequiereSacrificios {

	public DragonDefinitivo(ContenedorDeCartas sacrificios) {
		super(sacrificios);
		this.sacrificiosRequeridos = 3;
		this.chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
		this.puntosDeAtaque = new Puntos(4500);
		this.puntosDeDefensa = new Puntos(3800);
		this.nivel = 12;
		this.sacrificios = sacrificios;
		this.nombre = "Dragon Blanco de Ojos Azules Definitivo";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_DragonDefinitivo.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

}
