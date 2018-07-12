package opcionesQueAlteranALaCarta;

import cartas.CartaMonstruo;
import vista.ControladorVisual;

public class CambiarAModoDefensa extends Opcion {

	public CambiarAModoDefensa(ControladorVisual controladorVisual) {
		super(controladorVisual);
		this.setText("cambiar a modo defensa");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
			this.activarSonido();
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		cartaSeleccionada.cambiarAModoDefensa();
		this.controladorVisual.reseleccionarCarta(cartaSeleccionada);
	}
}
