package opcionesQueAlteranALaCarta;

import cartas.CartaEspecial;
import vista.ControladorVisual;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class ColocarBocaArriba extends Opcion {

	public ColocarBocaArriba(ControladorVisual vista) {
		super(vista);
		this.setText("Colocar boca arriba");
		
		this.setOnAction(value -> {
			
			CartaEspecial cartaSeleccionada = (CartaEspecial) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
			this.activarSonido();
		});
	}

	public void aplicarComando(CartaEspecial cartaSeleccionada) {
		//no chequeo si se puede porque siempre se puede. Si pude llegar a este contexto es porque la carta no esta muerta y esta en el campo.
		//Por eso se puede.
		cartaSeleccionada.colocarBocaArriba();
		this.activarSonido();
	}
	
	@Override
	protected void activarSonido() {
		String musicFile = "resources/sounds/magia.wav";
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
