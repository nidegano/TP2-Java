package modosDeVista;

import cartas.Carta;
import vista.Vista;

public class ModoSeleccionParaSacrificio extends ModoVista {

	public ModoSeleccionParaSacrificio(Vista vista) {
		super(vista);
	}

	@Override
	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
		this.vista.agregarSeleccionALasSeleccionesSecundarias(cartaNuevaSeleccion);
	}

	@Override
	public void avisarDeLaSeleccionDeJugador() {
		//en modo sacrificio seleccionar al jugador no implica nada
	}
}
