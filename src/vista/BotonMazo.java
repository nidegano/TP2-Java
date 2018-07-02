package vista;

import cartas.Carta;
import excepciones.CapacidadMaximaException;
import javafx.scene.control.Button;
import juego.Mano;
import juego.Mazo;

public class BotonMazo extends Button {

	private Mazo mazo;
	private Mano mano;

	public BotonMazo(Grilla unaGrilla) {
		super("Mazo");
		this.setMaxSize(100, 25);
		this.setMinSize(100, 25);
		this.setOnAction(value -> {
			try {
				Carta unaCarta = this.mazo.tomarUnaCarta();
				this.mano.agregar(unaCarta);
				unaGrilla.actualizarGrillaPorTomarCartaDelMazo();
			} catch (CapacidadMaximaException e) {
			}
		});
	}

	public void asignarMazo(Mazo unMazo) {
		this.mazo = unMazo;
	}

	public void asignarMano(Mano unaMano) {
		this.mano = unaMano;
	}

}