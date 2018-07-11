package modosDeControlador;

import cartas.Carta;
import vista.ControladorVisual;

public class ModoSeleccionParaSacrificio extends ModoDelControladorVisual {

	public ModoSeleccionParaSacrificio(ControladorVisual vista) {
		super(vista);
	}

	@Override
	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
		this.controladorVisual.agregarSeleccionALasSeleccionesSecundarias(cartaNuevaSeleccion);
	}

	@Override
	public void avisarDeLaSeleccionDeJugador() {
		//en modo sacrificio seleccionar al jugador no implica nada
	}
}
