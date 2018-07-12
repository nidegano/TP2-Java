package botones;


import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import juego.Juego;

public class BotonMazo extends Button {

	private MediaPlayer mediaPlayer;

	public BotonMazo(Juego juego) {
		super("Mazo");
		this.setMaxSize(100, 100);
		this.setVisible(true);
		this.inicializarSonido();
		
		this.setOnAction(value -> {
			juego.jugadorDeTurno().tomarCartaDelMazo();
			this.setDisable(true);
			this.activarSonido();
		});
	}
	
	private void inicializarSonido() {
		String musicFile = "resources/sounds/click2.wav";
		Media sound = new Media(new File(musicFile).toURI().toString());
		this.mediaPlayer = new MediaPlayer(sound);
	}
	
	private void activarSonido() {
		this.mediaPlayer.play();	
	}
}
