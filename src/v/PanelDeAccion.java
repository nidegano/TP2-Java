package v;

import cartas.Carta;
import configuraciones.ConfiguracionDeOpciones;
import fases.Fase;
import juego.Jugador;
import vista.Grilla;

public class PanelDeAccion {
	
	private Grilla grilla;

	public PanelDeAccion(Grilla grilla) {
		this.grilla = grilla;
	}

	public void actualizarPorCambioDeCartaSeleccionada(Carta cartaSeleccionada) {
		ConfiguracionDeOpciones configuracion = cartaSeleccionada.obtenerConfiguracionDeOpcionesSegunTipoYEstado();
		configuracion.configurar(this);
		this.grilla.cambiarImagenPor(cartaSeleccionada.obtenerImagen());
	}

	public void mostrarOpcionesDeCartaEspecialSinInvocar() {
		
		this.grilla.opcionCambiarAModoAtaqueHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionColocarBocaAbajoHacerVisible(true);
		this.grilla.opcionColocarBocaArribaHacerVisible(false);
		this.grilla.opcionColocarCartaDeCampoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoConSacrificioHacerVisible(false);
		
		this.grilla.opcionAtacarHacerVisible(false);
		this.grilla.opcionDescartarHacerVisible(true);		
	}
	
	public void mostrarOpcionesDeMonstruoSinInvocar() {
		
		this.grilla.opcionCambiarAModoAtaqueHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionColocarBocaAbajoHacerVisible(false);
		this.grilla.opcionColocarBocaArribaHacerVisible(false);
		this.grilla.opcionColocarCartaDeCampoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueHacerVisible(true);
		this.grilla.opcionInvocarEnModoDefensaHacerVisible(true);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoHacerVisible(true);
		
		this.grilla.opcionInvocarEnModoAtaqueConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoConSacrificioHacerVisible(false);
		
		this.grilla.opcionAtacarHacerVisible(false);
		this.grilla.opcionDescartarHacerVisible(true);
	}
	
	public void mostrarOpcionesDeCartaDeCampoSinInvocar() {
		
		this.grilla.opcionCambiarAModoAtaqueHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionColocarBocaAbajoHacerVisible(false);
		this.grilla.opcionColocarBocaArribaHacerVisible(false);
		this.grilla.opcionColocarCartaDeCampoHacerVisible(true);
		
		this.grilla.opcionInvocarEnModoAtaqueHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoConSacrificioHacerVisible(false);
		
		this.grilla.opcionAtacarHacerVisible(false);
		this.grilla.opcionDescartarHacerVisible(true);
	}

	public void mostrarOpcionesDeMonstruoRequiereSacrificiosSinInvocar() {
		
		this.grilla.opcionCambiarAModoAtaqueHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionColocarBocaAbajoHacerVisible(false);
		this.grilla.opcionColocarBocaArribaHacerVisible(false);
		this.grilla.opcionColocarCartaDeCampoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueConSacrificioHacerVisible(true);
		this.grilla.opcionInvocarEnModoDefensaConSacrificioHacerVisible(true);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoConSacrificioHacerVisible(true);
		
		this.grilla.opcionAtacarHacerVisible(false);
		this.grilla.opcionDescartarHacerVisible(true);
	}
	
	public void mostrarOpcionesModoAtaque() {
		
		this.grilla.opcionCambiarAModoAtaqueHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaHacerVisible(true);
		this.grilla.opcionCambiarAModoDefensaBocaAbajoHacerVisible(true);
		
		this.grilla.opcionColocarBocaAbajoHacerVisible(false);
		this.grilla.opcionColocarBocaArribaHacerVisible(false);
		this.grilla.opcionColocarCartaDeCampoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoConSacrificioHacerVisible(false);
		
		this.grilla.opcionAtacarHacerVisible(true);
		this.grilla.opcionDescartarHacerVisible(true);
	}

	public void mostrarOpcionesModoDefensa() {
		
		this.grilla.opcionCambiarAModoAtaqueHacerVisible(true);
		this.grilla.opcionCambiarAModoDefensaHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaBocaAbajoHacerVisible(true);
		
		this.grilla.opcionColocarBocaAbajoHacerVisible(false);
		this.grilla.opcionColocarBocaArribaHacerVisible(false);
		this.grilla.opcionColocarCartaDeCampoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoConSacrificioHacerVisible(false);
		
		this.grilla.opcionAtacarHacerVisible(false);
		this.grilla.opcionDescartarHacerVisible(true);
	}

	public void mostrarOpcionesModoDefensaBocaAbajo() {
		
		this.grilla.opcionCambiarAModoAtaqueHacerVisible(true);
		this.grilla.opcionCambiarAModoDefensaHacerVisible(true);
		this.grilla.opcionCambiarAModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionColocarBocaAbajoHacerVisible(false);
		this.grilla.opcionColocarBocaArribaHacerVisible(false);
		this.grilla.opcionColocarCartaDeCampoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoConSacrificioHacerVisible(false);
		
		this.grilla.opcionAtacarHacerVisible(false);
		this.grilla.opcionDescartarHacerVisible(true);
	}

	public void mostrarOpcionesDeCartaDeCampoInvocada() {
		
		this.grilla.opcionCambiarAModoAtaqueHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionColocarBocaAbajoHacerVisible(false);
		this.grilla.opcionColocarBocaArribaHacerVisible(false);
		this.grilla.opcionColocarCartaDeCampoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoConSacrificioHacerVisible(false);
		
		this.grilla.opcionAtacarHacerVisible(false);
		this.grilla.opcionDescartarHacerVisible(true);
	}

	public void mostrarSoloLaOpcionDeColocarBocaArribaYDescartar() {
		
		this.grilla.opcionCambiarAModoAtaqueHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionColocarBocaAbajoHacerVisible(false);
		this.grilla.opcionColocarBocaArribaHacerVisible(true);
		this.grilla.opcionColocarCartaDeCampoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoConSacrificioHacerVisible(false);
		
		this.grilla.opcionAtacarHacerVisible(false);
		this.grilla.opcionDescartarHacerVisible(true);
	}
	
	public void noMostrarNingunaOpcion() {
		
		this.grilla.opcionCambiarAModoAtaqueHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaHacerVisible(false);
		this.grilla.opcionCambiarAModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionColocarBocaAbajoHacerVisible(false);
		this.grilla.opcionColocarBocaArribaHacerVisible(false);
		this.grilla.opcionColocarCartaDeCampoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoHacerVisible(false);
		
		this.grilla.opcionInvocarEnModoAtaqueConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaConSacrificioHacerVisible(false);
		this.grilla.opcionInvocarEnModoDefensaBocaAbajoConSacrificioHacerVisible(false);
		
		this.grilla.opcionAtacarHacerVisible(false);
		this.grilla.opcionDescartarHacerVisible(false);
	}

	public void actualizarPorCambioDeFaseALaFase(Fase faseNueva) {
		this.grilla.cambiarLabelDeFasePor(faseNueva.nombre());
	}

	public void actualizarPorCambioDeTurno(Jugador jugadorDeTurno) {
		jugadorDeTurno.determinarComoCambiarElLabelDelTurnoDependiendoDeQueJugadorEsElTurnoATravezDeGrilla(this.grilla);
	}
}
