package opcionesQueAlteranALaCarta;

import cartas.CartaMonstruo;
import vista.ControladorVisual;

public class CambiarAModoDefensaBocaAbajo extends Opcion {

	public CambiarAModoDefensaBocaAbajo(ControladorVisual vista) {
		super(vista);
		this.setText("cambiar a modo defensa boca abajo");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
			this.activarSonido();
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		cartaSeleccionada.cambiarAModoDefensaBocaAbajo();
		this.controladorVisual.reseleccionarCarta(cartaSeleccionada);
	}
}
