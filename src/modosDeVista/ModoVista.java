package modosDeVista;

import cartas.Carta;
import vista.Vista;

public abstract class ModoVista {
	
	protected Vista vista;
	
	public ModoVista(Vista vista) {
		this.vista = vista;
	}

	public abstract void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion);

	public abstract void avisarDeLaSeleccionDeJugador();

}
