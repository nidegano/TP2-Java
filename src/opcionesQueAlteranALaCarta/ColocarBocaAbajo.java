package opcionesQueAlteranALaCarta;

import cartas.CartaEspecial;
import excepciones.CapacidadMaximaException;
import vista.ControladorVisual;

public class ColocarBocaAbajo extends Opcion {

	public ColocarBocaAbajo(ControladorVisual vista) {
		super(vista);
		this.setText("Colocar boca abajo");
		
		this.setOnAction(value -> {
			
			CartaEspecial cartaSeleccionada = (CartaEspecial) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
			this.activarSonido();
		});
	}

	public void aplicarComando(CartaEspecial cartaSeleccionada) {
		try {
			cartaSeleccionada.chequearSiSePuedeInvocarMonstruo();
			cartaSeleccionada.desasignarSuVistaCartaDelLugarDeManoEnVistaCampoJugadoresEnElQueEstaba();
			cartaSeleccionada.vistaCarta().agregarAVistaCampoJugadores();
			cartaSeleccionada.colocarBocaAbajo();
		}
		catch (CapacidadMaximaException e) {
			// e.printStackTrace();
		}
	}
}
