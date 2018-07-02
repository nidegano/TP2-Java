
package vista;

import javafx.application.Application;
import javafx.stage.Stage;
import juego.*;

public class Algooh extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// INICIALIZACION DEL JUEGO
		Mazo mazoJugador1 = new Mazo();
		Mazo mazoJugador2 = new Mazo();
		mazoJugador1.generarCartas();
		mazoJugador2.generarCartas();

		Campo campoJugador1 = new Campo(mazoJugador1);
		Campo campoJugador2 = new Campo(mazoJugador2);

		Jugador jugador1 = new Jugador(campoJugador1);
		Jugador jugador2 = new Jugador(campoJugador2);
		
		jugador1.asignarOponente(jugador2);
		jugador2.asignarOponente(jugador1);

		Juego juego = new Juego(jugador1, jugador2);

		Grilla grilla = new Grilla(jugador1, jugador2, juego);
		grilla.start(primaryStage);

	}

}