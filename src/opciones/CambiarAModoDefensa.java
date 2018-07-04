package opciones;

import cartas.CartaMonstruo;
import v.Vista;

public class CambiarAModoDefensa extends Opcion {

	public CambiarAModoDefensa(Vista vista) {
		super(vista);
		this.setText("cambiar a modo defensa");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.vista.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		cartaSeleccionada.colocarEnModoDefensa();
	}
}
