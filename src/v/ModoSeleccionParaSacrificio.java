package v;

import cartas.Carta;

public class ModoSeleccionParaSacrificio extends ModoVista {

	public ModoSeleccionParaSacrificio(Vista vista) {
		super(vista);
	}

	@Override
	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
		this.vista.agregarSeleccionALasSeleccionesSecundarias(cartaNuevaSeleccion);
	}

}
