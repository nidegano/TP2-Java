package opcionesQueAlteranALaCarta;

import cartas.CartaMonstruo;
import vista.ControladorVisual;

public class CambiarModoAtaque extends Opcion {
	
	public CambiarModoAtaque(ControladorVisual vista) {
		super(vista);
		this.setText("cambiar a modo ataque");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		cartaSeleccionada.cambiarAModoAtaque();
		this.controladorVisual.reseleccionarCarta(cartaSeleccionada);
	}
}
