package opcionesQueAlteranALaCarta;

import cartas.Carta;
import vista.ControladorVisual;

public class Descartar extends Opcion {

	public Descartar(ControladorVisual vista) {
		super(vista);
		this.setText("descartar");
		
		this.setOnAction(value -> {
			
			Carta cartaSeleccionada = this.controladorVisual.obtenerCartaSeleccionada();
			this.aplicarComando(cartaSeleccionada);
			this.activarSonido();
		});
	}

	public void aplicarComando(Carta cartaSeleccionada) {
		cartaSeleccionada.matar();
	}
}
