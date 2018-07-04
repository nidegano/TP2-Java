package vista;

import cartas.Carta;

public class ModoNormal extends ModoVista {

	public ModoNormal(Vista vista) {
		super(vista);
	}

	@Override
	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
		this.vista.cambiarCartaSeleccionActualPor(cartaNuevaSeleccion);	
	}

}
