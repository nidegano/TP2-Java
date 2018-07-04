package opciones;

import cartas.CartaMonstruo;
import vista.Vista;

public class Atacar extends Opcion {

	public Atacar(Vista vista) {
		super(vista);
		this.setText("atacar");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.vista.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		//no chequeo si se puede porque si no se puede se eleva una excepcion
		this.vista.cambiarAModoSeleccionParaAtacar(this);
	}
}
