package modosDeVista;

import cartas.Carta;
import vista.Vista;

public class ModoNormal extends ModoVista {

	public ModoNormal(Vista vista) {
		super(vista);
	}

	@Override
	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
		this.vista.cambiarCartaSeleccionActualPor(cartaNuevaSeleccion);	
	}

	@Override
	public void avisarDeLaSeleccionDeJugador() {
		//en modo normal seleccionar al jugador no implica nada
	}


}
