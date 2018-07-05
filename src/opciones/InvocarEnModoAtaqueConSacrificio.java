package opciones;

import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.CartaRequiereSacrificios;
import excepciones.CantidadInadecuadaDeSacrificiosException;
import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import excepciones.SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;
import vista.Vista;

public class InvocarEnModoAtaqueConSacrificio extends InvocarConSacrificio {

	public InvocarEnModoAtaqueConSacrificio(Vista vista) {
		super(vista);
		this.setText("invocar en modo ataque");
		
		this.setOnAction(value -> {
			
			CartaRequiereSacrificios cartaSeleccionada = (CartaRequiereSacrificios) this.vista.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		try {
			cartaSeleccionada.chequearSiSePuedeInvocarMonstruo();
			this.vista.cambiarAModoSeleccionParaSacrificio(this);
		} catch (NoSePuedeInvocarMonstruosEnEstaFase | SoloSePuedeInvocarUnSoloMonstruoEnEstaFase e) {
			e.printStackTrace();
		}
	}

	@Override
	public void finalizarInvocacionPorSacrificio(Carta cartaSeleccionada, ArrayList<CartaMonstruo> sacrificios) {
		
		try {
			((CartaRequiereSacrificios) cartaSeleccionada).chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
			cartaSeleccionada.desasignarSuVistaCartaDelLugarDeManoEnVistaCampoJugadoresEnElQueEstaba();
			cartaSeleccionada.vistaCarta().agregarAVistaCampoJugadores();
			((CartaRequiereSacrificios) cartaSeleccionada).invocarEnModoAtaque(sacrificios); 
		}
		catch (CantidadInadecuadaDeSacrificiosException e) {
			
			e.printStackTrace();
		}
	}
}

