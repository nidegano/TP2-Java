package opciones;

import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.CartaRequiereSacrificios;
import v.Vista;

public class InvocarEnModoAtaqueConSacrificio extends InvocarConSacrificio {

	public InvocarEnModoAtaqueConSacrificio(Vista vista) {
		super(vista);
		this.setText("invocar en modo ataque");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.vista.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		//no chequeo si se puede porque si no se puede se eleva una excepcion
		cartaSeleccionada.chequearSiSePuedeInvocarMonstruo();
		this.vista.cambiarAModoSeleccionParaSacrificio(this);
	}

	@Override
	public void finalizarInvocacionPorSacrificio(Carta cartaSeleccionada, ArrayList<CartaMonstruo> sacrificios) {
		((CartaRequiereSacrificios) cartaSeleccionada).invocarEnModoAtaque(sacrificios); 
		//aca cheque si la cantidad es valida y si no tira excepcion	
	}
}

