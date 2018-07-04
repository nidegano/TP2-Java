package opciones;

import cartas.CartaDeCampo;
import v.Vista;

public class ColocarCartaDeCampo extends Opcion {

	public ColocarCartaDeCampo(Vista vista) {
		super(vista);
		this.setText("colocar boca arriba");
		
		this.setOnAction(value -> {
			
			CartaDeCampo cartaSeleccionada = (CartaDeCampo) this.vista.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaDeCampo cartaSeleccionada) {
		//no chequeo si se puede porque si no se puede se eleva una excepcion
		cartaSeleccionada.vista().agregarAVistaCampoJugadores();
		cartaSeleccionada.colocarCartaDeCampo();
	}
}
