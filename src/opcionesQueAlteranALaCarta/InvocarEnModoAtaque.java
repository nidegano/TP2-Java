package opcionesQueAlteranALaCarta;

import cartas.CartaMonstruo;
import excepciones.CapacidadMaximaException;
import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import excepciones.SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;
import fases.FasePreparacion;
import vista.ControladorVisual;

public class InvocarEnModoAtaque extends Opcion {

	public InvocarEnModoAtaque(ControladorVisual vista) {
		super(vista);
		this.setText("Invocar en modo ataque");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
			this.activarSonido();
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		try {
			cartaSeleccionada.chequearSiSePuedeInvocarMonstruo();
			((FasePreparacion) cartaSeleccionada.obtenerDuenio().obtenerFase()).avisarAFaseQueSeInvocoMonstruo();
			cartaSeleccionada.desasignarSuVistaCartaDelLugarDeManoEnVistaCampoJugadoresEnElQueEstaba();
			cartaSeleccionada.vistaCarta().agregarAVistaCampoJugadores();
			cartaSeleccionada.invocarEnModoAtaque();
		} catch (NoSePuedeInvocarMonstruosEnEstaFase | SoloSePuedeInvocarUnSoloMonstruoEnEstaFase 
				| CapacidadMaximaException e) {
			// e.printStackTrace();
		}
	}
}
