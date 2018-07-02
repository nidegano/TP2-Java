package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import juego.RecolectorDePartesDeExodia;

public class PiernaIzquierdaExodia extends Exodia {

	public PiernaIzquierdaExodia() {
		super();
		this.puntosDeAtaque = new Puntos(200);
		this.puntosDeDefensa = new Puntos(300);
		this.nivel = 1;
		this.nombre = "Exodia - Pierna Izquierda";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_PiernaIzquierdaExodia.png");
		} catch (FileNotFoundException e) {
		}
		this.imagen = new Image(input);
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
		recolectorDePartesDeExodia.recolectarPiernaIzquierda(this);
	}

}
