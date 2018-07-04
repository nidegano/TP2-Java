
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

		JugadorA jugadorA = new JugadorA(campoJugadorA);
		JugadorB jugadorB = new JugadorB(campoJugadorB);

		Juego juego = new Juego(jugadorA, jugadorB);
		
		Vista vista = new Vista(jugadorA,jugadorB,juego);
		
		juego.asignarVista(vista);
		mazoJugadorA.asignarVistaCartaACartas(vista);
		mazoJugadorB.asignarVistaCartaACartas(vista);
		
		try {
			vista.start(primaryStage);
			
			juego.iniciar();
		}
		catch (Exception e){
			
		}

	}

}