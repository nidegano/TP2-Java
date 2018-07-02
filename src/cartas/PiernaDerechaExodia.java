package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import juego.RecolectorDePartesDeExodia;

public class PiernaDerechaExodia extends Exodia {

	public PiernaDerechaExodia() {
		super();
		this.puntosDeAtaque = new Puntos(200);
		this.puntosDeDefensa = new Puntos(300);
		this.nivel = 1;
		this.nombre = "Exodia - Pierna Derecha";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_PiernaDerechaExodia.png");
		} catch (FileNotFoundException e) {
		}
		this.imagen = new Image(input);
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
		recolectorDePartesDeExodia.recolectarPiernaDerecha(this);
	}

}
