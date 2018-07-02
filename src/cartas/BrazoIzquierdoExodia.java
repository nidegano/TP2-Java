package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import juego.RecolectorDePartesDeExodia;

public class BrazoIzquierdoExodia extends Exodia {

	public BrazoIzquierdoExodia() {
		super();
		this.puntosDeAtaque = new Puntos(200);
		this.puntosDeDefensa = new Puntos(300);
		this.nivel = 1;
		this.nombre = "Exodia - Brazo Izquierdo";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_BrazoIzquierdoExodia.png");
		} catch (FileNotFoundException e) {
		}
		this.imagen = new Image(input);
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
		recolectorDePartesDeExodia.recolectarBrazoIzquierdo(this);
	}

}
