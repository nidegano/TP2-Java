package opciones;

import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.CartaRequiereSacrificios;
import v.Vista;

public class InvocarEnModoDefensaConSacrificio extends InvocarConSacrificio {

	public InvocarEnModoDefensaConSacrificio(Vista vista) {
		super(vista);
		this.setText("invocar en modo defensa");
		
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
		((CartaRequiereSacrificios) cartaSeleccionada).invocarEnModoDefensa(sacrificios); 
		//aca cheque si la cantidad es valida y si no tira excepcion	
	}
}
