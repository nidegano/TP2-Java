package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import juego.RecolectorDePartesDeExodia;

public class CabezaExodia extends Exodia {

	public CabezaExodia() {
		super();
		this.puntosDeAtaque = new Puntos(1000);
		this.puntosDeDefensa = new Puntos(1000);
		this.nivel = 3;
		this.nombre = "Exodia - Cabeza";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_CabezaExodia.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
		recolectorDePartesDeExodia.recolectarCabeza(this);
	}

}
