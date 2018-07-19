package botones;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import juego.Juego;

public class BotonFinalizarFase extends Button {


	public BotonFinalizarFase(Juego juego) {
		super("Finalizar fase");
		this.setMaxSize(200, 200);
		this.setVisible(true);
		
		this.setOnAction(value -> {
			juego.informarQueJugadorDeTurnoTocoFinalizarFase();
			this.activarSonido();
		});
	}

	private void activarSonido() {
		String musicFile = "resources/sounds/click2.wav";
		Media sound = new Media(new File(musicFile).toURI().toString());
		try {
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
		}
		catch (Exception e) {
			// e.printStackTrace();
		}
	}
}