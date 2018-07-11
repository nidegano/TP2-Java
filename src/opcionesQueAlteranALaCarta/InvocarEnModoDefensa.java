package opcionesQueAlteranALaCarta;

import cartas.CartaMonstruo;
import excepciones.CapacidadMaximaException;
import excepciones.NoSePuedeInvocarMonstruosEnEstaFase;
import excepciones.SoloSePuedeInvocarUnSoloMonstruoEnEstaFase;
import fases.FasePreparacion;
import vista.ControladorVisual;

public class InvocarEnModoDefensa extends Opcion {

	public InvocarEnModoDefensa(ControladorVisual vista) {
		super(vista);
		this.setText("invocar en modo defensa");
		
		this.setOnAction(value -> {
			
			CartaMonstruo cartaSeleccionada = (CartaMonstruo) this.controladorVisual.obtenerCartaSeleccionada(); //el casteo es seguro por el contexto
			this.aplicarComando(cartaSeleccionada);
		});
	}

	public void aplicarComando(CartaMonstruo cartaSeleccionada) {
		try {
			cartaSeleccionada.chequearSiSePuedeInvocarMonstruo();
			((FasePreparacion) cartaSeleccionada.obtenerDuenio().obtenerFase()).avisarAFaseQueSeInvocoMonstruo();
			cartaSeleccionada.desasignarSuVistaCartaDelLugarDeManoEnVistaCampoJugadoresEnElQueEstaba();
			cartaSeleccionada.vistaCarta().agregarAVistaCampoJugadores();
			cartaSeleccionada.invocarEnModoDefensa();
		} catch (NoSePuedeInvocarMonstruosEnEstaFase | SoloSePuedeInvocarUnSoloMonstruoEnEstaFase 
				| CapacidadMaximaException e) {
			e.printStackTrace();
		}

	}
}
