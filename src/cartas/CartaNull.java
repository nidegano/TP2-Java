package cartas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import juego.Campo;
import juego.RecolectorDePartesDeExodia;
import vista.Grilla;

public class CartaNull extends Carta {
	
	public CartaNull() {
		FileInputStream input = null;
		try {
			input = new FileInputStream("resources/images/carta_Nula.png");
		} catch (FileNotFoundException e) {
		}
		this.imagen = new Image(input);
	}

	@Override
	public void agregarEnCampo(Campo campo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serRecolectadaPorElRecolectorDePartesDeExodia(RecolectorDePartesDeExodia recolectorDePartesDeExodia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void provocarActualizacionDeLaGrillaSegunTipo(Grilla grilla) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarGrillaPorinvocacionSegunCorrespondaPorElTipo(Grilla grilla) {
		// TODO Auto-generated method stub
		
	}

}
