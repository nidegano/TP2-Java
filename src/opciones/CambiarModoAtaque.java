package opciones;

import cartas.Carta;
import v.Vista;

public class CambiarModoAtaque extends Opcion {
	
	public CambiarModoAtaque(Vista vista) {
		super(vista);
		this.setText("cambiar a modo ataque");
		
		this.setOnAction(value -> {
			
			Carta cartaSeleccionada = this.vista.obtenerCartaSeleccionada();
			this.aplicarComando(cartaSeleccionada);
		});
	}

	@Override
	public void aplicarComando(Carta cartaSeleccionada) {
		// TODO Auto-generated method stub
		
	}
}
