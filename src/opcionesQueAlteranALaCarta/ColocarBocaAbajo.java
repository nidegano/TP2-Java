package opcionesQueAlteranALaCarta;

import cartas.CartaEspecial;
import vista.ControladorVisual;

public class ColocarBocaAbajo extends Opcion {

	public ColocarBocaAbajo(ControladorVisual vista) {
		super(vista);
		this.setText("colocar boca abajo");
		
		this.setOnAction(value -> {
			
			CartaEspecial cartaSeleccionada = (CartaEspecial) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaEspecial cartaSeleccionada) {
		cartaSeleccionada.desasignarSuVistaCartaDelLugarDeManoEnVistaCampoJugadoresEnElQueEstaba();
		cartaSeleccionada.vistaCarta().agregarAVistaCampoJugadores();
		cartaSeleccionada.colocarBocaAbajo();
	}
}
