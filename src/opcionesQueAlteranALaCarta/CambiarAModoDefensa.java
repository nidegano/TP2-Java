package opcionesQueAlteranALaCarta;

import cartas.CartaMonstruo;
import vista.ControladorVisual;

public class CambiarAModoDefensa extends Opcion {

	public CambiarAModoDefensa(ControladorVisual vista) {
		super(vista);
		this.setText("cambiar a modo defensa");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		cartaSeleccionada.cambiarAModoDefensa();
	}
}
