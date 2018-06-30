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

		Mazo mazoJugador1 = new Mazo();
		Mazo mazoJugador2 = new Mazo();
		
		Campo campoJugador1 = new Campo(mazoJugador1);
		Campo campoJugador2 = new Campo(mazoJugador2);
		
		Jugador jugador1 = new Jugador(campoJugador1);
		Jugador jugador2 = new Jugador(campoJugador2);
		
		Grilla grilla = new Grilla(jugador1, jugador2);
		grilla.start(primaryStage);
	}

}