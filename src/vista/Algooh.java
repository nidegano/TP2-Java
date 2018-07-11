
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
		Mazo mazoJugadorA = new Mazo();
		Mazo mazoJugadorB = new Mazo();
		mazoJugadorA.generarCartas();
		mazoJugadorB.generarCartas();

		Campo campoJugadorA = new Campo(mazoJugadorA);
		Campo campoJugadorB = new Campo(mazoJugadorB);

		Jugador jugadorA = new Jugador("JUGADOR A",campoJugadorA);
		Jugador jugadorB = new Jugador("JUGADOR B",campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		ControladorVisual vista = new ControladorVisual(jugadorA,jugadorB,juego);
		
		juego.asignarVista(vista);
		
		jugadorA.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		jugadorB.asignarAEsteJugadorComoDuenioDeTodasLasCartasDeSuMazo();
		
		mazoJugadorA.asignarVistaCartaACartas(vista);
		mazoJugadorB.asignarVistaCartaACartas(vista);

		vista.start(primaryStage);
		
		juego.iniciar();

	}

}