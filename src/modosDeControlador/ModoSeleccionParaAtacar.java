package modosDeControlador;

import cartas.Carta;
import vista.ControladorVisual;

public class ModoSeleccionParaAtacar extends ModoDelControladorVisual {

	public ModoSeleccionParaAtacar(ControladorVisual vista) {
		super(vista);
	}

	@Override
	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
		this.controladorVisual.finalizarComandoDeAtacar(cartaNuevaSeleccion);
	}

	@Override
	public void avisarDeLaSeleccionDeJugador() {
		this.controladorVisual.finalizarComandoDeAtacarAJugador();
	}
}
