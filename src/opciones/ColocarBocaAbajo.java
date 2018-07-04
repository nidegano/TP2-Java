package opciones;

import cartas.CartaEspecial;
import vista.Vista;

public class ColocarBocaAbajo extends Opcion {

	public ColocarBocaAbajo(Vista vista) {
		super(vista);
		this.setText("colocar boca abajo");
		
		this.setOnAction(value -> {
			
			CartaEspecial cartaSeleccionada = (CartaEspecial) this.vista.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaEspecial cartaSeleccionada) {
		//no chequeo si se puede porque si no se puede al ejecutarse colocarBocaAbajo() tira una excepcion
		cartaSeleccionada.vistaCarta().agregarAVistaCampoJugadores();
		cartaSeleccionada.colocarBocaAbajo();
	}
}
