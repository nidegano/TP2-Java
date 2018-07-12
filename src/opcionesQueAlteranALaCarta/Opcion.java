package opcionesQueAlteranALaCarta;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import vista.ControladorVisual;

public abstract class Opcion extends Button {
	
	protected ControladorVisual controladorVisual;
	
	public Opcion(ControladorVisual vista) {
		super("-");
		this.controladorVisual = vista;
		//this.inicializarSonido();
		
		this.setMaxSize(400, 200);
		this.setVisible(false);
	}

	
	protected void activarSonido() {
		String musicFile = "resources/sounds/click2.wav";
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
}
