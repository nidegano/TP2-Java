package modosDeVista;

import cartas.Carta;
import vista.Vista;

public class ModoSeleccionParaAtacar extends ModoVista {

	public ModoSeleccionParaAtacar(Vista vista) {
		super(vista);
	}

	@Override
	public void avisarDeLaSeleccionDeUnaVistaDeCarta(Carta cartaNuevaSeleccion) {
		this.vista.finalizarComandoDeAtacar(cartaNuevaSeleccion);
	}

}
