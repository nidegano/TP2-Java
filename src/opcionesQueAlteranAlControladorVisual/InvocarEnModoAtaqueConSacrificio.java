package opcionesQueAlteranAlControladorVisual;

import java.util.ArrayList;

import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.CartaRequiereSacrificios;
import excepciones.CantidadInadecuadaDeSacrificiosException;
import excepciones.CapacidadMaximaException;
import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import excepciones.SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;
import fases.FasePreparacion;
import vista.ControladorVisual;

public class InvocarEnModoAtaqueConSacrificio extends InvocarConSacrificio {

	public InvocarEnModoAtaqueConSacrificio(ControladorVisual vista) {
		super(vista);
		this.setText("Invocar en modo ataque");
		
		this.setOnAction(value -> {
			
			CartaRequiereSacrificios cartaSeleccionada = (CartaRequiereSacrificios) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
			this.activarSonido();
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		try {
			cartaSeleccionada.chequearSiSePuedeInvocarMonstruo();
			this.controladorVisual.cambiarAModoSeleccionParaSacrificio(this);
		} catch (NoSePuedeInvocarMonstruosEnEstaFase | SoloSePuedeInvocarUnSoloMonstruoEnEstaFase 
				| CapacidadMaximaException e) {
			// e.printStackTrace();
		}
	}

	@Override
	public void finalizarInvocacionPorSacrificio(Carta cartaSeleccionada, ArrayList<CartaMonstruo> sacrificios) {
		
		try {
			((CartaRequiereSacrificios) cartaSeleccionada).chequearQueLaCantidadDeSacrificiosSeaCorrecta(sacrificios);
			((FasePreparacion) cartaSeleccionada.obtenerDuenio().obtenerFase()).avisarAFaseQueSeInvocoMonstruo();
			cartaSeleccionada.desasignarSuVistaCartaDelLugarDeManoEnVistaCampoJugadoresEnElQueEstaba();
			cartaSeleccionada.vistaCarta().agregarAVistaCampoJugadores();
			((CartaRequiereSacrificios) cartaSeleccionada).invocarEnModoAtaque(sacrificios); 
		}
		catch (CantidadInadecuadaDeSacrificiosException e) {
			// e.printStackTrace();
		}
	}
}

