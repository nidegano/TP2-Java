package opcionesQueAlteranAlControladorVisual;

import cartas.CartaMonstruo;
import opcionesQueAlteranALaCarta.Opcion;
import vista.ControladorVisual;

public class Atacar extends Opcion {

	public Atacar(ControladorVisual vista) {
		super(vista);
		this.setText("Atacar");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
			this.activarSonido();
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {		
		this.controladorVisual.cambiarAModoSeleccionParaAtacar(this);
	}
}
