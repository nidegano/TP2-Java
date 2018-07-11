package opcionesQueAlteranALaCarta;

import cartas.CartaEspecial;
import vista.ControladorVisual;

public class ColocarBocaArriba extends Opcion {

	public ColocarBocaArriba(ControladorVisual vista) {
		super(vista);
		this.setText("colocar boca arriba");
		
		this.setOnAction(value -> {
			
			CartaEspecial cartaSeleccionada = (CartaEspecial) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaEspecial cartaSeleccionada) {
		//no chequeo si se puede porque siempre se puede. Si pude llegar a este contexto es porque la carta no esta muerta y esta en el campo.
		//Por eso se puede.
		cartaSeleccionada.colocarBocaArriba();
	}
}
