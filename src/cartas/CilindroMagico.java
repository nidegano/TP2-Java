package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import efectos.EfectoCilindroMagico;
import javafx.scene.image.Image;

public class CilindroMagico extends CartaTrampa {

	public CilindroMagico() {
		super();
		this.efecto = new EfectoCilindroMagico(this);
		this.nombre = "Cilindro Magico";
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_CilindroMagico.png");
		} catch (FileNotFoundException e) {
		}
		this.imagen = new Image(input);
	}

}
