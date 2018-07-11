package modosDeControlador;

import cartas.Carta;
import vista.ControladorVisual;

public abstract class ModoDelControladorVisual {
	
	protected ControladorVisual controladorVisual;
	
	public ModoDelControladorVisual(ControladorVisual vista) {
		this.controladorVisual = vista;
	}

	public abstract void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion);

	public abstract void avisarDeLaSeleccionDeJugador();

}
