package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import efectos.EfectoInsectoComeHombres;
import estado.ModoDefensaBocaAbajo;
import javafx.scene.image.Image;

public class InsectoComeHombres extends CartaMonstruo {

	public InsectoComeHombres() {
		super();
		this.puntosDeAtaque = new Puntos(450);
		this.puntosDeDefensa = new Puntos(600);
		this.nivel = 2;
		this.efecto = new EfectoInsectoComeHombres(this);
		this.nombre = "Insecto Come Hombres";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_InsectoComeHombres.png");
		} catch (FileNotFoundException e) {
		}
        this.imagen = new Image(input);
	}

	public void invocarEnModoDefensaBocaAbajo() {
		this.estado = new ModoDefensaBocaAbajo(this.puntosDeDefensa);
	}

}
