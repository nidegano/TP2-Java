package opciones;

import cartas.Carta;
import v.Vista;

public class Descartar extends Opcion {

	public Descartar(Vista vista) {
		super(vista);
		this.setText("descartar");
		
		this.setOnAction(value -> {
			
			Carta cartaSeleccionada = this.vista.obtenerCartaSeleccionada();
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(Carta cartaSeleccionada) {
		cartaSeleccionada.matar();
	}
}
