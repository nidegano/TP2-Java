package modosDeControlador;

import cartas.Carta;
import vista.ControladorVisual;

public class ModoNormal extends ModoDelControladorVisual {

	public ModoNormal(ControladorVisual vista) {
		super(vista);
	}

	@Override
	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
		this.controladorVisual.cambiarCartaSeleccionActualPor(cartaNuevaSeleccion);	
	}

	@Override
	public void avisarDeLaSeleccionDeJugador() {
		//en modo normal seleccionar al jugador no implica nada
	}


}
