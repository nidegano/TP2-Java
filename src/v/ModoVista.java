package v;

import cartas.Carta;

public abstract class ModoVista {
	
	protected Vista vista;
	
	public ModoVista(Vista vista) {
		this.vista = vista;
	}

	public abstract void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion);
}
