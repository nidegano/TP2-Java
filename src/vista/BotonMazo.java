package vista;

import excepciones.CapacidadMaximaException;
import excepciones.NoSePuedeTomarMasCartasDelMazoException;
import javafx.scene.control.Button;
import juego.Jugador;

public class BotonMazo extends Button {

	private Jugador jugador;

	public BotonMazo(Jugador jugador, Grilla unaGrilla) {
		super("Mazo");
		this.setMaxSize(100, 25);
		this.setMinSize(100, 25);
		this.setDisable(true);
		this.jugador = jugador;
		this.setOnAction(value -> {
			try {
				
				if (this.jugador.puedeTomarCarta()) {;
					this.jugador.tomarCartaDelMazo();
					unaGrilla.actualizarGrilla();
				}
			} catch (CapacidadMaximaException e1) {
			} catch (NoSePuedeTomarMasCartasDelMazoException e2) {
			}
		});
	}

}