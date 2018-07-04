package opciones;

import cartas.CartaMonstruo;
import vista.Vista;

public class CambiarModoAtaque extends Opcion {
	
	public CambiarModoAtaque(Vista vista) {
		super(vista);
		this.setText("cambiar a modo ataque");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.vista.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		cartaSeleccionada.colocarEnModoAtaque();
	}
}
