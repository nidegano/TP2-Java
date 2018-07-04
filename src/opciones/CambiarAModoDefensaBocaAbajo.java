package opciones;

import cartas.CartaMonstruo;
import v.Vista;

public class CambiarAModoDefensaBocaAbajo extends Opcion {

	public CambiarAModoDefensaBocaAbajo(Vista vista) {
		super(vista);
		this.setText("cambiar a modo defensa boca abajo");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.vista.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		cartaSeleccionada.colocarEnModoDefensaBocaAbajo();
	}
}
