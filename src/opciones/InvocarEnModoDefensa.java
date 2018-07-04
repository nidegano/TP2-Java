package opciones;

import cartas.CartaMonstruo;
import v.Vista;

public class InvocarEnModoDefensa extends Opcion {

	public InvocarEnModoDefensa(Vista vista) {
		super(vista);
		this.setText("invocar en modo defensa");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.vista.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		//no chequeo si se puede porque si no se puede se eleva una excepcion
		cartaSeleccionada.chequearSiSePuedeInvocarMonstruo();
		cartaSeleccionada.vista().agregarAVistaCampoJugadores();
		cartaSeleccionada.invocarEnModoDefensa();
	}
}
